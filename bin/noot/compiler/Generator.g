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

    private Program program = new Program();
    
}

program
    :   ^(NOOT (declaration | expression)+)
        {
           program.finalize();
        }
    ;
    
declaration returns [Node node = null;]
    :   ^(de=(INT | BOOL | CHAR) id=IDENTIFIER
            {
              program.pushInstruction(new Instruction("PUSH","1","Declaring "+((IdentifierNode)id).getNodeType()+" "+id.getText()));
              program.getDeclarations().add( (DeclarationNode)de );
            }
          declaration_extention?)
    ;
    
declaration_extention
    :   ^(de=COMMA id=IDENTIFIER
        {
            program.pushInstruction(new Instruction("PUSH","1","Declaring "+((IdentifierNode)id).getNodeType()+" "+id.getText()));
            program.getDeclarations().add( (DeclarationNode)de );
        }
          declaration_extention?)
    ;
    
expression returns [Node node = null;] // All statements are expressions because they all have a return value
    :   op=operand
        {
          node = op;
        }
    |   ^(te=PLUS expression expression)
        { 
          program.pushInstruction(new Instruction("CALL","add","Adition"));
          node = te;
        }
    |   ^(te=MINUS e1=expression e2=expression?)
        {
          if(e2 != null)
            program.pushInstruction(new Instruction("CALL","sub","Subtracting"));
          else
            program.pushInstruction(new Instruction("CALL","neg","Integer negation"));
            
          node = te;
        }
    |   ^(te=NEGATION expression)
        {
          program.pushInstruction(new Instruction("CALL","not","Boolean negation"));
          node = te;
        }
    |   ^(te=MULTIPLY e1=expression e2=expression)
        {
          program.pushInstruction(new Instruction("CALL","mult","Multiplication"));
          node = te;
        }
    |   ^(te=DEVIDE e1=expression e2=expression)
        {
          program.pushInstruction(new Instruction("CALL","div","Devide"));
          node = te;
        }
    |   ^(te=MODULO e1=expression e2=expression)
        {
          program.pushInstruction(new Instruction("CALL","mod","Modulo"));
          node = te;
        }
    |   ^(te=LESSEQ e1=expression e2=expression)
        {
          program.pushInstruction(new Instruction("CALL","le","Less than or equal"));
          node = te;
        }
    |   ^(te=MOREEQ e1=expression e2=expression)
        {
          program.pushInstruction(new Instruction("CALL","ge","Greater than or equal"));
          node = te;
        }
    |   ^(te=NEQ e1=expression e2=expression)
        {
          program.pushInstruction(new Instruction("LOADL","1"));
          program.pushInstruction(new Instruction("CALL","ne","Not equal"));
          node = te;
        }
    |   ^(te=EQ e1=expression e2=expression)
        {
          program.pushInstruction(new Instruction("LOADL","1" ));
          program.pushInstruction(new Instruction("CALL","eq"));
          node = te;
        }
    |   ^(te=LESS e1=expression e2=expression)
        {
          program.pushInstruction(new Instruction("CALL","lt","Less than"));
          node = te;
        }
    |   ^(te=MORE e1=expression e2=expression)
        {
          program.pushInstruction(new Instruction("CALL","gt","Greater than"));
          node = te;
        }
    |   ^(te=AND e1=expression e2=expression)
        {
          program.pushInstruction(new Instruction("CALL","and"));
          node = te;
        }
    |   ^(te=OR e1=expression e2=expression)
        {
          program.pushInstruction(new Instruction("CALL","or"));
          node = te;
        }
    |   ^(te=BECOMES id=IDENTIFIER e1=expression) // Assign statement
        {
          program.pushInstruction(new Instruction("STORE",program.addressOfIdentifier( (IdentifierNode)id ),1,"Assigning "+id.getText()));
          
          if(te.parrentNeedsResult())
          {
            program.pushInstruction(new Instruction("LOAD",program.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()+" for next expression"));
          }
          
          node = te;
        }
    |   ^(te=READ
          {
            int readCount = 0;
            Instruction returnInstruction = null;
          }
          (id=IDENTIFIER
            {
              if(readCount == 0)
                returnInstruction = new Instruction("LOAD",program.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()+" for next expression");
                
              program.pushInstruction(new Instruction("LOADA",program.addressOfIdentifier( (IdentifierNode)id ),1,"Loading address of "+id.getText()));
              
              if(id.getNodeType() == Node.NodeType.CHAR)
              {
                program.pushInstruction(new Instruction("CALL","get","Reading character "+id.getText()));
              }
              else if(id.getNodeType() == Node.NodeType.INT)
              {
                program.pushInstruction(new Instruction("CALL","getint","Reading int "+id.getText()));
              }
              else if(id.getNodeType() == Node.NodeType.BOOL)
              {
                program.pushInstruction(new Instruction("CALL","getint","Reading boolean "+id.getText()));
              }
              
              readCount++;
            }
          )+) // Read statement
        { 
          if(readCount == 1 && te.parrentNeedsResult())
          {
            program.pushInstruction(returnInstruction);
          }
          
          node = te;
        }
    |   ^(te=PRINT
          {
            int printCount = 0;
            Instruction returnInstruction = null;
          }
          (en=expression
            {
              if(printCount == 0)
                returnInstruction = program.getLastPushedInstruction();
            
              if(en.getNodeType() == Node.NodeType.CHAR)
                program.pushInstruction(new Instruction("CALL","put","Print character"));
              else if(en.getNodeType() == Node.NodeType.INT)
                program.pushInstruction(new Instruction("CALL","putint","Print int"));
              else if(en.getNodeType() == Node.NodeType.BOOL)
                program.pushInstruction(new Instruction("CALL","putint","Print boolean"));
                
              program.pushInstruction(new Instruction("CALL","puteol"));
              
              printCount++;
            }
          )+) // Print statement
        {
          if(printCount == 1 && te.parrentNeedsResult())
          {
            program.pushInstruction(returnInstruction);
          }
          
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
    |   ^(te=IF e1=expression
            {
              Instruction jumpIfInstruction = new Instruction("JUMPIF","notset",0,"If (jump to else)");
              program.pushInstruction(jumpIfInstruction);
            }
          e2=expression
            {
                // Dit kan ingekort worden in het geval er geen else aanwezig is
                Instruction jumpInstruction = new Instruction("JUMP","notset","Else (jump over else)");
                program.pushInstruction(jumpInstruction);
                program.pushBlock();
                
                jumpIfInstruction.setArgument(program.getCurrentBlock().jumpLabel());
            }
          e3=expression?)
        {
          program.pushBlock();
          jumpInstruction.setArgument(program.getCurrentBlock().jumpLabel());
          
          node = te;
        } // Conditional statement
    |   ^(te=WHILE
          { 
            program.pushBlock();
            String loopBackTo = program.getCurrentBlock().jumpLabel();
          }
        expression
          {
            program.pushInstruction(new Instruction("JUMPIF",InstructionBlock.label(program.getCurrentBlock().labelIdentifier + 1,true),0,"Looping"));
          }
        expression)
        {
          program.pushInstruction(new Instruction("JUMP",loopBackTo,"Looping"));
          node = te;
        } // Loop statement
    ;
    
operand returns [Node node = null;]
    :   id=IDENTIFIER 
        {
          program.pushInstruction(new Instruction("LOAD",program.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()));
          node = id;
        }
    |   n=NUMBER
        {
          program.pushInstruction(new Instruction("LOADL",n.getText()));
          node = n;
        }
    |   b=TRUE
        {
          program.pushInstruction(new Instruction("LOADL","1","True Boolean"));
          node = b;
        }
    |   b=FALSE
        {
          program.pushInstruction(new Instruction("LOADL","0","False Boolean"));
          node = b;
        }
    |   c=CHARACTER
        {
          int ascii = (int)c.getText().charAt(1);
          program.pushInstruction(new Instruction("LOADL",Integer.toString(ascii),"Loading character "+c.getText()));
          node = c;
        }
    ;
    