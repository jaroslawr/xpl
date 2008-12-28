tree grammar CodeGeneration;

options {
    tokenVocab=SemanticAnalysis;
    ASTLabelType=ASTNode;
}

@header {
    package xpl.codegen;

    import xpl.semantic.SymbolTable;
    import xpl.semantic.Types;
    import xpl.semantic.ast.*;
}

@members {
    private CodeGenerator generate;
    private SymbolTable symbolTable;

    public CodeGeneration(TreeNodeStream input, String filename) {
      this(input);

      this.symbolTable = symbolTable;
      this.generate    = new CodeGenerator(filename);
    }

    public byte[] getResults() {
        return this.generate.finish();
    }
}

program
    : (method_definition | atomic_operation)+;

atomic_operation
    :  conditional | loop | assignment | variable_definition | expression | return_expression;

method_definition
@after { generate.method().finish((MethodNode)$start); }
    :  ^(METHOD header=method_header[(MethodNode)$start] ^(PROGN (atomic_operation | method_definition)+));

method_header[MethodNode methodNode]
    :  ^(name=IDENTIFIER ((TYPE args+=IDENTIFIER)+)? return_type=TYPE) {
            generate.method().definition(methodNode);
        };

conditional
    :  ^(IF conditional_test[$conditional.start.hasElse] conditional_true_branch[$conditional.start.hasElse] conditional_false_branch?) {
            generate.conditional().ifAfterBody();
        };

conditional_test[boolean hasElse]
@after { generate.conditional().ifAfterCondition(hasElse); }
    :  expression;

conditional_true_branch[boolean hasElse]
@after { if(hasElse) { generate.conditional().ifElseAfterTrueBranch();} }
    :  ^(PROGN atomic_operation+);

conditional_false_branch
@init  { generate.conditional().ifElseBeforeFalseBranch(); }
    :  ^(PROGN atomic_operation+);

loop
    :  ^(WHILE loop_test ^(PROGN loop_body));

loop_test
@init  { generate.loop().whileBeforeCondition(); }
@after { generate.loop().whileAfterCondition(); }
    :  expression;

loop_body
@after { generate.loop().whileAfterBody(); }
    :  atomic_operation+;

variable_definition
@init  { generate.variable().beforeReference(); }
    :  ^('=' TYPE name=IDENTIFIER value=expression) {
            generate.variable().initialization(((VariableNode)$name));
        };

assignment
@init  { generate.variable().beforeReference(); }
    :  ^('=' name=IDENTIFIER value=expression) {
            generate.variable().assignment(((VariableNode)$name));
        };

expression
    : boolean_expression;

boolean_expression
    :  ^('&&' a=boolean_expression b=boolean_expression) { generate.bool().and($start); }
    |  ^('||' a=boolean_expression b=boolean_expression) { generate.bool().or($start); }
    |  comparision_expression;

comparision_expression
    :  ^('==' a=binary_expression b=binary_expression) { generate.bool().equal($start); }
    |  ^('<=' a=binary_expression b=binary_expression) { generate.bool().lessThanOrEqual($start); }
    |  ^('>=' a=binary_expression b=binary_expression) { generate.bool().greaterThanOrEqual($start); }
    |  ^('<'  a=binary_expression b=binary_expression) { generate.bool().lessThan($start); }
    |  ^('>'  a=binary_expression b=binary_expression) { generate.bool().greaterThan($start); }
    |  binary_expression;

binary_expression
    :  ^('+' a=binary_expression b=binary_expression) { generate.arithmetic().add($start); }
    |  ^('-' a=binary_expression b=binary_expression) { generate.arithmetic().subtract($start); }
    |  ^('*' a=binary_expression b=binary_expression) { generate.arithmetic().multiply($start); }
    |  ^('/' a=binary_expression b=binary_expression) { generate.arithmetic().divide($start); }
    |  ^('%' a=binary_expression b=binary_expression) { generate.arithmetic().mod($start); }
    |  string_concatenation
    |  unary
    ;

string_concatenation
@init  { generate.string().builder(); }
@after { generate.string().finish(); }
    :  ^(STRING_PLUS string_concatenation_arg+);

string_concatenation_arg
    :  binary_expression { generate.string().append($start); };

unary
    : ^(UNARY_MINUS atom) { generate.arithmetic().negate($start); }
    |  atom
    ;

atom
    :  REAL       { generate.constant().load($start); }
    |  INTEGER    { generate.constant().load($start); }
    |  IDENTIFIER { generate.variable().reference((IdentifierNode)$start); }
    |  STRING     { generate.string().load($start); }
    | '(' expression ')'
    |  call
    ;

call
@init { generate.method().prepareCall((MethodNode)$start); }
    :  ^(CALL IDENTIFIER call_arguments?) { generate.method().call(((MethodNode)$start)); };

call_arguments
scope { ArrayList<ASTNode> arguments; }
@init { $call_arguments::arguments = new ArrayList<ASTNode>(); }
    :  ^(CALL_ARGUMENTS argument*);

argument
    : expression { $call_arguments::arguments.add((ASTNode)$expression.start); };

return_expression
    :  ^(RETURN expression) { generate.method().ret(); };
