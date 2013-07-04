grammar Noot;

options {
    k=1; // This is a requirement for the project to keep the compiler fast
    language=Java;
    output=AST;
}

tokens {

    // Syntax supporting characters

    SEMICOLON   =   ';';
    LPAREN      =   '(';
    RPAREN      =   ')';
    LCURLY      =   '{';
    RCURLY      =   '}';
    COMMA       =   ',';
    APOSTROPHE  =   '\'';

    // Aritmetic operators
    
    BECOMES     =   ':=';

    PLUS        =   '+'; // takes: int returns: int
    MINUS       =   '-';
    NEGATION    =   '!'; // takes: bool returns: bool
    
    MULTIPLY    =   '*'; // takes: int returns: int
    DEVIDE      =   '/';
    MODULO      =   '%';
    
    LESS        =   '<'; // takes: int returns: bool
    LESSEQ      =   '<=';
    MOREEQ      =   '>=';
    MORE        =   '>';
    EQ          =   '=='; // takes: int, char, bool returns: bool
    NEQ         =   '!=';

    AND         =   '&&'; // takes: bool returns: bool
    OR          =   '||';

    // Keywords
    
    INT         =   'int';
    CHAR        =   'char';
    BOOL        =   'bool';
    READ        =   'read';
    PRINT       =   'print';
    IF          =   'if';
    THEN        =   'then';
    ELSE        =   'else';
    FI          =   'fi';
    WHILE       =   'while';
    DO          =   'do';
    OD          =   'od';
    NOOT        =   'noot';
    TRUE        =   'true';
    FALSE       =   'false';
    
}

@lexer::header {
  package noot.compiler;
}

@header {
  package noot.compiler;
}

program
    : NOOT^ command+ EOF
    ;
    
command
    :  declaration SEMICOLON!
    |  expression SEMICOLON!
    ;
    
declaration
    :   (INT^ | CHAR^ | BOOL^) IDENTIFIER declaration_extention
    ;
    
declaration_extention
    :   (COMMA^ IDENTIFIER declaration_extention)?
    ;

assignment
    :   IDENTIFIER BECOMES^ assignment_extention
    ;
    
assignment_extention
    :  (IDENTIFIER BECOMES) => IDENTIFIER BECOMES^ assignment_extention
    |  expression
    ;
    
expression
    :   (IDENTIFIER BECOMES) => assignment
    |   print_statement
    |   read_statement
    |   while_statement
    |   if_statement
    |   expression_level6
    ;

print_statement
    :   PRINT^ LPAREN! expression (COMMA! expression)* RPAREN!
    ; 
    
read_statement
    :   READ^ LPAREN! expression (COMMA! expression)* RPAREN!
    ; 
    
while_statement
    :   WHILE^ expression DO! expression OD!
    ; 

if_statement
    :   IF^ expression THEN! expression (ELSE! expression)? FI!
    ;
    
compound_expression
    :   LCURLY^ command* RCURLY!
    ;
    
expression_level6
    :   expression_level5 (OR^ expression_level5)*
    |   compound_expression
    ;
    
expression_level5
    :   expression_level4 (AND^ expression_level4)*
    ;
    
expression_level4
    :   expression_level3 ((LESS^ | LESSEQ^ | EQ^ | NEQ^ | MOREEQ^ | MORE^) expression_level3 )*
    ;
    
expression_level3
    :   expression_level2 ((PLUS^ | MINUS^) expression_level2 )* 
    ;
    
expression_level2
    :   expression_level1 ((MULTIPLY^ | DEVIDE^ | MODULO^) expression_level1 )*
    ;
    
expression_level1 // unary operators
    :   (MINUS^ | NEGATION^)? operand
    ;

operand
    :   (TRUE | FALSE)
    |   IDENTIFIER
    |   NUMBER
    |   CHARACTER
    |   LPAREN! expression RPAREN!
    ;

// Lexer rules

IDENTIFIER
    :   LETTER (LETTER | DIGIT)* // Identifier always starts with a letter
    ;

NUMBER
    :   DIGIT+
    ;
    
CHARACTER
    :  APOSTROPHE LETTER APOSTROPHE
    ;

COMMENT
    :   '//' .* '\n' 
            { $channel=HIDDEN; }
    ;

WS
    :   (' ' | '\t' | '\f' | '\r' | '\n')+
            { $channel=HIDDEN; }
    ;

fragment DIGIT  :   ('0'..'9') ;
fragment LOWER  :   ('a'..'z') ;
fragment UPPER  :   ('A'..'Z') ;
fragment LETTER :   LOWER | UPPER ;