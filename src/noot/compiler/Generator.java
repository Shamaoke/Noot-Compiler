// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/compiler/Generator.g 2013-07-05 16:03:52

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





	// $ANTLR start "program"
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:40:1: program : ^( NOOT ( declaration | expression )+ ) ;
	public final void program() throws RecognitionException {
		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:41:5: ( ^( NOOT ( declaration | expression )+ ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:41:9: ^( NOOT ( declaration | expression )+ )
			{
			match(input,NOOT,FOLLOW_NOOT_in_program91); 
			match(input, Token.DOWN, null); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:41:16: ( declaration | expression )+
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:41:17: declaration
					{
					pushFollow(FOLLOW_declaration_in_program94);
					declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:41:31: expression
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:44:1: declaration returns [Node node = null;] : ^( ( INT | BOOL | CHAR ) IDENTIFIER ( declaration_extention )? ) ;
	public final Node declaration() throws RecognitionException {
		Node node =  null;;


		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:45:5: ( ^( ( INT | BOOL | CHAR ) IDENTIFIER ( declaration_extention )? ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:45:9: ^( ( INT | BOOL | CHAR ) IDENTIFIER ( declaration_extention )? )
			{
			if ( (input.LA(1) >= BOOL && input.LA(1) <= CHAR)||input.LA(1)==INT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input, Token.DOWN, null); 
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration141); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:45:42: ( declaration_extention )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==COMMA) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:45:42: declaration_extention
					{
					pushFollow(FOLLOW_declaration_extention_in_declaration143);
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
		return node;
	}
	// $ANTLR end "declaration"



	// $ANTLR start "declaration_extention"
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:50:1: declaration_extention : ^( COMMA IDENTIFIER ( declaration_extention )? ) ;
	public final void declaration_extention() throws RecognitionException {
		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:51:5: ( ^( COMMA IDENTIFIER ( declaration_extention )? ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:51:9: ^( COMMA IDENTIFIER ( declaration_extention )? )
			{
			match(input,COMMA,FOLLOW_COMMA_in_declaration_extention179); 
			match(input, Token.DOWN, null); 
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention181); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:51:28: ( declaration_extention )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==COMMA) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:51:28: declaration_extention
					{
					pushFollow(FOLLOW_declaration_extention_in_declaration_extention183);
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:56:1: expression returns [Node node = null;] : (op= operand | ^(te= PLUS e1= expression e2= expression ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION e1= expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE e1= expression e2= expression ) );
	public final Node expression() throws RecognitionException {
		Node node =  null;;


		Node te=null;
		Node id=null;
		Node op =null;
		Node e1 =null;
		Node e2 =null;
		Node en =null;
		Node dc =null;
		Node e3 =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:57:5: (op= operand | ^(te= PLUS e1= expression e2= expression ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION e1= expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE e1= expression e2= expression ) )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:57:9: op= operand
					{
					pushFollow(FOLLOW_operand_in_expression225);
					op=operand();
					state._fsp--;


					          node = op;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:61:9: ^(te= PLUS e1= expression e2= expression )
					{
					te=(Node)match(input,PLUS,FOLLOW_PLUS_in_expression248); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression252);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression256);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					 
					          node = te;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:65:9: ^(te= MINUS e1= expression (e2= expression )? )
					{
					te=(Node)match(input,MINUS,FOLLOW_MINUS_in_expression280); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression284);
					e1=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:65:36: (e2= expression )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==AND||LA4_0==BECOMES||LA4_0==CHARACTER||LA4_0==DEVIDE||(LA4_0 >= EQ && LA4_0 <= FALSE)||(LA4_0 >= IDENTIFIER && LA4_0 <= IF)||(LA4_0 >= LCURLY && LA4_0 <= LESSEQ)||(LA4_0 >= MINUS && LA4_0 <= NEQ)||LA4_0==NUMBER||(LA4_0 >= OR && LA4_0 <= PRINT)||LA4_0==READ||LA4_0==TRUE||LA4_0==WHILE) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:65:36: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression288);
							e2=expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:69:9: ^(te= NEGATION e1= expression )
					{
					te=(Node)match(input,NEGATION,FOLLOW_NEGATION_in_expression313); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression317);
					e1=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:73:9: ^(te= MULTIPLY e1= expression e2= expression )
					{
					te=(Node)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression341); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression345);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression349);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 6 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:77:9: ^(te= DEVIDE e1= expression e2= expression )
					{
					te=(Node)match(input,DEVIDE,FOLLOW_DEVIDE_in_expression373); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression377);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression381);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 7 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:81:9: ^(te= MODULO e1= expression e2= expression )
					{
					te=(Node)match(input,MODULO,FOLLOW_MODULO_in_expression405); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression409);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression413);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 8 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:85:9: ^(te= LESSEQ e1= expression e2= expression )
					{
					te=(Node)match(input,LESSEQ,FOLLOW_LESSEQ_in_expression437); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression441);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression445);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 9 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:89:9: ^(te= MOREEQ e1= expression e2= expression )
					{
					te=(Node)match(input,MOREEQ,FOLLOW_MOREEQ_in_expression469); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression473);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression477);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 10 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:93:9: ^(te= NEQ e1= expression e2= expression )
					{
					te=(Node)match(input,NEQ,FOLLOW_NEQ_in_expression501); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression505);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression509);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 11 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:97:9: ^(te= EQ e1= expression e2= expression )
					{
					te=(Node)match(input,EQ,FOLLOW_EQ_in_expression533); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression537);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression541);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 12 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:101:9: ^(te= LESS e1= expression e2= expression )
					{
					te=(Node)match(input,LESS,FOLLOW_LESS_in_expression565); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression569);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression573);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 13 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:105:9: ^(te= MORE e1= expression e2= expression )
					{
					te=(Node)match(input,MORE,FOLLOW_MORE_in_expression597); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression601);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression605);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 14 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:109:9: ^(te= AND e1= expression e2= expression )
					{
					te=(Node)match(input,AND,FOLLOW_AND_in_expression629); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression633);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression637);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 15 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:113:9: ^(te= OR e1= expression e2= expression )
					{
					te=(Node)match(input,OR,FOLLOW_OR_in_expression661); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression665);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression669);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 16 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:117:9: ^(te= BECOMES id= IDENTIFIER e1= expression )
					{
					te=(Node)match(input,BECOMES,FOLLOW_BECOMES_in_expression693); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression697); 
					pushFollow(FOLLOW_expression_in_expression701);
					e1=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 17 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:121:9: ^(te= READ (id= IDENTIFIER )+ )
					{
					te=(Node)match(input,READ,FOLLOW_READ_in_expression726); 

					              ArrayList<IdentifierNode> identifiers = new ArrayList<IdentifierNode>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:125:11: (id= IDENTIFIER )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:125:12: id= IDENTIFIER
							{
							id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression755); 

							              identifiers.add( (IdentifierNode) id );
							            
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:133:9: ^(te= PRINT (en= expression )+ )
					{
					te=(Node)match(input,PRINT,FOLLOW_PRINT_in_expression807); 

					              ArrayList<Node> expressions = new ArrayList<Node>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:137:11: (en= expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:137:12: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression836);
							en=expression();
							state._fsp--;


							              expressions.add(en);
							            
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:146:9: ^(te= LCURLY (dc= declaration |en= expression )+ )
					{
					te=(Node)match(input,LCURLY,FOLLOW_LCURLY_in_expression888); 

					                ArrayList<Node> commands = new ArrayList<Node>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:150:11: (dc= declaration |en= expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:150:12: dc= declaration
							{
							pushFollow(FOLLOW_declaration_in_expression917);
							dc=declaration();
							state._fsp--;


							            
							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:153:14: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression948);
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


					            node = te;
					        
					}
					break;
				case 20 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:160:9: ^(te= IF e1= expression e2= expression (e3= expression )? )
					{
					te=(Node)match(input,IF,FOLLOW_IF_in_expression1000); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1004);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1008);
					e2=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:160:47: (e3= expression )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==AND||LA8_0==BECOMES||LA8_0==CHARACTER||LA8_0==DEVIDE||(LA8_0 >= EQ && LA8_0 <= FALSE)||(LA8_0 >= IDENTIFIER && LA8_0 <= IF)||(LA8_0 >= LCURLY && LA8_0 <= LESSEQ)||(LA8_0 >= MINUS && LA8_0 <= NEQ)||LA8_0==NUMBER||(LA8_0 >= OR && LA8_0 <= PRINT)||LA8_0==READ||LA8_0==TRUE||LA8_0==WHILE) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:160:47: e3= expression
							{
							pushFollow(FOLLOW_expression_in_expression1012);
							e3=expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					          node = te;
					        
					}
					break;
				case 21 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:164:9: ^(te= WHILE e1= expression e2= expression )
					{
					te=(Node)match(input,WHILE,FOLLOW_WHILE_in_expression1038); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1042);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1046);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


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
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:170:1: operand returns [Node node = null;] : (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER );
	public final Node operand() throws RecognitionException {
		Node node =  null;;


		Node id=null;
		Node n=null;
		Node b=null;
		Node c=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:171:5: (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:171:9: id= IDENTIFIER
					{
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand1087); 

					          node = id;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:175:9: n= NUMBER
					{
					n=(Node)match(input,NUMBER,FOLLOW_NUMBER_in_operand1110); 

					          node = n;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:179:9: b= TRUE
					{
					b=(Node)match(input,TRUE,FOLLOW_TRUE_in_operand1132); 

					          node = b;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:183:9: b= FALSE
					{
					b=(Node)match(input,FALSE,FOLLOW_FALSE_in_operand1154); 

					          node = b;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:187:9: c= CHARACTER
					{
					c=(Node)match(input,CHARACTER,FOLLOW_CHARACTER_in_operand1176); 

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
	public static final BitSet FOLLOW_set_in_declaration129 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration141 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration143 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention179 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention181 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention183 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_operand_in_expression225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression248 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression252 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression256 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression280 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression284 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_expression_in_expression288 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATION_in_expression313 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression317 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULTIPLY_in_expression341 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression345 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression349 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DEVIDE_in_expression373 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression377 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression381 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MODULO_in_expression405 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression409 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression413 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESSEQ_in_expression437 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression441 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression445 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MOREEQ_in_expression469 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression473 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression477 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEQ_in_expression501 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression505 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression509 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expression533 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression537 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression541 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESS_in_expression565 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression569 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression573 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MORE_in_expression597 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression601 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression605 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_expression629 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression633 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression637 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expression661 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression665 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression669 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_expression693 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression697 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression701 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_in_expression726 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression755 = new BitSet(new long[]{0x0000000000080008L});
	public static final BitSet FOLLOW_PRINT_in_expression807 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression836 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_LCURLY_in_expression888 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_expression917 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_expression_in_expression948 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_IF_in_expression1000 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1004 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression1008 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_expression_in_expression1012 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_expression1038 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1042 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression1046 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand1087 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand1110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_operand1132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_operand1154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_operand1176 = new BitSet(new long[]{0x0000000000000002L});
}
