tree grammar SemanticAnalysis;

options {
    tokenVocab=Xpl;
    ASTLabelType=ASTNode;
    output=AST;
    rewrite=true;
    backtrack=true;
}

@header {
    package xpl.semantic;

    import xpl.exceptions.*;
    import xpl.semantic.ast.*;
    import xpl.semantic.symbols.*;
}

@members {
    private SymbolTable symbolTable = new SymbolTable();

    private ArrayList<String> errors = new ArrayList<String>();
    public  ArrayList<String> getErrors() { return errors; }

    private int variableId = 0;

    public void reportError(RecognitionException e) {}

    private void error(TreeNodeStream input, int line, String message) throws RecognitionException {
        errors.add("Line " + line + ": " + message);
        throw new RecognitionException(input);
    }

    private void deduceType(ASTNode deduced, ASTNode a, ASTNode b) {
        if(a.isOf(Types.String) || b.isOf(Types.String))
            deduced.setNodeType(Types.String);
        else
            deduced.setNodeType(Types.Integer);
    }

    private void deduceType(ASTNode deduced, List<ASTNode> list) {
        if(containsString(list))
            deduced.setNodeType(Types.String);
        else
            deduced.setNodeType(Types.Integer);
    }

    private void deduceType(ASTNode deduced, ASTNode node, List<ASTNode> list) {
        if(node.isOf(Types.String) || containsString(list))
            deduced.setNodeType(Types.String);
        else
            deduced.setNodeType(Types.Integer);
    }

    private boolean containsString(List<ASTNode> astNodes) {
        for(ASTNode node : astNodes)
            if(node.isOf(Types.String))
                return true;
        return false;
    }
}

program
@after { if(!errors.isEmpty()) throw new SemanticAnalysisError(); }
    : (method_definition | atomic_operation)+;
catch [RecognitionException re] {
    throw re;
}

atomic_operation
    :  (conditional | loop | variable_definition | assignment | expression | return_expression);

method_definition
@after { symbolTable.exitFrame(); }
    :  ^(METHOD method_header ^(PROGN atomic_operation+)) {
            ((MethodNode)$start).setMethod($method_header.method);
        };

method_header returns [Method method]
    :  ^(name=IDENTIFIER ((types+=TYPE args+=IDENTIFIER)+)?) {
            List<Argument> arguments     = new ArrayList<Argument>();
            Type[]         argumentTypes = new Type[$args.size()];

            for(int i = 0; i < $args.size(); i++) {
                ASTNode  argNode = (ASTNode) $args.get(i);
                String   argType = ((ASTNode) $types.get(i)).getText();
                Type     type     = argType.equals("int") ? Types.Integer : Types.String;

                arguments.add(new Argument(type, argNode.getText(), i+1));
                argumentTypes[i] = type;
            }

            Method method = new Method(Types.Integer, $name.text, argumentTypes);
            symbolTable.put(method);
            symbolTable.enterNewFrame();
            for(Argument arg : arguments)
                symbolTable.put(arg);
            $method = method;
        };

conditional
    :  ^(IF expression ^(PROGN atomic_operation+) (^(PROGN atomic_operation+) { $conditional.start.hasElse = true; })?);

loop
    :  ^(WHILE expression ^(PROGN atomic_operation+));

variable_definition
    :  ^('=' TYPE name=IDENTIFIER value=expression) {
            Variable var = symbolTable.findVariable($name.text);
            if(var != null)
              error(input, $name.line, "declaring an already declared variable");
            Type type = $value.start.getNodeType();
            Variable variable = new Variable(type, $name.text, variableId++);
            symbolTable.put(variable);
            ((VariableNode)$name).setVariable(variable);
        };

assignment
    :  ^('=' name=IDENTIFIER value=expression) {
          Variable variable = symbolTable.findVariable($name.text);
          if(variable == null)
            error(input, $name.line, "using an undeclared variable");
          $start.setNodeType($value.start.getNodeType());
          ((VariableNode)$name).setVariable(variable);
        };

expression
    : boolean_expression { $start.setNodeType($boolean_expression.start.getNodeType()); };

boolean_expression
    :  ^(('&&' | '||') a=comparision_expression b=boolean_expression)
    |  comparision_expression { $start.setNodeType($comparision_expression.start.getNodeType()); }
    ;

comparision_expression
    :  ^(('==' | '<=' | '>=' | '<' | '>') a=binary_expression b=binary_expression)
    |  binary_expression { $start.setNodeType(Types.Integer); }
    |  addition          { $start.setNodeType($addition.start.getNodeType()); }
    ;

binary_expression
    :  ^(('-' | '*' | '/' | '%') a=binary_expression b=binary_expression) { deduceType($start, $a.start, $b.start); }
    | '(' binary_expression ')'
    | atom
    ;

atom
    :  NUMBER     { $NUMBER.setNodeType(Types.Integer); }
    |  STRING     { $STRING.setNodeType(Types.String); }
    |  IDENTIFIER {
            Identifier identifier = symbolTable.findIdentifier($IDENTIFIER.text);
            if(identifier != null)
                $IDENTIFIER.setNodeType(identifier.getType());
            ((IdentifierNode)$IDENTIFIER).setIdentifier(identifier);
        }
    |  call
    ;

addition
    :  ^('+' string_plus_fold binary_expression) { deduceType($start, $string_plus_fold.start, $binary_expression.start); }
       -> { $start.isOf(Types.String) }? ^(STRING_PLUS string_plus_fold binary_expression)
       ->                                ^('+' string_plus_fold binary_expression)
    | string_plus_fold                   { $start.setNodeType($string_plus_fold.start.getNodeType()); }
    ;

string_plus_fold
    :  ^('+' (exps+=binary_expression)+) { deduceType($start, $exps); }
        -> {$start.isOf(Types.String)}? binary_expression+
        -> ^('+' binary_expression+)
    |  ^('+' rest=string_plus_fold exp=binary_expression) { deduceType($start, $rest.start, $exp.start); }
        -> {$start.isOf(Types.String)}?   $rest $exp
        -> ^('+' $rest $exp)
    |  atom { $start.setNodeType($atom.start.getNodeType()); }
    ;

return_expression
    :   ^(RETURN expression)
    ;

call
    :   ^(CALL IDENTIFIER ^(CALL_ARGUMENTS expression+)) {
        Method method = symbolTable.findMethod($IDENTIFIER.text);
        ((MethodNode)$start).setMethod(method);
    }
    ;
