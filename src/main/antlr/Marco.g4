grammar Marco;

program: form* ;

form
    : list          # FormList
    | application   # FormApplication
    | block         # FormBlock
    | literal       # FormLiteral
    | nested_access # FormNestedAccess
    ;

list: '[' form* ']' ;

application: '(' form* ')' ;

block: '{' form* '}' ;

literal
    : NAME       # Name
    | SYMBOL     # Symbol
    | STRING     # String
    | NUMBER     # Number
    ;

nested_access
    : NAME ('.' NAME)+    # NestedAccess
    ;

STRING : '"' ( ~'"' | '\\' '"' )* '"' ;

NUMBER : '-'? [0-9]+ ;

SYMBOL : ':' NAME ;

NAME: SYMBOL_HEAD SYMBOL_REST* ;

fragment
SYMBOL_HEAD
    :   'a'..'z' | 'A'..'Z' | '*' | '+' | '/' | '%' | '!' | '-' | '_' | '?' | '>' | '<' | '=' | '$'
    ;

fragment
SYMBOL_REST
    : SYMBOL_HEAD
    | '0'..'9'
    ;


WHITESPACE : [ \t\n] -> channel(HIDDEN) ;

COMMENT : '//' ~[\r\n]* -> channel(HIDDEN) ;