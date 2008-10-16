tree grammar SemanticAnalysis;

options {
    tokenVocab=Xpl;
    ASTLabelType=ASTNode;
}

@members {
  private SymbolTable symbolTable = new SymbolTable();
  public  SymbolTable getSymbolTable() { return symbolTable; }

  private ArrayList<String> errors = new ArrayList<String>();
  public ArrayList<String> getErrors() { return errors; }

  private int localVariableId = 0;

  public void reportError(RecognitionException e) {}
}

program
@init  {
    $program.start.setFrameId(symbolTable.getCurrentFrameId());
}
@after { if(!errors.isEmpty()) throw new SemanticAnalysisError(); }
    : ((method_definition | atomic_operation) newline?)+;
catch [RecognitionException re] {
    throw re;
}

atomic_operation
    :  conditional | loop | variable_definition | assignment | expression | return_expression;

atomic_operations_list
    :  atomic_operation+;

method_definition
@after { symbolTable.exitFrame(); }
    :  ^(METHOD method_header METHOD_BODY method_body);

method_header
    :  ^(name=IDENTIFIER ((type_declaration args+=IDENTIFIER)+)?) {
            Type type = new Type("integer");
            Method method = new Method(type, $name.text, $args.size());
            symbolTable.put(method);
            symbolTable.enterNewFrame();
            for(int i = 0; i < $args.size(); i++) {
                ASTNode node   = (ASTNode) $args.get(i);
                String argName = node.getText();
                symbolTable.put(new Argument(type, argName, i+1));
            }
            $method_header.start.setFrameId(symbolTable.getCurrentFrameId());
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
            if(var != null) {
              errors.add("Line " + $name.line + ": declaring an already declared variable");
              throw new RecognitionException(input);
            }
            LocalVariable localVariable = new LocalVariable(new Type("integer"), $name.text, localVariableId++);
            symbolTable.put(localVariable);
        };

assignment
    :  ^('=' name=IDENTIFIER value=expression) {
          LocalVariable var = symbolTable.findLocalVariable($name.text);
          if(var == null) {
              errors.add("Line " + $name.line + ": using an undeclared variable");
              throw new RecognitionException(input);
          }
          $assignment.start.setExpType($value.start.getExpType());
        };

expression
@init { $expression.start.setExpType("integer"); }
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

number:           NUMBER { $number.start.setExpType("integer"); };

string:           STRING { $string.start.setExpType("string"); };

identifier:       IDENTIFIER { $identifier.start.setExpType("integer"); };

method_name:      IDENTIFIER;

type_declaration: TYPE;

variable_name:    IDENTIFIER;

newline:          NEWLINE;
