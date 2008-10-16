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
    : (method_definition | atomic_operation)+;
catch [RecognitionException re] {
    throw re;
}

atomic_operation
    :  conditional | loop | variable_definition | assignment | expression | return_expression;

method_definition
@after { symbolTable.exitFrame(); }
    :  ^(METHOD method_header ^(PROGN atomic_operation+));

method_header
    :  ^(name=IDENTIFIER ((TYPE args+=IDENTIFIER)+)?) {
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

conditional
    :  ^(IF expression ^(PROGN atomic_operation+));

loop
    :  ^(WHILE expression ^(PROGN atomic_operation+));

variable_definition
    :  ^('=' TYPE name=IDENTIFIER value=expression) {
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
    :  ^(boolean_op a=comparision_expression b=boolean_expression)
    |  comparision_expression
    ;

boolean_op
    : '&&' | '||';

comparision_expression
    :  ^(comparision_op a=arithmetic_expression b=arithmetic_expression)
    |  arithmetic_expression
    ;

comparision_op
    : '==' | '<=' | '>=' | '<' | '>';

arithmetic_expression
    :  ^(arithmetic_op a=arithmetic_expression b=arithmetic_expression)
    |  NUMBER
    |  STRING
    |  IDENTIFIER
    |  call
    ;

arithmetic_op
    : '+' | '-' | '*' | '/' | '%';

return_expression: ^(RETURN expression);

call:              ^(CALL IDENTIFIER ^(CALL_ARGUMENTS expression+));

number:            NUMBER     { $number.start.setExpType("integer"); };

string:            STRING     { $string.start.setExpType("string"); };

reference:         IDENTIFIER { $IDENTIFIER.setExpType("integer"); };
