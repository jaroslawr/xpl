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

  private void error(TreeNodeStream input, int line, String message) throws RecognitionException {
      errors.add("Line " + line + ": " + message);
      throw new RecognitionException(input);
  }

  private void deduceType(ASTNode deduced, ASTNode a, ASTNode b) {
      if(a.getExpType() == "string" || b.getExpType() == "string")
          deduced.setExpType("string");
      else
          deduced.setExpType("integer");
  }

  private void deduceType(ASTNode deduced, List<ASTNode> list) {
      if(containsString(list))
          deduced.setExpType("string");
      else
          deduced.setExpType("integer");
  }

  private void deduceType(ASTNode deduced, ASTNode node, List<ASTNode> list) {
      if(node.getExpType() == "string" || containsString(list))
          deduced.setExpType("string");
      else
          deduced.setExpType("integer");
  }

  private boolean containsString(List<ASTNode> astNodes) {
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
            if(var != null)
              error(input, $name.line, "declaring an already declared variable");
            Type type = new Type($value.start.getExpType());
            LocalVariable localVariable = new LocalVariable(type, $name.text, localVariableId++);
            symbolTable.put(localVariable);
        };

assignment
    :  ^('=' name=IDENTIFIER value=expression) {
          LocalVariable var = symbolTable.findLocalVariable($name.text);
          if(var == null)
            error(input, $name.line, "using an undeclared variable");
          $start.setExpType($value.start.getExpType());
        };

expression
    : boolean_expression { $start.setExpType($boolean_expression.start.getExpType()); };

boolean_expression
    :  ^(('&&' | '||') a=comparision_expression b=boolean_expression)
    |  comparision_expression { $start.setExpType($comparision_expression.start.getExpType()); }
    ;

comparision_expression
    :  ^(('==' | '<=' | '>=' | '<' | '>') a=binary_expression b=binary_expression)
    |  binary_expression { $start.setExpType("integer"); }
    |  addition          { $start.setExpType($addition.start.getExpType()); }
    ;

binary_expression
    :  ^(('-' | '*' | '/' | '%') a=binary_expression b=binary_expression) { deduceType($start, $a.start, $b.start); }
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
    :  ^('+' string_plus_fold binary_expression) { deduceType($start, $string_plus_fold.start, $binary_expression.start); }
       -> { $start.getExpType() == "string" }? ^(STRING_PLUS string_plus_fold binary_expression)
       ->                                      ^('+' string_plus_fold binary_expression)
    | string_plus_fold                           { $start.setExpType($string_plus_fold.start.getExpType()); }
    ;

string_plus_fold
    :  ^('+' (exps+=binary_expression)+) { deduceType($start, $exps); }
        -> {$start.getExpType() == "string"}? binary_expression+
        -> ^('+' binary_expression+)
    |  ^('+' rest=string_plus_fold exp=binary_expression) { deduceType($start, $rest.start, $exp.start); }
        -> {$start.getExpType() == "string"}?   $rest $exp
        -> ^('+' $rest $exp)
    |  atom { $start.setExpType($atom.start.getExpType()); }
    ;

return_expression: ^(RETURN expression);

call:              ^(CALL IDENTIFIER ^(CALL_ARGUMENTS expression+));
