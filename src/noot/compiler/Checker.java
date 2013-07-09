// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/compiler/Checker.g 2013-07-09 20:35:12

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
	@Override public String getGrammarFileName() { return "/Users/Thijs/Development/noot/src/noot/compiler/Checker.g"; }


	    private CheckerHelper checkerHelper = new CheckerHelper();



	// $ANTLR start "program"
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:41:1: program : ^( NOOT (dec= declaration |ex= expression )+ ) ;
	public final void program() throws RecognitionException {
		Node dec =null;
		Node ex =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:42:5: ( ^( NOOT (dec= declaration |ex= expression )+ ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:42:9: ^( NOOT (dec= declaration |ex= expression )+ )
			{
			match(input,NOOT,FOLLOW_NOOT_in_program91); 
			match(input, Token.DOWN, null); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:42:16: (dec= declaration |ex= expression )+
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:42:17: dec= declaration
					{
					pushFollow(FOLLOW_declaration_in_program96);
					dec=declaration();
					state._fsp--;


					            dec.setIgnoreReturnValue(true);
					          
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:46:13: ex= expression
					{
					pushFollow(FOLLOW_expression_in_program124);
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:53:1: declaration returns [Node node = null;] : ( ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER op= operand (dex= declaration_extention )? ) | ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER (dex= declaration_extention )? ) );
	public final Node declaration() throws RecognitionException {
		Node node =  null;;


		Node d=null;
		Node id=null;
		Node op =null;
		Node dex =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:54:3: ( ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER op= operand (dex= declaration_extention )? ) | ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER (dex= declaration_extention )? ) )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:54:9: ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER op= operand (dex= declaration_extention )? )
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
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration190); 
					pushFollow(FOLLOW_operand_in_declaration194);
					op=operand();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:54:61: (dex= declaration_extention )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==COMMA) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:54:61: dex= declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration198);
							dex=declaration_extention();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					            ((DeclarationNode) d).setConstant(true);
					        
					            checkerHelper.declare( (DeclarationNode) d );
					            checkerHelper.linkToDeclaration( (IdentifierNode) id );
					            
					            List<Node> nodes = asList(id,op);
					            checkerHelper.checkExpressionsForEqualType(nodes,d);
					            
					            d.addValuePropagatingChild(id);
					            if(dex != null) d.addValuePropagatingChild(dex);
					            
					            node = d;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:69:9: ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER (dex= declaration_extention )? )
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
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration238); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:69:50: (dex= declaration_extention )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==COMMA) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:69:50: dex= declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration242);
							dex=declaration_extention();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					            checkerHelper.declare( (DeclarationNode) d );
					            checkerHelper.linkToDeclaration( (IdentifierNode) id );
					            
					            d.addValuePropagatingChild(id);
					            if(dex != null) d.addValuePropagatingChild(dex);
					            
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:81:1: declaration_extention returns [Node node = null;] : ( ^(d= COMMA id= IDENTIFIER op= operand (dex= declaration_extention )? ) | ^(d= COMMA id= IDENTIFIER (dex= declaration_extention )? ) );
	public final Node declaration_extention() throws RecognitionException {
		Node node =  null;;


		Node d=null;
		Node id=null;
		Node op =null;
		Node dex =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:82:5: ( ^(d= COMMA id= IDENTIFIER op= operand (dex= declaration_extention )? ) | ^(d= COMMA id= IDENTIFIER (dex= declaration_extention )? ) )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:82:9: ^(d= COMMA id= IDENTIFIER op= operand (dex= declaration_extention )? )
					{
					d=(Node)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention283); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention287); 
					pushFollow(FOLLOW_operand_in_declaration_extention291);
					op=operand();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:82:47: (dex= declaration_extention )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==COMMA) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:82:47: dex= declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration_extention295);
							dex=declaration_extention();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					            ((DeclarationNode) d).setConstant(true);
					            
					            checkerHelper.declare( (DeclarationNode) d );
					            checkerHelper.linkToDeclaration( (IdentifierNode) id );
					            
					            List<Node> nodes = asList(id,op);
					            checkerHelper.checkExpressionsForEqualType(nodes,d);
					            
					            d.addValuePropagatingChild(id);
					            if(dex != null) d.addValuePropagatingChild(dex);
					            
					            node = d;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:97:9: ^(d= COMMA id= IDENTIFIER (dex= declaration_extention )? )
					{
					d=(Node)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention321); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention325); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:97:36: (dex= declaration_extention )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==COMMA) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:97:36: dex= declaration_extention
							{
							pushFollow(FOLLOW_declaration_extention_in_declaration_extention329);
							dex=declaration_extention();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					            checkerHelper.declare( (DeclarationNode) d );
					            checkerHelper.linkToDeclaration( (IdentifierNode) id );
					            
					            d.addValuePropagatingChild(id);
					            if(dex != null) d.addValuePropagatingChild(dex);
					            
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



	// $ANTLR start "variable_declaration"
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:110:1: variable_declaration returns [Node node = null;] : ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER (dex= variable_declaration_extention )? ) ;
	public final Node variable_declaration() throws RecognitionException {
		Node node =  null;;


		Node d=null;
		Node id=null;
		Node dex =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:111:5: ( ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER (dex= variable_declaration_extention )? ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:111:9: ^(d= ( INT | BOOL | CHAR ) id= IDENTIFIER (dex= variable_declaration_extention )? )
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
			id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_variable_declaration391); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:111:50: (dex= variable_declaration_extention )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==COMMA) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:111:50: dex= variable_declaration_extention
					{
					pushFollow(FOLLOW_variable_declaration_extention_in_variable_declaration395);
					dex=variable_declaration_extention();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 


			            checkerHelper.declare( (DeclarationNode) d );
			            checkerHelper.linkToDeclaration( (IdentifierNode) id );
			            
			            d.addValuePropagatingChild(id);
			            if(dex != null) d.addValuePropagatingChild(dex);
			            
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
	// $ANTLR end "variable_declaration"



	// $ANTLR start "variable_declaration_extention"
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:123:1: variable_declaration_extention returns [Node node = null;] : ^(d= COMMA id= IDENTIFIER (dex= variable_declaration_extention )? ) ;
	public final Node variable_declaration_extention() throws RecognitionException {
		Node node =  null;;


		Node d=null;
		Node id=null;
		Node dex =null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:124:5: ( ^(d= COMMA id= IDENTIFIER (dex= variable_declaration_extention )? ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:124:9: ^(d= COMMA id= IDENTIFIER (dex= variable_declaration_extention )? )
			{
			d=(Node)match(input,COMMA,FOLLOW_COMMA_in_variable_declaration_extention437); 
			match(input, Token.DOWN, null); 
			id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_variable_declaration_extention441); 
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:124:36: (dex= variable_declaration_extention )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==COMMA) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:124:36: dex= variable_declaration_extention
					{
					pushFollow(FOLLOW_variable_declaration_extention_in_variable_declaration_extention445);
					dex=variable_declaration_extention();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 


			            checkerHelper.declare( (DeclarationNode) d );
			            checkerHelper.linkToDeclaration( (IdentifierNode) id );
			            
			            d.addValuePropagatingChild(id);
			            if(dex != null) d.addValuePropagatingChild(dex);
			            
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
	// $ANTLR end "variable_declaration_extention"



	// $ANTLR start "expression"
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:136:1: expression returns [Node node = null;] : (op= operand | ^(te= PLUS e1= expression (e2= expression )? ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION e1= expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE e1= expression e2= expression ) );
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
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:137:5: (op= operand | ^(te= PLUS e1= expression (e2= expression )? ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION e1= expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE e1= expression e2= expression ) )
			int alt16=21;
			switch ( input.LA(1) ) {
			case CHARACTER:
			case FALSE:
			case IDENTIFIER:
			case NUMBER:
			case TRUE:
				{
				alt16=1;
				}
				break;
			case PLUS:
				{
				alt16=2;
				}
				break;
			case MINUS:
				{
				alt16=3;
				}
				break;
			case NEGATION:
				{
				alt16=4;
				}
				break;
			case MULTIPLY:
				{
				alt16=5;
				}
				break;
			case DEVIDE:
				{
				alt16=6;
				}
				break;
			case MODULO:
				{
				alt16=7;
				}
				break;
			case LESSEQ:
				{
				alt16=8;
				}
				break;
			case MOREEQ:
				{
				alt16=9;
				}
				break;
			case NEQ:
				{
				alt16=10;
				}
				break;
			case EQ:
				{
				alt16=11;
				}
				break;
			case LESS:
				{
				alt16=12;
				}
				break;
			case MORE:
				{
				alt16=13;
				}
				break;
			case AND:
				{
				alt16=14;
				}
				break;
			case OR:
				{
				alt16=15;
				}
				break;
			case BECOMES:
				{
				alt16=16;
				}
				break;
			case READ:
				{
				alt16=17;
				}
				break;
			case PRINT:
				{
				alt16=18;
				}
				break;
			case LCURLY:
				{
				alt16=19;
				}
				break;
			case IF:
				{
				alt16=20;
				}
				break;
			case WHILE:
				{
				alt16=21;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:137:9: op= operand
					{
					pushFollow(FOLLOW_operand_in_expression487);
					op=operand();
					state._fsp--;


					          node = op;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:141:9: ^(te= PLUS e1= expression (e2= expression )? )
					{
					te=(Node)match(input,PLUS,FOLLOW_PLUS_in_expression510); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression514);
					e1=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:141:35: (e2= expression )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==AND||LA10_0==BECOMES||LA10_0==CHARACTER||LA10_0==DEVIDE||(LA10_0 >= EQ && LA10_0 <= FALSE)||(LA10_0 >= IDENTIFIER && LA10_0 <= IF)||(LA10_0 >= LCURLY && LA10_0 <= LESSEQ)||(LA10_0 >= MINUS && LA10_0 <= NEQ)||LA10_0==NUMBER||(LA10_0 >= OR && LA10_0 <= PRINT)||LA10_0==READ||LA10_0==TRUE||LA10_0==WHILE) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:141:35: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression518);
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
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:153:9: ^(te= MINUS e1= expression (e2= expression )? )
					{
					te=(Node)match(input,MINUS,FOLLOW_MINUS_in_expression543); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression547);
					e1=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:153:36: (e2= expression )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==AND||LA11_0==BECOMES||LA11_0==CHARACTER||LA11_0==DEVIDE||(LA11_0 >= EQ && LA11_0 <= FALSE)||(LA11_0 >= IDENTIFIER && LA11_0 <= IF)||(LA11_0 >= LCURLY && LA11_0 <= LESSEQ)||(LA11_0 >= MINUS && LA11_0 <= NEQ)||LA11_0==NUMBER||(LA11_0 >= OR && LA11_0 <= PRINT)||LA11_0==READ||LA11_0==TRUE||LA11_0==WHILE) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:153:36: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression551);
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
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:165:9: ^(te= NEGATION e1= expression )
					{
					te=(Node)match(input,NEGATION,FOLLOW_NEGATION_in_expression576); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression580);
					e1=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:172:9: ^(te= MULTIPLY e1= expression e2= expression )
					{
					te=(Node)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression604); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression608);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression612);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 6 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:179:9: ^(te= DEVIDE e1= expression e2= expression )
					{
					te=(Node)match(input,DEVIDE,FOLLOW_DEVIDE_in_expression636); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression640);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression644);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 7 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:186:9: ^(te= MODULO e1= expression e2= expression )
					{
					te=(Node)match(input,MODULO,FOLLOW_MODULO_in_expression668); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression672);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression676);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 8 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:193:9: ^(te= LESSEQ e1= expression e2= expression )
					{
					te=(Node)match(input,LESSEQ,FOLLOW_LESSEQ_in_expression700); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression704);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression708);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 9 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:200:9: ^(te= MOREEQ e1= expression e2= expression )
					{
					te=(Node)match(input,MOREEQ,FOLLOW_MOREEQ_in_expression732); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression736);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression740);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 10 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:207:9: ^(te= NEQ e1= expression e2= expression )
					{
					te=(Node)match(input,NEQ,FOLLOW_NEQ_in_expression764); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression768);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression772);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForEqualType(expressions,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 11 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:214:9: ^(te= EQ e1= expression e2= expression )
					{
					te=(Node)match(input,EQ,FOLLOW_EQ_in_expression796); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression800);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression804);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForEqualType(expressions,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 12 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:221:9: ^(te= LESS e1= expression e2= expression )
					{
					te=(Node)match(input,LESS,FOLLOW_LESS_in_expression828); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression832);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression836);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 13 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:228:9: ^(te= MORE e1= expression e2= expression )
					{
					te=(Node)match(input,MORE,FOLLOW_MORE_in_expression860); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression864);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression868);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.INT,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 14 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:235:9: ^(te= AND e1= expression e2= expression )
					{
					te=(Node)match(input,AND,FOLLOW_AND_in_expression892); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression896);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression900);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 15 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:242:9: ^(te= OR e1= expression e2= expression )
					{
					te=(Node)match(input,OR,FOLLOW_OR_in_expression924); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression928);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression932);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          List<Node> expressions = asList(e1,e2);
					          checkerHelper.checkExpressionsForType(expressions,Node.NodeType.BOOL,te);
					          te.addValuePropagatingChildren(expressions);
					          node = te;
					        
					}
					break;
				case 16 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:249:9: ^(te= BECOMES id= IDENTIFIER e1= expression )
					{
					te=(Node)match(input,BECOMES,FOLLOW_BECOMES_in_expression956); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression960); 
					pushFollow(FOLLOW_expression_in_expression964);
					e1=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          checkerHelper.linkToDeclaration( (IdentifierNode) id );
					          
					          if(((IdentifierNode) id).getDeclarationNode().isConstant())
					              throw new CheckerException(te,"Trying to reassign constant, this is not allowed.");
					          
					          List<Node> nodes = asList(id,e1);
					          checkerHelper.checkExpressionsForEqualType(nodes,te);
					          
					          // This so the chaining of BECOME rules will occure with the correct type checking
					          ((TypeAdoptedNode) te).setTypeDefiningChild(e1);
					          
					          node = te;
					        
					}
					break;
				case 17 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:264:9: ^(te= READ (id= IDENTIFIER )+ )
					{
					te=(Node)match(input,READ,FOLLOW_READ_in_expression989); 

					              ArrayList<IdentifierNode> identifiers = new ArrayList<IdentifierNode>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:268:11: (id= IDENTIFIER )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==IDENTIFIER) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:268:12: id= IDENTIFIER
							{
							id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression1018); 

							              checkerHelper.linkToDeclaration( (IdentifierNode) id );
							              identifiers.add( (IdentifierNode) id );
							              
							              if(((IdentifierNode) id).getDeclarationNode().isConstant())
							                throw new CheckerException(te,"Trying to read constant, this is not allowed.");
							            
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


					        
					          if(identifiers.size() == 1) // If only one argument is given let the read statement adopt its type
					          {
					            ((TypeAdoptedNode) te).setTypeDefiningChild(identifiers.get(0));
					          }
					          
					          node = te;
					        
					}
					break;
				case 18 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:286:9: ^(te= PRINT (en= expression )+ )
					{
					te=(Node)match(input,PRINT,FOLLOW_PRINT_in_expression1070); 

					              ArrayList<Node> expressions = new ArrayList<Node>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:290:11: (en= expression )+
					int cnt13=0;
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==AND||LA13_0==BECOMES||LA13_0==CHARACTER||LA13_0==DEVIDE||(LA13_0 >= EQ && LA13_0 <= FALSE)||(LA13_0 >= IDENTIFIER && LA13_0 <= IF)||(LA13_0 >= LCURLY && LA13_0 <= LESSEQ)||(LA13_0 >= MINUS && LA13_0 <= NEQ)||LA13_0==NUMBER||(LA13_0 >= OR && LA13_0 <= PRINT)||LA13_0==READ||LA13_0==TRUE||LA13_0==WHILE) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:290:12: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression1099);
							en=expression();
							state._fsp--;


							              expressions.add(en);
							            
							}
							break;

						default :
							if ( cnt13 >= 1 ) break loop13;
							EarlyExitException eee = new EarlyExitException(13, input);
							throw eee;
						}
						cnt13++;
					}

					match(input, Token.UP, null); 


					        
					          if(expressions.size() == 1) // If only one argument is given let the print statement adopt its type
					          {
					            ((TypeAdoptedNode) te).setTypeDefiningChild(expressions.get(0));
					          }
					            
					          for(Node argumentNode : expressions)
					          {
					            if(argumentNode.getNodeType() == Node.NodeType.VOID)
					              throw new CheckerException(argumentNode,"Print argument is a void expression, this is not allowed.");
					          } 
					          
					          node = te;
					        
					}
					break;
				case 19 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:310:9: ^(te= LCURLY (dc= declaration |en= expression )+ )
					{
					te=(Node)match(input,LCURLY,FOLLOW_LCURLY_in_expression1151); 

					                checkerHelper.openScope();
					                ArrayList<Node> commands = new ArrayList<Node>();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:315:11: (dc= declaration |en= expression )+
					int cnt14=0;
					loop14:
					while (true) {
						int alt14=3;
						int LA14_0 = input.LA(1);
						if ( ((LA14_0 >= BOOL && LA14_0 <= CHAR)||LA14_0==INT) ) {
							alt14=1;
						}
						else if ( (LA14_0==AND||LA14_0==BECOMES||LA14_0==CHARACTER||LA14_0==DEVIDE||(LA14_0 >= EQ && LA14_0 <= FALSE)||(LA14_0 >= IDENTIFIER && LA14_0 <= IF)||(LA14_0 >= LCURLY && LA14_0 <= LESSEQ)||(LA14_0 >= MINUS && LA14_0 <= NEQ)||LA14_0==NUMBER||(LA14_0 >= OR && LA14_0 <= PRINT)||LA14_0==READ||LA14_0==TRUE||LA14_0==WHILE) ) {
							alt14=2;
						}

						switch (alt14) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:315:12: dc= declaration
							{
							pushFollow(FOLLOW_declaration_in_expression1180);
							dc=declaration();
							state._fsp--;


							              commands.add(dc);
							            
							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:319:14: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression1211);
							en=expression();
							state._fsp--;


							              commands.add(en);
							            
							}
							break;

						default :
							if ( cnt14 >= 1 ) break loop14;
							EarlyExitException eee = new EarlyExitException(14, input);
							throw eee;
						}
						cnt14++;
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
					        
					            checkerHelper.tryToCloseScope();
					            node = te;
					        
					}
					break;
				case 20 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:345:9: ^(te= IF e1= expression e2= expression (e3= expression )? )
					{
					te=(Node)match(input,IF,FOLLOW_IF_in_expression1263); 

					              checkerHelper.holdUpcomingScope();
					            
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1291);
					e1=expression();
					state._fsp--;


					              boolean scopeReleased = checkerHelper.releaseUpcomingScope();
					              
					              List<Node> condition = asList(e1);
					              checkerHelper.checkExpressionsForType(condition,Node.NodeType.BOOL,te);
					            
					pushFollow(FOLLOW_expression_in_expression1319);
					e2=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:356:27: (e3= expression )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==AND||LA15_0==BECOMES||LA15_0==CHARACTER||LA15_0==DEVIDE||(LA15_0 >= EQ && LA15_0 <= FALSE)||(LA15_0 >= IDENTIFIER && LA15_0 <= IF)||(LA15_0 >= LCURLY && LA15_0 <= LESSEQ)||(LA15_0 >= MINUS && LA15_0 <= NEQ)||LA15_0==NUMBER||(LA15_0 >= OR && LA15_0 <= PRINT)||LA15_0==READ||LA15_0==TRUE||LA15_0==WHILE) ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:356:27: e3= expression
							{
							pushFollow(FOLLOW_expression_in_expression1323);
							e3=expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					          if(!scopeReleased) checkerHelper.releaseAndCloseScope();
					          
					          if(e3 != null)
					          {
					            try {
					              List<Node> nodes = asList(e2,e3);
					              checkerHelper.checkExpressionsForEqualType(nodes,te);
					            
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:385:9: ^(te= WHILE e1= expression e2= expression )
					{
					te=(Node)match(input,WHILE,FOLLOW_WHILE_in_expression1349); 

					              checkerHelper.holdUpcomingScope();
					            
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1377);
					e1=expression();
					state._fsp--;


					              boolean scopeReleased = checkerHelper.releaseUpcomingScope();
					              
					              List<Node> condition = asList(e1);
					              checkerHelper.checkExpressionsForType(condition,Node.NodeType.BOOL,te);
					            
					pushFollow(FOLLOW_expression_in_expression1405);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!scopeReleased) checkerHelper.releaseAndCloseScope();
					          
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:406:1: operand returns [Node node = null;] : (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER );
	public final Node operand() throws RecognitionException {
		Node node =  null;;


		Node id=null;
		Node n=null;
		Node b=null;
		Node c=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:407:5: (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER )
			int alt17=5;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				alt17=1;
				}
				break;
			case NUMBER:
				{
				alt17=2;
				}
				break;
			case TRUE:
				{
				alt17=3;
				}
				break;
			case FALSE:
				{
				alt17=4;
				}
				break;
			case CHARACTER:
				{
				alt17=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:407:9: id= IDENTIFIER
					{
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand1446); 

					          checkerHelper.linkToDeclaration( (IdentifierNode) id );
					          node = id;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:412:9: n= NUMBER
					{
					n=(Node)match(input,NUMBER,FOLLOW_NUMBER_in_operand1469); 

					          node = n;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:416:9: b= TRUE
					{
					b=(Node)match(input,TRUE,FOLLOW_TRUE_in_operand1491); 

					          node = b;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:420:9: b= FALSE
					{
					b=(Node)match(input,FALSE,FOLLOW_FALSE_in_operand1513); 

					          node = b;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Checker.g:424:9: c= CHARACTER
					{
					c=(Node)match(input,CHARACTER,FOLLOW_CHARACTER_in_operand1535); 

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
	public static final BitSet FOLLOW_declaration_in_program96 = new BitSet(new long[]{0x00050BAFE3F623D8L});
	public static final BitSet FOLLOW_expression_in_program124 = new BitSet(new long[]{0x00050BAFE3F623D8L});
	public static final BitSet FOLLOW_set_in_declaration176 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration190 = new BitSet(new long[]{0x0001002000140200L});
	public static final BitSet FOLLOW_operand_in_declaration194 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration198 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_declaration224 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration238 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration242 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention283 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention287 = new BitSet(new long[]{0x0001002000140200L});
	public static final BitSet FOLLOW_operand_in_declaration_extention291 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention295 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention321 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention325 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention329 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_variable_declaration377 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_variable_declaration391 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_variable_declaration_extention_in_variable_declaration395 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COMMA_in_variable_declaration_extention437 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_variable_declaration_extention441 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_variable_declaration_extention_in_variable_declaration_extention445 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_operand_in_expression487 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression510 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression514 = new BitSet(new long[]{0x00050BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression518 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression543 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression547 = new BitSet(new long[]{0x00050BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression551 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATION_in_expression576 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression580 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULTIPLY_in_expression604 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression608 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression612 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DEVIDE_in_expression636 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression640 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression644 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MODULO_in_expression668 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression672 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression676 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESSEQ_in_expression700 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression704 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression708 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MOREEQ_in_expression732 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression736 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression740 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEQ_in_expression764 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression768 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression772 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expression796 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression800 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression804 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESS_in_expression828 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression832 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression836 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MORE_in_expression860 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression864 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression868 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_expression892 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression896 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression900 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expression924 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression928 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression932 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_expression956 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression960 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression964 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_in_expression989 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression1018 = new BitSet(new long[]{0x0000000000100008L});
	public static final BitSet FOLLOW_PRINT_in_expression1070 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1099 = new BitSet(new long[]{0x00050BAFE3B62258L});
	public static final BitSet FOLLOW_LCURLY_in_expression1151 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_expression1180 = new BitSet(new long[]{0x00050BAFE3F623D8L});
	public static final BitSet FOLLOW_expression_in_expression1211 = new BitSet(new long[]{0x00050BAFE3F623D8L});
	public static final BitSet FOLLOW_IF_in_expression1263 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1291 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression1319 = new BitSet(new long[]{0x00050BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression1323 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_expression1349 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1377 = new BitSet(new long[]{0x00050BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression1405 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand1446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand1469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_operand1491 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_operand1513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_operand1535 = new BitSet(new long[]{0x0000000000000002L});
}
