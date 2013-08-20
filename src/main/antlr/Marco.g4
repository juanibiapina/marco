grammar Marco;

program
    : message
    ;

message
    : SYMBOL   # Symbol
    | STRING   # String
    ;

SYMBOL : [a-zA-Z_-]+ ;

STRING : '"' ( ~'"' | '\\' '"' )* '"' ;