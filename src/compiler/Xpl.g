grammar Xpl;

options { output=AST; ASTLabelType=ASTNode; }

tokens  { CALL; CALL_ARGUMENTS; WHILE; IF; METHOD; PROGN; RETURN; STRING_PLUS; TOSTRING; }

@members {
    private ArrayList<String> errors = new ArrayList<String>();
    public  ArrayList<String> getErrors() { return errors; }

    public void reportError(RecognitionException e) {
        errors.add(getErrorHeader(e) + " " + getErrorMessage(e, getTokenNames()));
        state.errorRecovery = true;
    }
}

program
@after { if(!errors.isEmpty()) throw new SyntacticAnalysisError(); }
    :                    (method_definition | atomic_operation)+;
catch [RecognitionException re] {
    throw re;
}

atomic_operation:        conditional | loop | assignment | variable_definition | expression | return_expression;

method_definition:       method_header atomic_operation+ 'end' -> ^(METHOD method_header ^(PROGN atomic_operation+));

method_header:           'method' IDENTIFIER '(' method_arguments? ')' -> ^(IDENTIFIER method_arguments?);

method_arguments:        variable_declaration (','! variable_declaration)*;

return_expression:       'return' expression -> ^(RETURN expression);

call:                    IDENTIFIER '(' call_arguments? ')' -> ^(CALL IDENTIFIER call_arguments?);

call_arguments:          arguments+=expression (',' arguments+=expression)* -> ^(CALL_ARGUMENTS $arguments);

conditional:             'if' expression (true_branch+=atomic_operation)+ ('else' (false_branch+=atomic_operation)+)? 'end'
                         -> ^(IF expression ^(PROGN $true_branch) ^(PROGN $false_branch)?);

loop:                    'while' expression atomic_operation+ 'end' -> ^(WHILE expression ^(PROGN atomic_operation+));

variable_declaration:    TYPE IDENTIFIER;

variable_definition:     TYPE IDENTIFIER '='^ expression;

assignment:              IDENTIFIER '='^ expression;

expression:              boolean_expression;

boolean_expression:      comparision_expression (('&&' | '||')^ boolean_expression)?;

comparision_expression:  binary_expression (('==' | '<=' | '>=' | '<' | '>')^ binary_expression)?;

binary_expression:       term (('+' | '-')^ term)*;

term:		             factor (('*' | '/')^ factor)*;

factor:                  atom ('%'^ atom)*;

atom:                    NUMBER | STRING | (IDENTIFIER '(') => call | '('! expression ')'! | IDENTIFIER;

STRING:                  '\"' (options {greedy=false;}: ('A'..'z') | ' ')* '\"';

NUMBER:    	             ('0'..'9')+;

TYPE:                    'int' | 'string';

IDENTIFIER:              ('a'..'z')+;

NEWLINE:                 ('\n')+ { emit(); skip(); };

WS:                      (' ' | '\t')+ { skip(); };

