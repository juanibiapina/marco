grammar Marco;

file: form* ;

form
    : list          # FormList
    | hash_map      # FormHashMap
    | application   # FormApplication
    | block         # FormBlock
    | literal       # FormLiteral
    | member_access # FormMemberAccess
    ;

list: '[' form* ']' ;

hash_map: '#{' (SYMBOL form)* '}' ;

application: '(' form* ')' ;

block: '{' form* '}' ;

literal
    : NAME       # Name
    | SYMBOL     # Symbol
    | STRING     # String
    | NUMBER     # Number
    ;

member_access
    : NAME ('.' NAME)+    # MemberAccess
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