grammer Noot;

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
    HIGHEQ      =   '>=';
    HIGH        =   '>';
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
    START       =   'start';
    END         =   'end';
    
}

@lexer::header {
package noot.compiler;
}

@header {
package noot.compiler;
}