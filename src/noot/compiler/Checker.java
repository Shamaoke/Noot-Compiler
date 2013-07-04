// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/compiler/Checker.g 2013-07-04 16:24:10

    package noot.compiler;
    import noot.ast.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Checker extends TreeParser {
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


	public Checker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public Checker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return Checker.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/Thijs/Development/noot/src/noot/compiler/Checker.g"; }


	    public CheckerHelper checkerHelper = new CheckerHelper();



	// $ANTLR start "program"
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:25:1: program : ^( NOOT ( declaration | expression )+ ) ;
	public final void program() throws RecognitionException {
		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:26:5: ( ^( NOOT ( declaration | expression )+ ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:26:9: ^( NOOT ( declaration | expression )+ )
			{
			match(input,NOOT,FOLLOW_NOOT_in_program94); 
			match(input, Token.DOWN, null); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:26:16: ( declaration | expression )+
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:26:17: declaration
					{
					pushFollow(FOLLOW_declaration_in_program97);
					declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:26:31: expression
					{
					pushFollow(FOLLOW_expression_in_program101);
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:29:1: declaration : ^(d= ( INT | BOOL | CHAR ) IDENTIFIER ( declaration_extention )? ) ;
	public final void declaration() throws RecognitionException {
		Node d=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:30:5: ( ^(d= ( INT | BOOL | CHAR ) IDENTIFIER ( declaration_extention )? ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:30:9: ^(d= ( INT | BOOL | CHAR ) IDENTIFIER ( declaration_extention )? )
			{
			d=(Node)input.LT(1);
			if ( (input.LA(1) >= BOOL && input.LA(1) <= CHAR)||input.LA(1)==INT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input, Token.DOWN, null); 
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration142); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:30:44: ( declaration_extention )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==COMMA) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:30:44: declaration_extention
					{
					pushFollow(FOLLOW_declaration_extention_in_declaration144);
					declaration_extention();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 


			            checkerHelper.declare((DeclarationNode)d);
			        
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:36:1: declaration_extention : ^(d= COMMA id= IDENTIFIER ( declaration_extention )? ) ;
	public final void declaration_extention() throws RecognitionException {
		Node d=null;
		Node id=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:37:5: ( ^(d= COMMA id= IDENTIFIER ( declaration_extention )? ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:37:9: ^(d= COMMA id= IDENTIFIER ( declaration_extention )? )
			{
			d=(Node)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention182); 
			match(input, Token.DOWN, null); 
			id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention186); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:37:33: ( declaration_extention )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==COMMA) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:37:33: declaration_extention
					{
					pushFollow(FOLLOW_declaration_extention_in_declaration_extention188);
					declaration_extention();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 


			            checkerHelper.declare((DeclarationNode)d);
			        
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:43:1: expression : ( operand | ^( PLUS expression expression ) | ^( MINUS expression ( expression )? ) | ^( NEGATION expression ) | ^( MULTIPLY expression expression ) | ^( DEVIDE expression expression ) | ^( MODULO expression expression ) | ^( LESSEQ expression expression ) | ^( MOREEQ expression expression ) | ^( NEQ expression expression ) | ^( EQ expression expression ) | ^( LESS expression expression ) | ^( MORE expression expression ) | ^( AND expression expression ) | ^( OR expression expression ) | ^( BECOMES id= IDENTIFIER expression ) | ^( READ ( expression )+ ) | ^( PRINT ( expression )+ ) | ^( LCURLY ( declaration | expression )+ ) | ^( IF expression expression ( expression )? ) | ^( WHILE expression expression ) );
	public final void expression() throws RecognitionException {
		Node id=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:44:5: ( operand | ^( PLUS expression expression ) | ^( MINUS expression ( expression )? ) | ^( NEGATION expression ) | ^( MULTIPLY expression expression ) | ^( DEVIDE expression expression ) | ^( MODULO expression expression ) | ^( LESSEQ expression expression ) | ^( MOREEQ expression expression ) | ^( NEQ expression expression ) | ^( EQ expression expression ) | ^( LESS expression expression ) | ^( MORE expression expression ) | ^( AND expression expression ) | ^( OR expression expression ) | ^( BECOMES id= IDENTIFIER expression ) | ^( READ ( expression )+ ) | ^( PRINT ( expression )+ ) | ^( LCURLY ( declaration | expression )+ ) | ^( IF expression expression ( expression )? ) | ^( WHILE expression expression ) )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:44:9: operand
					{
					pushFollow(FOLLOW_operand_in_expression224);
					operand();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:45:9: ^( PLUS expression expression )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression235); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression237);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression239);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:46:9: ^( MINUS expression ( expression )? )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression251); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression253);
					expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:46:28: ( expression )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==AND||LA4_0==BECOMES||LA4_0==CHARACTER||LA4_0==DEVIDE||(LA4_0 >= EQ && LA4_0 <= FALSE)||(LA4_0 >= IDENTIFIER && LA4_0 <= IF)||(LA4_0 >= LCURLY && LA4_0 <= LESSEQ)||(LA4_0 >= MINUS && LA4_0 <= NEQ)||LA4_0==NUMBER||(LA4_0 >= OR && LA4_0 <= PRINT)||LA4_0==READ||LA4_0==TRUE||LA4_0==WHILE) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:46:28: expression
							{
							pushFollow(FOLLOW_expression_in_expression255);
							expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:47:9: ^( NEGATION expression )
					{
					match(input,NEGATION,FOLLOW_NEGATION_in_expression268); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression270);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:48:9: ^( MULTIPLY expression expression )
					{
					match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression282); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression284);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression286);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:49:9: ^( DEVIDE expression expression )
					{
					match(input,DEVIDE,FOLLOW_DEVIDE_in_expression298); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression300);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression302);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:50:9: ^( MODULO expression expression )
					{
					match(input,MODULO,FOLLOW_MODULO_in_expression314); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression316);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression318);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:51:9: ^( LESSEQ expression expression )
					{
					match(input,LESSEQ,FOLLOW_LESSEQ_in_expression330); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression332);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression334);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:52:9: ^( MOREEQ expression expression )
					{
					match(input,MOREEQ,FOLLOW_MOREEQ_in_expression346); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression348);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression350);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 10 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:53:9: ^( NEQ expression expression )
					{
					match(input,NEQ,FOLLOW_NEQ_in_expression362); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression364);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression366);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 11 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:54:9: ^( EQ expression expression )
					{
					match(input,EQ,FOLLOW_EQ_in_expression378); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression380);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression382);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 12 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:55:9: ^( LESS expression expression )
					{
					match(input,LESS,FOLLOW_LESS_in_expression394); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression396);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression398);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 13 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:56:9: ^( MORE expression expression )
					{
					match(input,MORE,FOLLOW_MORE_in_expression410); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression412);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression414);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 14 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:57:9: ^( AND expression expression )
					{
					match(input,AND,FOLLOW_AND_in_expression426); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression428);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression430);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 15 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:58:9: ^( OR expression expression )
					{
					match(input,OR,FOLLOW_OR_in_expression442); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression444);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression446);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 16 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:59:9: ^( BECOMES id= IDENTIFIER expression )
					{
					match(input,BECOMES,FOLLOW_BECOMES_in_expression458); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression462); 
					pushFollow(FOLLOW_expression_in_expression464);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					        checkerHelper.linkToDeclaration((IdentifierNode)id);
					    
					}
					break;
				case 17 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:63:9: ^( READ ( expression )+ )
					{
					match(input,READ,FOLLOW_READ_in_expression483); 
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:63:16: ( expression )+
					int cnt5=0;
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==AND||LA5_0==BECOMES||LA5_0==CHARACTER||LA5_0==DEVIDE||(LA5_0 >= EQ && LA5_0 <= FALSE)||(LA5_0 >= IDENTIFIER && LA5_0 <= IF)||(LA5_0 >= LCURLY && LA5_0 <= LESSEQ)||(LA5_0 >= MINUS && LA5_0 <= NEQ)||LA5_0==NUMBER||(LA5_0 >= OR && LA5_0 <= PRINT)||LA5_0==READ||LA5_0==TRUE||LA5_0==WHILE) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:63:16: expression
							{
							pushFollow(FOLLOW_expression_in_expression485);
							expression();
							state._fsp--;

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

					}
					break;
				case 18 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:64:9: ^( PRINT ( expression )+ )
					{
					match(input,PRINT,FOLLOW_PRINT_in_expression499); 
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:64:17: ( expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:64:17: expression
							{
							pushFollow(FOLLOW_expression_in_expression501);
							expression();
							state._fsp--;

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

					}
					break;
				case 19 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:65:9: ^( LCURLY ( declaration | expression )+ )
					{
					match(input,LCURLY,FOLLOW_LCURLY_in_expression515); 

					            checkerHelper.openScope();
					        
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:67:11: ( declaration | expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:67:12: declaration
							{
							pushFollow(FOLLOW_declaration_in_expression520);
							declaration();
							state._fsp--;

							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:67:26: expression
							{
							pushFollow(FOLLOW_expression_in_expression524);
							expression();
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


					            checkerHelper.closeScope();
					        
					}
					break;
				case 20 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:71:9: ^( IF expression expression ( expression )? )
					{
					match(input,IF,FOLLOW_IF_in_expression549); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression551);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression553);
					expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:71:36: ( expression )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==AND||LA8_0==BECOMES||LA8_0==CHARACTER||LA8_0==DEVIDE||(LA8_0 >= EQ && LA8_0 <= FALSE)||(LA8_0 >= IDENTIFIER && LA8_0 <= IF)||(LA8_0 >= LCURLY && LA8_0 <= LESSEQ)||(LA8_0 >= MINUS && LA8_0 <= NEQ)||LA8_0==NUMBER||(LA8_0 >= OR && LA8_0 <= PRINT)||LA8_0==READ||LA8_0==TRUE||LA8_0==WHILE) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:71:36: expression
							{
							pushFollow(FOLLOW_expression_in_expression555);
							expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 21 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:72:9: ^( WHILE expression expression )
					{
					match(input,WHILE,FOLLOW_WHILE_in_expression569); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression571);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression573);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

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
	}
	// $ANTLR end "expression"



	// $ANTLR start "operand"
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:75:1: operand : (id= IDENTIFIER |n= NUMBER | TRUE | FALSE |c= CHARACTER );
	public final void operand() throws RecognitionException {
		Node id=null;
		Node n=null;
		Node c=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:76:5: (id= IDENTIFIER |n= NUMBER | TRUE | FALSE |c= CHARACTER )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:76:9: id= IDENTIFIER
					{
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand600); 

					          checkerHelper.linkToDeclaration((IdentifierNode)id);
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:80:9: n= NUMBER
					{
					n=(Node)match(input,NUMBER,FOLLOW_NUMBER_in_operand623); 
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:81:9: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_operand634); 
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:82:9: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_operand644); 
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:83:9: c= CHARACTER
					{
					c=(Node)match(input,CHARACTER,FOLLOW_CHARACTER_in_operand656); 
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
	}
	// $ANTLR end "operand"

	// Delegated rules



	public static final BitSet FOLLOW_NOOT_in_program94 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_program97 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_expression_in_program101 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_set_in_declaration130 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration142 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration144 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention182 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention186 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention188 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_operand_in_expression224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression235 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression237 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression239 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression251 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression253 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_expression_in_expression255 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATION_in_expression268 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression270 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULTIPLY_in_expression282 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression284 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression286 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DEVIDE_in_expression298 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression300 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression302 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MODULO_in_expression314 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression316 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression318 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESSEQ_in_expression330 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression332 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression334 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MOREEQ_in_expression346 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression348 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression350 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEQ_in_expression362 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression364 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression366 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expression378 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression380 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression382 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESS_in_expression394 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression396 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression398 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MORE_in_expression410 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression412 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression414 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_expression426 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression428 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression430 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expression442 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression444 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression446 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_expression458 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression462 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression464 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_in_expression483 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression485 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_PRINT_in_expression499 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression501 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_LCURLY_in_expression515 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_expression520 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_expression_in_expression524 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_IF_in_expression549 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression551 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression553 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_expression_in_expression555 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_expression569 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression571 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression573 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_operand634 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_operand644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_operand656 = new BitSet(new long[]{0x0000000000000002L});
}
