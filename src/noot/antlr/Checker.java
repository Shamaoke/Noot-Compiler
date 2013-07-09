// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/antlr/Checker.g 2013-07-10 00:04:44

    package noot.antlr;
    import noot.ast.*;
    import static java.util.Arrays.asList;
    import noot.compiler.CheckerHelper;
    import noot.exceptions.CheckerException;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Checker extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "APOSTROPHE", "BECOMES", 
		"BOOL", "CHAR", "CHARACTER", "COMMA", "COMMENT", "CONST", "DEVIDE", "DIGIT", 
		"DO", "ELSE", "EQ", "FALSE", "FI", "IDENTIFIER", "IF", "INT", "LCURLY", 
		"LESS", "LESSEQ", "LETTER", "LOWER", "LPAREN", "MINUS", "MODULO", "MORE", 
		"MOREEQ", "MULTIPLY", "NEGATION", "NEQ", "NOOT", "NUMBER", "OD", "OR", 
		"PLUS", "PRINT", "RCURLY", "READ", "RPAREN", "SEMICOLON", "SYMBOL", "THEN", 
		"TRUE", "UPPER", "WHILE", "WS"
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
	public static final int CONST=12;
	public static final int DEVIDE=13;
	public static final int DIGIT=14;
	public static final int DO=15;
	public static final int ELSE=16;
	public static final int EQ=17;
	public static final int FALSE=18;
	public static final int FI=19;
	public static final int IDENTIFIER=20;
	public static final int IF=21;
	public static final int INT=22;
	public static final int LCURLY=23;
	public static final int LESS=24;
	public static final int LESSEQ=25;
	public static final int LETTER=26;
	public static final int LOWER=27;
	public static final int LPAREN=28;
	public static final int MINUS=29;
	public static final int MODULO=30;
	public static final int MORE=31;
	public static final int MOREEQ=32;
	public static final int MULTIPLY=33;
	public static final int NEGATION=34;
	public static final int NEQ=35;
	public static final int NOOT=36;
	public static final int NUMBER=37;
	public static final int OD=38;
	public static final int OR=39;
	public static final int PLUS=40;
	public static final int PRINT=41;
	public static final int RCURLY=42;
	public static final int READ=43;
	public static final int RPAREN=44;
	public static final int SEMICOLON=45;
	public static final int SYMBOL=46;
	public static final int THEN=47;
	public static final int TRUE=48;
	public static final int UPPER=49;
	public static final int WHILE=50;
	public static final int WS=51;

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
	@Override public String getGrammarFileName() { return "/Users/Thijs/Development/noot/src/noot/antlr/Checker.g"; }


	    private CheckerHelper ch = new CheckerHelper();



	// $ANTLR start "program"
	// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:41:1: program : ^( NOOT (dec= declaration |ex= expression )+ ) ;
	public final void program() throws RecognitionException {
		Node dec =null;
		Node ex =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:42:5: ( ^( NOOT (dec= declaration |ex= expression )+ ) )
			// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:42:9: ^( NOOT (dec= declaration |ex= expression )+ )
			{
			match(input,NOOT,FOLLOW_NOOT_in_program89); 
			match(input, Token.DOWN, null); 
			// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:42:16: (dec= declaration |ex= expression )+
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
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:42:17: dec= declaration
					{
					pushFollow(FOLLOW_declaration_in_program94);
					dec=declaration();
					state._fsp--;


					            dec.setIgnoreReturnValue(true);
					          
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:46:13: ex= expression
					{
					pushFollow(FOLLOW_expression_in_program122);
					ex=expression();
					state._fsp--;


					            ex.setIgnoreReturnValue(true);
					          
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
	// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:53:1: declaration returns [Node node = null;] : ( ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER op= operand (dex= declaration_extention )? ) | ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER (dex= declaration_extention )? ) );
	public final Node declaration() throws RecognitionException {
		Node node =  null;;


		Node d=null;
		Node id=null;
		Node op =null;
		Node dex =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:54:3: ( ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER op= operand (dex= declaration_extention )? ) | ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER (dex= declaration_extention )? ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= BOOL && LA4_0 <= CHAR)||LA4_0==INT) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==DOWN) ) {
					int LA4_2 = input.LA(3);
					if ( (LA4_2==IDENTIFIER) ) {
						int LA4_3 = input.LA(4);
						if ( (LA4_3==CHARACTER||LA4_3==FALSE||LA4_3==IDENTIFIER||LA4_3==NUMBER||LA4_3==TRUE) ) {
							alt4=1;
						}
						else if ( (LA4_3==UP||LA4_3==COMMA) ) {
							alt4=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:54:9: ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER op= operand (dex= declaration_extention )? )
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
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration188); 
					pushFollow(FOLLOW_operand_in_declaration192);
					op=operand();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:54:61: (dex= declaration_extention )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==COMMA) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:54:61: dex= declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration196);
							dex=declaration_extention();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					            ((DeclarationNode) d).setConstant(true);
					        
					            ch.declare( (DeclarationNode) d );
					            ch.linkToDeclaration( (IdentifierNode) id );
					            
					            List<Node> nodes = asList(id,op);
					            ch.checkExpressionsForEqualType(nodes,d); // Check for types for constant assignment
					            
					            node = d;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:66:9: ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER (dex= declaration_extention )? )
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
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration236); 
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:66:50: (dex= declaration_extention )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==COMMA) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:66:50: dex= declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration240);
							dex=declaration_extention();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					            ch.declare( (DeclarationNode) d );
					            ch.linkToDeclaration( (IdentifierNode) id );
					            
					            node = d;
					        
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
	// $ANTLR end "declaration"



	// $ANTLR start "declaration_extention"
	// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:75:1: declaration_extention returns [Node node = null;] : ( ^(d= COMMA id= IDENTIFIER op= operand (dex= declaration_extention )? ) | ^(d= COMMA id= IDENTIFIER (dex= declaration_extention )? ) );
	public final Node declaration_extention() throws RecognitionException {
		Node node =  null;;


		Node d=null;
		Node id=null;
		Node op =null;
		Node dex =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:76:5: ( ^(d= COMMA id= IDENTIFIER op= operand (dex= declaration_extention )? ) | ^(d= COMMA id= IDENTIFIER (dex= declaration_extention )? ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==COMMA) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==DOWN) ) {
					int LA7_2 = input.LA(3);
					if ( (LA7_2==IDENTIFIER) ) {
						int LA7_3 = input.LA(4);
						if ( (LA7_3==CHARACTER||LA7_3==FALSE||LA7_3==IDENTIFIER||LA7_3==NUMBER||LA7_3==TRUE) ) {
							alt7=1;
						}
						else if ( (LA7_3==UP||LA7_3==COMMA) ) {
							alt7=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 7, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 7, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:76:9: ^(d= COMMA id= IDENTIFIER op= operand (dex= declaration_extention )? )
					{
					d=(Node)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention281); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention285); 
					pushFollow(FOLLOW_operand_in_declaration_extention289);
					op=operand();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:76:47: (dex= declaration_extention )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==COMMA) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:76:47: dex= declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration_extention293);
							dex=declaration_extention();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					            ((DeclarationNode) d).setConstant(true);
					            
					            ch.declare( (DeclarationNode) d );
					            ch.linkToDeclaration( (IdentifierNode) id );
					            
					            List<Node> nodes = asList(id,op);
					            ch.checkExpressionsForEqualType(nodes,d);
					            
					            node = d;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:88:9: ^(d= COMMA id= IDENTIFIER (dex= declaration_extention )? )
					{
					d=(Node)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention319); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention323); 
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:88:36: (dex= declaration_extention )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==COMMA) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:88:36: dex= declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration_extention327);
							dex=declaration_extention();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					            ch.declare( (DeclarationNode) d );
					            ch.linkToDeclaration( (IdentifierNode) id );
					            
					            node = d;
					        
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
	// $ANTLR end "declaration_extention"



	// $ANTLR start "expression"
	// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:97:1: expression returns [Node node = null;] : (op= operand | ^(te= PLUS e1= expression (e2= expression )? ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION e1= expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE e1= expression e2= expression ) );
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
			// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:98:5: (op= operand | ^(te= PLUS e1= expression (e2= expression )? ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION e1= expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE e1= expression e2= expression ) )
			int alt14=21;
			switch ( input.LA(1) ) {
			case CHARACTER:
			case FALSE:
			case IDENTIFIER:
			case NUMBER:
			case TRUE:
				{
				alt14=1;
				}
				break;
			case PLUS:
				{
				alt14=2;
				}
				break;
			case MINUS:
				{
				alt14=3;
				}
				break;
			case NEGATION:
				{
				alt14=4;
				}
				break;
			case MULTIPLY:
				{
				alt14=5;
				}
				break;
			case DEVIDE:
				{
				alt14=6;
				}
				break;
			case MODULO:
				{
				alt14=7;
				}
				break;
			case LESSEQ:
				{
				alt14=8;
				}
				break;
			case MOREEQ:
				{
				alt14=9;
				}
				break;
			case NEQ:
				{
				alt14=10;
				}
				break;
			case EQ:
				{
				alt14=11;
				}
				break;
			case LESS:
				{
				alt14=12;
				}
				break;
			case MORE:
				{
				alt14=13;
				}
				break;
			case AND:
				{
				alt14=14;
				}
				break;
			case OR:
				{
				alt14=15;
				}
				break;
			case BECOMES:
				{
				alt14=16;
				}
				break;
			case READ:
				{
				alt14=17;
				}
				break;
			case PRINT:
				{
				alt14=18;
				}
				break;
			case LCURLY:
				{
				alt14=19;
				}
				break;
			case IF:
				{
				alt14=20;
				}
				break;
			case WHILE:
				{
				alt14=21;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:98:9: op= operand
					{
					pushFollow(FOLLOW_operand_in_expression370);
					op=operand();
					state._fsp--;

					 node = op; 
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:99:9: ^(te= PLUS e1= expression (e2= expression )? )
					{
					te=(Node)match(input,PLUS,FOLLOW_PLUS_in_expression385); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression389);
					e1=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:99:35: (e2= expression )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==AND||LA8_0==BECOMES||LA8_0==CHARACTER||LA8_0==DEVIDE||(LA8_0 >= EQ && LA8_0 <= FALSE)||(LA8_0 >= IDENTIFIER && LA8_0 <= IF)||(LA8_0 >= LCURLY && LA8_0 <= LESSEQ)||(LA8_0 >= MINUS && LA8_0 <= NEQ)||LA8_0==NUMBER||(LA8_0 >= OR && LA8_0 <= PRINT)||LA8_0==READ||LA8_0==TRUE||LA8_0==WHILE) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:99:35: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression393);
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
					            
					          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:111:9: ^(te= MINUS e1= expression (e2= expression )? )
					{
					te=(Node)match(input,MINUS,FOLLOW_MINUS_in_expression418); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression422);
					e1=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:111:36: (e2= expression )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==AND||LA9_0==BECOMES||LA9_0==CHARACTER||LA9_0==DEVIDE||(LA9_0 >= EQ && LA9_0 <= FALSE)||(LA9_0 >= IDENTIFIER && LA9_0 <= IF)||(LA9_0 >= LCURLY && LA9_0 <= LESSEQ)||(LA9_0 >= MINUS && LA9_0 <= NEQ)||LA9_0==NUMBER||(LA9_0 >= OR && LA9_0 <= PRINT)||LA9_0==READ||LA9_0==TRUE||LA9_0==WHILE) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:111:36: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression426);
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
					            
					          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:123:9: ^(te= NEGATION e1= expression )
					{
					te=(Node)match(input,NEGATION,FOLLOW_NEGATION_in_expression451); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression455);
					e1=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1);
					          ch.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:130:9: ^(te= MULTIPLY e1= expression e2= expression )
					{
					te=(Node)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression479); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression483);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression487);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 6 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:137:9: ^(te= DEVIDE e1= expression e2= expression )
					{
					te=(Node)match(input,DEVIDE,FOLLOW_DEVIDE_in_expression511); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression515);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression519);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 7 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:144:9: ^(te= MODULO e1= expression e2= expression )
					{
					te=(Node)match(input,MODULO,FOLLOW_MODULO_in_expression543); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression547);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression551);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 8 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:151:9: ^(te= LESSEQ e1= expression e2= expression )
					{
					te=(Node)match(input,LESSEQ,FOLLOW_LESSEQ_in_expression575); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression579);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression583);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 9 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:158:9: ^(te= MOREEQ e1= expression e2= expression )
					{
					te=(Node)match(input,MOREEQ,FOLLOW_MOREEQ_in_expression607); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression611);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression615);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 10 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:165:9: ^(te= NEQ e1= expression e2= expression )
					{
					te=(Node)match(input,NEQ,FOLLOW_NEQ_in_expression639); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression643);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression647);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          ch.checkExpressionsForEqualType(expressions,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 11 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:172:9: ^(te= EQ e1= expression e2= expression )
					{
					te=(Node)match(input,EQ,FOLLOW_EQ_in_expression671); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression675);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression679);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          ch.checkExpressionsForEqualType(expressions,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 12 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:179:9: ^(te= LESS e1= expression e2= expression )
					{
					te=(Node)match(input,LESS,FOLLOW_LESS_in_expression703); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression707);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression711);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 13 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:186:9: ^(te= MORE e1= expression e2= expression )
					{
					te=(Node)match(input,MORE,FOLLOW_MORE_in_expression735); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression739);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression743);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          ch.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 14 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:193:9: ^(te= AND e1= expression e2= expression )
					{
					te=(Node)match(input,AND,FOLLOW_AND_in_expression767); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression771);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression775);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          ch.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 15 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:200:9: ^(te= OR e1= expression e2= expression )
					{
					te=(Node)match(input,OR,FOLLOW_OR_in_expression799); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression803);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression807);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          ch.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 16 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:207:9: ^(te= BECOMES id= IDENTIFIER e1= expression )
					{
					te=(Node)match(input,BECOMES,FOLLOW_BECOMES_in_expression831); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression835); 
					pushFollow(FOLLOW_expression_in_expression839);
					e1=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          ch.linkToDeclaration( (IdentifierNode) id );
					          
					          if(((IdentifierNode) id).getDeclarationNode().isConstant())
					              throw new CheckerException(te,"Trying to reassign constant, this is not allowed.");
					          
					          List<Node> nodes = asList(id,e1);
					          ch.checkExpressionsForEqualType(nodes,te);
					          
					          // This so the chaining of BECOME rules will occure with the correct type checking
					          ((TypeAdoptedNode) te).setTypeDefiningChild(e1);
					          
					          node = te;
					        
					}
					break;
				case 17 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:222:9: ^(te= READ (id= IDENTIFIER )+ )
					{
					te=(Node)match(input,READ,FOLLOW_READ_in_expression864); 

					              ArrayList<IdentifierNode> identifiers = new ArrayList<IdentifierNode>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:226:11: (id= IDENTIFIER )+
					int cnt10=0;
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==IDENTIFIER) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:226:12: id= IDENTIFIER
							{
							id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression894); 

							              ch.linkToDeclaration( (IdentifierNode) id );
							              identifiers.add( (IdentifierNode) id );
							              
							              if(((IdentifierNode) id).getDeclarationNode().isConstant())
							                throw new CheckerException(te,"Trying to read constant, this is not allowed.");
							            
							}
							break;

						default :
							if ( cnt10 >= 1 ) break loop10;
							EarlyExitException eee = new EarlyExitException(10, input);
							throw eee;
						}
						cnt10++;
					}

					match(input, Token.UP, null); 


					          if(identifiers.size() == 1) // If only one argument is given let the read statement adopt its type
					            ((TypeAdoptedNode) te).setTypeDefiningChild(identifiers.get(0));
					          
					          node = te;
					        
					}
					break;
				case 18 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:241:9: ^(te= PRINT (en= expression )+ )
					{
					te=(Node)match(input,PRINT,FOLLOW_PRINT_in_expression946); 

					              ArrayList<Node> expressions = new ArrayList<Node>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:245:11: (en= expression )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==AND||LA11_0==BECOMES||LA11_0==CHARACTER||LA11_0==DEVIDE||(LA11_0 >= EQ && LA11_0 <= FALSE)||(LA11_0 >= IDENTIFIER && LA11_0 <= IF)||(LA11_0 >= LCURLY && LA11_0 <= LESSEQ)||(LA11_0 >= MINUS && LA11_0 <= NEQ)||LA11_0==NUMBER||(LA11_0 >= OR && LA11_0 <= PRINT)||LA11_0==READ||LA11_0==TRUE||LA11_0==WHILE) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:245:12: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression976);
							en=expression();
							state._fsp--;


							              expressions.add(en);
							            
							}
							break;

						default :
							if ( cnt11 >= 1 ) break loop11;
							EarlyExitException eee = new EarlyExitException(11, input);
							throw eee;
						}
						cnt11++;
					}

					match(input, Token.UP, null); 


					          if(expressions.size() == 1) // If only one argument is given let the print statement adopt its type
					            ((TypeAdoptedNode) te).setTypeDefiningChild(expressions.get(0));
					          
					          for(Node argumentNode : expressions) // None of the arguments may be a void expression
					          {
					            if(argumentNode.getNodeType() == Node.NodeType.VOID)
					              throw new CheckerException(argumentNode,"Print argument is a void expression, this is not allowed.");
					          } 
					          
					          node = te;
					        
					}
					break;
				case 19 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:262:9: ^(te= LCURLY (dc= declaration |en= expression )+ )
					{
					te=(Node)match(input,LCURLY,FOLLOW_LCURLY_in_expression1027); 

					                ch.openScope();
					                ArrayList<Node> commands = new ArrayList<Node>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:267:11: (dc= declaration |en= expression )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=3;
						int LA12_0 = input.LA(1);
						if ( ((LA12_0 >= BOOL && LA12_0 <= CHAR)||LA12_0==INT) ) {
							alt12=1;
						}
						else if ( (LA12_0==AND||LA12_0==BECOMES||LA12_0==CHARACTER||LA12_0==DEVIDE||(LA12_0 >= EQ && LA12_0 <= FALSE)||(LA12_0 >= IDENTIFIER && LA12_0 <= IF)||(LA12_0 >= LCURLY && LA12_0 <= LESSEQ)||(LA12_0 >= MINUS && LA12_0 <= NEQ)||LA12_0==NUMBER||(LA12_0 >= OR && LA12_0 <= PRINT)||LA12_0==READ||LA12_0==TRUE||LA12_0==WHILE) ) {
							alt12=2;
						}

						switch (alt12) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:267:12: dc= declaration
							{
							pushFollow(FOLLOW_declaration_in_expression1057);
							dc=declaration();
							state._fsp--;


							              commands.add(dc);
							            
							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:271:14: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression1088);
							en=expression();
							state._fsp--;


							              commands.add(en);
							            
							}
							break;

						default :
							if ( cnt12 >= 1 ) break loop12;
							EarlyExitException eee = new EarlyExitException(12, input);
							throw eee;
						}
						cnt12++;
					}

					match(input, Token.UP, null); 


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
					break;
				case 20 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:297:9: ^(te= IF e1= expression e2= expression (e3= expression )? )
					{
					te=(Node)match(input,IF,FOLLOW_IF_in_expression1140); 

					              ch.holdUpcomingScope();
					            
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1170);
					e1=expression();
					state._fsp--;


					              boolean scopeReleased = ch.releaseUpcomingScope();
					              
					              List<Node> condition = asList(e1);
					              ch.checkExpressionsForType(condition,Node.NodeType.BOOL,te);
					            
					pushFollow(FOLLOW_expression_in_expression1198);
					e2=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:308:27: (e3= expression )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==AND||LA13_0==BECOMES||LA13_0==CHARACTER||LA13_0==DEVIDE||(LA13_0 >= EQ && LA13_0 <= FALSE)||(LA13_0 >= IDENTIFIER && LA13_0 <= IF)||(LA13_0 >= LCURLY && LA13_0 <= LESSEQ)||(LA13_0 >= MINUS && LA13_0 <= NEQ)||LA13_0==NUMBER||(LA13_0 >= OR && LA13_0 <= PRINT)||LA13_0==READ||LA13_0==TRUE||LA13_0==WHILE) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:308:27: e3= expression
							{
							pushFollow(FOLLOW_expression_in_expression1202);
							e3=expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


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
					break;
				case 21 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:337:9: ^(te= WHILE e1= expression e2= expression )
					{
					te=(Node)match(input,WHILE,FOLLOW_WHILE_in_expression1227); 

					              ch.holdUpcomingScope();
					            
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1256);
					e1=expression();
					state._fsp--;


					              boolean scopeReleased = ch.releaseUpcomingScope();
					              
					              List<Node> condition = asList(e1);
					              ch.checkExpressionsForType(condition,Node.NodeType.BOOL,te);
					            
					pushFollow(FOLLOW_expression_in_expression1284);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!scopeReleased) ch.releaseAndCloseScope();
					          
					          e2.setIgnoreReturnValue(true);
					          
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
	// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:358:1: operand returns [Node node = null;] : (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER );
	public final Node operand() throws RecognitionException {
		Node node =  null;;


		Node id=null;
		Node n=null;
		Node b=null;
		Node c=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:359:5: (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER )
			int alt15=5;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				alt15=1;
				}
				break;
			case NUMBER:
				{
				alt15=2;
				}
				break;
			case TRUE:
				{
				alt15=3;
				}
				break;
			case FALSE:
				{
				alt15=4;
				}
				break;
			case CHARACTER:
				{
				alt15=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:359:9: id= IDENTIFIER
					{
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand1325); 

					          ch.linkToDeclaration( (IdentifierNode) id );
					          node = id;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:364:9: n= NUMBER
					{
					n=(Node)match(input,NUMBER,FOLLOW_NUMBER_in_operand1348); 
					 node = n; 
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:365:9: b= TRUE
					{
					b=(Node)match(input,TRUE,FOLLOW_TRUE_in_operand1362); 
					 node = b; 
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:366:9: b= FALSE
					{
					b=(Node)match(input,FALSE,FOLLOW_FALSE_in_operand1376); 
					 node = b; 
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/antlr/Checker.g:367:9: c= CHARACTER
					{
					c=(Node)match(input,CHARACTER,FOLLOW_CHARACTER_in_operand1390); 
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



	public static final BitSet FOLLOW_NOOT_in_program89 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_program94 = new BitSet(new long[]{0x00050BAFE3F623D8L});
	public static final BitSet FOLLOW_expression_in_program122 = new BitSet(new long[]{0x00050BAFE3F623D8L});
	public static final BitSet FOLLOW_set_in_declaration174 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration188 = new BitSet(new long[]{0x0001002000140200L});
	public static final BitSet FOLLOW_operand_in_declaration192 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration196 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_declaration222 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration236 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration240 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention281 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention285 = new BitSet(new long[]{0x0001002000140200L});
	public static final BitSet FOLLOW_operand_in_declaration_extention289 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention293 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention319 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention323 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention327 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_operand_in_expression370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression385 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression389 = new BitSet(new long[]{0x00050BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression393 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression418 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression422 = new BitSet(new long[]{0x00050BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression426 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATION_in_expression451 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression455 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULTIPLY_in_expression479 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression483 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression487 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DEVIDE_in_expression511 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression515 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression519 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MODULO_in_expression543 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression547 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression551 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESSEQ_in_expression575 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression579 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression583 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MOREEQ_in_expression607 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression611 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression615 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEQ_in_expression639 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression643 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression647 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expression671 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression675 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression679 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESS_in_expression703 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression707 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression711 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MORE_in_expression735 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression739 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression743 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_expression767 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression771 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression775 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expression799 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression803 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression807 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_expression831 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression835 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression839 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_in_expression864 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression894 = new BitSet(new long[]{0x0000000000100008L});
	public static final BitSet FOLLOW_PRINT_in_expression946 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression976 = new BitSet(new long[]{0x00050BAFE3B62258L});
	public static final BitSet FOLLOW_LCURLY_in_expression1027 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_expression1057 = new BitSet(new long[]{0x00050BAFE3F623D8L});
	public static final BitSet FOLLOW_expression_in_expression1088 = new BitSet(new long[]{0x00050BAFE3F623D8L});
	public static final BitSet FOLLOW_IF_in_expression1140 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1170 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression1198 = new BitSet(new long[]{0x00050BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression1202 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_expression1227 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1256 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression1284 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand1325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand1348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_operand1362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_operand1376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_operand1390 = new BitSet(new long[]{0x0000000000000002L});
}
