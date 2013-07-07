// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/compiler/Generator.g 2013-07-07 18:52:42

    package noot.compiler;
    import noot.ast.*;
    import noot.assembly.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Generator extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "APOSTROPHE", "BECOMES", 
		"BOOL", "CHAR", "CHARACTER", "COMMA", "COMMENT", "DEVIDE", "DIGIT", "DO", 
		"ELSE", "EQ", "FALSE", "FI", "IDENTIFIER", "IF", "INT", "LCURLY", "LESS", 
		"LESSEQ", "LETTER", "LOWER", "LPAREN", "MINUS", "MODULO", "MORE", "MOREEQ", 
		"MULTIPLY", "NEGATION", "NEQ", "NOOT", "NUMBER", "OD", "OR", "PLUS", "PRINT", 
		"RCURLY", "READ", "RPAREN", "SEMICOLON", "THEN", "TRUE", "UPPER", "WHILE", 
		"WS"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int APOSTROPHE=5;
	public static final int BECOMES=6;
	public static final int BOOL=7;
	public static final int CHAR=8;
	public static final int CHARACTER=9;
	public static final int COMMA=10;
	public static final int COMMENT=11;
	public static final int DEVIDE=12;
	public static final int DIGIT=13;
	public static final int DO=14;
	public static final int ELSE=15;
	public static final int EQ=16;
	public static final int FALSE=17;
	public static final int FI=18;
	public static final int IDENTIFIER=19;
	public static final int IF=20;
	public static final int INT=21;
	public static final int LCURLY=22;
	public static final int LESS=23;
	public static final int LESSEQ=24;
	public static final int LETTER=25;
	public static final int LOWER=26;
	public static final int LPAREN=27;
	public static final int MINUS=28;
	public static final int MODULO=29;
	public static final int MORE=30;
	public static final int MOREEQ=31;
	public static final int MULTIPLY=32;
	public static final int NEGATION=33;
	public static final int NEQ=34;
	public static final int NOOT=35;
	public static final int NUMBER=36;
	public static final int OD=37;
	public static final int OR=38;
	public static final int PLUS=39;
	public static final int PRINT=40;
	public static final int RCURLY=41;
	public static final int READ=42;
	public static final int RPAREN=43;
	public static final int SEMICOLON=44;
	public static final int THEN=45;
	public static final int TRUE=46;
	public static final int UPPER=47;
	public static final int WHILE=48;
	public static final int WS=49;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public Generator(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public Generator(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return Generator.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/Thijs/Development/noot/src/noot/compiler/Generator.g"; }



	    private GeneratorHelper gh = new GeneratorHelper();
	    



	// $ANTLR start "program"
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:43:1: program : ^( NOOT ( declaration | expression )+ ) ;
	public final void program() throws RecognitionException {
		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:44:5: ( ^( NOOT ( declaration | expression )+ ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:44:9: ^( NOOT ( declaration | expression )+ )
			{
			match(input,NOOT,FOLLOW_NOOT_in_program91); 
			match(input, Token.DOWN, null); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:44:16: ( declaration | expression )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= BOOL && LA1_0 <= CHAR)||LA1_0==INT) ) {
					alt1=1;
				}
				else if ( (LA1_0==AND||LA1_0==BECOMES||LA1_0==CHARACTER||LA1_0==DEVIDE||(LA1_0 >= EQ && LA1_0 <= FALSE)||(LA1_0 >= IDENTIFIER && LA1_0 <= IF)||(LA1_0 >= LCURLY && LA1_0 <= LESSEQ)||(LA1_0 >= MINUS && LA1_0 <= NEQ)||LA1_0==NUMBER||(LA1_0 >= OR && LA1_0 <= PRINT)||LA1_0==READ||LA1_0==TRUE||LA1_0==WHILE) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:44:17: declaration
					{
					pushFollow(FOLLOW_declaration_in_program94);
					declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:44:31: expression
					{
					pushFollow(FOLLOW_expression_in_program98);
					expression();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input, Token.UP, null); 


			           gh.finalizeAndPrintInstructions();
			        
			}

		}
		 
		    catch (RecognitionException e) { 
		        throw e; 
		    } 

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "declaration"
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:50:1: declaration : ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER ( declaration_extention )? ) ;
	public final void declaration() throws RecognitionException {
		Node de=null;
		Node id=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:51:5: ( ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER ( declaration_extention )? ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:51:9: ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER ( declaration_extention )? )
			{
			de=(Node)input.LT(1);
			if ( (input.LA(1) >= BOOL && input.LA(1) <= CHAR)||input.LA(1)==INT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input, Token.DOWN, null); 
			id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration151); 

			              gh.declare( (DeclarationNode)de );
			            
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:55:11: ( declaration_extention )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==COMMA) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:55:11: declaration_extention
					{
					pushFollow(FOLLOW_declaration_extention_in_declaration177);
					declaration_extention();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 

			}

		}
		 
		    catch (RecognitionException e) { 
		        throw e; 
		    } 

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declaration"



	// $ANTLR start "declaration_extention"
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:58:1: declaration_extention : ^(de= COMMA id= IDENTIFIER ( declaration_extention )? ) ;
	public final void declaration_extention() throws RecognitionException {
		Node de=null;
		Node id=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:59:5: ( ^(de= COMMA id= IDENTIFIER ( declaration_extention )? ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:59:9: ^(de= COMMA id= IDENTIFIER ( declaration_extention )? )
			{
			de=(Node)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention205); 
			match(input, Token.DOWN, null); 
			id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention209); 

			            gh.declare( (DeclarationNode)de );
			        
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:63:11: ( declaration_extention )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==COMMA) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:63:11: declaration_extention
					{
					pushFollow(FOLLOW_declaration_extention_in_declaration_extention231);
					declaration_extention();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 

			}

		}
		 
		    catch (RecognitionException e) { 
		        throw e; 
		    } 

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declaration_extention"



	// $ANTLR start "expression"
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:66:1: expression returns [Node node = null;] : (op= operand | ^(te= PLUS expression expression ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE expression expression ) );
	public final Node expression() throws RecognitionException {
		Node node =  null;;


		Node te=null;
		Node id=null;
		Node op =null;
		Node e1 =null;
		Node e2 =null;
		Node en =null;
		Node e3 =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:67:5: (op= operand | ^(te= PLUS expression expression ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE expression expression ) )
			int alt9=21;
			switch ( input.LA(1) ) {
			case CHARACTER:
			case FALSE:
			case IDENTIFIER:
			case NUMBER:
			case TRUE:
				{
				alt9=1;
				}
				break;
			case PLUS:
				{
				alt9=2;
				}
				break;
			case MINUS:
				{
				alt9=3;
				}
				break;
			case NEGATION:
				{
				alt9=4;
				}
				break;
			case MULTIPLY:
				{
				alt9=5;
				}
				break;
			case DEVIDE:
				{
				alt9=6;
				}
				break;
			case MODULO:
				{
				alt9=7;
				}
				break;
			case LESSEQ:
				{
				alt9=8;
				}
				break;
			case MOREEQ:
				{
				alt9=9;
				}
				break;
			case NEQ:
				{
				alt9=10;
				}
				break;
			case EQ:
				{
				alt9=11;
				}
				break;
			case LESS:
				{
				alt9=12;
				}
				break;
			case MORE:
				{
				alt9=13;
				}
				break;
			case AND:
				{
				alt9=14;
				}
				break;
			case OR:
				{
				alt9=15;
				}
				break;
			case BECOMES:
				{
				alt9=16;
				}
				break;
			case READ:
				{
				alt9=17;
				}
				break;
			case PRINT:
				{
				alt9=18;
				}
				break;
			case LCURLY:
				{
				alt9=19;
				}
				break;
			case IF:
				{
				alt9=20;
				}
				break;
			case WHILE:
				{
				alt9=21;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:67:9: op= operand
					{
					pushFollow(FOLLOW_operand_in_expression263);
					op=operand();
					state._fsp--;


					          node = op;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:71:9: ^(te= PLUS expression expression )
					{
					te=(Node)match(input,PLUS,FOLLOW_PLUS_in_expression286); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression288);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression290);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					 
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","add","Adition"));
					          node = te;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:76:9: ^(te= MINUS e1= expression (e2= expression )? )
					{
					te=(Node)match(input,MINUS,FOLLOW_MINUS_in_expression314); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression318);
					e1=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:76:36: (e2= expression )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==AND||LA4_0==BECOMES||LA4_0==CHARACTER||LA4_0==DEVIDE||(LA4_0 >= EQ && LA4_0 <= FALSE)||(LA4_0 >= IDENTIFIER && LA4_0 <= IF)||(LA4_0 >= LCURLY && LA4_0 <= LESSEQ)||(LA4_0 >= MINUS && LA4_0 <= NEQ)||LA4_0==NUMBER||(LA4_0 >= OR && LA4_0 <= PRINT)||LA4_0==READ||LA4_0==TRUE||LA4_0==WHILE) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:76:36: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression322);
							e2=expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue())
					          {
					            if(e2 != null)
					              gh.currentBlock().push(new Instruction("CALL","sub","Subtracting"));
					            else
					              gh.currentBlock().push(new Instruction("CALL","neg","Integer negation"));
					          }  
					          node = te;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:87:9: ^(te= NEGATION expression )
					{
					te=(Node)match(input,NEGATION,FOLLOW_NEGATION_in_expression347); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression349);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","not","Boolean negation"));
					          node = te;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:92:9: ^(te= MULTIPLY e1= expression e2= expression )
					{
					te=(Node)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression373); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression377);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression381);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","mult","Multiplication"));
					          node = te;
					        
					}
					break;
				case 6 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:97:9: ^(te= DEVIDE e1= expression e2= expression )
					{
					te=(Node)match(input,DEVIDE,FOLLOW_DEVIDE_in_expression405); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression409);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression413);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","div","Devide"));
					          node = te;
					        
					}
					break;
				case 7 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:102:9: ^(te= MODULO e1= expression e2= expression )
					{
					te=(Node)match(input,MODULO,FOLLOW_MODULO_in_expression437); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression441);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression445);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","mod","Modulo"));
					          node = te;
					        
					}
					break;
				case 8 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:107:9: ^(te= LESSEQ e1= expression e2= expression )
					{
					te=(Node)match(input,LESSEQ,FOLLOW_LESSEQ_in_expression469); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression473);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression477);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","le","Less than or equal"));
					          node = te;
					        
					}
					break;
				case 9 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:112:9: ^(te= MOREEQ e1= expression e2= expression )
					{
					te=(Node)match(input,MOREEQ,FOLLOW_MOREEQ_in_expression501); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression505);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression509);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","ge","Greater than or equal"));
					          node = te;
					        
					}
					break;
				case 10 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:117:9: ^(te= NEQ e1= expression e2= expression )
					{
					te=(Node)match(input,NEQ,FOLLOW_NEQ_in_expression533); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression537);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression541);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1"));
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","ne","Not equal"));
					          node = te;
					        
					}
					break;
				case 11 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:123:9: ^(te= EQ e1= expression e2= expression )
					{
					te=(Node)match(input,EQ,FOLLOW_EQ_in_expression565); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression569);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression573);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1" ));
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","eq"));
					          node = te;
					        
					}
					break;
				case 12 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:129:9: ^(te= LESS e1= expression e2= expression )
					{
					te=(Node)match(input,LESS,FOLLOW_LESS_in_expression597); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression601);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression605);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","lt","Less than"));
					          node = te;
					        
					}
					break;
				case 13 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:134:9: ^(te= MORE e1= expression e2= expression )
					{
					te=(Node)match(input,MORE,FOLLOW_MORE_in_expression629); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression633);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression637);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","gt","Greater than"));
					          node = te;
					        
					}
					break;
				case 14 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:139:9: ^(te= AND e1= expression e2= expression )
					{
					te=(Node)match(input,AND,FOLLOW_AND_in_expression661); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression665);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression669);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","and"));
					          node = te;
					        
					}
					break;
				case 15 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:144:9: ^(te= OR e1= expression e2= expression )
					{
					te=(Node)match(input,OR,FOLLOW_OR_in_expression693); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression697);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression701);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","or"));
					          node = te;
					        
					}
					break;
				case 16 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:149:9: ^(te= BECOMES id= IDENTIFIER e1= expression )
					{
					te=(Node)match(input,BECOMES,FOLLOW_BECOMES_in_expression725); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression729); 
					pushFollow(FOLLOW_expression_in_expression733);
					e1=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          gh.currentBlock().push(new Instruction("STORE",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Assigning "+id.getText()));
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()+" for next expression"));
					          node = te;
					        
					}
					break;
				case 17 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:155:9: ^(te= READ (id= IDENTIFIER )+ )
					{
					te=(Node)match(input,READ,FOLLOW_READ_in_expression758); 
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:155:19: (id= IDENTIFIER )+
					int cnt5=0;
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==IDENTIFIER) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:155:20: id= IDENTIFIER
							{
							id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression763); 

							                
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
							                gh.pushInstructionsForPrintingString("Enter boolean: ");
							                gh.currentBlock().push(new Instruction("CALL","getint","Reading boolean "+id.getText()));
							              }
							              
							              if(te.getChildren().size() == 1 && !te.shouldIgnoreReturnValue())
							              {
							                gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()+" for next expression"));
							              }
							            
							}
							break;

						default :
							if ( cnt5 >= 1 ) break loop5;
							EarlyExitException eee = new EarlyExitException(5, input);
							throw eee;
						}
						cnt5++;
					}

					match(input, Token.UP, null); 

					 
					          node = te;
					        
					}
					break;
				case 18 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:185:9: ^(te= PRINT (en= expression )+ )
					{
					te=(Node)match(input,PRINT,FOLLOW_PRINT_in_expression815); 

					              MemoryLocation temp = null;
					              if(te.getChildren().size() == 1 && !te.shouldIgnoreReturnValue()) temp = gh.allocHelperRegister();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:190:11: (en= expression )+
					int cnt6=0;
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==AND||LA6_0==BECOMES||LA6_0==CHARACTER||LA6_0==DEVIDE||(LA6_0 >= EQ && LA6_0 <= FALSE)||(LA6_0 >= IDENTIFIER && LA6_0 <= IF)||(LA6_0 >= LCURLY && LA6_0 <= LESSEQ)||(LA6_0 >= MINUS && LA6_0 <= NEQ)||LA6_0==NUMBER||(LA6_0 >= OR && LA6_0 <= PRINT)||LA6_0==READ||LA6_0==TRUE||LA6_0==WHILE) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:190:12: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression845);
							en=expression();
							state._fsp--;


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
							                gh.currentBlock().push(new Instruction("CALL","putint","Print boolean"));
							                
							              gh.currentBlock().push(new Instruction("CALL","puteol"));
							              
							              if(temp != null)
							              {
							                gh.currentBlock().push(new Instruction("LOAD",gh.addressOfMemoryLocation(temp),1,"Loading temp"));
							                gh.deallocHelperRegister(temp);
							              }
							            
							}
							break;

						default :
							if ( cnt6 >= 1 ) break loop6;
							EarlyExitException eee = new EarlyExitException(6, input);
							throw eee;
						}
						cnt6++;
					}

					match(input, Token.UP, null); 


					          
					          node = te;
					        
					}
					break;
				case 19 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:218:9: ^(te= LCURLY (dc= declaration |en= expression )+ )
					{
					te=(Node)match(input,LCURLY,FOLLOW_LCURLY_in_expression897); 

					              gh.openScope();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:222:11: (dc= declaration |en= expression )+
					int cnt7=0;
					loop7:
					while (true) {
						int alt7=3;
						int LA7_0 = input.LA(1);
						if ( ((LA7_0 >= BOOL && LA7_0 <= CHAR)||LA7_0==INT) ) {
							alt7=1;
						}
						else if ( (LA7_0==AND||LA7_0==BECOMES||LA7_0==CHARACTER||LA7_0==DEVIDE||(LA7_0 >= EQ && LA7_0 <= FALSE)||(LA7_0 >= IDENTIFIER && LA7_0 <= IF)||(LA7_0 >= LCURLY && LA7_0 <= LESSEQ)||(LA7_0 >= MINUS && LA7_0 <= NEQ)||LA7_0==NUMBER||(LA7_0 >= OR && LA7_0 <= PRINT)||LA7_0==READ||LA7_0==TRUE||LA7_0==WHILE) ) {
							alt7=2;
						}

						switch (alt7) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:222:12: dc= declaration
							{
							pushFollow(FOLLOW_declaration_in_expression926);
							declaration();
							state._fsp--;

							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:222:29: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression932);
							en=expression();
							state._fsp--;

							}
							break;

						default :
							if ( cnt7 >= 1 ) break loop7;
							EarlyExitException eee = new EarlyExitException(7, input);
							throw eee;
						}
						cnt7++;
					}

					match(input, Token.UP, null); 


					            gh.tryToCloseScope();
					            node = te;
					        
					}
					break;
				case 20 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:227:9: ^(te= IF e1= expression e2= expression (e3= expression )? )
					{
					te=(Node)match(input,IF,FOLLOW_IF_in_expression959); 

					              gh.holdUpcommingScope();
					            
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression987);
					e1=expression();
					state._fsp--;


					              Instruction jumpIfInstruction = new Instruction("JUMPIF","notset",0,"If (jump to else)");
					              gh.currentBlock().push(jumpIfInstruction);
					            
					pushFollow(FOLLOW_expression_in_expression1015);
					e2=expression();
					state._fsp--;


					                Instruction jumpInstruction = new Instruction("JUMP","notset","Else (jump over else)");
					                
					                if(te.getChildren().size() == 3)
					                  gh.currentBlock().push(jumpInstruction);
					   
					                gh.pushBlock();
					                
					                jumpIfInstruction.setArgument(gh.currentBlock().jumpLabel());
					            
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:247:13: (e3= expression )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==AND||LA8_0==BECOMES||LA8_0==CHARACTER||LA8_0==DEVIDE||(LA8_0 >= EQ && LA8_0 <= FALSE)||(LA8_0 >= IDENTIFIER && LA8_0 <= IF)||(LA8_0 >= LCURLY && LA8_0 <= LESSEQ)||(LA8_0 >= MINUS && LA8_0 <= NEQ)||LA8_0==NUMBER||(LA8_0 >= OR && LA8_0 <= PRINT)||LA8_0==READ||LA8_0==TRUE||LA8_0==WHILE) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:247:13: e3= expression
							{
							pushFollow(FOLLOW_expression_in_expression1043);
							e3=expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					          gh.releaseAndCloseScope();
					          
					          gh.pushBlock(); // if block is empty it won't push
					          jumpInstruction.setArgument(gh.currentBlock().jumpLabel());
					          
					          node = te;
					        
					}
					break;
				case 21 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:256:9: ^(te= WHILE expression expression )
					{
					te=(Node)match(input,WHILE,FOLLOW_WHILE_in_expression1069); 
					 
					            gh.pushBlock();
					            String loopBackTo = gh.currentBlock().jumpLabel();
					            
					            gh.holdUpcommingScope();
					          
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1091);
					expression();
					state._fsp--;


					            Instruction jumpIfInstruction = new Instruction("JUMPIF","notset",0,"While (jump out)");
					            gh.currentBlock().push(jumpIfInstruction);
					          
					pushFollow(FOLLOW_expression_in_expression1113);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          gh.releaseAndCloseScope();
					          
					          gh.currentBlock().push(new Instruction("JUMP",loopBackTo,"Looping back"));
					          
					          gh.pushBlock();
					          jumpIfInstruction.setArgument(gh.currentBlock().jumpLabel());
					          
					          node = te;
					        
					}
					break;

			}
		}
		 
		    catch (RecognitionException e) { 
		        throw e; 
		    } 

		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "expression"



	// $ANTLR start "operand"
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:281:1: operand returns [Node node = null;] : (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER );
	public final Node operand() throws RecognitionException {
		Node node =  null;;


		Node id=null;
		Node n=null;
		Node b=null;
		Node c=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:282:5: (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER )
			int alt10=5;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				alt10=1;
				}
				break;
			case NUMBER:
				{
				alt10=2;
				}
				break;
			case TRUE:
				{
				alt10=3;
				}
				break;
			case FALSE:
				{
				alt10=4;
				}
				break;
			case CHARACTER:
				{
				alt10=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:282:9: id= IDENTIFIER
					{
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand1154); 

					          if(!id.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()));
					          node = id;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:287:9: n= NUMBER
					{
					n=(Node)match(input,NUMBER,FOLLOW_NUMBER_in_operand1177); 

					          if(!n.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL",n.getText()));
					          node = n;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:292:9: b= TRUE
					{
					b=(Node)match(input,TRUE,FOLLOW_TRUE_in_operand1199); 

					          if(!b.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1","True Boolean"));
					          node = b;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:297:9: b= FALSE
					{
					b=(Node)match(input,FALSE,FOLLOW_FALSE_in_operand1221); 

					          if(!b.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","0","False Boolean"));
					          node = b;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:302:9: c= CHARACTER
					{
					c=(Node)match(input,CHARACTER,FOLLOW_CHARACTER_in_operand1243); 

					          if(!c.shouldIgnoreReturnValue())
					          {
					            int ascii = (int)c.getText().charAt(1);
					            gh.currentBlock().push(new Instruction("LOADL",Integer.toString(ascii),"Loading character "+c.getText()));
					          }
					          node = c;
					        
					}
					break;

			}
		}
		 
		    catch (RecognitionException e) { 
		        throw e; 
		    } 

		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "operand"

	// Delegated rules



	public static final BitSet FOLLOW_NOOT_in_program91 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_program94 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_expression_in_program98 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_set_in_declaration137 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration151 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration177 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention205 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention209 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention231 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_operand_in_expression263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression286 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression288 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression290 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression314 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression318 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_expression_in_expression322 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATION_in_expression347 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression349 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULTIPLY_in_expression373 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression377 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression381 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DEVIDE_in_expression405 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression409 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression413 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MODULO_in_expression437 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression441 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression445 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESSEQ_in_expression469 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression473 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression477 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MOREEQ_in_expression501 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression505 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression509 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEQ_in_expression533 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression537 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression541 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expression565 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression569 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression573 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESS_in_expression597 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression601 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression605 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MORE_in_expression629 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression633 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression637 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_expression661 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression665 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression669 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expression693 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression697 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression701 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_expression725 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression729 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression733 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_in_expression758 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression763 = new BitSet(new long[]{0x0000000000080008L});
	public static final BitSet FOLLOW_PRINT_in_expression815 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression845 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_LCURLY_in_expression897 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_expression926 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_expression_in_expression932 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_IF_in_expression959 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression987 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression1015 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_expression_in_expression1043 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_expression1069 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1091 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression1113 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand1154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand1177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_operand1199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_operand1221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_operand1243 = new BitSet(new long[]{0x0000000000000002L});
}
