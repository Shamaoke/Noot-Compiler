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
    ASTLabelType=Node;            // AST nodes are of type Node
}

@header {
    package noot.antlr;
    import noot.ast.*;
    import static java.util.Arrays.asList;
    import noot.compiler.CheckerHelper;
    import noot.exceptions.CheckerException;
}

@rulecatch { 
    catch (RecognitionException e) { 
        throw e; 
    } 
}

@members {
    private CheckerHelper ch = new CheckerHelper();
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
        
            ch.declare( (DeclarationNode) d );
            ch.linkToDeclaration( (IdentifierNode) id );
            
            List<Node> nodes = asList(id,op);
            ch.checkExpressionsForEqualType(nodes,d); // Check for types for constant assignment
            
            node = d;
        }
  |     ^(d=(INT | BOOL | CHAR) id=IDENTIFIER dex=declaration_extention?) // variable
        {
            ch.declare( (DeclarationNode) d );
            ch.linkToDeclaration( (IdentifierNode) id );
            
            node = d;
        }
  ;
    
declaration_extention returns [Node node = null;]
    :   ^(d=COMMA id=IDENTIFIER op=operand dex=declaration_extention?) // constant
        {
            ((DeclarationNode) d).setConstant(true);
            
            ch.declare( (DeclarationNode) d );
            ch.linkToDeclaration( (IdentifierNode) id );
            
            List<Node> nodes = asList(id,op);
            ch.checkExpressionsForEqualType(nodes,d);
            
            node = d;
        }
    |   ^(d=COMMA id=IDENTIFIER dex=declaration_extention?) // variable
        {
            ch.declare( (DeclarationNode) d );
            ch.linkToDeclaration( (IdentifierNode) id );
            
            node = d;
        }
    ;
    
expression returns [Node node = null;] // All statements are expressions because they all have a return value
    :   op=operand { node = op; }
    |   ^(te=PLUS e1=expression e2=expression?)
        {
          List<Node> expressions;
          if(e2 != null)
            expressions = asList(e1,e2);
          else
            expressions = asList(e1);
            
          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
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
            
          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=NEGATION e1=expression)
        {
          List<Node> expressions = asList(e1);
          ch.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=MULTIPLY e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=DEVIDE e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=MODULO e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=LESSEQ e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=MOREEQ e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=NEQ e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          ch.checkExpressionsForEqualType(expressions,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=EQ e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          ch.checkExpressionsForEqualType(expressions,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=LESS e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=MORE e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=AND e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          ch.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=OR e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          ch.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
          te.addValuePropagatingChildren(expressions);
          node = te;
        }
    |   ^(te=BECOMES id=IDENTIFIER e1=expression) // Assign statement
        {
          ch.linkToDeclaration( (IdentifierNode) id );
          
          if(((IdentifierNode) id).getDeclarationNode().isConstant())
              throw new CheckerException(te,"Trying to reassign constant, this is not allowed.");
          
          List<Node> nodes = asList(id,e1);
          ch.checkExpressionsForEqualType(nodes,te);
          
          // This so the chaining of BECOME rules will occure with the correct type checking
          ((TypeAdoptedNode) te).setTypeDefiningChild(e1);
          
          node = te;
        }
    |   ^(te=READ // Read statement
            {
              ArrayList<IdentifierNode> identifiers = new ArrayList<IdentifierNode>();
            }
          (id=IDENTIFIER
            {
              ch.linkToDeclaration( (IdentifierNode) id );
              identifiers.add( (IdentifierNode) id );
              
              if(((IdentifierNode) id).getDeclarationNode().isConstant())
                throw new CheckerException(te,"Trying to read constant, this is not allowed.");
            }
          )+) 
        {
          if(identifiers.size() == 1) // If only one argument is given let the read statement adopt its type
            ((TypeAdoptedNode) te).setTypeDefiningChild(identifiers.get(0));
          
          node = te;
        }
    |   ^(te=PRINT // Print statement
            {
              ArrayList<Node> expressions = new ArrayList<Node>();
            }
          (en=expression
            {
              expressions.add(en);
            }
          )+)
        {
          if(expressions.size() == 1) // If only one argument is given let the print statement adopt its type
            ((TypeAdoptedNode) te).setTypeDefiningChild(expressions.get(0));
          
          for(Node argumentNode : expressions) // None of the arguments may be a void expression
          {
            if(argumentNode.getNodeType() == Node.NodeType.VOID)
              throw new CheckerException(argumentNode,"Print argument is a void expression, this is not allowed.");
          } 
          
          node = te;
        }
    |   ^(te=LCURLY // Compound expression
            {
                ch.openScope();
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
                throw new CheckerException(lastCommand,"Last command in compound expression is a declaration, this is not allowed.");
              
              ((TypeAdoptedNode) te).setTypeDefiningChild(lastCommand);
              ((TypeAdoptedNode) te).addValuePropagatingChild(lastCommand);
            }
            
            // Only not for the last command
            for(int index = 0; index < commands.size() - 1; index++)
            {
              commands.get(index).setIgnoreReturnValue(true);
            }
        
            ch.tryToCloseScope();
            node = te;
        } 
    |   ^(te=IF  // Conditional statement
            {
              ch.holdUpcomingScope();
            }
          e1=expression
            {
              boolean scopeReleased = ch.releaseUpcomingScope();
              
              List<Node> condition = asList(e1);
              ch.checkExpressionsForType(condition,Node.NodeType.BOOL,te);
            }
          e2=expression e3=expression?)
        {
          if(!scopeReleased) ch.releaseAndCloseScope();
          
          if(e3 != null)
          {
            try {
              List<Node> nodes = asList(e2,e3);
              ch.checkExpressionsForEqualType(nodes,te);
            
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
        }
    |   ^(te=WHILE // Loop statement
            {
              ch.holdUpcomingScope();
            }
          e1=expression
            {
              boolean scopeReleased = ch.releaseUpcomingScope();
              
              List<Node> condition = asList(e1);
              ch.checkExpressionsForType(condition,Node.NodeType.BOOL,te);
            }
          e2=expression)
        {
          if(!scopeReleased) ch.releaseAndCloseScope();
          
          e2.setIgnoreReturnValue(true);
          
          node = te;
        } 
    ;
    
operand returns [Node node = null;]
    :   id=IDENTIFIER 
        {
          ch.linkToDeclaration( (IdentifierNode) id );
          node = id;
        }
    |   n=NUMBER { node = n; }
    |   b=TRUE { node = b; }
    |   b=FALSE { node = b; }
    |   c=CHARACTER { node = c; }
    ;
    