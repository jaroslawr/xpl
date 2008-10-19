tree grammar SemanticAnalysis;

options {
    tokenVocab=Xpl;
    ASTLabelType=ASTNode;
    output=AST;
    rewrite=true;
    backtrack=true;
}

@members {
  private SymbolTable symbolTable = new SymbolTable();
  public  SymbolTable getSymbolTable() { return symbolTable; }

  private ArrayList<String> errors = new ArrayList<String>();
  public  ArrayList<String> getErrors() { return errors; }

  private int localVariableId = 0;

  public void reportError(RecognitionException e) {}

  public boolean containsString(List<ASTNode> astNodes) {
      for(ASTNode node : astNodes)
          if(node.getExpType() == "string")
             return true;
      return false;
  }
}

program
@init  { $program.start.setFrameId(symbolTable.getCurrentFrameId()); }
@after { if(!errors.isEmpty()) throw new SemanticAnalysisError(); }
    : (method_definition | atomic_operation)+;
catch [RecognitionException re] {
    throw re;
}

atomic_operation
    :  (conditional | loop | variable_definition | assignment | expression | return_expression);

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
    :  ^(IF expression ^(PROGN atomic_operation+) (^(PROGN atomic_operation+) { $conditional.start.hasElse = true; })?);

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
    :  ^(('&&' | '||') a=comparision_expression b=boolean_expression)
    |  comparision_expression
    ;

comparision_expression
    :  ^(('==' | '<=' | '>=' | '<' | '>') a=binary_expression b=binary_expression)
    |  binary_expression
    |  addition
    ;

binary_expression
    :  ^(('-' | '*' | '/' | '%') a=binary_expression b=binary_expression) {
            if($a.start.getExpType() == "string" || $b.start.getExpType() == "string")
                $start.setExpType("string");
            else
                $start.setExpType("integer");
        }
    | '(' binary_expression ')'
    | atom
    ;

atom
    :  NUMBER     { $NUMBER.setExpType("integer"); }
    |  STRING     { $STRING.setExpType("string"); }
    |  IDENTIFIER { $IDENTIFIER.setExpType("integer"); }
    |  call
    ;

addition
    :  ^('+' string_plus_fold exp=binary_expression)
       -> { $string_plus_fold.start.getExpType() == "string" || $exp.start.getExpType() == "string" }?
          ^(STRING_PLUS string_plus_fold $exp)
       -> ^('+' string_plus_fold $exp)
    | string_plus_fold
    ;

string_plus_fold
    :  ^('+' (exps+=binary_expression)+)
        {
            if(containsString($exps))
                $start.setExpType("string");
            else
                $start.setExpType("integer");
        }
        -> {$start.getExpType() == "string"}? binary_expression+
        ->                                   ^('+' binary_expression+)
    |  ^('+' rest=string_plus_fold exp=binary_expression)
        {
            if($rest.start.getExpType() == "string" || $exp.start.getExpType() == "string")
                $start.setExpType("string");
            else
                $start.setExpType("integer");
        }
        -> {$start.getExpType() == "string"}?   $rest $exp
        ->                                      ^('+' $rest $exp)
    |  atom
    ;

return_expression: ^(RETURN expression);

call:              ^(CALL IDENTIFIER ^(CALL_ARGUMENTS expression+));
