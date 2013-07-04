tree grammar Checker;

options {
    tokenVocab=Noot;                    // import tokens from Calc.tokens
    ASTLabelType=CommonTree;            // AST nodes are of type CommonTree
}

@header {
    package noot.compiler;
    import java.util.Set;
    import java.util.HashSet;
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
    :   ^(NOOT (declaration | statement)+)
    ;
    
declaration
    :   ^(INT id=IDENTIFIER declaration_extention)
        {   
        }
    |   ^(BOOL id=IDENTIFIER declaration_extention)
        {   
        }
    |   ^(CHAR id=IDENTIFIER declaration_extention)
        {   
        }
    ;
    
declaration_extention
    :   ^(COMMA id=IDENTIFIER declaration_extention)
        {
        }
    ;
 
statement 
    :   ^(BECOMES id=IDENTIFIER)
        {   
        }
    |   
    ;
    
expression 
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
    |   ^(BECOMES id=IDENTIFIER expression) {
        }
    ;
    
operand
    :   id=IDENTIFIER 
        {   
        }
    |   n=NUMBER 
    |   TRUE
    |   FALSE
    |   c=CHARACTER
    ;
    
boolean_value
    