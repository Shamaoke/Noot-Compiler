/*
 * @author Thijs Scheepers <thijs@label305.com>
 * Copyright (c) 2013 Thijs Scheepers. All Right Reserved.
 *
 * This source is subject to the BSD License.
 * Please see the LICENSE file for more information.
 * All other rights reserved.
 *
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY 
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 * 
 */

grammar Noot;

options {
    k=1; // This is a requirement for the project, and also to keep the compiler fast
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
    CONST       =   'const';
    
}

@lexer::header {
  package noot.compiler;
  import noot.ast.*;
}

@lexer::rulecatch { 
    catch (RecognitionException e) { 
        throw e; 
    } 
}

@parser::header {
  package noot.compiler;
  import noot.ast.*;
}

@parser::rulecatch { 
    catch (RecognitionException e) { 
        throw e; 
    } 
}

@parser::members {

  @Override
/*
 * This method is overrided because Antlr
 * does not have a convenient way to halt the program on 
 * a recoverable Lexer or Parser error. We will use the
 * LexerParserException which extends RuntimeException to
 * halt the program without the adding a throws to the
 * deleration.
 */
  public void reportError(RecognitionException e) {
      throw new LexerParserException("Parsing error on line: " + e.line);
  }
}

@lexer::members {

  @Override
/*
 * This method is overrided because Antlr
 * does not have a convenient way to halt the program on 
 * a recoverable Lexer or Parser error. We will use the
 * LexerParserException which extends RuntimeException to
 * halt the program without the adding a throws to the
 * deleration.
 */
  public void reportError(RecognitionException e) { 
      throw new LexerParserException("Lexing error on line: " + e.line);
  }
}

program
    : NOOT^ command+ EOF!
    ;
    
command
    :  declaration SEMICOLON!
    |  expression SEMICOLON! // All statements are expressions, so we don't have a seperate statement grammar rule
    ;
    
declaration
    :  CONST! constant_declaration // Constant declaration
    |  variable_declaration // Variable declaration
    ;

constant_declaration
    :  (INT<DeclarationNode>^ | CHAR<DeclarationNode>^ | BOOL<DeclarationNode>^) IDENTIFIER<IdentifierNode> BECOMES! primary_operand constant_declaration_extention
    ;
    
constant_declaration_extention
    :  (COMMA<DeclarationNode>^ IDENTIFIER<IdentifierNode> BECOMES! primary_operand constant_declaration_extention)?
    ;
    
variable_declaration
    :  (INT<DeclarationNode>^ | CHAR<DeclarationNode>^ | BOOL<DeclarationNode>^) IDENTIFIER<IdentifierNode> variable_declaration_extention
    ;
    
variable_declaration_extention
    :  (COMMA<DeclarationNode>^ IDENTIFIER<IdentifierNode> variable_declaration_extention)?
    ;
    
expression // All statements are expressions, so we don't have a seperate statement grammar rule
    :   (IDENTIFIER BECOMES) => assignment
    |   while_statement
    |   expression_level6
    ;
    
assignment
    :  IDENTIFIER<IdentifierNode> BECOMES<TypeAdoptedNode>^ assignment_extention
    ;
    
assignment_extention
    :  (IDENTIFIER BECOMES) => IDENTIFIER<IdentifierNode> BECOMES<TypeAdoptedNode>^ assignment_extention
    |  expression
    ;
    
while_statement
    :   WHILE^ expression DO! expression OD!
    ; 
    
expression_level6
    :   expression_level5 (OR<BinaryExpressionNode>^ expression_level5)*
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
    :   (MINUS<NumericalExpressionNode>^ | NEGATION<BinaryExpressionNode>^ | PLUS<NumericalExpressionNode>^)? operand
    ; 

operand
    :   primary_operand
    |   LPAREN! expression RPAREN!
    |   print_statement
    |   read_statement
    |   compound_expression
    |   if_statement
    ;
    
primary_operand
    :   TRUE<BinaryExpressionNode>
    |   FALSE<BinaryExpressionNode>
    |   IDENTIFIER<IdentifierNode>
    |   NUMBER<NumericalExpressionNode>
    |   CHARACTER<CharacterExpressionNode>
    ;
    
print_statement
    :   PRINT<TypeAdoptedNode>^ LPAREN! expression (COMMA! expression)* RPAREN!
    ; 
    
read_statement
    :   READ<TypeAdoptedNode>^ LPAREN! IDENTIFIER<IdentifierNode> (COMMA! IDENTIFIER<IdentifierNode>)* RPAREN!
    ;
    
compound_expression
    :   LCURLY<TypeAdoptedNode>^ command* RCURLY!
    ; 

if_statement
    :   IF<TypeAdoptedNode>^ expression THEN! expression (ELSE! expression)? FI!
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