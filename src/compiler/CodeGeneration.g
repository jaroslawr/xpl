tree grammar CodeGeneration;

options {
    tokenVocab=SemanticAnalysis;
    ASTLabelType=ASTNode;
}

@members {
  private CodeGenerator generate;

  public CodeGeneration(TreeNodeStream input, String filename) {
    this(input);
    generate = new CodeGenerator(filename);
  }
}

program
@after {
    generate.misc().finish();
    generate.getOutput().save();
}
    : ((method_definition | atomic_operation) newline?)+ {
          generate.switchScope($program.start.scope);
        };

atomic_operation
    :  conditional | loop | assignment | expression | return_expression;

atomic_operations_list
    :  atomic_operation+;

method_definition
@after { generate.method().finish(); }
    :  ^(METHOD method_header METHOD_BODY method_body);

method_header
    :  ^(name=IDENTIFIER ((type_declaration args+=IDENTIFIER)+)?) {
          generate.switchScope($method_header.start.scope);
          generate.method().definition($name.text);
};

method_body
    :  atomic_operation+;

conditional
@after { generate.conditional().ifAfterBody(); }
    :  ^(IF conditional_test IF_BODY atomic_operations_list);

conditional_test
@after { generate.conditional().ifAfterCondition(); }
    :  expression;

conditional_else
    :  ^(ELSE expression ELSE_BODY atomic_operations_list);

conditional_body
    :  (conditional | assignment | expression)+;

loop
    :  ^(WHILE loop_test WHILE_BODY loop_body);

loop_test
@init  { generate.loop().whileBeforeCondition(); }
@after { generate.loop().whileAfterCondition(); }
    :  expression;

loop_body
@after { generate.loop().whileAfterBody(); }
    :  (conditional | assignment | expression)+;

assignment
@init  { generate.misc().pushThis(); }
    :  ^('=' type_declaration var=IDENTIFIER val=expression) { generate.misc().storeVariable($var.text); };

variable_declaration: type_declaration identifier;

type_declaration: 'int';

expression
    : boolean_expression;

boolean_expression
    :  ^('&&' a=comparision_expression b=boolean_expression) { generate.bool().and(); }
    |  ^('||' a=comparision_expression b=boolean_expression) { generate.bool().or(); }
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
    :  ^(RETURN expression) { generate.method().ret(); };

call
@init { generate.method().prepareCall(); }
    :  ^(CALL IDENTIFIER call_arguments?)                     { generate.method().call($IDENTIFIER.text); };

call_arguments
scope {
  ArrayList<ASTNode> arguments;
}
@init { $call_arguments::arguments = new ArrayList<ASTNode>(); }
    :  ^(CALL_ARGUMENTS argument*)  {
          System.out.println("Arguments");
          for(ASTNode argument : $call_arguments::arguments)
              System.out.println(argument);
          System.out.println();
        };

argument: expression {
          $call_arguments::arguments.add((ASTNode)$expression.start);
        };

number:         NUMBER;

string:         STRING;

identifier:     IDENTIFIER;

method_name:    IDENTIFIER;

variable_name:  IDENTIFIER;

newline:        NEWLINE;
