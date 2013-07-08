// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/compiler/Generator.g 2013-07-08 14:22:35

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
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:84:1: expression returns [Node node = null;] : (op= operand | ^(te= PLUS expression expression ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE expression expression ) );
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
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:85:5: (op= operand | ^(te= PLUS expression expression ) | ^(te= MINUS e1= expression (e2= expression )? ) | ^(te= NEGATION expression ) | ^(te= MULTIPLY e1= expression e2= expression ) | ^(te= DEVIDE e1= expression e2= expression ) | ^(te= MODULO e1= expression e2= expression ) | ^(te= LESSEQ e1= expression e2= expression ) | ^(te= MOREEQ e1= expression e2= expression ) | ^(te= NEQ e1= expression e2= expression ) | ^(te= EQ e1= expression e2= expression ) | ^(te= LESS e1= expression e2= expression ) | ^(te= MORE e1= expression e2= expression ) | ^(te= AND e1= expression e2= expression ) | ^(te= OR e1= expression e2= expression ) | ^(te= BECOMES id= IDENTIFIER e1= expression ) | ^(te= READ (id= IDENTIFIER )+ ) | ^(te= PRINT (en= expression )+ ) | ^(te= LCURLY (dc= declaration |en= expression )+ ) | ^(te= IF e1= expression e2= expression (e3= expression )? ) | ^(te= WHILE expression expression ) )
			int alt13=21;
			switch ( input.LA(1) ) {
			case CHARACTER:
			case FALSE:
			case IDENTIFIER:
			case NUMBER:
			case TRUE:
				{
				alt13=1;
				}
				break;
			case PLUS:
				{
				alt13=2;
				}
				break;
			case MINUS:
				{
				alt13=3;
				}
				break;
			case NEGATION:
				{
				alt13=4;
				}
				break;
			case MULTIPLY:
				{
				alt13=5;
				}
				break;
			case DEVIDE:
				{
				alt13=6;
				}
				break;
			case MODULO:
				{
				alt13=7;
				}
				break;
			case LESSEQ:
				{
				alt13=8;
				}
				break;
			case MOREEQ:
				{
				alt13=9;
				}
				break;
			case NEQ:
				{
				alt13=10;
				}
				break;
			case EQ:
				{
				alt13=11;
				}
				break;
			case LESS:
				{
				alt13=12;
				}
				break;
			case MORE:
				{
				alt13=13;
				}
				break;
			case AND:
				{
				alt13=14;
				}
				break;
			case OR:
				{
				alt13=15;
				}
				break;
			case BECOMES:
				{
				alt13=16;
				}
				break;
			case READ:
				{
				alt13=17;
				}
				break;
			case PRINT:
				{
				alt13=18;
				}
				break;
			case LCURLY:
				{
				alt13=19;
				}
				break;
			case IF:
				{
				alt13=20;
				}
				break;
			case WHILE:
				{
				alt13=21;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:89:9: ^(te= PLUS expression expression )
					{
					te=(Node)match(input,PLUS,FOLLOW_PLUS_in_expression453); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression455);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression457);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					 
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","add","Adition"));
					          node = te;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:94:9: ^(te= MINUS e1= expression (e2= expression )? )
					{
					te=(Node)match(input,MINUS,FOLLOW_MINUS_in_expression481); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression485);
					e1=expression();
					state._fsp--;

					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:94:36: (e2= expression )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==AND||LA8_0==BECOMES||LA8_0==CHARACTER||LA8_0==DEVIDE||(LA8_0 >= EQ && LA8_0 <= FALSE)||(LA8_0 >= IDENTIFIER && LA8_0 <= IF)||(LA8_0 >= LCURLY && LA8_0 <= LESSEQ)||(LA8_0 >= MINUS && LA8_0 <= NEQ)||LA8_0==NUMBER||(LA8_0 >= OR && LA8_0 <= PRINT)||LA8_0==READ||LA8_0==TRUE||LA8_0==WHILE) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:94:36: e2= expression
							{
							pushFollow(FOLLOW_expression_in_expression489);
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:105:9: ^(te= NEGATION expression )
					{
					te=(Node)match(input,NEGATION,FOLLOW_NEGATION_in_expression514); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression516);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","not","Boolean negation"));
					          node = te;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:110:9: ^(te= MULTIPLY e1= expression e2= expression )
					{
					te=(Node)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression540); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression544);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression548);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","mult","Multiplication"));
					          node = te;
					        
					}
					break;
				case 6 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:115:9: ^(te= DEVIDE e1= expression e2= expression )
					{
					te=(Node)match(input,DEVIDE,FOLLOW_DEVIDE_in_expression572); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression576);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression580);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","div","Devide"));
					          node = te;
					        
					}
					break;
				case 7 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:120:9: ^(te= MODULO e1= expression e2= expression )
					{
					te=(Node)match(input,MODULO,FOLLOW_MODULO_in_expression604); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression608);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression612);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","mod","Modulo"));
					          node = te;
					        
					}
					break;
				case 8 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:125:9: ^(te= LESSEQ e1= expression e2= expression )
					{
					te=(Node)match(input,LESSEQ,FOLLOW_LESSEQ_in_expression636); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression640);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression644);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","le","Less than or equal"));
					          node = te;
					        
					}
					break;
				case 9 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:130:9: ^(te= MOREEQ e1= expression e2= expression )
					{
					te=(Node)match(input,MOREEQ,FOLLOW_MOREEQ_in_expression668); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression672);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression676);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","ge","Greater than or equal"));
					          node = te;
					        
					}
					break;
				case 10 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:135:9: ^(te= NEQ e1= expression e2= expression )
					{
					te=(Node)match(input,NEQ,FOLLOW_NEQ_in_expression700); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression704);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression708);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1"));
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","ne","Not equal"));
					          node = te;
					        
					}
					break;
				case 11 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:141:9: ^(te= EQ e1= expression e2= expression )
					{
					te=(Node)match(input,EQ,FOLLOW_EQ_in_expression732); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression736);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression740);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1" ));
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","eq"));
					          node = te;
					        
					}
					break;
				case 12 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:147:9: ^(te= LESS e1= expression e2= expression )
					{
					te=(Node)match(input,LESS,FOLLOW_LESS_in_expression764); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression768);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression772);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","lt","Less than"));
					          node = te;
					        
					}
					break;
				case 13 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:152:9: ^(te= MORE e1= expression e2= expression )
					{
					te=(Node)match(input,MORE,FOLLOW_MORE_in_expression796); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression800);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression804);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","gt","Greater than"));
					          node = te;
					        
					}
					break;
				case 14 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:157:9: ^(te= AND e1= expression e2= expression )
					{
					te=(Node)match(input,AND,FOLLOW_AND_in_expression828); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression832);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression836);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","and"));
					          node = te;
					        
					}
					break;
				case 15 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:162:9: ^(te= OR e1= expression e2= expression )
					{
					te=(Node)match(input,OR,FOLLOW_OR_in_expression860); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression864);
					e1=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression868);
					e2=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("CALL","or"));
					          node = te;
					        
					}
					break;
				case 16 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:167:9: ^(te= BECOMES id= IDENTIFIER e1= expression )
					{
					te=(Node)match(input,BECOMES,FOLLOW_BECOMES_in_expression892); 
					match(input, Token.DOWN, null); 
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression896); 
					pushFollow(FOLLOW_expression_in_expression900);
					e1=expression();
					state._fsp--;

					match(input, Token.UP, null); 


					          gh.currentBlock().push(new Instruction("STORE",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Assigning "+id.getText()));
					          if(!te.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()+" for next expression"));
					          node = te;
					        
					}
					break;
				case 17 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:173:9: ^(te= READ (id= IDENTIFIER )+ )
					{
					te=(Node)match(input,READ,FOLLOW_READ_in_expression925); 
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:173:19: (id= IDENTIFIER )+
					int cnt9=0;
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==IDENTIFIER) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:173:20: id= IDENTIFIER
							{
							id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression930); 

							                
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
							if ( cnt9 >= 1 ) break loop9;
							EarlyExitException eee = new EarlyExitException(9, input);
							throw eee;
						}
						cnt9++;
					}

					match(input, Token.UP, null); 

					 
					          node = te;
					        
					}
					break;
				case 18 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:203:9: ^(te= PRINT (en= expression )+ )
					{
					te=(Node)match(input,PRINT,FOLLOW_PRINT_in_expression982); 

					              MemoryLocation temp = null;
					              if(te.getChildren().size() == 1 && !te.shouldIgnoreReturnValue()) temp = gh.allocHelperRegister();
					            
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:208:11: (en= expression )+
					int cnt10=0;
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==AND||LA10_0==BECOMES||LA10_0==CHARACTER||LA10_0==DEVIDE||(LA10_0 >= EQ && LA10_0 <= FALSE)||(LA10_0 >= IDENTIFIER && LA10_0 <= IF)||(LA10_0 >= LCURLY && LA10_0 <= LESSEQ)||(LA10_0 >= MINUS && LA10_0 <= NEQ)||LA10_0==NUMBER||(LA10_0 >= OR && LA10_0 <= PRINT)||LA10_0==READ||LA10_0==TRUE||LA10_0==WHILE) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:208:12: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression1012);
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
							                //gh.deallocHelperRegister(temp);
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
				case 19 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:236:9: ^(te= LCURLY (dc= declaration |en= expression )+ )
					{
					te=(Node)match(input,LCURLY,FOLLOW_LCURLY_in_expression1064); 
					match(input, Token.DOWN, null); 
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:236:21: (dc= declaration |en= expression )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=3;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= BOOL && LA11_0 <= CHAR)||LA11_0==INT) ) {
							alt11=1;
						}
						else if ( (LA11_0==AND||LA11_0==BECOMES||LA11_0==CHARACTER||LA11_0==DEVIDE||(LA11_0 >= EQ && LA11_0 <= FALSE)||(LA11_0 >= IDENTIFIER && LA11_0 <= IF)||(LA11_0 >= LCURLY && LA11_0 <= LESSEQ)||(LA11_0 >= MINUS && LA11_0 <= NEQ)||LA11_0==NUMBER||(LA11_0 >= OR && LA11_0 <= PRINT)||LA11_0==READ||LA11_0==TRUE||LA11_0==WHILE) ) {
							alt11=2;
						}

						switch (alt11) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:236:22: dc= declaration
							{
							pushFollow(FOLLOW_declaration_in_expression1069);
							declaration();
							state._fsp--;

							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:236:39: en= expression
							{
							pushFollow(FOLLOW_expression_in_expression1075);
							en=expression();
							state._fsp--;

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
				case 20 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:240:9: ^(te= IF e1= expression e2= expression (e3= expression )? )
					{
					te=(Node)match(input,IF,FOLLOW_IF_in_expression1102); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1106);
					e1=expression();
					state._fsp--;


					              Instruction jumpIfInstruction = new Instruction("JUMPIF","notset",0,"If (jump to else)");
					              gh.currentBlock().push(jumpIfInstruction);
					            
					pushFollow(FOLLOW_expression_in_expression1134);
					e2=expression();
					state._fsp--;


					                Instruction jumpInstruction = new Instruction("JUMP","notset","Else (jump over else)");
					                
					                if(te.getChildren().size() == 3)
					                  gh.currentBlock().push(jumpInstruction);
					   
					                gh.pushBlock();
					                
					                jumpIfInstruction.setArgument(gh.currentBlock().jumpLabel());
					            
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:256:13: (e3= expression )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==AND||LA12_0==BECOMES||LA12_0==CHARACTER||LA12_0==DEVIDE||(LA12_0 >= EQ && LA12_0 <= FALSE)||(LA12_0 >= IDENTIFIER && LA12_0 <= IF)||(LA12_0 >= LCURLY && LA12_0 <= LESSEQ)||(LA12_0 >= MINUS && LA12_0 <= NEQ)||LA12_0==NUMBER||(LA12_0 >= OR && LA12_0 <= PRINT)||LA12_0==READ||LA12_0==TRUE||LA12_0==WHILE) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:256:13: e3= expression
							{
							pushFollow(FOLLOW_expression_in_expression1162);
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:264:9: ^(te= WHILE expression expression )
					{
					te=(Node)match(input,WHILE,FOLLOW_WHILE_in_expression1188); 
					 
					            gh.pushBlock();
					            String loopBackTo = gh.currentBlock().jumpLabel();
					          
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1210);
					expression();
					state._fsp--;


					            Instruction jumpIfInstruction = new Instruction("JUMPIF","notset",0,"While (jump out)");
					            gh.currentBlock().push(jumpIfInstruction);
					          
					pushFollow(FOLLOW_expression_in_expression1232);
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
	// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:285:1: operand returns [Node node = null;] : (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER );
	public final Node operand() throws RecognitionException {
		Node node =  null;;


		Node id=null;
		Node n=null;
		Node b=null;
		Node c=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:286:5: (id= IDENTIFIER |n= NUMBER |b= TRUE |b= FALSE |c= CHARACTER )
			int alt14=5;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				alt14=1;
				}
				break;
			case NUMBER:
				{
				alt14=2;
				}
				break;
			case TRUE:
				{
				alt14=3;
				}
				break;
			case FALSE:
				{
				alt14=4;
				}
				break;
			case CHARACTER:
				{
				alt14=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:286:9: id= IDENTIFIER
					{
					id=(Node)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand1273); 

					          if(!id.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOAD",gh.addressOfIdentifier( (IdentifierNode)id ),1,"Loading "+id.getText()));
					          node = id;
					        
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:291:9: n= NUMBER
					{
					n=(Node)match(input,NUMBER,FOLLOW_NUMBER_in_operand1296); 

					          if(!n.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL",n.getText()));
					          node = n;
					        
					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:296:9: b= TRUE
					{
					b=(Node)match(input,TRUE,FOLLOW_TRUE_in_operand1318); 

					          if(!b.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","1","True Boolean"));
					          node = b;
					        
					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:301:9: b= FALSE
					{
					b=(Node)match(input,FALSE,FOLLOW_FALSE_in_operand1340); 

					          if(!b.shouldIgnoreReturnValue()) gh.currentBlock().push(new Instruction("LOADL","0","False Boolean"));
					          node = b;
					        
					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Generator.g:306:9: c= CHARACTER
					{
					c=(Node)match(input,CHARACTER,FOLLOW_CHARACTER_in_operand1362); 

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
	public static final BitSet FOLLOW_expression_in_expression455 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression457 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression481 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression485 = new BitSet(new long[]{0x00028BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression489 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATION_in_expression514 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression516 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULTIPLY_in_expression540 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression544 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression548 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DEVIDE_in_expression572 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression576 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression580 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MODULO_in_expression604 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression608 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression612 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESSEQ_in_expression636 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression640 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression644 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MOREEQ_in_expression668 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression672 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression676 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEQ_in_expression700 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression704 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression708 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expression732 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression736 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression740 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LESS_in_expression764 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression768 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression772 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MORE_in_expression796 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression800 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression804 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_expression828 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression832 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression836 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expression860 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression864 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression868 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BECOMES_in_expression892 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression896 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression900 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_in_expression925 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_expression930 = new BitSet(new long[]{0x0000000000100008L});
	public static final BitSet FOLLOW_PRINT_in_expression982 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1012 = new BitSet(new long[]{0x00028BAFE3B62258L});
	public static final BitSet FOLLOW_LCURLY_in_expression1064 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_expression1069 = new BitSet(new long[]{0x00028BAFE3F623D8L});
	public static final BitSet FOLLOW_expression_in_expression1075 = new BitSet(new long[]{0x00028BAFE3F623D8L});
	public static final BitSet FOLLOW_IF_in_expression1102 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1106 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression1134 = new BitSet(new long[]{0x00028BAFE3B62258L});
	public static final BitSet FOLLOW_expression_in_expression1162 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_expression1188 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1210 = new BitSet(new long[]{0x00028BAFE3B62250L});
	public static final BitSet FOLLOW_expression_in_expression1232 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand1273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand1296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_operand1318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_operand1340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_operand1362 = new BitSet(new long[]{0x0000000000000002L});
}
