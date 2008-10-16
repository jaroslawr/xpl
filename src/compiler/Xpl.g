grammar Xpl;

options { output=AST; ASTLabelType=CommonTree; }

tokens  { CALL; CALL_ARGUMENTS; WHILE; WHILE_BODY; IF; IF_BODY; ELSE; ELSE_BODY; METHOD; METHOD_BODY; RETURN; }

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
    :                    ((method_definition | atomic_operation) newline?)+;
catch [RecognitionException re] {
    throw re;
}

atomic_operation:        conditional | loop | assignment | variable_definition | expression | return_expression;

atomic_operations_list:  (atomic_operation (newline!)?)+;

method_definition:       method_header method_body 'end' -> ^(METHOD method_header METHOD_BODY method_body);

method_header
    :                    'method' identifier '(' ')' -> ^(identifier)
    |                    'method' identifier '(' method_arguments ')' -> ^(identifier method_arguments);

method_arguments:        variable_declaration (','! variable_declaration)*;

method_body:             atomic_operation+;

conditional:             'if' expression newline? atomic_operations_list 'end'
                         -> ^(IF expression IF_BODY atomic_operations_list);

conditional_else:        'else' expression newline? atomic_operations_list -> ^(ELSE expression ELSE_BODY atomic_operations_list);

loop:                    'while' expression newline? atomic_operations_list 'end' -> ^(WHILE expression WHILE_BODY atomic_operations_list);

variable_declaration:    type_declaration identifier;

variable_definition:     type_declaration identifier '=' expression -> ^('=' type_declaration identifier expression);

type_declaration:        TYPE;

assignment:              identifier '=' expression -> ^('=' identifier expression);

expression:              boolean_expression;

boolean_expression:      comparision_expression (('&&'^ | '||'^) boolean_expression)?;

comparision_expression:  arithmetic_expression (('=='^ | '<='^ | '>='^ | '<'^ | '>'^) arithmetic_expression)?;

arithmetic_expression:   term (('+'^ | '-'^) term)*;

term:		             factor (('*'^ | '/'^) factor)*;

factor:                  atom ('%'^ atom)*;

atom:                    number | string | (identifier '(') => call | '(' expression ')' | reference;

return_expression:       'return' expression -> ^(RETURN expression);

call
    :                    identifier '(' ')'        -> ^(CALL identifier)
    |                    identifier call_arguments -> ^(CALL identifier call_arguments);

call_arguments:          '(' call_arguments_list ')' -> ^(CALL_ARGUMENTS call_arguments_list);

call_arguments_list:     expression (','! expression)*;

reference:               identifier;

identifier:              IDENTIFIER;

number:                  NUMBER;

string:                  STRING;

newline:                 NEWLINE;

STRING:                  '\"' (options {greedy=false;}: ('A'..'z') | ' ')* '\"';

NUMBER:    	             ('0'..'9')+;

TYPE:                    'int' | 'string';

IDENTIFIER:              ('a'..'z')+;

NEWLINE:                 ('\n')+ { emit(); skip(); };

WS:                      (' ' | '\t')+ { skip(); };

