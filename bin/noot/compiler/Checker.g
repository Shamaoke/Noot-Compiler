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

tree grammar Checker;

options {
    tokenVocab=Noot;              // import tokens from Noot.tokens
    ASTLabelType=Node;            // AST nodes are of type CommonTree
}

@header {
    package noot.compiler;
    import noot.ast.*;
    import static java.util.Arrays.asList;
}

// Alter code generation so catch-clauses get replaced with this action. 
// This disables ANTLR error handling: CheckerExceptions are propagated upwards.
@rulecatch { 
    catch (RecognitionException e) { 
        throw e; 
    } 
}

@members {
    private CheckerHelper checkerHelper = new CheckerHelper();
}

program
    :   ^(NOOT (dec=declaration
          {
            dec.setIgnoreReturnValue(true);
          }
          | ex=expression
          {
            ex.setIgnoreReturnValue(true);
          }
          )+)
    ;

declaration returns [Node node = null;]
  :     ^(d=(INT | BOOL | CHAR) id=IDENTIFIER op=operand dex=declaration_extention?) // constant
        {
            ((DeclarationNode) d).setConstant(true);
        
            checkerHelper.declare( (DeclarationNode) d );
            checkerHelper.linkToDeclaration( (IdentifierNode) id );
            
            List<Node> nodes = asList(id,op);
            checkerHelper.checkExpressionsForEqualType(nodes,d);
            
            d.addValuePropagatingChild(id);
            if(dex != null) d.addValuePropagatingChild(dex);
            
            node = d;
        }
  |     ^(d=(INT | BOOL | CHAR) id=IDENTIFIER dex=declaration_extention?) // variable
        {
            checkerHelper.declare( (DeclarationNode) d );
            checkerHelper.linkToDeclaration( (IdentifierNode) id );
            
            d.addValuePropagatingChild(id);
            if(dex != null) d.addValuePropagatingChild(dex);
            
            node = d;
        }
  ;
    
declaration_extention returns [Node node = null;]
    :   ^(d=COMMA id=IDENTIFIER op=operand dex=declaration_extention?) // constant
        {
            ((DeclarationNode) d).setConstant(true);
            
            checkerHelper.declare( (DeclarationNode) d );
            checkerHelper.linkToDeclaration( (IdentifierNode) id );
            
            List<Node> nodes = asList(id,op);
            checkerHelper.checkExpressionsForEqualType(nodes,d);
            
            d.addValuePropagatingChild(id);
            if(dex != null) d.addValuePropagatingChild(dex);
            
            node = d;
        }
    |   ^(d=COMMA id=IDENTIFIER dex=declaration_extention?) // variable
        {
            checkerHelper.declare( (DeclarationNode) d );
            checkerHelper.linkToDeclaration( (IdentifierNode) id );
            
            d.addValuePropagatingChild(id);
            if(dex != null) d.addValuePropagatingChild(dex);
            
            node = d;
        }
    ;
    
    
variable_declaration returns [Node node = null;]
    :   ^(d=(INT | BOOL | CHAR) id=IDENTIFIER dex=variable_declaration_extention?)
        {
            checkerHelper.declare( (DeclarationNode) d );
            checkerHelper.linkToDeclaration( (IdentifierNode) id );
            
            d.addValuePropagatingChild(id);
            if(dex != null) d.addValuePropagatingChild(dex);
            
            node = d;
        }
    ;
    
variable_declaration_extention returns [Node node = null;]
    :   ^(d=COMMA id=IDENTIFIER dex=variable_declaration_extention?)
        {
            checkerHelper.declare( (DeclarationNode) d );
            checkerHelper.linkToDeclaration( (IdentifierNode) id );
            
            d.addValuePropagatingChild(id);
            if(dex != null) d.addValuePropagatingChild(dex);
            
            node = d;
        }
    ;
    
expression returns [Node node = null;] // All statements are expressions because they all have a return value
    :   op=operand
        {
          node = op;
        }
    |   ^(te=PLUS e1=expression e2=expression?)
        {
          List<Node> expressions;
          if(e2 != null)
            expressions = asList(e1,e2);
          else
            expressions = asList(e1);
            
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=MINUS e1=expression e2=expression?)
        {
          List<Node> expressions;
          if(e2 != null)
            expressions = asList(e1,e2);
          else
            expressions = asList(e1);
            
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=NEGATION e1=expression)
        {
          List<Node> expressions = asList(e1);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=MULTIPLY e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=DEVIDE e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=MODULO e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=LESSEQ e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=MOREEQ e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=NEQ e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForEqualType(expressions,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=EQ e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForEqualType(expressions,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=LESS e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=MORE e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=AND e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=OR e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=BECOMES id=IDENTIFIER e1=expression) // Assign statement
        {
          checkerHelper.linkToDeclaration( (IdentifierNode) id );
          
          if(((IdentifierNode) id).getDeclarationNode().isConstant())
              throw new CheckerException("Reassigning a constant on line: " + te.getLine() + " this is not allowed.");
          
          List<Node> nodes = asList(id,e1);
          checkerHelper.checkExpressionsForEqualType(nodes,te);
          
          // This so the chaining of BECOME rules will occure with the correct type checking
          ((TypeAdoptedNode) te).setTypeDefiningChild(e1);
          
          node = te;
        }
    |   ^(te=READ
            {
              ArrayList<IdentifierNode> identifiers = new ArrayList<IdentifierNode>();
            }
          (id=IDENTIFIER
            {
              checkerHelper.linkToDeclaration( (IdentifierNode) id );
              identifiers.add( (IdentifierNode) id );
              
              if(((IdentifierNode) id).getDeclarationNode().isConstant())
                throw new CheckerException("Reading a constant on line: " + te.getLine() + " this is not allowed.");
            }
          )+) // Read statement
        {
        
          if(identifiers.size() == 1) // If only one argument is given let the read statement adopt its type
          {
            ((TypeAdoptedNode) te).setTypeDefiningChild(identifiers.get(0));
          }
          
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
        
          if(expressions.size() == 1) // If only one argument is given let the print statement adopt its type
          {
            ((TypeAdoptedNode) te).setTypeDefiningChild(expressions.get(0));
          }
            
          for(Node argumentNode : expressions)
          {
            if(argumentNode.getNodeType() == Node.NodeType.VOID)
              throw new CheckerException("Expression on line: " + argumentNode.getLine() + " is a void expression, this is not allowed as an argument of print.");
          } 
          
          node = te;
        }
    |   ^(te=LCURLY
            {
                checkerHelper.openScope();
                ArrayList<Node> commands = new ArrayList<Node>();
            }
          (dc=declaration
            {
              commands.add(dc);
            }
           | en=expression
            {
              commands.add(en);
            }
          )+)
        {
            if(commands.size() > 0)
            {
              Node lastCommand = commands.get(commands.size() - 1);
              
              if(lastCommand instanceof DeclarationNode)
                throw new CheckerException("Command on line:" + lastCommand.getLine() + " is a declaration, this is not allowed, the last command in a compound expression needs to be a statement.");
              
              ((TypeAdoptedNode) te).setTypeDefiningChild(lastCommand);
              ((TypeAdoptedNode) te).addValuePropagatingChild(lastCommand);
            }
            
            // Only not for the last command
            for(int index = 0; index < commands.size() - 1; index++)
            {
              commands.get(index).setIgnoreReturnValue(true);
            }
        
            checkerHelper.tryToCloseScope();
            node = te;
        } // Compound expression
    |   ^(te=IF
            {
              checkerHelper.holdUpcomingScope();
            }
          e1=expression
            {
              boolean scopeReleased = checkerHelper.releaseUpcomingScope();
              
              List<Node> condition = asList(e1);
              checkerHelper.checkExpressionsForType(condition,Node.NodeType.BOOL,te);
            }
          e2=expression e3=expression?)
        {
          if(!scopeReleased) checkerHelper.releaseAndCloseScope();
          
          if(e3 != null)
          {
            try {
              List<Node> nodes = asList(e2,e3);
              checkerHelper.checkExpressionsForEqualType(nodes,te);
            
              // This so the if statement has the same type as both options
              ((TypeAdoptedNode) te).setTypeDefiningChild(e2);
              
              ((TypeAdoptedNode) te).addValuePropagatingChild(e2);
              ((TypeAdoptedNode) te).addValuePropagatingChild(e3);
              
            } catch (CheckerException ce) {
              // no defining type set, so remains void
              e2.setIgnoreReturnValue(true);
              e3.setIgnoreReturnValue(true);
            }
          }
          else
          {
            e2.setIgnoreReturnValue(true);
          }
          
          node = te;
        } // Conditional statement
    |   ^(te=WHILE
            {
              checkerHelper.holdUpcomingScope();
            }
          e1=expression
            {
              boolean scopeReleased = checkerHelper.releaseUpcomingScope();
              
              List<Node> condition = asList(e1);
              checkerHelper.checkExpressionsForType(condition,Node.NodeType.BOOL,te);
            }
          e2=expression)
        {
          if(!scopeReleased) checkerHelper.releaseAndCloseScope();
          
          e2.setIgnoreReturnValue(true);
          
          node = te;
        } // Loop statement
    ;
    
operand returns [Node node = null;]
    :   id=IDENTIFIER 
        {
          checkerHelper.linkToDeclaration( (IdentifierNode) id );
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
    