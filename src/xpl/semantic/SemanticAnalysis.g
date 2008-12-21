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
@after { symbolTable.exitScope(); }
    :  ^(METHOD method_header ^(PROGN (atomic_operation | method_definition)+)) {
            ((MethodNode)$start).setMethod($method_header.method);
        };

method_header returns [Method method]
    :  ^(name=IDENTIFIER ((types+=TYPE args+=IDENTIFIER)+)? return_type=TYPE) {
            List<Argument> arguments      = new ArrayList<Argument>();
            Type[]         argumentTypes  = new Type[$args.size()];
            TypeNode       returnTypeNode = (TypeNode) $return_type;

            int argId = 1;

            for(int i = 0; i < $args.size(); i++) {
                ASTNode  idNode   = (ASTNode)  $args.get(i);
                TypeNode typeNode = (TypeNode) $types.get(i);
                Type     type     = typeNode.getRepresentedType();

                arguments.add(new Argument(symbolTable.getNextScopeId(), type, idNode.getText(), argId));
                argumentTypes[i] = type;

                argId += (type == Types.Real ? 2 : 1);
            }

            Method method = new Method(symbolTable.getCurrentScopeId(), returnTypeNode.getRepresentedType(), $name.text, argumentTypes);
            symbolTable.put(method);
            symbolTable.enterScope();
            for(Argument arg : arguments)
                symbolTable.put(arg);
            $method = method;
        };

conditional
    :  ^(IF expression ^(PROGN atomic_operation+) (^(PROGN atomic_operation+) {
                System.out.println("Setting hasElse on true");
                $start.hasElse = true;
            })?) {
            System.out.println("Processing conditional");
        };

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

            Variable variable = new Variable(symbolTable.getCurrentScopeId(), lType, $name.text, variableId++);
            symbolTable.put(variable);
            ((VariableNode)$name).setVariable(variable);
        };

assignment
    :  ^('=' name=IDENTIFIER value=expression) {
          Variable variable = symbolTable.findVariable($name.text);
          if(variable == null)
            error(input, $name.line, "using an undeclared variable '" + $name.text + "'");
          $start.setNodeType($value.start.getNodeType());
          ((VariableNode)$name).setVariable(variable);
        };

expression
    : boolean_expression {
            $start.setNodeType($boolean_expression.start.getNodeType());
        };

boolean_expression
    :  ^(('&&' | '||') a=boolean_expression b=boolean_expression) {
            TypeChecker.infer($start, $a.start, $b.start);
        }
    |  comparision_expression {
            $start.setNodeType($comparision_expression.start.getNodeType());
        }
    ;

comparision_expression
    :  ^(('==' | '<=' | '>=' | '<' | '>') a=binary_expression b=binary_expression) {
            TypeChecker.infer($start, $a.start, $b.start);
        }
    |  binary_expression {
            $start.setNodeType($binary_expression.start.getNodeType());
        }
    ;

binary_expression
    :  ^(('-' | '*' | '/' | '%') a=binary_expression b=binary_expression) {
            TypeChecker.infer($start, $a.start, $b.start);
            if($start.isOf(Types.Real) && !$a.start.isOf(Types.Real))
                $a.start.setTypeToPromoteTo(Types.Real);
            if($start.isOf(Types.Real) && !$b.start.isOf(Types.Real))
                $b.start.setTypeToPromoteTo(Types.Real);
        }
    |  addition {
            $start.setNodeType($addition.start.getNodeType());
        }
    |  '(' expr=binary_expression ')' {
            $start.setNodeType($expr.start.getNodeType());
        }
    |  atom {
            $start.setNodeType($atom.start.getNodeType());
        }
    ;

addition
    : ^('+' a=addition_flatten b=addition_flatten) {
            TypeChecker.infer($start, $a.start, $b.start);
            if($start.isOf(Types.Real) && !$a.start.isOf(Types.Real))
                $a.start.setTypeToPromoteTo(Types.Real);
            if($start.isOf(Types.Real) && !$b.start.isOf(Types.Real))
                $b.start.setTypeToPromoteTo(Types.Real);
        }
        -> {$start.isOf(Types.String)}? ^(STRING_PLUS<ASTNode>[Types.String] addition_flatten+)
        -> ^('+' addition_flatten+)
    ;

addition_flatten
    : ^('+' (operands+=addition_flatten)+) {
            TypeChecker.infer($start, $operands);
        }
        -> {$start.isOf(Types.String)}? addition_flatten+
        -> ^('+' addition_flatten+)
    | binary_expression
    ;

atom
    :  REAL {
            $REAL.setNodeType(Types.Real);
       }
    |  INTEGER {
            $INTEGER.setNodeType(Types.Integer);
        }
    |  STRING {
            $STRING.setNodeType(Types.String);
        }
    |  IDENTIFIER {
            Identifier identifier = symbolTable.findIdentifier($IDENTIFIER.text);
            if(identifier == null)
              error(input, $IDENTIFIER.line, "using an undeclared variable '" + $IDENTIFIER.text + "'");
            else
              $IDENTIFIER.setNodeType(identifier.getType());
            ((IdentifierNode)$IDENTIFIER).setIdentifier(identifier);
        }
    |  call
    ;

return_expression
    :  ^(RETURN expression)
    ;

call
    :  ^(CALL IDENTIFIER ^(CALL_ARGUMENTS (args+=expression)+)) {
          Type[] callSignature = new Type[$args.size()];
          for(int i = 0; i < $args.size(); i++) {
            ASTNode node = (ASTNode)$args.get(i);
            if(node == null)
              throw new RecognitionException(input);

            callSignature[i] = node.getNodeType();

            if(callSignature[i] == null)
              throw new RecognitionException(input);
          }

          Method method = symbolTable.findMethod($IDENTIFIER.text, callSignature);

          if(method == null) {
            error(input, $IDENTIFIER.line, "no method '" + $IDENTIFIER.text + "' with this signature");
            return null;
          }

          MethodNode node = ((MethodNode)$start);
          node.setMethod(method);
          node.setNodeType(method.getReturnType());
        }
    ;
