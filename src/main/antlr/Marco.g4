grammar Marco;

program: form* ;

form
    : literal     # FormLiteral
    | list        # FormList
    | quoted_form # FormQuotedForm
    ;

list: '(' form* ')' ;

quoted_form: '\'' form ;

literal
    : SYMBOL   # Symbol
    | STRING   # String
    | NUMBER   # Number
    ;

STRING : '"' ( ~'"' | '\\' '"' )* '"' ;

NUMBER : '-'? [0-9]+ ;

SYMBOL: SYMBOL_HEAD SYMBOL_REST* ;

fragment
SYMBOL_HEAD
    :   'a'..'z' | 'A'..'Z' | '*' | '+' | '!' | '-' | '_' | '?' | '>' | '<' | '=' | '$'
    ;

fragment
SYMBOL_REST
    : SYMBOL_HEAD
    | '0'..'9'
    ;


WHITESPACE : [ \t\n] -> channel(HIDDEN) ;

COMMENT : '//' ~[\r\n]* -> channel(HIDDEN) ;