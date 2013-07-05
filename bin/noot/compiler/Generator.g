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

tree grammar Generator;

options {
    tokenVocab=Noot;              // import tokens from Noot.tokens
    ASTLabelType=Node;            // AST nodes are of type CommonTree
}

@header {
    package noot.compiler;
    import noot.ast.*;
    import noot.assembly.*;
}

// Alter code generation so catch-clauses get replaced with this action. 
// This disables ANTLR error handling: CheckerExceptions are propagated upwards.
@rulecatch { 
    catch (RecognitionException e) { 
        throw e; 
    } 
}

@members {
}

program
    :   ^(NOOT (declaration | expression)+)
    ;
    
declaration returns [Node node = null;]
    :   ^((INT | BOOL | CHAR) IDENTIFIER declaration_extention?)
        {
        }
    ;
    
declaration_extention
    :   ^(COMMA IDENTIFIER declaration_extention?)
        {
        }
    ;
    
expression returns [Node node = null;] // All statements are expressions because they all have a return value
    :   op=operand
        {
          node = op;
        }
    |   ^(te=PLUS e1=expression e2=expression)
        { 
          node = te;
        }
    |   ^(te=MINUS e1=expression e2=expression?)
        {
          node = te;
        }
    |   ^(te=NEGATION e1=expression)
        {
          node = te;
        }
    |   ^(te=MULTIPLY e1=expression e2=expression)
        {
          node = te;
        }
    |   ^(te=DEVIDE e1=expression e2=expression)
        {
          node = te;
        }
    |   ^(te=MODULO e1=expression e2=expression)
        {
          node = te;
        }
    |   ^(te=LESSEQ e1=expression e2=expression)
        {
          node = te;
        }
    |   ^(te=MOREEQ e1=expression e2=expression)
        {
          node = te;
        }
    |   ^(te=NEQ e1=expression e2=expression)
        {
          node = te;
        }
    |   ^(te=EQ e1=expression e2=expression)
        {
          node = te;
        }
    |   ^(te=LESS e1=expression e2=expression)
        {
          node = te;
        }
    |   ^(te=MORE e1=expression e2=expression)
        {
          node = te;
        }
    |   ^(te=AND e1=expression e2=expression)
        {
          node = te;
        }
    |   ^(te=OR e1=expression e2=expression)
        {
          node = te;
        }
    |   ^(te=BECOMES id=IDENTIFIER e1=expression) // Assign statement
        {
          node = te;
        }
    |   ^(te=READ
            {
              ArrayList<IdentifierNode> identifiers = new ArrayList<IdentifierNode>();
            }
          (id=IDENTIFIER
            {
              identifiers.add( (IdentifierNode) id );
            }
          )+) // Read statement
        { 
          node = te;
        }
    |   ^(te=PRINT
            {
              ArrayList<Node> expressions = new ArrayList<Node>();
            }
          (en=expression
            {
              expressions.add(en);
            }
          )+) // Print statement
        {
          
          node = te;
        }
    |   ^(te=LCURLY
            {
                ArrayList<Node> commands = new ArrayList<Node>();
            }
          (dc=declaration
            {
            }
           | en=expression
            {
            }
          )+)
        {
            node = te;
        } // Compound expression
    |   ^(te=IF e1=expression e2=expression e3=expression?)
        {
          node = te;
        } // Conditional statement
    |   ^(te=WHILE e1=expression e2=expression)
        {
          node = te;
        } // Loop statement
    ;
    
operand returns [Node node = null;]
    :   id=IDENTIFIER 
        {
          node = id;
        }
    |   n=NUMBER
        {
          node = n;
        }
    |   b=TRUE
        {
          node = b;
        }
    |   b=FALSE
        {
          node = b;
        }
    |   c=CHARACTER
        {
          node = c;
        }
    ;
    