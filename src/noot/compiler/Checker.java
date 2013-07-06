// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/compiler/Checker.g 2013-07-06 10:39:04

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


	    private CheckerHelper checkerHelper = new CheckerHelper();



	// $ANTLR start "program"
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:41:1: program : ^( NOOT ( declaration | expression )+ ) ;
	public final void program() throws RecognitionException {
		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:42:5: ( ^( NOOT ( declaration | expression )+ ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:42:9: ^( NOOT ( declaration | expression )+ )
			{
			match(input,NOOT,FOLLOW_NOOT_in_program91); 
			match(input, Token.DOWN, null); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:42:16: ( declaration | expression )+
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:42:17: declaration
					{
					pushFollow(FOLLOW_declaration_in_program94);
					declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:42:31: expression
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:45:1: declaration returns [Node node = null;] : ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER ( declaration_extention )? ) ;
	public final Node declaration() throws RecognitionException {
		Node node =  null;;


		Node d=null;
		Node id=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:46:5: ( ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER ( declaration_extention )? ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:46:9: ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER ( declaration_extention )? )
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
			id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration145); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:46:47: ( declaration_extention )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==COMMA) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:46:47: declaration_extention
					{
					pushFollow(FOLLOW_declaration_extention_in_declaration147);
					declaration_extention();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 


			            checkerHelper.declare( (DeclarationNode) d );
			            checkerHelper.linkToDeclaration( (IdentifierNode) id );
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:54:1: declaration_extention : ^(d= COMMA id= IDENTIFIER ( declaration_extention )? ) ;
	public final void declaration_extention() throws RecognitionException {
		Node d=null;
		Node id=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:55:5: ( ^(d= COMMA id= IDENTIFIER ( declaration_extention )? ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:55:9: ^(d= COMMA id= IDENTIFIER ( declaration_extention )? )
			{
			d=(Node)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention185); 
			match(input, Token.DOWN, null); 
			id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention189); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:55:33: ( declaration_extention )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==COMMA) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:55:33: declaration_extention
					{
					pushFollow(FOLLOW_declaration_extention_in_declaration_extention191);
					declaration_extention();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 


			            checkerHelper.declare( (DeclarationNode) d );
			            checkerHelper.linkToDeclaration( (IdentifierNode) id );
			        
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:62:1: expression returns [Node node = null;] : (op= operand | ^(te= PLUS e1= expression e2= expression ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION e1= expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE e1= expression e2= expression ) );
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
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:63:5: (op= operand | ^(te= PLUS e1= expression e2= expression ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION e1= expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE e1= expression e2= expression ) )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:63:9: op= operand
					{
					pushFollow(FOLLOW_operand_in_expression233);
					op=operand();
					state._fsp--;


					          node = op;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:67:9: ^(te= PLUS e1= expression e2= expression )
					{
					te=(Node)match(input,PLUS,FOLLOW_PLUS_in_expression256); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression260);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression264);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:73:9: ^(te= MINUS e1= expression (e2= expression )? )
					{
					te=(Node)match(input,MINUS,FOLLOW_MINUS_in_expression288); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression292);
					e1=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:73:36: (e2= expression )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==AND||LA4_0==BECOMES||LA4_0==CHARACTER||LA4_0==DEVIDE||(LA4_0 >= EQ && LA4_0 <= FALSE)||(LA4_0 >= IDENTIFIER && LA4_0 <= IF)||(LA4_0 >= LCURLY && LA4_0 <= LESSEQ)||(LA4_0 >= MINUS && LA4_0 <= NEQ)||LA4_0==NUMBER||(LA4_0 >= OR && LA4_0 <= PRINT)||LA4_0==READ||LA4_0==TRUE||LA4_0==WHILE) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:73:36: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression296);
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:84:9: ^(te= NEGATION e1= expression )
					{
					te=(Node)match(input,NEGATION,FOLLOW_NEGATION_in_expression321); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression325);
					e1=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
					          node = te;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:90:9: ^(te= MULTIPLY e1= expression e2= expression )
					{
					te=(Node)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression349); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression353);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression357);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 6 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:96:9: ^(te= DEVIDE e1= expression e2= expression )
					{
					te=(Node)match(input,DEVIDE,FOLLOW_DEVIDE_in_expression381); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression385);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression389);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 7 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:102:9: ^(te= MODULO e1= expression e2= expression )
					{
					te=(Node)match(input,MODULO,FOLLOW_MODULO_in_expression413); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression417);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression421);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 8 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:108:9: ^(te= LESSEQ e1= expression e2= expression )
					{
					te=(Node)match(input,LESSEQ,FOLLOW_LESSEQ_in_expression445); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression449);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression453);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 9 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:114:9: ^(te= MOREEQ e1= expression e2= expression )
					{
					te=(Node)match(input,MOREEQ,FOLLOW_MOREEQ_in_expression477); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression481);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression485);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 10 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:120:9: ^(te= NEQ e1= expression e2= expression )
					{
					te=(Node)match(input,NEQ,FOLLOW_NEQ_in_expression509); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression513);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression517);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForEqualType(expressions,te);
					          node = te;
					        
					}
					break;
				case 11 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:126:9: ^(te= EQ e1= expression e2= expression )
					{
					te=(Node)match(input,EQ,FOLLOW_EQ_in_expression541); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression545);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression549);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForEqualType(expressions,te);
					          node = te;
					        
					}
					break;
				case 12 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:132:9: ^(te= LESS e1= expression e2= expression )
					{
					te=(Node)match(input,LESS,FOLLOW_LESS_in_expression573); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression577);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression581);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 13 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:138:9: ^(te= MORE e1= expression e2= expression )
					{
					te=(Node)match(input,MORE,FOLLOW_MORE_in_expression605); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression609);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression613);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          node = te;
					        
					}
					break;
				case 14 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:144:9: ^(te= AND e1= expression e2= expression )
					{
					te=(Node)match(input,AND,FOLLOW_AND_in_expression637); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression641);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression645);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
					          node = te;
					        
					}
					break;
				case 15 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:150:9: ^(te= OR e1= expression e2= expression )
					{
					te=(Node)match(input,OR,FOLLOW_OR_in_expression669); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression673);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression677);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
					          node = te;
					        
					}
					break;
				case 16 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:156:9: ^(te= BECOMES id= IDENTIFIER e1= expression )
					{
					te=(Node)match(input,BECOMES,FOLLOW_BECOMES_in_expression701); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression705); 
					pushFollow(FOLLOW_expression_in_expression709);
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:168:9: ^(te= READ (id= IDENTIFIER )+ )
					{
					te=(Node)match(input,READ,FOLLOW_READ_in_expression734); 

					              ArrayList<IdentifierNode> identifiers = new ArrayList<IdentifierNode>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:172:11: (id= IDENTIFIER )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:172:12: id= IDENTIFIER
							{
							id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression763); 

							              checkerHelper.linkToDeclaration( (IdentifierNode) id );
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


					        
					          if(identifiers.size() == 1) // If only one argument is given let the read statement adopt its type
					            ((TypeAdoptedNode) te).setTypeDefiningChild(identifiers.get(0));
					          
					          node = te;
					        
					}
					break;
				case 18 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:185:9: ^(te= PRINT (en= expression )+ )
					{
					te=(Node)match(input,PRINT,FOLLOW_PRINT_in_expression815); 

					              ArrayList<Node> expressions = new ArrayList<Node>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:189:11: (en= expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:189:12: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression844);
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


					        
					          if(expressions.size() == 1) // If only one argument is given let the print statement adopt its type
					            ((TypeAdoptedNode) te).setTypeDefiningChild(expressions.get(0));
					            
					          for(Node argumentNode : expressions)
					          {
					            if(argumentNode.getNodeType() == Node.NodeType.VOID)
					              throw new CheckerException("Expression on line:" + argumentNode.getLine() + " is a void expression, this is not allowed as an argument of print.");
					          } 
					          
					          node = te;
					        
					}
					break;
				case 19 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:207:9: ^(te= LCURLY (dc= declaration |en= expression )+ )
					{
					te=(Node)match(input,LCURLY,FOLLOW_LCURLY_in_expression896); 

					                checkerHelper.openScope();
					                ArrayList<Node> commands = new ArrayList<Node>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:212:11: (dc= declaration |en= expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:212:12: dc= declaration
							{
							pushFollow(FOLLOW_declaration_in_expression925);
							dc=declaration();
							state._fsp--;


							              commands.add(dc);
							            
							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:216:14: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression956);
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
					        
					            checkerHelper.tryToCloseScope();
					            node = te;
					        
					}
					break;
				case 20 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:235:9: ^(te= IF e1= expression e2= expression (e3= expression )? )
					{
					te=(Node)match(input,IF,FOLLOW_IF_in_expression1008); 

					              checkerHelper.holdUpcommingScope();
					            
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1036);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1040);
					e2=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:239:41: (e3= expression )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==AND||LA8_0==BECOMES||LA8_0==CHARACTER||LA8_0==DEVIDE||(LA8_0 >= EQ && LA8_0 <= FALSE)||(LA8_0 >= IDENTIFIER && LA8_0 <= IF)||(LA8_0 >= LCURLY && LA8_0 <= LESSEQ)||(LA8_0 >= MINUS && LA8_0 <= NEQ)||LA8_0==NUMBER||(LA8_0 >= OR && LA8_0 <= PRINT)||LA8_0==READ||LA8_0==TRUE||LA8_0==WHILE) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:239:41: e3= expression
							{
							pushFollow(FOLLOW_expression_in_expression1044);
							e3=expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					          checkerHelper.releaseAndCloseScope();
					          
					          List<Node> condition = asList(e1);
					          checkerHelper.checkExpressionsForType(condition,Node.NodeType.BOOL,te);
					          
					          if(e3 != null)
					          {
					            try {
					              List<Node> nodes = asList(e2,e3);
					              checkerHelper.checkExpressionsForEqualType(nodes,te);
					            
					              // This so the if statement has the same type as both options
					              ((TypeAdoptedNode) te).setTypeDefiningChild(e2);
					            } catch (CheckerException ce) {
					              // no defining type set, so remains void
					            }
					          }
					          
					          node = te;
					        
					}
					break;
				case 21 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:261:9: ^(te= WHILE e1= expression e2= expression )
					{
					te=(Node)match(input,WHILE,FOLLOW_WHILE_in_expression1070); 

					              checkerHelper.holdUpcommingScope();
					            
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1098);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1102);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          checkerHelper.releaseAndCloseScope();
					          
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:273:1: operand returns [Node node = null;] : (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER );
	public final Node operand() throws RecognitionException {
		Node node =  null;;


		Node id=null;
		Node n=null;
		Node b=null;
		Node c=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:274:5: (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:274:9: id= IDENTIFIER
					{
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand1143); 

					          checkerHelper.linkToDeclaration( (IdentifierNode) id );
					          node = id;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:279:9: n= NUMBER
					{
					n=(Node)match(input,NUMBER,FOLLOW_NUMBER_in_operand1166); 

					          node = n;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:283:9: b= TRUE
					{
					b=(Node)match(input,TRUE,FOLLOW_TRUE_in_operand1188); 

					          node = b;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:287:9: b= FALSE
					{
					b=(Node)match(input,FALSE,FOLLOW_FALSE_in_operand1210); 

					          node = b;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:291:9: c= CHARACTER
					{
					c=(Node)match(input,CHARACTER,FOLLOW_CHARACTER_in_operand1232); 

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
	public static final BitSet FOLLOW_set_in_declaration131 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration145 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration147 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention185 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention189 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention191 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_operand_in_expression233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression256 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression260 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression264 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression288 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression292 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_expression_in_expression296 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATION_in_expression321 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression325 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULTIPLY_in_expression349 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression353 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression357 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DEVIDE_in_expression381 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression385 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression389 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MODULO_in_expression413 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression417 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression421 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESSEQ_in_expression445 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression449 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression453 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MOREEQ_in_expression477 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression481 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression485 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEQ_in_expression509 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression513 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression517 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expression541 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression545 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression549 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESS_in_expression573 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression577 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression581 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MORE_in_expression605 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression609 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression613 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_expression637 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression641 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression645 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expression669 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression673 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression677 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_expression701 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression705 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression709 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_in_expression734 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression763 = new BitSet(new long[]{0x0000000000080008L});
	public static final BitSet FOLLOW_PRINT_in_expression815 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression844 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_LCURLY_in_expression896 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_expression925 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_expression_in_expression956 = new BitSet(new long[]{0x000145D7F1FB13D8L});
	public static final BitSet FOLLOW_IF_in_expression1008 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1036 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression1040 = new BitSet(new long[]{0x000145D7F1DB1258L});
	public static final BitSet FOLLOW_expression_in_expression1044 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_expression1070 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1098 = new BitSet(new long[]{0x000145D7F1DB1250L});
	public static final BitSet FOLLOW_expression_in_expression1102 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand1143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand1166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_operand1188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_operand1210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_operand1232 = new BitSet(new long[]{0x0000000000000002L});
}
