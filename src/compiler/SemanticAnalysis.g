tree grammar SemanticAnalysis;

options {
    tokenVocab=Xpl;
    ASTLabelType=ASTNode;
}

@members {
  private SymbolTable symbolTable = new SymbolTable();
}

program
@init { $program.start.scope = symbolTable.enterScope(); }
    : ((method_definition | atomic_operation) newline?)+;

atomic_operation
    :  conditional | loop | variable_definition | assignment | expression | return_expression;

atomic_operations_list
    :  atomic_operation+;

method_definition
@after { symbolTable.exitScope(); }
    :  ^(METHOD method_header METHOD_BODY method_body);

method_header
    :  ^(name=IDENTIFIER ((type_declaration args+=IDENTIFIER)+)?) {
          ArrayList<String> arguments = new ArrayList<String>();
          for(Object tree : $args)
            arguments.add(((ASTNode)tree).getText());
          Scope scope = symbolTable.addMethod($name.text, arguments);
          $method_header.start.scope = scope;
        };

method_body
    :  atomic_operation+;

conditional
    :  ^(IF conditional_test IF_BODY atomic_operations_list);

conditional_test
    :  expression;

conditional_else
    :  ^(ELSE expression ELSE_BODY atomic_operations_list);

loop
    :  ^(WHILE loop_test WHILE_BODY atomic_operations_list);

loop_test
    :  expression;

variable_definition
    :  ^('=' type_declaration name=IDENTIFIER value=expression) {
            LocalVariable var = symbolTable.findLocalVariable($name.text);
            if(var != null)
                // foo already defined
                return;
            symbolTable.addLocalVariable($name.text);
        };

assignment
    :  ^('=' name=IDENTIFIER value=expression) {
          LocalVariable var = symbolTable.findLocalVariable($name.text);
          $assignment.start.type = $value.start.type;
        };

type_declaration: 'int';

expression
@init { $expression.start.type = "integer"; }
    : exp=boolean_expression;

boolean_expression
    :  ^('&&' a=comparision_expression b=boolean_expression)
    |  ^('||' a=comparision_expression b=boolean_expression)
    |  comparision_expression
    ;

comparision_expression
    :  ^('==' a=arithmetic_expression b=arithmetic_expression)
    |  ^('<=' a=arithmetic_expression b=arithmetic_expression)
    |  ^('>=' a=arithmetic_expression b=arithmetic_expression)
    |  ^('<'  a=arithmetic_expression b=arithmetic_expression)
    |  ^('>'  a=arithmetic_expression b=arithmetic_expression)
    |  arithmetic_expression
    ;

arithmetic_expression
    :  ^('+' a=arithmetic_expression b=arithmetic_expression)
    |  ^('-' a=arithmetic_expression b=arithmetic_expression)
    |  ^('*' a=arithmetic_expression b=arithmetic_expression)
    |  ^('/' a=arithmetic_expression b=arithmetic_expression)
    |  ^('%' a=arithmetic_expression b=arithmetic_expression)
    |  number
    |  string
    |  identifier
    |  call
    ;

return_expression
    :  ^(RETURN expression);

call
    :  ^(CALL IDENTIFIER call_arguments?);

call_arguments
    :  ^(CALL_ARGUMENTS call_arguments_list);

call_arguments_list
    :  expression*;

number:         NUMBER { $number.start.type = "integer"; };

string:         STRING { $string.start.type = "string"; };

identifier:     IDENTIFIER { $identifier.start.type = "integer"; };

method_name:    IDENTIFIER;

variable_name:  IDENTIFIER;

newline:        NEWLINE;
