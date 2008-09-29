grammar Xpl;

options { output=AST; ASTLabelType=CommonTree; }

tokens  { CALL; CALL_ARGUMENTS; WHILE; WHILE_BODY; IF; IF_BODY; ELSE; ELSE_BODY; METHOD; METHOD_BODY; RETURN; }

program:                 ((method_definition | atomic_operation) newline?)+;

atomic_operation:        conditional | loop | assignment | expression | return_expression;

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

assignment:              variable_declaration ('='^ expression);

variable_declaration:    type_declaration identifier;

type_declaration:        'int';

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

IDENTIFIER:              ('a'..'z')+;

NUMBER:    	             ('0'..'9')+;

NEWLINE:                 ('\n')+ { emit(); skip(); };

WS:                      (' ' | '\t')+ { skip(); };

