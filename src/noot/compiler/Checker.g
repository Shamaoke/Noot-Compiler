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
    public CheckerHelper checkerHelper = new CheckerHelper();
}

program
    :   ^(NOOT (declaration | expression)+)
    ;
    
declaration returns [Node node = null;]
    :   ^(d=(INT | BOOL | CHAR) IDENTIFIER declaration_extention?)
        {
            checkerHelper.declare( (DeclarationNode) d );
            node = d;
        }
    ;
    
declaration_extention
    :   ^(d=COMMA IDENTIFIER declaration_extention?)
        {
            checkerHelper.declare( (DeclarationNode) d );
        }
    ;
    
expression returns [Node node = null;] // All statements are expressions because they all have a return value
    :   op=operand
        {
          node = op;
        }
    |   ^(te=PLUS e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
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
          node = te;
        }
    |   ^(te=NEGATION e1=expression)
        {
          List<Node> expressions = asList(e1);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
          node = te;
        }
    |   ^(te=MULTIPLY e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          node = te;
        }
    |   ^(te=DEVIDE e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          node = te;
        }
    |   ^(te=MODULO e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          node = te;
        }
    |   ^(te=LESSEQ e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          node = te;
        }
    |   ^(te=MOREEQ e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          node = te;
        }
    |   ^(te=NEQ e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForEqualType(expressions,te);
          node = te;
        }
    |   ^(te=EQ e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForEqualType(expressions,te);
          node = te;
        }
    |   ^(te=LESS e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          node = te;
        }
    |   ^(te=MORE e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
          node = te;
        }
    |   ^(te=AND e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
          node = te;
        }
    |   ^(te=OR e1=expression e2=expression)
        {
          List<Node> expressions = asList(e1,e2);
          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
          node = te;
        }
    |   ^(te=BECOMES id=IDENTIFIER e1=expression) // Assign statement
        {
          checkerHelper.linkToDeclaration( (IdentifierNode) id );
          
          List<Node> nodes = asList(id,e1);
          checkerHelper.checkExpressionsForEqualType(nodes,te);
          
          // This so the chaining of BECOME rules will occure with the correct type checking
          ((TypeAdoptedNode) te).setTypeDefiningChild(e1);
          
          node = te;
        }
    |   ^(te=READ expression+) // Read statement
        {
          node = te;
        }
    |   ^(te=PRINT expression+) // Print statement
        {
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
            }
        
            checkerHelper.closeScope();
            node = te;
        } // Compound expression
    |   ^(te=IF e1=expression e2=expression e3=expression?)
        {
        
          if(e3 != null)
          {
            List<Node> nodes = asList(e2,e3);
            checkerHelper.checkExpressionsForEqualType(nodes,te);
          }
          
          // This so the chaining of IF rules will occure with the correct type checking
          ((TypeAdoptedNode) te).setTypeDefiningChild(e2);
          
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
    