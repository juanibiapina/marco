grammar Marco;

program
    : expr
    ;

expr
    : singleExpr*
    ;

singleExpr
    : message+ NEWLINE?
    ;

message
    : SYMBOL   # Symbol
    | STRING   # String
    | NUMBER   # Number
    ;

SYMBOL : [a-zA-Z_-]+ ;

STRING : '"' ( ~'"' | '\\' '"' )* '"' ;

NUMBER : '-'? [0-9]+ ;

WHITESPACE : [ \t] -> channel(HIDDEN) ;

NEWLINE: '\n' -> channel(HIDDEN);