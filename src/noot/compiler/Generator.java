// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/compiler/Generator.g 2013-07-08 18:17:02

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
		"PLUS", "PRINT", "RCURLY", "READ", "RPAREN", "SEMICOLON", "THEN", "TRUE", 
		"UPPER", "WHILE", "WS"
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
	public static final int THEN=46;
	public static final int TRUE=47;
	public static final int UPPER=48;
	public static final int WHILE=49;
	public static final int WS=50;

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
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:50:1: declaration : ( ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER op= operand ( declaration_extention )? ) | ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER ( declaration_extention )? ) );
	public final void declaration() throws RecognitionException {
		Node de=null;
		Node id=null;
		Node op =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:51:5: ( ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER op= operand ( declaration_extention )? ) | ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER ( declaration_extention )? ) )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:51:9: ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER op= operand ( declaration_extention )? )
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
					            
					pushFollow(FOLLOW_operand_in_declaration180);
					op=operand();
					state._fsp--;


					              gh.currentBlock().push(new Instruction("STORE",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Assigning constant "+id.getText()));
					            
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:59:11: ( declaration_extention )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==COMMA) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:59:11: declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration206);
							declaration_extention();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:60:9: ^(de= ( INT | BOOL | CHAR ) id= IDENTIFIER ( declaration_extention )? )
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
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration235); 

					              gh.declare( (DeclarationNode)de );
					            
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:64:11: ( declaration_extention )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==COMMA) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:64:11: declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration262);
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:67:1: declaration_extention : ( ^(de= COMMA id= IDENTIFIER op= operand ( declaration_extention )? ) | ^(de= COMMA id= IDENTIFIER ( declaration_extention )? ) );
	public final void declaration_extention() throws RecognitionException {
		Node de=null;
		Node id=null;
		Node op =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:68:5: ( ^(de= COMMA id= IDENTIFIER op= operand ( declaration_extention )? ) | ^(de= COMMA id= IDENTIFIER ( declaration_extention )? ) )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:68:9: ^(de= COMMA id= IDENTIFIER op= operand ( declaration_extention )? )
					{
					de=(Node)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention290); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention294); 

					              gh.declare( (DeclarationNode)de );
					            
					pushFollow(FOLLOW_operand_in_declaration_extention323);
					op=operand();
					state._fsp--;


					              gh.currentBlock().push(new Instruction("STORE",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Assigning constant "+id.getText()));
					            
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:76:11: ( declaration_extention )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==COMMA) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:76:11: declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration_extention349);
							declaration_extention();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:77:9: ^(de= COMMA id= IDENTIFIER ( declaration_extention )? )
					{
					de=(Node)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention364); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention368); 

					              gh.declare( (DeclarationNode)de );
					            
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:81:12: ( declaration_extention )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==COMMA) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:81:12: declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration_extention396);
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:84:1: expression returns [Node node = null;] : (op= operand | ^(te= PLUS e1= expression (e2= expression )? ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE expression expression ) );
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
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:85:5: (op= operand | ^(te= PLUS e1= expression (e2= expression )? ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE expression expression ) )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:85:9: op= operand
					{
					pushFollow(FOLLOW_operand_in_expression430);
					op=operand();
					state._fsp--;


					          node = op;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:89:9: ^(te= PLUS e1= expression (e2= expression )? )
					{
					te=(Node)match(input,PLUS,FOLLOW_PLUS_in_expression453); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression457);
					e1=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:89:35: (e2= expression )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==AND||LA8_0==BECOMES||LA8_0==CHARACTER||LA8_0==DEVIDE||(LA8_0 >= EQ && LA8_0 <= FALSE)||(LA8_0 >= IDENTIFIER && LA8_0 <= IF)||(LA8_0 >= LCURLY && LA8_0 <= LESSEQ)||(LA8_0 >= MINUS && LA8_0 <= NEQ)||LA8_0==NUMBER||(LA8_0 >= OR && LA8_0 <= PRINT)||LA8_0==READ||LA8_0==TRUE||LA8_0==WHILE) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:89:35: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression461);
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:98:9: ^(te= MINUS e1= expression (e2= expression )? )
					{
					te=(Node)match(input,MINUS,FOLLOW_MINUS_in_expression486); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression490);
					e1=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:98:36: (e2= expression )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==AND||LA9_0==BECOMES||LA9_0==CHARACTER||LA9_0==DEVIDE||(LA9_0 >= EQ && LA9_0 <= FALSE)||(LA9_0 >= IDENTIFIER && LA9_0 <= IF)||(LA9_0 >= LCURLY && LA9_0 <= LESSEQ)||(LA9_0 >= MINUS && LA9_0 <= NEQ)||LA9_0==NUMBER||(LA9_0 >= OR && LA9_0 <= PRINT)||LA9_0==READ||LA9_0==TRUE||LA9_0==WHILE) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:98:36: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression494);
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:109:9: ^(te= NEGATION expression )
					{
					te=(Node)match(input,NEGATION,FOLLOW_NEGATION_in_expression519); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression521);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","not","Boolean negation"));
					          node = te;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:114:9: ^(te= MULTIPLY e1= expression e2= expression )
					{
					te=(Node)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression545); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression549);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression553);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","mult","Multiplication"));
					          node = te;
					        
					}
					break;
				case 6 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:119:9: ^(te= DEVIDE e1= expression e2= expression )
					{
					te=(Node)match(input,DEVIDE,FOLLOW_DEVIDE_in_expression577); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression581);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression585);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","div","Devide"));
					          node = te;
					        
					}
					break;
				case 7 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:124:9: ^(te= MODULO e1= expression e2= expression )
					{
					te=(Node)match(input,MODULO,FOLLOW_MODULO_in_expression609); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression613);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression617);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","mod","Modulo"));
					          node = te;
					        
					}
					break;
				case 8 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:129:9: ^(te= LESSEQ e1= expression e2= expression )
					{
					te=(Node)match(input,LESSEQ,FOLLOW_LESSEQ_in_expression641); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression645);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression649);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","le","Less than or equal"));
					          node = te;
					        
					}
					break;
				case 9 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:134:9: ^(te= MOREEQ e1= expression e2= expression )
					{
					te=(Node)match(input,MOREEQ,FOLLOW_MOREEQ_in_expression673); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression677);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression681);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","ge","Greater than or equal"));
					          node = te;
					        
					}
					break;
				case 10 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:139:9: ^(te= NEQ e1= expression e2= expression )
					{
					te=(Node)match(input,NEQ,FOLLOW_NEQ_in_expression705); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression709);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression713);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1"));
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","ne","Not equal"));
					          node = te;
					        
					}
					break;
				case 11 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:145:9: ^(te= EQ e1= expression e2= expression )
					{
					te=(Node)match(input,EQ,FOLLOW_EQ_in_expression737); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression741);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression745);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1" ));
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","eq"));
					          node = te;
					        
					}
					break;
				case 12 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:151:9: ^(te= LESS e1= expression e2= expression )
					{
					te=(Node)match(input,LESS,FOLLOW_LESS_in_expression769); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression773);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression777);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","lt","Less than"));
					          node = te;
					        
					}
					break;
				case 13 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:156:9: ^(te= MORE e1= expression e2= expression )
					{
					te=(Node)match(input,MORE,FOLLOW_MORE_in_expression801); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression805);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression809);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","gt","Greater than"));
					          node = te;
					        
					}
					break;
				case 14 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:161:9: ^(te= AND e1= expression e2= expression )
					{
					te=(Node)match(input,AND,FOLLOW_AND_in_expression833); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression837);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression841);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","and"));
					          node = te;
					        
					}
					break;
				case 15 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:166:9: ^(te= OR e1= expression e2= expression )
					{
					te=(Node)match(input,OR,FOLLOW_OR_in_expression865); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression869);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression873);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","or"));
					          node = te;
					        
					}
					break;
				case 16 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:171:9: ^(te= BECOMES id= IDENTIFIER e1= expression )
					{
					te=(Node)match(input,BECOMES,FOLLOW_BECOMES_in_expression897); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression901); 
					pushFollow(FOLLOW_expression_in_expression905);
					e1=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          gh.currentBlock().push(new Instruction("STORE",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Assigning "+id.getText()));
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()+" for next expression"));
					          node = te;
					        
					}
					break;
				case 17 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:177:9: ^(te= READ (id= IDENTIFIER )+ )
					{
					te=(Node)match(input,READ,FOLLOW_READ_in_expression930); 
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:177:19: (id= IDENTIFIER )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:177:20: id= IDENTIFIER
							{
							id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression935); 

							                
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:207:9: ^(te= PRINT (en= expression )+ )
					{
					te=(Node)match(input,PRINT,FOLLOW_PRINT_in_expression987); 

					              MemoryLocation temp = null;
					              if(te.getChildren().size() == 1 && !te.shouldIgnoreReturnValue()) temp = gh.allocHelperRegister();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:212:11: (en= expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:212:12: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression1017);
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
							                //gh.deallocHelperRegister(temp);
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:260:9: ^(te= LCURLY (dc= declaration |en= expression )+ )
					{
					te=(Node)match(input,LCURLY,FOLLOW_LCURLY_in_expression1069); 
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:260:21: (dc= declaration |en= expression )+
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:260:22: dc= declaration
							{
							pushFollow(FOLLOW_declaration_in_expression1074);
							declaration();
							state._fsp--;

							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:260:39: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression1080);
							en=expression();
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:264:9: ^(te= IF e1= expression e2= expression (e3= expression )? )
					{
					te=(Node)match(input,IF,FOLLOW_IF_in_expression1107); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1111);
					e1=expression();
					state._fsp--;


					              Instruction jumpIfInstruction = new Instruction("JUMPIF","notset",0,"If (jump to else)");
					              gh.currentBlock().push(jumpIfInstruction);
					            
					pushFollow(FOLLOW_expression_in_expression1139);
					e2=expression();
					state._fsp--;


					                Instruction jumpInstruction = new Instruction("JUMP","notset","Else (jump over else)");
					                
					                if(te.getChildren().size() == 3)
					                  gh.currentBlock().push(jumpInstruction);
					   
					                gh.pushBlock();
					                
					                jumpIfInstruction.setArgument(gh.currentBlock().jumpLabel());
					            
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:280:13: (e3= expression )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==AND||LA13_0==BECOMES||LA13_0==CHARACTER||LA13_0==DEVIDE||(LA13_0 >= EQ && LA13_0 <= FALSE)||(LA13_0 >= IDENTIFIER && LA13_0 <= IF)||(LA13_0 >= LCURLY && LA13_0 <= LESSEQ)||(LA13_0 >= MINUS && LA13_0 <= NEQ)||LA13_0==NUMBER||(LA13_0 >= OR && LA13_0 <= PRINT)||LA13_0==READ||LA13_0==TRUE||LA13_0==WHILE) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:280:13: e3= expression
							{
							pushFollow(FOLLOW_expression_in_expression1167);
							e3=expression();
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:288:9: ^(te= WHILE expression expression )
					{
					te=(Node)match(input,WHILE,FOLLOW_WHILE_in_expression1193); 
					 
					            gh.pushBlock();
					            String loopBackTo = gh.currentBlock().jumpLabel();
					          
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1215);
					expression();
					state._fsp--;


					            Instruction jumpIfInstruction = new Instruction("JUMPIF","notset",0,"While (jump out)");
					            gh.currentBlock().push(jumpIfInstruction);
					          
					pushFollow(FOLLOW_expression_in_expression1237);
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:309:1: operand returns [Node node = null;] : (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER );
	public final Node operand() throws RecognitionException {
		Node node =  null;;


		Node id=null;
		Node n=null;
		Node b=null;
		Node c=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:310:5: (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:310:9: id= IDENTIFIER
					{
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand1278); 

					          if(!id.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()));
					          node = id;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:315:9: n= NUMBER
					{
					n=(Node)match(input,NUMBER,FOLLOW_NUMBER_in_operand1301); 

					          if(!n.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL",n.getText()));
					          node = n;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:320:9: b= TRUE
					{
					b=(Node)match(input,TRUE,FOLLOW_TRUE_in_operand1323); 

					          if(!b.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1","True Boolean"));
					          node = b;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:325:9: b= FALSE
					{
					b=(Node)match(input,FALSE,FOLLOW_FALSE_in_operand1345); 

					          if(!b.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","0","False Boolean"));
					          node = b;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:330:9: c= CHARACTER
					{
					c=(Node)match(input,CHARACTER,FOLLOW_CHARACTER_in_operand1367); 

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
	public static final BitSet FOLLOW_declaration_in_program94 = new BitSet(new long[]{0x00028BAFE3F623D8L});
	public static final BitSet FOLLOW_expression_in_program98 = new BitSet(new long[]{0x00028BAFE3F623D8L});
	public static final BitSet FOLLOW_set_in_declaration137 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration151 = new BitSet(new long[]{0x0000802000140200L});
	public static final BitSet FOLLOW_operand_in_declaration180 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration206 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_declaration221 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration235 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration262 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention290 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention294 = new BitSet(new long[]{0x0000802000140200L});
	public static final BitSet FOLLOW_operand_in_declaration_extention323 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention349 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention364 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention368 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention396 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_operand_in_expression430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression453 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression457 = new BitSet(new long[]{0x00028BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression461 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression486 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression490 = new BitSet(new long[]{0x00028BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression494 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATION_in_expression519 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression521 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULTIPLY_in_expression545 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression549 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression553 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DEVIDE_in_expression577 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression581 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression585 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MODULO_in_expression609 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression613 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression617 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESSEQ_in_expression641 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression645 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression649 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MOREEQ_in_expression673 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression677 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression681 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEQ_in_expression705 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression709 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression713 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expression737 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression741 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression745 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESS_in_expression769 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression773 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression777 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MORE_in_expression801 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression805 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression809 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_expression833 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression837 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression841 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expression865 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression869 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression873 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_expression897 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression901 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression905 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_in_expression930 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression935 = new BitSet(new long[]{0x0000000000100008L});
	public static final BitSet FOLLOW_PRINT_in_expression987 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1017 = new BitSet(new long[]{0x00028BAFE3B62258L});
	public static final BitSet FOLLOW_LCURLY_in_expression1069 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_expression1074 = new BitSet(new long[]{0x00028BAFE3F623D8L});
	public static final BitSet FOLLOW_expression_in_expression1080 = new BitSet(new long[]{0x00028BAFE3F623D8L});
	public static final BitSet FOLLOW_IF_in_expression1107 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1111 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression1139 = new BitSet(new long[]{0x00028BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression1167 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_expression1193 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1215 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression1237 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand1278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand1301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_operand1323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_operand1345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_operand1367 = new BitSet(new long[]{0x0000000000000002L});
}
