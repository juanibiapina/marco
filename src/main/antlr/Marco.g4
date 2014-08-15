grammar Marco;

file: form_with_doc* ;

form_with_doc: ('@' STRING)? form ;

form
    : list          # FormList
    | hash_map      # FormHashMap
    | application   # FormApplication
    | block         # FormBlock
    | literal       # FormLiteral
    | member_access # FormMemberAccess
    ;

list: '[' form_with_doc* ']' ;

hash_map: '#{' (SYMBOL form_with_doc)* '}' ;

application: '(' form_with_doc* ')' ;

block: '{' form_with_doc* '}' ;

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