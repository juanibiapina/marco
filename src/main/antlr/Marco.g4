grammar Marco;

program
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