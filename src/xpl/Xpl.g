grammar Xpl;

options { output=AST; ASTLabelType=ASTNode; }

tokens  { CALL; CALL_ARGUMENTS; WHILE; IF; METHOD; PROGN; RETURN; STRING_PLUS; TOREAL; TOSTRING; UNARY_MINUS; }

@header {
    package xpl;
    import xpl.exceptions.*;
    import xpl.semantic.ast.*;
}

@lexer::header {
    package xpl;
}

@members {
    private ArrayList<String> errors = new ArrayList<String>();
    public  ArrayList<String> getErrors() { return errors; }

    public void reportError(RecognitionException e) {
        errors.add(getErrorHeader(e) + " " + getErrorMessage(e, getTokenNames()));
        state.errorRecovery = true;
    }
}

program:                 (method_definition | atomic_operation)+ {  if(!errors.isEmpty()) throw new SyntacticAnalysisError(); };
catch [RecognitionException re] { throw re; }

atomic_operation:        conditional | loop | assignment | variable_definition | expression | return_expression;

method_definition:       method_header method_operation+ 'end' -> ^(METHOD<node=MethodDefinitionNode> method_header ^(PROGN method_operation+));

method_header:           'fn' IDENTIFIER '(' method_arguments? ')' '-' '>' TYPE -> ^(IDENTIFIER method_arguments? TYPE<TypeNode>);

method_arguments:        variable_declaration (','! variable_declaration)*;

method_operation:        atomic_operation | method_definition;

return_expression:       'return' expression -> ^(RETURN expression);

call:                    IDENTIFIER '(' call_arguments? ')' -> ^(CALL<node=MethodCallNode> IDENTIFIER call_arguments?);

call_arguments:          expression (',' expression)* -> ^(CALL_ARGUMENTS expression+);

conditional:             'if' expression (true_branch+=atomic_operation)+ ('else' (false_branch+=atomic_operation)+)? 'end'
                         -> ^(IF expression ^(PROGN $true_branch) ^(PROGN $false_branch)?);

loop:                    'while' expression atomic_operation+ 'end' -> ^(WHILE expression ^(PROGN atomic_operation+));

variable_declaration:    TYPE<TypeNode> IDENTIFIER<VariableNode>;

variable_definition:     TYPE<TypeNode> IDENTIFIER<VariableNode> '='^ expression;

assignment:              IDENTIFIER<VariableNode> '='^ expression;

expression:              boolean_expression;

boolean_expression:      comparision_expression (('&&' | '||')^ comparision_expression)*;

comparision_expression:  binary_expression (('==' | '<=' | '>=' | '<' | '>')^ binary_expression)?;

binary_expression:       term (('+' | '-')^ term)*;

term:		             unary (('*' | '/' | '%')^ unary)*;

unary:                   (('-' unary) -> ^(UNARY_MINUS unary)) | atom;

atom:                    REAL | INTEGER | STRING | (IDENTIFIER '(') => call | '('! expression ')'! | IDENTIFIER<IdentifierNode>;

STRING:                  '\"' (options {greedy=false;}: ('A'..'z') | ' ' | '(' | ')' | ':' | '-')* '\"';

REAL:                    ('0'..'9')+ '.' ('0'..'9')+;

INTEGER:    	         ('0'..'9')+;

TYPE:                    'int' | 'real' | 'string' | 'void';

IDENTIFIER:              ('a'..'z' | '_')+;

NEWLINE:                 ('\n')+ { emit(); skip(); };

WS:                      (' ' | '\t')+ { skip(); };
