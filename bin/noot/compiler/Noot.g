grammar Noot;

options {
    k=1; // This is a requirement for the project to keep the compiler fast
    language=Java;
    output=AST;
    ASTLabelType=Node;
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
  import noot.ast.*;
}

@header {
  package noot.compiler;
  import noot.ast.*;
}

program
    : NOOT^ command+ EOF!
    ;
    
command
    :  declaration SEMICOLON!
    |  expression SEMICOLON!
    ;
    
declaration
    :   (INT<DeclarationNode>^ | CHAR<DeclarationNode>^ | BOOL<DeclarationNode>^) IDENTIFIER<IdentifierNode> declaration_extention
    ;
    
declaration_extention
    :   (COMMA<DeclarationNode>^ IDENTIFIER<IdentifierNode> declaration_extention)?
    ;

assignment
    :   IDENTIFIER<IdentifierNode> BECOMES^ assignment_extention
    ;
    
assignment_extention
    :  (IDENTIFIER BECOMES) => IDENTIFIER<IdentifierNode> BECOMES^ assignment_extention
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
    :   expression_level5 (OR<BinaryExpressionNode>^ expression_level5)*
    |   compound_expression
    ;
    
expression_level5
    :   expression_level4 (AND<BinaryExpressionNode>^ expression_level4)*
    ;
    
expression_level4
    :   expression_level3 ((LESS<BinaryExpressionNode>^ | LESSEQ<BinaryExpressionNode>^ | EQ<BinaryExpressionNode>^ | NEQ<BinaryExpressionNode>^ | MOREEQ<BinaryExpressionNode>^ | MORE<BinaryExpressionNode>^) expression_level3 )*
    ;
    
expression_level3
    :   expression_level2 ((PLUS<NumericalExpressionNode>^ | MINUS<NumericalExpressionNode>^) expression_level2 )* 
    ;
    
expression_level2
    :   expression_level1 ((MULTIPLY<NumericalExpressionNode>^ | DEVIDE<NumericalExpressionNode>^ | MODULO<NumericalExpressionNode>^) expression_level1 )*
    ;
    
expression_level1 // unary operators
    :   (MINUS<NumericalExpressionNode>^ | NEGATION<BinaryExpressionNode>^)? operand
    ; 

operand
    :   (TRUE<BinaryExpressionNode> | FALSE<BinaryExpressionNode>)
    |   IDENTIFIER<IdentifierNode>
    |   NUMBER<NumericalExpressionNode>
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