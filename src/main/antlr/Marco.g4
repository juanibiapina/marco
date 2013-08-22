grammar Marco;

program
    : chain
    ;

chain
    : message
    ;

message
    : SYMBOL   # Symbol
    | STRING   # String
    | NUMBER   # Number
    ;

SYMBOL : [a-zA-Z_-]+ ;

STRING : '"' ( ~'"' | '\\' '"' )* '"' ;

NUMBER : '-'? [0-9]+ ;