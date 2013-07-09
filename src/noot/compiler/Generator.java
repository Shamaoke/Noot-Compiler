// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/compiler/Generator.g 2013-07-09 21:42:55

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
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:41:1: program : ^( NOOT ( declaration | expression )+ ) ;
	public final void program() throws RecognitionException {
		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:42:5: ( ^( NOOT ( declaration | expression )+ ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:42:9: ^( NOOT ( declaration | expression )+ )
			{
			match(input,NOOT,FOLLOW_NOOT_in_program89); 
			match(input, Token.DOWN, null); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:42:16: ( declaration | expression )+
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:42:17: declaration
					{
					pushFollow(FOLLOW_declaration_in_program92);
					declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:42:31: expression
					{
					pushFollow(FOLLOW_expression_in_program96);
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:48:1: declaration : ( ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER op= operand ( declaration_extention )? ) | ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER ( declaration_extention )? ) );
	public final void declaration() throws RecognitionException {
		Node de=null;
		Node id=null;
		Node op =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:49:5: ( ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER op= operand ( declaration_extention )? ) | ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER ( declaration_extention )? ) )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:49:9: ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER op= operand ( declaration_extention )? )
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
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration149); 

					              gh.declare( (DeclarationNode)de );
					            
					pushFollow(FOLLOW_operand_in_declaration178);
					op=operand();
					state._fsp--;


					              gh.currentBlock().push(new Instruction("STORE",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Assigning constant "+id.getText()));
					            
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:57:11: ( declaration_extention )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==COMMA) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:57:11: declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration204);
							declaration_extention();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:58:9: ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER ( declaration_extention )? )
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
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration233); 

					              gh.declare( (DeclarationNode)de );
					            
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:62:11: ( declaration_extention )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==COMMA) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:62:11: declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration260);
							declaration_extention();
							state._fsp--;

							}
							break;

					}

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
	// $ANTLR end "declaration"



	// $ANTLR start "declaration_extention"
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:65:1: declaration_extention : ( ^(de= COMMA id= IDENTIFIER op= operand ( declaration_extention )? ) | ^(de= COMMA id= IDENTIFIER ( declaration_extention )? ) );
	public final void declaration_extention() throws RecognitionException {
		Node de=null;
		Node id=null;
		Node op =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:66:5: ( ^(de= COMMA id= IDENTIFIER op= operand ( declaration_extention )? ) | ^(de= COMMA id= IDENTIFIER ( declaration_extention )? ) )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:66:9: ^(de= COMMA id= IDENTIFIER op= operand ( declaration_extention )? )
					{
					de=(Node)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention288); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention292); 

					              gh.declare( (DeclarationNode)de );
					            
					pushFollow(FOLLOW_operand_in_declaration_extention321);
					op=operand();
					state._fsp--;


					              gh.currentBlock().push(new Instruction("STORE",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Assigning constant "+id.getText()));
					            
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:74:11: ( declaration_extention )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==COMMA) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:74:11: declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration_extention347);
							declaration_extention();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:75:9: ^(de= COMMA id= IDENTIFIER ( declaration_extention )? )
					{
					de=(Node)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention362); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention366); 

					              gh.declare( (DeclarationNode)de );
					            
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:79:12: ( declaration_extention )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==COMMA) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:79:12: declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration_extention394);
							declaration_extention();
							state._fsp--;

							}
							break;

					}

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
	// $ANTLR end "declaration_extention"



	// $ANTLR start "expression"
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:82:1: expression returns [Node node = null;] : (op= operand | ^(te= PLUS expression (e2= expression )? ) | ^(te= MINUS expression (e2= expression )? ) | ^(te= NEGATION expression ) | ^(te= MULTIPLY expression expression ) | ^(te= DEVIDE expression expression ) | ^(te= MODULO expression expression ) | ^(te= LESSEQ expression expression ) | ^(te= MOREEQ expression expression ) | ^(te= NEQ expression expression ) | ^(te= EQ expression expression ) | ^(te= LESS expression expression ) | ^(te= MORE expression expression ) | ^(te= AND expression expression ) | ^(te= OR expression expression ) | ^(te= BECOMES id= IDENTIFIER expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY ( declaration | expression )+ ) | ^(te= IF expression expression ( expression )? ) | ^(te= WHILE expression expression ) );
	public final Node expression() throws RecognitionException {
		Node node =  null;;


		Node te=null;
		Node id=null;
		Node op =null;
		Node e2 =null;
		Node en =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:83:5: (op= operand | ^(te= PLUS expression (e2= expression )? ) | ^(te= MINUS expression (e2= expression )? ) | ^(te= NEGATION expression ) | ^(te= MULTIPLY expression expression ) | ^(te= DEVIDE expression expression ) | ^(te= MODULO expression expression ) | ^(te= LESSEQ expression expression ) | ^(te= MOREEQ expression expression ) | ^(te= NEQ expression expression ) | ^(te= EQ expression expression ) | ^(te= LESS expression expression ) | ^(te= MORE expression expression ) | ^(te= AND expression expression ) | ^(te= OR expression expression ) | ^(te= BECOMES id= IDENTIFIER expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY ( declaration | expression )+ ) | ^(te= IF expression expression ( expression )? ) | ^(te= WHILE expression expression ) )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:83:9: op= operand
					{
					pushFollow(FOLLOW_operand_in_expression428);
					op=operand();
					state._fsp--;

					 node = op; 
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:84:9: ^(te= PLUS expression (e2= expression )? )
					{
					te=(Node)match(input,PLUS,FOLLOW_PLUS_in_expression443); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression445);
					expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:84:32: (e2= expression )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==AND||LA8_0==BECOMES||LA8_0==CHARACTER||LA8_0==DEVIDE||(LA8_0 >= EQ && LA8_0 <= FALSE)||(LA8_0 >= IDENTIFIER && LA8_0 <= IF)||(LA8_0 >= LCURLY && LA8_0 <= LESSEQ)||(LA8_0 >= MINUS && LA8_0 <= NEQ)||LA8_0==NUMBER||(LA8_0 >= OR && LA8_0 <= PRINT)||LA8_0==READ||LA8_0==TRUE||LA8_0==WHILE) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:84:32: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression449);
							e2=expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					 
					          if(!te.shouldIgnoreReturnValue())
					          {
					            if(e2 != null)
					              gh.currentBlock().push(new Instruction("CALL","add","Adition"));
					          }  
					          node = te;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:93:9: ^(te= MINUS expression (e2= expression )? )
					{
					te=(Node)match(input,MINUS,FOLLOW_MINUS_in_expression474); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression476);
					expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:93:33: (e2= expression )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==AND||LA9_0==BECOMES||LA9_0==CHARACTER||LA9_0==DEVIDE||(LA9_0 >= EQ && LA9_0 <= FALSE)||(LA9_0 >= IDENTIFIER && LA9_0 <= IF)||(LA9_0 >= LCURLY && LA9_0 <= LESSEQ)||(LA9_0 >= MINUS && LA9_0 <= NEQ)||LA9_0==NUMBER||(LA9_0 >= OR && LA9_0 <= PRINT)||LA9_0==READ||LA9_0==TRUE||LA9_0==WHILE) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:93:33: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression480);
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:104:9: ^(te= NEGATION expression )
					{
					te=(Node)match(input,NEGATION,FOLLOW_NEGATION_in_expression505); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression507);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","not","Boolean negation"));
					          node = te;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:109:9: ^(te= MULTIPLY expression expression )
					{
					te=(Node)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression531); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression533);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression535);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","mult","Multiplication"));
					          node = te;
					        
					}
					break;
				case 6 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:114:9: ^(te= DEVIDE expression expression )
					{
					te=(Node)match(input,DEVIDE,FOLLOW_DEVIDE_in_expression559); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression561);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression563);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","div","Devide"));
					          node = te;
					        
					}
					break;
				case 7 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:119:9: ^(te= MODULO expression expression )
					{
					te=(Node)match(input,MODULO,FOLLOW_MODULO_in_expression587); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression589);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression591);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","mod","Modulo"));
					          node = te;
					        
					}
					break;
				case 8 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:124:9: ^(te= LESSEQ expression expression )
					{
					te=(Node)match(input,LESSEQ,FOLLOW_LESSEQ_in_expression615); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression617);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression619);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","le","Less than or equal"));
					          node = te;
					        
					}
					break;
				case 9 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:129:9: ^(te= MOREEQ expression expression )
					{
					te=(Node)match(input,MOREEQ,FOLLOW_MOREEQ_in_expression643); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression645);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression647);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","ge","Greater than or equal"));
					          node = te;
					        
					}
					break;
				case 10 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:134:9: ^(te= NEQ expression expression )
					{
					te=(Node)match(input,NEQ,FOLLOW_NEQ_in_expression671); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression673);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression675);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1"));
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","ne","Not equal"));
					          node = te;
					        
					}
					break;
				case 11 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:140:9: ^(te= EQ expression expression )
					{
					te=(Node)match(input,EQ,FOLLOW_EQ_in_expression699); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression701);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression703);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1" ));
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","eq"));
					          node = te;
					        
					}
					break;
				case 12 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:146:9: ^(te= LESS expression expression )
					{
					te=(Node)match(input,LESS,FOLLOW_LESS_in_expression727); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression729);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression731);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","lt","Less than"));
					          node = te;
					        
					}
					break;
				case 13 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:151:9: ^(te= MORE expression expression )
					{
					te=(Node)match(input,MORE,FOLLOW_MORE_in_expression755); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression757);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression759);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","gt","Greater than"));
					          node = te;
					        
					}
					break;
				case 14 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:156:9: ^(te= AND expression expression )
					{
					te=(Node)match(input,AND,FOLLOW_AND_in_expression783); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression785);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression787);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","and"));
					          node = te;
					        
					}
					break;
				case 15 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:161:9: ^(te= OR expression expression )
					{
					te=(Node)match(input,OR,FOLLOW_OR_in_expression811); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression813);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression815);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","or"));
					          node = te;
					        
					}
					break;
				case 16 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:166:9: ^(te= BECOMES id= IDENTIFIER expression )
					{
					te=(Node)match(input,BECOMES,FOLLOW_BECOMES_in_expression839); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression843); 
					pushFollow(FOLLOW_expression_in_expression845);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          gh.currentBlock().push(new Instruction("STORE",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Assigning "+id.getText()));
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()+" for next expression"));
					          node = te;
					        
					}
					break;
				case 17 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:172:9: ^(te= READ (id= IDENTIFIER )+ )
					{
					te=(Node)match(input,READ,FOLLOW_READ_in_expression870); 
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:172:19: (id= IDENTIFIER )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:172:20: id= IDENTIFIER
							{
							id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression875); 

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
							                gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()+" for next expression"));
							            
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

					 node = te; 
					}
					break;
				case 18 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:196:9: ^(te= PRINT (en= expression )+ )
					{
					te=(Node)match(input,PRINT,FOLLOW_PRINT_in_expression919); 

					              MemoryLocation temp = null;
					              if(te.getChildren().size() == 1 && !te.shouldIgnoreReturnValue()) temp = gh.allocHelperRegister();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:201:11: (en= expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:201:12: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression949);
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
							              }
							            
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

					 node = te; 
					}
					break;
				case 19 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:244:9: ^(te= LCURLY ( declaration | expression )+ )
					{
					te=(Node)match(input,LCURLY,FOLLOW_LCURLY_in_expression992); 
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:244:21: ( declaration | expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:244:22: declaration
							{
							pushFollow(FOLLOW_declaration_in_expression995);
							declaration();
							state._fsp--;

							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:244:36: expression
							{
							pushFollow(FOLLOW_expression_in_expression999);
							expression();
							state._fsp--;

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

					 node = te; 
					}
					break;
				case 20 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:245:9: ^(te= IF expression expression ( expression )? )
					{
					te=(Node)match(input,IF,FOLLOW_IF_in_expression1018); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1020);
					expression();
					state._fsp--;


					              Instruction jumpIfInstruction = new Instruction("JUMPIF","notset",0,"If (jump to else)");
					              gh.currentBlock().push(jumpIfInstruction);
					            
					pushFollow(FOLLOW_expression_in_expression1047);
					expression();
					state._fsp--;


					                Instruction jumpInstruction = new Instruction("JUMP","notset","Else (jump over else)");
					                
					                if(te.getChildren().size() == 3)
					                  gh.currentBlock().push(jumpInstruction);
					   
					                gh.pushBlock();
					                
					                jumpIfInstruction.setArgument(gh.currentBlock().jumpLabel());
					            
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:261:11: ( expression )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==AND||LA13_0==BECOMES||LA13_0==CHARACTER||LA13_0==DEVIDE||(LA13_0 >= EQ && LA13_0 <= FALSE)||(LA13_0 >= IDENTIFIER && LA13_0 <= IF)||(LA13_0 >= LCURLY && LA13_0 <= LESSEQ)||(LA13_0 >= MINUS && LA13_0 <= NEQ)||LA13_0==NUMBER||(LA13_0 >= OR && LA13_0 <= PRINT)||LA13_0==READ||LA13_0==TRUE||LA13_0==WHILE) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:261:11: expression
							{
							pushFollow(FOLLOW_expression_in_expression1073);
							expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					          
					          gh.pushBlock(); // if block is empty it won't push
					          jumpInstruction.setArgument(gh.currentBlock().jumpLabel());
					          
					          node = te;
					        
					}
					break;
				case 21 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:269:9: ^(te= WHILE expression expression )
					{
					te=(Node)match(input,WHILE,FOLLOW_WHILE_in_expression1099); 
					 
					              gh.pushBlock();
					              String loopBackTo = gh.currentBlock().jumpLabel();
					            
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1126);
					expression();
					state._fsp--;


					              Instruction jumpIfInstruction = new Instruction("JUMPIF","notset",0,"While (jump out)");
					              gh.currentBlock().push(jumpIfInstruction);
					            
					pushFollow(FOLLOW_expression_in_expression1152);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


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
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:290:1: operand returns [Node node = null;] : (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER );
	public final Node operand() throws RecognitionException {
		Node node =  null;;


		Node id=null;
		Node n=null;
		Node b=null;
		Node c=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:291:5: (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:291:9: id= IDENTIFIER
					{
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand1193); 

					          if(!id.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()));
					          node = id;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:296:9: n= NUMBER
					{
					n=(Node)match(input,NUMBER,FOLLOW_NUMBER_in_operand1216); 

					          if(!n.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL",n.getText()));
					          node = n;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:301:9: b= TRUE
					{
					b=(Node)match(input,TRUE,FOLLOW_TRUE_in_operand1238); 

					          if(!b.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1","True Boolean"));
					          node = b;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:306:9: b= FALSE
					{
					b=(Node)match(input,FALSE,FOLLOW_FALSE_in_operand1260); 

					          if(!b.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","0","False Boolean"));
					          node = b;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:311:9: c= CHARACTER
					{
					c=(Node)match(input,CHARACTER,FOLLOW_CHARACTER_in_operand1282); 

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



	public static final BitSet FOLLOW_NOOT_in_program89 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_program92 = new BitSet(new long[]{0x00050BAFE3F623D8L});
	public static final BitSet FOLLOW_expression_in_program96 = new BitSet(new long[]{0x00050BAFE3F623D8L});
	public static final BitSet FOLLOW_set_in_declaration135 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration149 = new BitSet(new long[]{0x0001002000140200L});
	public static final BitSet FOLLOW_operand_in_declaration178 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration204 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_declaration219 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration233 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration260 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention288 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention292 = new BitSet(new long[]{0x0001002000140200L});
	public static final BitSet FOLLOW_operand_in_declaration_extention321 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention347 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention362 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention366 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention394 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_operand_in_expression428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression443 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression445 = new BitSet(new long[]{0x00050BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression449 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression474 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression476 = new BitSet(new long[]{0x00050BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression480 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATION_in_expression505 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression507 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULTIPLY_in_expression531 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression533 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression535 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DEVIDE_in_expression559 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression561 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression563 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MODULO_in_expression587 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression589 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression591 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESSEQ_in_expression615 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression617 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression619 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MOREEQ_in_expression643 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression645 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression647 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEQ_in_expression671 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression673 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression675 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expression699 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression701 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression703 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESS_in_expression727 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression729 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression731 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MORE_in_expression755 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression757 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression759 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_expression783 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression785 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression787 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expression811 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression813 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression815 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_expression839 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression843 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression845 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_in_expression870 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression875 = new BitSet(new long[]{0x0000000000100008L});
	public static final BitSet FOLLOW_PRINT_in_expression919 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression949 = new BitSet(new long[]{0x00050BAFE3B62258L});
	public static final BitSet FOLLOW_LCURLY_in_expression992 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_expression995 = new BitSet(new long[]{0x00050BAFE3F623D8L});
	public static final BitSet FOLLOW_expression_in_expression999 = new BitSet(new long[]{0x00050BAFE3F623D8L});
	public static final BitSet FOLLOW_IF_in_expression1018 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1020 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression1047 = new BitSet(new long[]{0x00050BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression1073 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_expression1099 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1126 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression1152 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand1193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand1216 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_operand1238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_operand1260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_operand1282 = new BitSet(new long[]{0x0000000000000002L});
}
