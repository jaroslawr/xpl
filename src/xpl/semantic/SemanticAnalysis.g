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
    :  ^(name=IDENTIFIER ((types+=TYPE args+=IDENTIFIER)+)? return_type=TYPE) {
            List<Argument> arguments      = new ArrayList<Argument>();
            Type[]         argumentTypes  = new Type[$args.size()];
            TypeNode       returnTypeNode = (TypeNode) $return_type;

            for(int i = 0; i < $args.size(); i++) {
                ASTNode  idNode   = (ASTNode)  $args.get(i);
                TypeNode typeNode = (TypeNode) $types.get(i);

                Type type = typeNode.getRepresentedType();
                arguments.add(new Argument(type, idNode.getText(), i+1));
                argumentTypes[i] = type;
            }

            Method method = new Method(returnTypeNode.getRepresentedType(), $name.text, argumentTypes);
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
    :  ^('=' decl_type=TYPE name=IDENTIFIER value=expression) {
            Variable var = symbolTable.findVariable($name.text);
            if(var != null)
              error(input, $name.line, "declaring an already declared variable");

            Type lType = ((TypeNode)$decl_type).getRepresentedType();
            Type rType = $value.start.getNodeType();

            if(!lType.equals(rType))
              error(input, $name.line, "the declared type isn't the same as the r-value type");

            Variable variable = new Variable(lType, $name.text, variableId++);
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
    :  ^(('&&' | '||') a=boolean_expression b=boolean_expression)
    |  comparision_expression { $start.setNodeType($comparision_expression.start.getNodeType()); }
    ;

comparision_expression
    :  ^(('==' | '<=' | '>=' | '<' | '>') a=binary_expression b=binary_expression)
    |  binary_expression { $start.setNodeType($binary_expression.start.getNodeType()); }
    |  addition          { $start.setNodeType($addition.start.getNodeType()); }
    ;

binary_expression
    :  ^(('-' | '*' | '/' | '%') a=binary_expression b=binary_expression) { TypeChecker.infer($start, $a.start, $b.start); }
    | '(' expr=binary_expression ')' { $start.setNodeType($expr.start.getNodeType()); }
    | atom                           { $start.setNodeType($atom.start.getNodeType()); }
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
    :  ^('+' string_plus_fold binary_expression) { TypeChecker.infer($start, $string_plus_fold.start, $binary_expression.start); }
       -> { $start.isOf(Types.String) }? ^(STRING_PLUS string_plus_fold binary_expression)
       ->                                ^('+' string_plus_fold binary_expression)
    | string_plus_fold                   { $start.setNodeType($string_plus_fold.start.getNodeType()); }
    ;

string_plus_fold
    :  ^('+' (exps+=binary_expression)+) { TypeChecker.infer($start, $exps); }
        -> {$start.isOf(Types.String)}? binary_expression+
        -> ^('+' binary_expression+)
    |  ^('+' rest=string_plus_fold exp=binary_expression) { TypeChecker.infer($start, $rest.start, $exp.start); }
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
