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

@rulecatch { 
    catch (RecognitionException e) { 
        throw e; 
    } 
}

@members {

    private GeneratorHelper gh = new GeneratorHelper();
    
}

program
    :   ^(NOOT (declaration | expression)+)
        {
           gh.finalizeAndPrintInstructions();
        }
    ;
    
declaration
    :   ^(de=(INT | BOOL | CHAR) id=IDENTIFIER // Constant
            {
              gh.declare( (DeclarationNode)de );
            }
          op=operand
            {
              gh.currentBlock().push(new Instruction("STORE",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Assigning constant "+id.getText()));
            }
          declaration_extention?)
    |   ^(de=(INT | BOOL | CHAR) id=IDENTIFIER // Variable
            {
              gh.declare( (DeclarationNode)de );
            }
          declaration_extention?)
    ;
    
declaration_extention
    :   ^(de=COMMA id=IDENTIFIER // Constant
            {
              gh.declare( (DeclarationNode)de );
            }
          op=operand
            {
              gh.currentBlock().push(new Instruction("STORE",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Assigning constant "+id.getText()));
            }
          declaration_extention?)
    |   ^(de=COMMA id=IDENTIFIER // Variable
            {
              gh.declare( (DeclarationNode)de );
            }
           declaration_extention?)  
    ;
    
expression returns [Node node = null;] // All statements are expressions because they all have a return value
    :   op=operand
        {
          node = op;
        }
    |   ^(te=PLUS e1=expression e2=expression?)
        { 
          if(!te.shouldIgnoreReturnValue())
          {
            if(e2 != null)
              gh.currentBlock().push(new Instruction("CALL","add","Adition"));
          }  
          node = te;
        }
    |   ^(te=MINUS e1=expression e2=expression?)
        {
          if(!te.shouldIgnoreReturnValue())
          {
            if(e2 != null)
              gh.currentBlock().push(new Instruction("CALL","sub","Subtracting"));
            else
              gh.currentBlock().push(new Instruction("CALL","neg","Integer negation"));
          }  
          node = te;
        }
    |   ^(te=NEGATION expression)
        {
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","not","Boolean negation"));
          node = te;
        }
    |   ^(te=MULTIPLY e1=expression e2=expression)
        {
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","mult","Multiplication"));
          node = te;
        }
    |   ^(te=DEVIDE e1=expression e2=expression)
        {
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","div","Devide"));
          node = te;
        }
    |   ^(te=MODULO e1=expression e2=expression)
        {
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","mod","Modulo"));
          node = te;
        }
    |   ^(te=LESSEQ e1=expression e2=expression)
        {
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","le","Less than or equal"));
          node = te;
        }
    |   ^(te=MOREEQ e1=expression e2=expression)
        {
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","ge","Greater than or equal"));
          node = te;
        }
    |   ^(te=NEQ e1=expression e2=expression)
        {
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1"));
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","ne","Not equal"));
          node = te;
        }
    |   ^(te=EQ e1=expression e2=expression)
        {
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1" ));
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","eq"));
          node = te;
        }
    |   ^(te=LESS e1=expression e2=expression)
        {
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","lt","Less than"));
          node = te;
        }
    |   ^(te=MORE e1=expression e2=expression)
        {
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","gt","Greater than"));
          node = te;
        }
    |   ^(te=AND e1=expression e2=expression)
        {
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","and"));
          node = te;
        }
    |   ^(te=OR e1=expression e2=expression)
        {
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","or"));
          node = te;
        }
    |   ^(te=BECOMES id=IDENTIFIER e1=expression) // Assign statement
        {
          gh.currentBlock().push(new Instruction("STORE",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Assigning "+id.getText()));
          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()+" for next expression"));
          node = te;
        }
    |   ^(te=READ (id=IDENTIFIER
            {
                
              gh.currentBlock().push(new Instruction("LOADA",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading address of "+id.getText()));
              
              if(id.getNodeType() == Node.NodeType.CHAR)
              {
                gh.pushInstructionsForPrintingString("Enter character: ");
                gh.currentBlock().push(new Instruction("CALL","get","Reading character "+id.getText()));
              }
              else if(id.getNodeType() == Node.NodeType.INT)
              {
                gh.pushInstructionsForPrintingString("Enter integer: ");
                gh.currentBlock().push(new Instruction("CALL","getint","Reading int "+id.getText()));
              }
              else if(id.getNodeType() == Node.NodeType.BOOL)
              {
                gh.pushInstructionsForPrintingString("Enter boolean (0/1): ");
                gh.currentBlock().push(new Instruction("CALL","getint","Reading boolean "+id.getText()));
              }
              
              if(te.getChildren().size() == 1 && !te.shouldIgnoreReturnValue())
              {
                gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()+" for next expression"));
              }
            }
          )+) // Read statement
        { 
          node = te;
        }
    |   ^(te=PRINT 
            {
              MemoryLocation temp = null;
              if(te.getChildren().size() == 1 && !te.shouldIgnoreReturnValue()) temp = gh.allocHelperRegister();
            }
          (en=expression
            {
              if(temp != null)
              {
                gh.currentBlock().push(new Instruction("STORE",gh.addressOfMemoryLocation(temp),1,"Assigning temp"));
                gh.currentBlock().push(new Instruction("LOAD",gh.addressOfMemoryLocation(temp),1,"Loading temp"));
              }
              
              if(en.getNodeType() == Node.NodeType.CHAR)
                gh.currentBlock().push(new Instruction("CALL","put","Print character"));
              else if(en.getNodeType() == Node.NodeType.INT)
                gh.currentBlock().push(new Instruction("CALL","putint","Print int"));
              else if(en.getNodeType() == Node.NodeType.BOOL)
              {
                gh.currentBlock().push(new Instruction("LOADL","1" ));
                gh.currentBlock().push(new Instruction("LOADL","1" ));
                gh.currentBlock().push(new Instruction("CALL","eq"));
                Instruction jumpIfInstruction = new Instruction("JUMPIF","notset",0,"Printing True or jump");
                gh.currentBlock().push(jumpIfInstruction);
                
                gh.pushInstructionsForPrintingString("true");
                
                Instruction jumpInstruction = new Instruction("JUMP","notset","Printing False");
                gh.currentBlock().push(jumpInstruction);
                
                gh.pushBlock();
                jumpIfInstruction.setArgument(gh.currentBlock().jumpLabel());
                
                gh.pushInstructionsForPrintingString("false");
                
                gh.pushBlock();
                jumpInstruction.setArgument(gh.currentBlock().jumpLabel());
                
              }
                
              gh.currentBlock().push(new Instruction("CALL","puteol"));
              
              if(temp != null)
              {
                gh.currentBlock().push(new Instruction("LOAD",gh.addressOfMemoryLocation(temp),1,"Loading temp"));
                //gh.deallocHelperRegister(temp);
              }
            }
          )+) // Print statement
        {
          
          node = te;
        }
    |   ^(te=LCURLY (dc=declaration | en=expression)+)
        {
            node = te;
        } // Compound expression
    |   ^(te=IF e1=expression
            {
              Instruction jumpIfInstruction = new Instruction("JUMPIF","notset",0,"If (jump to else)");
              gh.currentBlock().push(jumpIfInstruction);
            }
          e2=expression
            {
                Instruction jumpInstruction = new Instruction("JUMP","notset","Else (jump over else)");
                
                if(te.getChildren().size() == 3)
                  gh.currentBlock().push(jumpInstruction);
   
                gh.pushBlock();
                
                jumpIfInstruction.setArgument(gh.currentBlock().jumpLabel());
            }
          e3=expression?)
        {
          
          gh.pushBlock(); // if block is empty it won't push
          jumpInstruction.setArgument(gh.currentBlock().jumpLabel());
          
          node = te;
        } // Conditional statement
    |   ^(te=WHILE
          { 
            gh.pushBlock();
            String loopBackTo = gh.currentBlock().jumpLabel();
          }
        expression
          {
            Instruction jumpIfInstruction = new Instruction("JUMPIF","notset",0,"While (jump out)");
            gh.currentBlock().push(jumpIfInstruction);
          }
        expression)
        {
          gh.currentBlock().push(new Instruction("JUMP",loopBackTo,"Looping back"));
          
          gh.pushBlock();
          jumpIfInstruction.setArgument(gh.currentBlock().jumpLabel());
          
          node = te;
        } // Loop statement
    ;
    
operand returns [Node node = null;]
    :   id=IDENTIFIER 
        {
          if(!id.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()));
          node = id;
        }
    |   n=NUMBER
        {
          if(!n.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL",n.getText()));
          node = n;
        }
    |   b=TRUE
        {
          if(!b.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1","True Boolean"));
          node = b;
        }
    |   b=FALSE
        {
          if(!b.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","0","False Boolean"));
          node = b;
        }
    |   c=CHARACTER
        {
          if(!c.shouldIgnoreReturnValue())
          {
            int ascii = (int)c.getText().charAt(1);
            gh.currentBlock().push(new Instruction("LOADL",Integer.toString(ascii),"Loading character "+c.getText()));
          }
          node = c;
        }
    ;
    