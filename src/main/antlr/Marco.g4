grammar Marco;

program: form* ;

form
    : literal     # FormLiteral
    | list        # FormList
    | quoted_form # FormQuotedForm
    | quoted_list # FormQuotedList
    ;

list: '(' form* ')' ;

quoted_form: '\'' form ;

quoted_list: '[' form* ']' ;

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