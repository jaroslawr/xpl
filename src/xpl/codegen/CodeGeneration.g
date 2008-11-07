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

    public String strip(String literal) {
        return literal.substring(1, literal.length() - 1);
    }
}

program
@after {
    generate.misc().finish();
    generate.getOutput().save();
}
    : (method_definition | atomic_operation)+;

atomic_operation
    :  conditional | loop | assignment | variable_definition | expression | return_expression;

method_definition
@after { generate.method().finish((MethodNode)$start); }
    :  ^(METHOD header=method_header[(MethodNode)$start] ^(PROGN (atomic_operation | method_definition)+));

method_header[MethodNode methodNode] returns [int argumentsCount]
    :  ^(name=IDENTIFIER ((TYPE args+=IDENTIFIER)+)? return_type=TYPE) {
            generate.method().definition(methodNode);
            {$argumentsCount = $args.size() + 1;}
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
@init  { generate.misc().pushThis(); }
    :  ^('=' TYPE name=IDENTIFIER value=expression) {
            generate.misc().createVariable(((VariableNode)$name));
        };

assignment
@init  { generate.misc().pushThis(); }
    :  ^('=' name=IDENTIFIER value=expression) {
            generate.misc().assignToVariable(((VariableNode)$name));
        };

expression
    : boolean_expression;

boolean_expression
    :  ^('&&' a=boolean_expression b=boolean_expression) { generate.bool().and(); }
    |  ^('||' a=boolean_expression b=boolean_expression) { generate.bool().or(); }
    |  comparision_expression;

comparision_expression
    :  ^('==' a=binary_expression b=binary_expression) { generate.bool().equal(); }
    |  ^('<=' a=binary_expression b=binary_expression) { generate.bool().lessThanOrEqual(); }
    |  ^('>=' a=binary_expression b=binary_expression) { generate.bool().greaterThanOrEqual(); }
    |  ^('<'  a=binary_expression b=binary_expression) { generate.bool().lessThan(); }
    |  ^('>'  a=binary_expression b=binary_expression) { generate.bool().greaterThan(); }
    |  binary_expression;

binary_expression
    :  ^('+' a=binary_expression b=binary_expression) { generate.arithmetic().add(); }
    |  ^('-' a=binary_expression b=binary_expression) { generate.arithmetic().subtract(); }
    |  ^('*' a=binary_expression b=binary_expression) { generate.arithmetic().multiply(); }
    |  ^('/' a=binary_expression b=binary_expression) { generate.arithmetic().divide(); }
    |  ^('%' a=binary_expression b=binary_expression) { generate.arithmetic().mod(); }
    |  string_concatenation
    |  atom
    ;

string_concatenation
@init  { generate.string().builder(); }
@after { generate.string().finish(); }
    :  ^(STRING_PLUS string_concatenation_arg+);

string_concatenation_arg
    :  binary_expression {
            if($start.isOf(Types.String))
                generate.string().appendString();
            else
                generate.string().appendInteger();
        };

atom
    :  NUMBER     { generate.misc().load(Integer.parseInt($NUMBER.text)); }
    |  IDENTIFIER { generate.misc().loadVariable((IdentifierNode)$IDENTIFIER); }
    |  STRING     { generate.string().load(strip($STRING.text)); }
    | '(' expression ')'
    |  call
    ;

call
@init { generate.method().prepareCall(); }
    :  ^(CALL IDENTIFIER call_arguments?) { generate.method().call(((MethodNode)$start)); };

call_arguments
scope { ArrayList<ASTNode> arguments; }
@init { $call_arguments::arguments = new ArrayList<ASTNode>(); }
    :  ^(CALL_ARGUMENTS argument*);

argument
    : expression { $call_arguments::arguments.add((ASTNode)$expression.start); };

return_expression
    :  ^(RETURN expression) { generate.method().ret(); };
