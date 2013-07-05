// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/compiler/Checker.g 2013-07-05 13:25:59

    package noot.compiler;
    import noot.ast.*;
    import static java.util.Arrays.asList;


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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:26:1: program : ^( NOOT ( declaration | expression )+ ) ;
	public final void program() throws RecognitionException {
		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:27:5: ( ^( NOOT ( declaration | expression )+ ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:27:9: ^( NOOT ( declaration | expression )+ )
			{
			match(input,NOOT,FOLLOW_NOOT_in_program88); 
			match(input, Token.DOWN, null); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:27:16: ( declaration | expression )+
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:27:17: declaration
					{
					pushFollow(FOLLOW_declaration_in_program91);
					declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:27:31: expression
					{
					pushFollow(FOLLOW_expression_in_program95);
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:30:1: declaration returns [Node node = null;] : ^(d= ( INT | BOOL | CHAR ) IDENTIFIER ( declaration_extention )? ) ;
	public final Node declaration() throws RecognitionException {
		Node node =  null;;


		Node d=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:31:5: ( ^(d= ( INT | BOOL | CHAR ) IDENTIFIER ( declaration_extention )? ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:31:9: ^(d= ( INT | BOOL | CHAR ) IDENTIFIER ( declaration_extention )? )
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
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration140); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:31:44: ( declaration_extention )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==COMMA) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:31:44: declaration_extention
					{
					pushFollow(FOLLOW_declaration_extention_in_declaration142);
					declaration_extention();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 


			            checkerHelper.declare( (DeclarationNode) d );
			            node = d;
			        
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:38:1: declaration_extention : ^(d= COMMA IDENTIFIER ( declaration_extention )? ) ;
	public final void declaration_extention() throws RecognitionException {
		Node d=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:39:5: ( ^(d= COMMA IDENTIFIER ( declaration_extention )? ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:39:9: ^(d= COMMA IDENTIFIER ( declaration_extention )? )
			{
			d=(Node)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention180); 
			match(input, Token.DOWN, null); 
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention182); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:39:30: ( declaration_extention )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==COMMA) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:39:30: declaration_extention
					{
					pushFollow(FOLLOW_declaration_extention_in_declaration_extention184);
					declaration_extention();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 


			            checkerHelper.declare( (DeclarationNode) d );
			        
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:45:1: expression returns [Node node = null;] : (op= operand | ^(te= PLUS e1= expression e2= expression ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION e1= expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ ( expression )+ ) | ^(te= PRINT ( expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE e1= expression e2= expression ) );
	public final Node expression() throws RecognitionException {
		Node node =  null;;


		Node te=null;
		Node id=null;
		Node op =null;
		Node e1 =null;
		Node e2 =null;
		Node dc =null;
		Node en =null;
		Node e3 =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:46:5: (op= operand | ^(te= PLUS e1= expression e2= expression ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION e1= expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ ( expression )+ ) | ^(te= PRINT ( expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE e1= expression e2= expression ) )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:46:9: op= operand
					{
					pushFollow(FOLLOW_operand_in_expression226);
					op=operand();
					state._fsp--;


					          node = op;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:50:9: ^(te= PLUS e1= expression e2= expression )
					{
					te=(Node)match(input,PLUS,FOLLOW_PLUS_in_expression249); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression253);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression257);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:56:9: ^(te= MINUS e1= expression (e2= expression )? )
					{
					te=(Node)match(input,MINUS,FOLLOW_MINUS_in_expression281); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression285);
					e1=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:56:36: (e2= expression )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==AND||LA4_0==BECOMES||LA4_0==CHARACTER||LA4_0==DEVIDE||(LA4_0 >= EQ && LA4_0 <= FALSE)||(LA4_0 >= IDENTIFIER && LA4_0 <= IF)||(LA4_0 >= LCURLY && LA4_0 <= LESSEQ)||(LA4_0 >= MINUS && LA4_0 <= NEQ)||LA4_0==NUMBER||(LA4_0 >= OR && LA4_0 <= PRINT)||LA4_0==READ||LA4_0==TRUE||LA4_0==WHILE) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:56:36: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression289);
							e2=expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					          List<Node> expressions;
					          if(e2 != null)
					            expressions = asList(e1,e2);
					          else
					            expressions = asList(e1);
					            
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:67:9: ^(te= NEGATION e1= expression )
					{
					te=(Node)match(input,NEGATION,FOLLOW_NEGATION_in_expression314); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression318);
					e1=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
					          node = te;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:73:9: ^(te= MULTIPLY e1= expression e2= expression )
					{
					te=(Node)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression342); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression346);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression350);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 6 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:79:9: ^(te= DEVIDE e1= expression e2= expression )
					{
					te=(Node)match(input,DEVIDE,FOLLOW_DEVIDE_in_expression374); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression378);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression382);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 7 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:85:9: ^(te= MODULO e1= expression e2= expression )
					{
					te=(Node)match(input,MODULO,FOLLOW_MODULO_in_expression406); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression410);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression414);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 8 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:91:9: ^(te= LESSEQ e1= expression e2= expression )
					{
					te=(Node)match(input,LESSEQ,FOLLOW_LESSEQ_in_expression438); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression442);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression446);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 9 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:97:9: ^(te= MOREEQ e1= expression e2= expression )
					{
					te=(Node)match(input,MOREEQ,FOLLOW_MOREEQ_in_expression470); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression474);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression478);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 10 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:103:9: ^(te= NEQ e1= expression e2= expression )
					{
					te=(Node)match(input,NEQ,FOLLOW_NEQ_in_expression502); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression506);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression510);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForEqualType(expressions,te);
					          node = te;
					        
					}
					break;
				case 11 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:109:9: ^(te= EQ e1= expression e2= expression )
					{
					te=(Node)match(input,EQ,FOLLOW_EQ_in_expression534); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression538);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression542);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForEqualType(expressions,te);
					          node = te;
					        
					}
					break;
				case 12 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:115:9: ^(te= LESS e1= expression e2= expression )
					{
					te=(Node)match(input,LESS,FOLLOW_LESS_in_expression566); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression570);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression574);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 13 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:121:9: ^(te= MORE e1= expression e2= expression )
					{
					te=(Node)match(input,MORE,FOLLOW_MORE_in_expression598); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression602);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression606);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 14 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:127:9: ^(te= AND e1= expression e2= expression )
					{
					te=(Node)match(input,AND,FOLLOW_AND_in_expression630); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression634);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression638);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
					          node = te;
					        
					}
					break;
				case 15 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:133:9: ^(te= OR e1= expression e2= expression )
					{
					te=(Node)match(input,OR,FOLLOW_OR_in_expression662); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression666);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression670);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
					          node = te;
					        
					}
					break;
				case 16 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:139:9: ^(te= BECOMES id= IDENTIFIER e1= expression )
					{
					te=(Node)match(input,BECOMES,FOLLOW_BECOMES_in_expression694); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression698); 
					pushFollow(FOLLOW_expression_in_expression702);
					e1=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          checkerHelper.linkToDeclaration( (IdentifierNode) id );
					          
					          List<Node> nodes = asList(id,e1);
					          checkerHelper.checkExpressionsForEqualType(nodes,te);
					          
					          // This so the chaining of BECOME rules will occure with the correct type checking
					          ((TypeAdoptedNode) te).setTypeDefiningChild(e1);
					          
					          node = te;
					        
					}
					break;
				case 17 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:151:9: ^(te= READ ( expression )+ )
					{
					te=(Node)match(input,READ,FOLLOW_READ_in_expression727); 
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:151:19: ( expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:151:19: expression
							{
							pushFollow(FOLLOW_expression_in_expression729);
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


					          node = te;
					        
					}
					break;
				case 18 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:155:9: ^(te= PRINT ( expression )+ )
					{
					te=(Node)match(input,PRINT,FOLLOW_PRINT_in_expression755); 
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:155:20: ( expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:155:20: expression
							{
							pushFollow(FOLLOW_expression_in_expression757);
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


					          node = te;
					        
					}
					break;
				case 19 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:159:9: ^(te= LCURLY (dc= declaration |en= expression )+ )
					{
					te=(Node)match(input,LCURLY,FOLLOW_LCURLY_in_expression783); 

					                checkerHelper.openScope();
					                ArrayList<Node> commands = new ArrayList<Node>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:164:11: (dc= declaration |en= expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:164:12: dc= declaration
							{
							pushFollow(FOLLOW_declaration_in_expression812);
							dc=declaration();
							state._fsp--;


							              commands.add(dc);
							            
							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:168:14: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression843);
							en=expression();
							state._fsp--;


							              commands.add(en);
							            
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


					            if(commands.size() > 0)
					            {
					              Node lastCommand = commands.get(commands.size() - 1);
					              
					              if(lastCommand instanceof DeclarationNode)
					                throw new CheckerException("Command on line:" + lastCommand.getLine() + " is a declaration, this is not allowed, the last command in a compound expression needs to be a statement.");
					              
					              ((TypeAdoptedNode) te).setTypeDefiningChild(lastCommand);
					            }
					        
					            checkerHelper.closeScope();
					            node = te;
					        
					}
					break;
				case 20 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:187:9: ^(te= IF e1= expression e2= expression (e3= expression )? )
					{
					te=(Node)match(input,IF,FOLLOW_IF_in_expression895); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression899);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression903);
					e2=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:187:47: (e3= expression )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==AND||LA8_0==BECOMES||LA8_0==CHARACTER||LA8_0==DEVIDE||(LA8_0 >= EQ && LA8_0 <= FALSE)||(LA8_0 >= IDENTIFIER && LA8_0 <= IF)||(LA8_0 >= LCURLY && LA8_0 <= LESSEQ)||(LA8_0 >= MINUS && LA8_0 <= NEQ)||LA8_0==NUMBER||(LA8_0 >= OR && LA8_0 <= PRINT)||LA8_0==READ||LA8_0==TRUE||LA8_0==WHILE) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:187:47: e3= expression
							{
							pushFollow(FOLLOW_expression_in_expression907);
							e3=expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					        
					          if(e3 != null)
					          {
					            List<Node> nodes = asList(e2,e3);
					            checkerHelper.checkExpressionsForEqualType(nodes,te);
					          }
					          
					          // This so the chaining of IF rules will occure with the correct type checking
					          ((TypeAdoptedNode) te).setTypeDefiningChild(e2);
					          
					          node = te;
					        
					}
					break;
				case 21 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:201:9: ^(te= WHILE e1= expression e2= expression )
					{
					te=(Node)match(input,WHILE,FOLLOW_WHILE_in_expression933); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression937);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression941);
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:207:1: operand returns [Node node = null;] : (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER );
	public final Node operand() throws RecognitionException {
		Node node =  null;;


		Node id=null;
		Node n=null;
		Node b=null;
		Node c=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:208:5: (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:208:9: id= IDENTIFIER
					{
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand982); 

					          checkerHelper.linkToDeclaration( (IdentifierNode) id );
					          node = id;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:213:9: n= NUMBER
					{
					n=(Node)match(input,NUMBER,FOLLOW_NUMBER_in_operand1005); 

					          node = n;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:217:9: b= TRUE
					{
					b=(Node)match(input,TRUE,FOLLOW_TRUE_in_operand1027); 

					          node = b;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:221:9: b= FALSE
					{
					b=(Node)match(input,FALSE,FOLLOW_FALSE_in_operand1049); 

					          node = b;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:225:9: c= CHARACTER
					{
					c=(Node)match(input,CHARACTER,FOLLOW_CHARACTER_in_operand1071); 

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



	public static final BitSet FOLLOW_NOOT_in_program88 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_program91 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_expression_in_program95 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_set_in_declaration128 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration140 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration142 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention180 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention182 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention184 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_operand_in_expression226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression249 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression253 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression257 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression281 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression285 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_expression_in_expression289 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATION_in_expression314 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression318 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULTIPLY_in_expression342 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression346 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression350 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DEVIDE_in_expression374 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression378 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression382 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MODULO_in_expression406 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression410 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression414 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESSEQ_in_expression438 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression442 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression446 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MOREEQ_in_expression470 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression474 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression478 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEQ_in_expression502 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression506 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression510 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expression534 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression538 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression542 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESS_in_expression566 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression570 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression574 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MORE_in_expression598 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression602 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression606 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_expression630 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression634 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression638 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expression662 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression666 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression670 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_expression694 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression698 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression702 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_in_expression727 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression729 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_PRINT_in_expression755 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression757 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_LCURLY_in_expression783 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_expression812 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_expression_in_expression843 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_IF_in_expression895 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression899 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression903 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_expression_in_expression907 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_expression933 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression937 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression941 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand982 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand1005 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_operand1027 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_operand1049 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_operand1071 = new BitSet(new long[]{0x0000000000000002L});
}
