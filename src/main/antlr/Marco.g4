grammar Marco;

program: form* ;

form
    : literal # FormLiteral
    | list    # FormList
    ;

list: '(' form* ')' ;

literal
    : SYMBOL   # Symbol
    | STRING   # String
    | NUMBER   # Number
    ;

SYMBOL : [a-zA-Z_-]+ ;

STRING : '"' ( ~'"' | '\\' '"' )* '"' ;

NUMBER : '-'? [0-9]+ ;


WHITESPACE : [ \t\n] -> channel(HIDDEN) ;