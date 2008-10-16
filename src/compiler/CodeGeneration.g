tree grammar CodeGeneration;

options {
    tokenVocab=SemanticAnalysis;
    ASTLabelType=ASTNode;
}

@members {
  private CodeGenerator generate;
  private SymbolTable symbolTable;

  public CodeGeneration(TreeNodeStream input, SymbolTable symbolTable, String filename) {
    this(input);

    this.symbolTable = symbolTable;
    this.generate    = new CodeGenerator(symbolTable, filename);
  }
}

program
@init {
    generate.usingFrameId($program.start.getFrameId());
}
@after {
    generate.misc().finish();
    generate.getOutput().save();
}
    : (method_definition | atomic_operation)+;

atomic_operation
    :  conditional | loop | assignment | variable_definition | expression | return_expression;

method_definition
scope {
  int argumentCount;
}
@after { generate.method().finish($method_definition::argumentCount); }
    :  ^(METHOD method_header ^(PROGN atomic_operation+));

method_header
    :  ^(name=IDENTIFIER ((TYPE args+=IDENTIFIER)+)?) {
            generate.usingFrameId($method_header.start.getFrameId());
            generate.method().definition($name.text);
            $method_definition::argumentCount = $args.size() + 1;
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
            generate.misc().createVariable($name.text);
        };

assignment
@init  { generate.misc().pushThis(); }
    :  ^('=' name=IDENTIFIER value=expression) {
            generate.misc().assignToVariable($name.text);
        };

expression
    : boolean_expression;

boolean_expression
    :  ^('&&' a=comparision_expression b=boolean_expression)   { generate.bool().and(); }
    |  ^('||' a=comparision_expression b=boolean_expression)   { generate.bool().or(); }
    |  comparision_expression;

comparision_expression
    :  ^('==' a=arithmetic_expression b=arithmetic_expression) { generate.bool().equal(); }
    |  ^('<=' a=arithmetic_expression b=arithmetic_expression) { generate.bool().lessThanOrEqual(); }
    |  ^('>=' a=arithmetic_expression b=arithmetic_expression) { generate.bool().greaterThanOrEqual(); }
    |  ^('<'  a=arithmetic_expression b=arithmetic_expression) { generate.bool().lessThan(); }
    |  ^('>'  a=arithmetic_expression b=arithmetic_expression) { generate.bool().greaterThan(); }
    |  arithmetic_expression;

arithmetic_expression
    :  ^('+' a=arithmetic_expression b=arithmetic_expression) { generate.arithmetic().add(); }
    |  ^('-' a=arithmetic_expression b=arithmetic_expression) { generate.arithmetic().subtract(); }
    |  ^('*' a=arithmetic_expression b=arithmetic_expression) { generate.arithmetic().multiply(); }
    |  ^('/' a=arithmetic_expression b=arithmetic_expression) { generate.arithmetic().divide(); }
    |  ^('%' a=arithmetic_expression b=arithmetic_expression) { generate.arithmetic().mod(); }
    |  NUMBER                                                 { generate.misc().load(Integer.parseInt($NUMBER.text)); }
    |  IDENTIFIER                                             { generate.misc().loadVariable($IDENTIFIER.text); }
    |  STRING
    |  call
    ;

return_expression
    :  ^(RETURN expression)                                   { generate.method().ret(); };

call
@init { generate.method().prepareCall(); }
    :  ^(CALL IDENTIFIER call_arguments?)                     { generate.method().call($IDENTIFIER.text); };

call_arguments
scope { ArrayList<ASTNode> arguments; }
@init { $call_arguments::arguments = new ArrayList<ASTNode>(); }
    :  ^(CALL_ARGUMENTS argument*);

argument
    : expression { $call_arguments::arguments.add((ASTNode)$expression.start); };
