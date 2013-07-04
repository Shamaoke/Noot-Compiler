tree grammar Checker;

options {
    tokenVocab=Noot;                    // import tokens from Calc.tokens
    ASTLabelType=Node;            // AST nodes are of type CommonTree
}

@header {
    package noot.compiler;
    import noot.ast.*;
}

// Alter code generation so catch-clauses get replaced with this action. 
// This disables ANTLR error handling: CalcExceptions are propagated upwards.
@rulecatch { 
    catch (RecognitionException e) { 
        throw e; 
    } 
}

@members {
    public CheckerHelper checkerHelper = new CheckerHelper();
}

program
    :   ^(NOOT (declaration | expression)+)
    ;
    
declaration
    :   ^(d=(INT | BOOL | CHAR) IDENTIFIER declaration_extention?)
        {
            checkerHelper.declare((DeclarationNode)d);
        }
    ;
    
declaration_extention
    :   ^(d=COMMA id=IDENTIFIER declaration_extention?)
        {
            checkerHelper.declare((DeclarationNode)d);
        }
    ;
    
expression // All statements are expressions because they all have a return value
    :   operand
    |   ^(PLUS expression expression)
    |   ^(MINUS expression expression?)
    |   ^(NEGATION expression)
    |   ^(MULTIPLY expression expression)
    |   ^(DEVIDE expression expression)
    |   ^(MODULO expression expression)
    |   ^(LESSEQ expression expression)
    |   ^(MOREEQ expression expression)
    |   ^(NEQ expression expression)
    |   ^(EQ expression expression)
    |   ^(LESS expression expression)
    |   ^(MORE expression expression)
    |   ^(AND expression expression)
    |   ^(OR expression expression)
    |   ^(BECOMES id=IDENTIFIER expression) // Assign statement
    {
        checkerHelper.linkToDeclaration((IdentifierNode)id);
    }
    |   ^(READ expression+) // Read statement
    |   ^(PRINT expression+) // Print statement
    |   ^(LCURLY {
            checkerHelper.openScope();
        } (declaration | expression)+)
        {
            checkerHelper.closeScope();
        } // Compound expression
    |   ^(IF expression expression expression?) // Conditional statement
    |   ^(WHILE expression expression) // Loop statement
    ;
    
operand
    :   id=IDENTIFIER 
        {
          checkerHelper.linkToDeclaration((IdentifierNode)id);
        }
    |   n=NUMBER 
    |   TRUE
    |   FALSE
    |   c=CHARACTER
    ;
    