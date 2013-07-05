// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/compiler/Noot.g 2013-07-05 15:37:26

  package noot.compiler;
  import noot.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class NootParser extends Parser {
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public NootParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public NootParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return NootParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/Thijs/Development/noot/src/noot/compiler/Noot.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "program"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:89:1: program : NOOT ^ ( command )+ EOF !;
	public final NootParser.program_return program() throws RecognitionException {
		NootParser.program_return retval = new NootParser.program_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token NOOT1=null;
		Token EOF3=null;
		ParserRuleReturnScope command2 =null;

		Node NOOT1_tree=null;
		Node EOF3_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:90:5: ( NOOT ^ ( command )+ EOF !)
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:90:7: NOOT ^ ( command )+ EOF !
			{
			root_0 = (Node)adaptor.nil();


			NOOT1=(Token)match(input,NOOT,FOLLOW_NOOT_in_program843); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NOOT1_tree = (Node)adaptor.create(NOOT1);
			root_0 = (Node)adaptor.becomeRoot(NOOT1_tree, root_0);
			}

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:90:13: ( command )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= BOOL && LA1_0 <= CHARACTER)||LA1_0==FALSE||(LA1_0 >= IDENTIFIER && LA1_0 <= LCURLY)||(LA1_0 >= LPAREN && LA1_0 <= MINUS)||LA1_0==NEGATION||LA1_0==NUMBER||LA1_0==PRINT||LA1_0==READ||LA1_0==TRUE||LA1_0==WHILE) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:90:13: command
					{
					pushFollow(FOLLOW_command_in_program846);
					command2=command();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, command2.getTree());

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_program849); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class command_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "command"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:93:1: command : ( declaration SEMICOLON !| expression SEMICOLON !);
	public final NootParser.command_return command() throws RecognitionException {
		NootParser.command_return retval = new NootParser.command_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token SEMICOLON5=null;
		Token SEMICOLON7=null;
		ParserRuleReturnScope declaration4 =null;
		ParserRuleReturnScope expression6 =null;

		Node SEMICOLON5_tree=null;
		Node SEMICOLON7_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:94:5: ( declaration SEMICOLON !| expression SEMICOLON !)
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= BOOL && LA2_0 <= CHAR)||LA2_0==INT) ) {
				alt2=1;
			}
			else if ( (LA2_0==CHARACTER||LA2_0==FALSE||(LA2_0 >= IDENTIFIER && LA2_0 <= IF)||LA2_0==LCURLY||(LA2_0 >= LPAREN && LA2_0 <= MINUS)||LA2_0==NEGATION||LA2_0==NUMBER||LA2_0==PRINT||LA2_0==READ||LA2_0==TRUE||LA2_0==WHILE) ) {
				alt2=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:94:8: declaration SEMICOLON !
					{
					root_0 = (Node)adaptor.nil();


					pushFollow(FOLLOW_declaration_in_command872);
					declaration4=declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration4.getTree());

					SEMICOLON5=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_command874); if (state.failed) return retval;
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:95:8: expression SEMICOLON !
					{
					root_0 = (Node)adaptor.nil();


					pushFollow(FOLLOW_expression_in_command884);
					expression6=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression6.getTree());

					SEMICOLON7=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_command886); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "command"


	public static class declaration_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "declaration"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:98:1: declaration : ( INT ^| CHAR ^| BOOL ^) IDENTIFIER declaration_extention ;
	public final NootParser.declaration_return declaration() throws RecognitionException {
		NootParser.declaration_return retval = new NootParser.declaration_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token INT8=null;
		Token CHAR9=null;
		Token BOOL10=null;
		Token IDENTIFIER11=null;
		ParserRuleReturnScope declaration_extention12 =null;

		Node INT8_tree=null;
		Node CHAR9_tree=null;
		Node BOOL10_tree=null;
		Node IDENTIFIER11_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:99:5: ( ( INT ^| CHAR ^| BOOL ^) IDENTIFIER declaration_extention )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:99:9: ( INT ^| CHAR ^| BOOL ^) IDENTIFIER declaration_extention
			{
			root_0 = (Node)adaptor.nil();


			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:99:9: ( INT ^| CHAR ^| BOOL ^)
			int alt3=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt3=1;
				}
				break;
			case CHAR:
				{
				alt3=2;
				}
				break;
			case BOOL:
				{
				alt3=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:99:10: INT ^
					{
					INT8=(Token)match(input,INT,FOLLOW_INT_in_declaration911); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT8_tree = new DeclarationNode(INT8) ;
					root_0 = (Node)adaptor.becomeRoot(INT8_tree, root_0);
					}

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:99:34: CHAR ^
					{
					CHAR9=(Token)match(input,CHAR,FOLLOW_CHAR_in_declaration919); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CHAR9_tree = new DeclarationNode(CHAR9) ;
					root_0 = (Node)adaptor.becomeRoot(CHAR9_tree, root_0);
					}

					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:99:59: BOOL ^
					{
					BOOL10=(Token)match(input,BOOL,FOLLOW_BOOL_in_declaration927); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BOOL10_tree = new DeclarationNode(BOOL10) ;
					root_0 = (Node)adaptor.becomeRoot(BOOL10_tree, root_0);
					}

					}
					break;

			}

			IDENTIFIER11=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration934); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER11_tree = new IdentifierNode(IDENTIFIER11) ;
			adaptor.addChild(root_0, IDENTIFIER11_tree);
			}

			pushFollow(FOLLOW_declaration_extention_in_declaration939);
			declaration_extention12=declaration_extention();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration_extention12.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration"


	public static class declaration_extention_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "declaration_extention"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:102:1: declaration_extention : ( COMMA ^ IDENTIFIER declaration_extention )? ;
	public final NootParser.declaration_extention_return declaration_extention() throws RecognitionException {
		NootParser.declaration_extention_return retval = new NootParser.declaration_extention_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token COMMA13=null;
		Token IDENTIFIER14=null;
		ParserRuleReturnScope declaration_extention15 =null;

		Node COMMA13_tree=null;
		Node IDENTIFIER14_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:103:5: ( ( COMMA ^ IDENTIFIER declaration_extention )? )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:103:9: ( COMMA ^ IDENTIFIER declaration_extention )?
			{
			root_0 = (Node)adaptor.nil();


			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:103:9: ( COMMA ^ IDENTIFIER declaration_extention )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==COMMA) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:103:10: COMMA ^ IDENTIFIER declaration_extention
					{
					COMMA13=(Token)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention963); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA13_tree = new DeclarationNode(COMMA13) ;
					root_0 = (Node)adaptor.becomeRoot(COMMA13_tree, root_0);
					}

					IDENTIFIER14=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention969); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER14_tree = new IdentifierNode(IDENTIFIER14) ;
					adaptor.addChild(root_0, IDENTIFIER14_tree);
					}

					pushFollow(FOLLOW_declaration_extention_in_declaration_extention974);
					declaration_extention15=declaration_extention();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration_extention15.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration_extention"


	public static class assignment_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:106:1: assignment : IDENTIFIER BECOMES ^ assignment_extention ;
	public final NootParser.assignment_return assignment() throws RecognitionException {
		NootParser.assignment_return retval = new NootParser.assignment_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token IDENTIFIER16=null;
		Token BECOMES17=null;
		ParserRuleReturnScope assignment_extention18 =null;

		Node IDENTIFIER16_tree=null;
		Node BECOMES17_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:107:5: ( IDENTIFIER BECOMES ^ assignment_extention )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:107:9: IDENTIFIER BECOMES ^ assignment_extention
			{
			root_0 = (Node)adaptor.nil();


			IDENTIFIER16=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignment995); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER16_tree = new IdentifierNode(IDENTIFIER16) ;
			adaptor.addChild(root_0, IDENTIFIER16_tree);
			}

			BECOMES17=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_assignment1000); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BECOMES17_tree = new TypeAdoptedNode(BECOMES17) ;
			root_0 = (Node)adaptor.becomeRoot(BECOMES17_tree, root_0);
			}

			pushFollow(FOLLOW_assignment_extention_in_assignment1006);
			assignment_extention18=assignment_extention();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_extention18.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment"


	public static class assignment_extention_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "assignment_extention"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:110:1: assignment_extention : ( ( IDENTIFIER BECOMES )=> IDENTIFIER BECOMES ^ assignment_extention | expression );
	public final NootParser.assignment_extention_return assignment_extention() throws RecognitionException {
		NootParser.assignment_extention_return retval = new NootParser.assignment_extention_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token IDENTIFIER19=null;
		Token BECOMES20=null;
		ParserRuleReturnScope assignment_extention21 =null;
		ParserRuleReturnScope expression22 =null;

		Node IDENTIFIER19_tree=null;
		Node BECOMES20_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:111:5: ( ( IDENTIFIER BECOMES )=> IDENTIFIER BECOMES ^ assignment_extention | expression )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==IDENTIFIER) ) {
				int LA5_1 = input.LA(2);
				if ( (synpred1_Noot()) ) {
					alt5=1;
				}
				else if ( (true) ) {
					alt5=2;
				}

			}
			else if ( (LA5_0==CHARACTER||LA5_0==FALSE||LA5_0==IF||LA5_0==LCURLY||(LA5_0 >= LPAREN && LA5_0 <= MINUS)||LA5_0==NEGATION||LA5_0==NUMBER||LA5_0==PRINT||LA5_0==READ||LA5_0==TRUE||LA5_0==WHILE) ) {
				alt5=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:111:8: ( IDENTIFIER BECOMES )=> IDENTIFIER BECOMES ^ assignment_extention
					{
					root_0 = (Node)adaptor.nil();


					IDENTIFIER19=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignment_extention1036); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER19_tree = new IdentifierNode(IDENTIFIER19) ;
					adaptor.addChild(root_0, IDENTIFIER19_tree);
					}

					BECOMES20=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_assignment_extention1041); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BECOMES20_tree = new TypeAdoptedNode(BECOMES20) ;
					root_0 = (Node)adaptor.becomeRoot(BECOMES20_tree, root_0);
					}

					pushFollow(FOLLOW_assignment_extention_in_assignment_extention1047);
					assignment_extention21=assignment_extention();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_extention21.getTree());

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:112:8: expression
					{
					root_0 = (Node)adaptor.nil();


					pushFollow(FOLLOW_expression_in_assignment_extention1056);
					expression22=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression22.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment_extention"


	public static class expression_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:115:1: expression : ( ( IDENTIFIER BECOMES )=> assignment | while_statement | expression_level6 );
	public final NootParser.expression_return expression() throws RecognitionException {
		NootParser.expression_return retval = new NootParser.expression_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		ParserRuleReturnScope assignment23 =null;
		ParserRuleReturnScope while_statement24 =null;
		ParserRuleReturnScope expression_level625 =null;


		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:116:5: ( ( IDENTIFIER BECOMES )=> assignment | while_statement | expression_level6 )
			int alt6=3;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				int LA6_1 = input.LA(2);
				if ( (synpred2_Noot()) ) {
					alt6=1;
				}
				else if ( (true) ) {
					alt6=3;
				}

				}
				break;
			case WHILE:
				{
				alt6=2;
				}
				break;
			case CHARACTER:
			case FALSE:
			case IF:
			case LCURLY:
			case LPAREN:
			case MINUS:
			case NEGATION:
			case NUMBER:
			case PRINT:
			case READ:
			case TRUE:
				{
				alt6=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:116:9: ( IDENTIFIER BECOMES )=> assignment
					{
					root_0 = (Node)adaptor.nil();


					pushFollow(FOLLOW_assignment_in_expression1087);
					assignment23=assignment();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment23.getTree());

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:117:9: while_statement
					{
					root_0 = (Node)adaptor.nil();


					pushFollow(FOLLOW_while_statement_in_expression1097);
					while_statement24=while_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, while_statement24.getTree());

					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:118:9: expression_level6
					{
					root_0 = (Node)adaptor.nil();


					pushFollow(FOLLOW_expression_level6_in_expression1107);
					expression_level625=expression_level6();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level625.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class while_statement_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "while_statement"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:121:1: while_statement : WHILE ^ expression DO ! expression OD !;
	public final NootParser.while_statement_return while_statement() throws RecognitionException {
		NootParser.while_statement_return retval = new NootParser.while_statement_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token WHILE26=null;
		Token DO28=null;
		Token OD30=null;
		ParserRuleReturnScope expression27 =null;
		ParserRuleReturnScope expression29 =null;

		Node WHILE26_tree=null;
		Node DO28_tree=null;
		Node OD30_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:122:5: ( WHILE ^ expression DO ! expression OD !)
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:122:9: WHILE ^ expression DO ! expression OD !
			{
			root_0 = (Node)adaptor.nil();


			WHILE26=(Token)match(input,WHILE,FOLLOW_WHILE_in_while_statement1130); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			WHILE26_tree = (Node)adaptor.create(WHILE26);
			root_0 = (Node)adaptor.becomeRoot(WHILE26_tree, root_0);
			}

			pushFollow(FOLLOW_expression_in_while_statement1133);
			expression27=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression27.getTree());

			DO28=(Token)match(input,DO,FOLLOW_DO_in_while_statement1135); if (state.failed) return retval;
			pushFollow(FOLLOW_expression_in_while_statement1138);
			expression29=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression29.getTree());

			OD30=(Token)match(input,OD,FOLLOW_OD_in_while_statement1140); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "while_statement"


	public static class expression_level6_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "expression_level6"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:125:1: expression_level6 : expression_level5 ( OR ^ expression_level5 )* ;
	public final NootParser.expression_level6_return expression_level6() throws RecognitionException {
		NootParser.expression_level6_return retval = new NootParser.expression_level6_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token OR32=null;
		ParserRuleReturnScope expression_level531 =null;
		ParserRuleReturnScope expression_level533 =null;

		Node OR32_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:126:5: ( expression_level5 ( OR ^ expression_level5 )* )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:126:9: expression_level5 ( OR ^ expression_level5 )*
			{
			root_0 = (Node)adaptor.nil();


			pushFollow(FOLLOW_expression_level5_in_expression_level61165);
			expression_level531=expression_level5();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level531.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:126:27: ( OR ^ expression_level5 )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==OR) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:126:28: OR ^ expression_level5
					{
					OR32=(Token)match(input,OR,FOLLOW_OR_in_expression_level61168); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR32_tree = new BinaryExpressionNode(OR32) ;
					root_0 = (Node)adaptor.becomeRoot(OR32_tree, root_0);
					}

					pushFollow(FOLLOW_expression_level5_in_expression_level61174);
					expression_level533=expression_level5();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level533.getTree());

					}
					break;

				default :
					break loop7;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression_level6"


	public static class expression_level5_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "expression_level5"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:129:1: expression_level5 : expression_level4 ( AND ^ expression_level4 )* ;
	public final NootParser.expression_level5_return expression_level5() throws RecognitionException {
		NootParser.expression_level5_return retval = new NootParser.expression_level5_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token AND35=null;
		ParserRuleReturnScope expression_level434 =null;
		ParserRuleReturnScope expression_level436 =null;

		Node AND35_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:130:5: ( expression_level4 ( AND ^ expression_level4 )* )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:130:9: expression_level4 ( AND ^ expression_level4 )*
			{
			root_0 = (Node)adaptor.nil();


			pushFollow(FOLLOW_expression_level4_in_expression_level51199);
			expression_level434=expression_level4();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level434.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:130:27: ( AND ^ expression_level4 )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==AND) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:130:28: AND ^ expression_level4
					{
					AND35=(Token)match(input,AND,FOLLOW_AND_in_expression_level51202); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND35_tree = new BinaryExpressionNode(AND35) ;
					root_0 = (Node)adaptor.becomeRoot(AND35_tree, root_0);
					}

					pushFollow(FOLLOW_expression_level4_in_expression_level51208);
					expression_level436=expression_level4();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level436.getTree());

					}
					break;

				default :
					break loop8;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression_level5"


	public static class expression_level4_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "expression_level4"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:133:1: expression_level4 : expression_level3 ( ( LESS ^| LESSEQ ^| EQ ^| NEQ ^| MOREEQ ^| MORE ^) expression_level3 )* ;
	public final NootParser.expression_level4_return expression_level4() throws RecognitionException {
		NootParser.expression_level4_return retval = new NootParser.expression_level4_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token LESS38=null;
		Token LESSEQ39=null;
		Token EQ40=null;
		Token NEQ41=null;
		Token MOREEQ42=null;
		Token MORE43=null;
		ParserRuleReturnScope expression_level337 =null;
		ParserRuleReturnScope expression_level344 =null;

		Node LESS38_tree=null;
		Node LESSEQ39_tree=null;
		Node EQ40_tree=null;
		Node NEQ41_tree=null;
		Node MOREEQ42_tree=null;
		Node MORE43_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:134:5: ( expression_level3 ( ( LESS ^| LESSEQ ^| EQ ^| NEQ ^| MOREEQ ^| MORE ^) expression_level3 )* )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:134:9: expression_level3 ( ( LESS ^| LESSEQ ^| EQ ^| NEQ ^| MOREEQ ^| MORE ^) expression_level3 )*
			{
			root_0 = (Node)adaptor.nil();


			pushFollow(FOLLOW_expression_level3_in_expression_level41233);
			expression_level337=expression_level3();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level337.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:134:27: ( ( LESS ^| LESSEQ ^| EQ ^| NEQ ^| MOREEQ ^| MORE ^) expression_level3 )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==EQ||(LA10_0 >= LESS && LA10_0 <= LESSEQ)||(LA10_0 >= MORE && LA10_0 <= MOREEQ)||LA10_0==NEQ) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:134:28: ( LESS ^| LESSEQ ^| EQ ^| NEQ ^| MOREEQ ^| MORE ^) expression_level3
					{
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:134:28: ( LESS ^| LESSEQ ^| EQ ^| NEQ ^| MOREEQ ^| MORE ^)
					int alt9=6;
					switch ( input.LA(1) ) {
					case LESS:
						{
						alt9=1;
						}
						break;
					case LESSEQ:
						{
						alt9=2;
						}
						break;
					case EQ:
						{
						alt9=3;
						}
						break;
					case NEQ:
						{
						alt9=4;
						}
						break;
					case MOREEQ:
						{
						alt9=5;
						}
						break;
					case MORE:
						{
						alt9=6;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 9, 0, input);
						throw nvae;
					}
					switch (alt9) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:134:29: LESS ^
							{
							LESS38=(Token)match(input,LESS,FOLLOW_LESS_in_expression_level41237); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							LESS38_tree = new BinaryExpressionNode(LESS38) ;
							root_0 = (Node)adaptor.becomeRoot(LESS38_tree, root_0);
							}

							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:134:59: LESSEQ ^
							{
							LESSEQ39=(Token)match(input,LESSEQ,FOLLOW_LESSEQ_in_expression_level41245); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							LESSEQ39_tree = new BinaryExpressionNode(LESSEQ39) ;
							root_0 = (Node)adaptor.becomeRoot(LESSEQ39_tree, root_0);
							}

							}
							break;
						case 3 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:134:91: EQ ^
							{
							EQ40=(Token)match(input,EQ,FOLLOW_EQ_in_expression_level41253); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							EQ40_tree = new BinaryExpressionNode(EQ40) ;
							root_0 = (Node)adaptor.becomeRoot(EQ40_tree, root_0);
							}

							}
							break;
						case 4 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:134:119: NEQ ^
							{
							NEQ41=(Token)match(input,NEQ,FOLLOW_NEQ_in_expression_level41261); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NEQ41_tree = new BinaryExpressionNode(NEQ41) ;
							root_0 = (Node)adaptor.becomeRoot(NEQ41_tree, root_0);
							}

							}
							break;
						case 5 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:134:148: MOREEQ ^
							{
							MOREEQ42=(Token)match(input,MOREEQ,FOLLOW_MOREEQ_in_expression_level41269); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							MOREEQ42_tree = new BinaryExpressionNode(MOREEQ42) ;
							root_0 = (Node)adaptor.becomeRoot(MOREEQ42_tree, root_0);
							}

							}
							break;
						case 6 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:134:180: MORE ^
							{
							MORE43=(Token)match(input,MORE,FOLLOW_MORE_in_expression_level41277); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							MORE43_tree = new BinaryExpressionNode(MORE43) ;
							root_0 = (Node)adaptor.becomeRoot(MORE43_tree, root_0);
							}

							}
							break;

					}

					pushFollow(FOLLOW_expression_level3_in_expression_level41284);
					expression_level344=expression_level3();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level344.getTree());

					}
					break;

				default :
					break loop10;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression_level4"


	public static class expression_level3_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "expression_level3"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:137:1: expression_level3 : expression_level2 ( ( PLUS ^| MINUS ^) expression_level2 )* ;
	public final NootParser.expression_level3_return expression_level3() throws RecognitionException {
		NootParser.expression_level3_return retval = new NootParser.expression_level3_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token PLUS46=null;
		Token MINUS47=null;
		ParserRuleReturnScope expression_level245 =null;
		ParserRuleReturnScope expression_level248 =null;

		Node PLUS46_tree=null;
		Node MINUS47_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:138:5: ( expression_level2 ( ( PLUS ^| MINUS ^) expression_level2 )* )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:138:9: expression_level2 ( ( PLUS ^| MINUS ^) expression_level2 )*
			{
			root_0 = (Node)adaptor.nil();


			pushFollow(FOLLOW_expression_level2_in_expression_level31310);
			expression_level245=expression_level2();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level245.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:138:27: ( ( PLUS ^| MINUS ^) expression_level2 )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==MINUS||LA12_0==PLUS) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:138:28: ( PLUS ^| MINUS ^) expression_level2
					{
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:138:28: ( PLUS ^| MINUS ^)
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==PLUS) ) {
						alt11=1;
					}
					else if ( (LA11_0==MINUS) ) {
						alt11=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						throw nvae;
					}

					switch (alt11) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:138:29: PLUS ^
							{
							PLUS46=(Token)match(input,PLUS,FOLLOW_PLUS_in_expression_level31314); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							PLUS46_tree = new NumericalExpressionNode(PLUS46) ;
							root_0 = (Node)adaptor.becomeRoot(PLUS46_tree, root_0);
							}

							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:138:62: MINUS ^
							{
							MINUS47=(Token)match(input,MINUS,FOLLOW_MINUS_in_expression_level31322); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							MINUS47_tree = new NumericalExpressionNode(MINUS47) ;
							root_0 = (Node)adaptor.becomeRoot(MINUS47_tree, root_0);
							}

							}
							break;

					}

					pushFollow(FOLLOW_expression_level2_in_expression_level31329);
					expression_level248=expression_level2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level248.getTree());

					}
					break;

				default :
					break loop12;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression_level3"


	public static class expression_level2_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "expression_level2"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:141:1: expression_level2 : expression_level1 ( ( MULTIPLY ^| DEVIDE ^| MODULO ^) expression_level1 )* ;
	public final NootParser.expression_level2_return expression_level2() throws RecognitionException {
		NootParser.expression_level2_return retval = new NootParser.expression_level2_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token MULTIPLY50=null;
		Token DEVIDE51=null;
		Token MODULO52=null;
		ParserRuleReturnScope expression_level149 =null;
		ParserRuleReturnScope expression_level153 =null;

		Node MULTIPLY50_tree=null;
		Node DEVIDE51_tree=null;
		Node MODULO52_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:142:5: ( expression_level1 ( ( MULTIPLY ^| DEVIDE ^| MODULO ^) expression_level1 )* )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:142:9: expression_level1 ( ( MULTIPLY ^| DEVIDE ^| MODULO ^) expression_level1 )*
			{
			root_0 = (Node)adaptor.nil();


			pushFollow(FOLLOW_expression_level1_in_expression_level21356);
			expression_level149=expression_level1();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level149.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:142:27: ( ( MULTIPLY ^| DEVIDE ^| MODULO ^) expression_level1 )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==DEVIDE||LA14_0==MODULO||LA14_0==MULTIPLY) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:142:28: ( MULTIPLY ^| DEVIDE ^| MODULO ^) expression_level1
					{
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:142:28: ( MULTIPLY ^| DEVIDE ^| MODULO ^)
					int alt13=3;
					switch ( input.LA(1) ) {
					case MULTIPLY:
						{
						alt13=1;
						}
						break;
					case DEVIDE:
						{
						alt13=2;
						}
						break;
					case MODULO:
						{
						alt13=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 13, 0, input);
						throw nvae;
					}
					switch (alt13) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:142:29: MULTIPLY ^
							{
							MULTIPLY50=(Token)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression_level21360); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							MULTIPLY50_tree = new NumericalExpressionNode(MULTIPLY50) ;
							root_0 = (Node)adaptor.becomeRoot(MULTIPLY50_tree, root_0);
							}

							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:142:66: DEVIDE ^
							{
							DEVIDE51=(Token)match(input,DEVIDE,FOLLOW_DEVIDE_in_expression_level21368); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DEVIDE51_tree = new NumericalExpressionNode(DEVIDE51) ;
							root_0 = (Node)adaptor.becomeRoot(DEVIDE51_tree, root_0);
							}

							}
							break;
						case 3 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:142:101: MODULO ^
							{
							MODULO52=(Token)match(input,MODULO,FOLLOW_MODULO_in_expression_level21376); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							MODULO52_tree = new NumericalExpressionNode(MODULO52) ;
							root_0 = (Node)adaptor.becomeRoot(MODULO52_tree, root_0);
							}

							}
							break;

					}

					pushFollow(FOLLOW_expression_level1_in_expression_level21383);
					expression_level153=expression_level1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level153.getTree());

					}
					break;

				default :
					break loop14;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression_level2"


	public static class expression_level1_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "expression_level1"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:145:1: expression_level1 : ( MINUS ^| NEGATION ^)? operand ;
	public final NootParser.expression_level1_return expression_level1() throws RecognitionException {
		NootParser.expression_level1_return retval = new NootParser.expression_level1_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token MINUS54=null;
		Token NEGATION55=null;
		ParserRuleReturnScope operand56 =null;

		Node MINUS54_tree=null;
		Node NEGATION55_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:146:5: ( ( MINUS ^| NEGATION ^)? operand )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:146:9: ( MINUS ^| NEGATION ^)? operand
			{
			root_0 = (Node)adaptor.nil();


			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:146:9: ( MINUS ^| NEGATION ^)?
			int alt15=3;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==MINUS) ) {
				alt15=1;
			}
			else if ( (LA15_0==NEGATION) ) {
				alt15=2;
			}
			switch (alt15) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:146:10: MINUS ^
					{
					MINUS54=(Token)match(input,MINUS,FOLLOW_MINUS_in_expression_level11411); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS54_tree = new NumericalExpressionNode(MINUS54) ;
					root_0 = (Node)adaptor.becomeRoot(MINUS54_tree, root_0);
					}

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:146:44: NEGATION ^
					{
					NEGATION55=(Token)match(input,NEGATION,FOLLOW_NEGATION_in_expression_level11419); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NEGATION55_tree = new BinaryExpressionNode(NEGATION55) ;
					root_0 = (Node)adaptor.becomeRoot(NEGATION55_tree, root_0);
					}

					}
					break;

			}

			pushFollow(FOLLOW_operand_in_expression_level11427);
			operand56=operand();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, operand56.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression_level1"


	public static class operand_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "operand"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:149:1: operand : ( ( TRUE | FALSE ) | IDENTIFIER | NUMBER | CHARACTER | LPAREN ! expression RPAREN !| print_statement | read_statement | compound_expression | if_statement );
	public final NootParser.operand_return operand() throws RecognitionException {
		NootParser.operand_return retval = new NootParser.operand_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token TRUE57=null;
		Token FALSE58=null;
		Token IDENTIFIER59=null;
		Token NUMBER60=null;
		Token CHARACTER61=null;
		Token LPAREN62=null;
		Token RPAREN64=null;
		ParserRuleReturnScope expression63 =null;
		ParserRuleReturnScope print_statement65 =null;
		ParserRuleReturnScope read_statement66 =null;
		ParserRuleReturnScope compound_expression67 =null;
		ParserRuleReturnScope if_statement68 =null;

		Node TRUE57_tree=null;
		Node FALSE58_tree=null;
		Node IDENTIFIER59_tree=null;
		Node NUMBER60_tree=null;
		Node CHARACTER61_tree=null;
		Node LPAREN62_tree=null;
		Node RPAREN64_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:150:5: ( ( TRUE | FALSE ) | IDENTIFIER | NUMBER | CHARACTER | LPAREN ! expression RPAREN !| print_statement | read_statement | compound_expression | if_statement )
			int alt17=9;
			switch ( input.LA(1) ) {
			case FALSE:
			case TRUE:
				{
				alt17=1;
				}
				break;
			case IDENTIFIER:
				{
				alt17=2;
				}
				break;
			case NUMBER:
				{
				alt17=3;
				}
				break;
			case CHARACTER:
				{
				alt17=4;
				}
				break;
			case LPAREN:
				{
				alt17=5;
				}
				break;
			case PRINT:
				{
				alt17=6;
				}
				break;
			case READ:
				{
				alt17=7;
				}
				break;
			case LCURLY:
				{
				alt17=8;
				}
				break;
			case IF:
				{
				alt17=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:150:9: ( TRUE | FALSE )
					{
					root_0 = (Node)adaptor.nil();


					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:150:9: ( TRUE | FALSE )
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==TRUE) ) {
						alt16=1;
					}
					else if ( (LA16_0==FALSE) ) {
						alt16=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						throw nvae;
					}

					switch (alt16) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:150:10: TRUE
							{
							TRUE57=(Token)match(input,TRUE,FOLLOW_TRUE_in_operand1448); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							TRUE57_tree = new BinaryExpressionNode(TRUE57) ;
							adaptor.addChild(root_0, TRUE57_tree);
							}

							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:150:39: FALSE
							{
							FALSE58=(Token)match(input,FALSE,FOLLOW_FALSE_in_operand1455); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							FALSE58_tree = new BinaryExpressionNode(FALSE58) ;
							adaptor.addChild(root_0, FALSE58_tree);
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:151:9: IDENTIFIER
					{
					root_0 = (Node)adaptor.nil();


					IDENTIFIER59=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand1469); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER59_tree = new IdentifierNode(IDENTIFIER59) ;
					adaptor.addChild(root_0, IDENTIFIER59_tree);
					}

					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:152:9: NUMBER
					{
					root_0 = (Node)adaptor.nil();


					NUMBER60=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_operand1482); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER60_tree = new NumericalExpressionNode(NUMBER60) ;
					adaptor.addChild(root_0, NUMBER60_tree);
					}

					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:153:9: CHARACTER
					{
					root_0 = (Node)adaptor.nil();


					CHARACTER61=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_operand1495); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CHARACTER61_tree = new CharacterNode(CHARACTER61) ;
					adaptor.addChild(root_0, CHARACTER61_tree);
					}

					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:154:9: LPAREN ! expression RPAREN !
					{
					root_0 = (Node)adaptor.nil();


					LPAREN62=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_operand1508); if (state.failed) return retval;
					pushFollow(FOLLOW_expression_in_operand1511);
					expression63=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression63.getTree());

					RPAREN64=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_operand1513); if (state.failed) return retval;
					}
					break;
				case 6 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:155:9: print_statement
					{
					root_0 = (Node)adaptor.nil();


					pushFollow(FOLLOW_print_statement_in_operand1524);
					print_statement65=print_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, print_statement65.getTree());

					}
					break;
				case 7 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:156:9: read_statement
					{
					root_0 = (Node)adaptor.nil();


					pushFollow(FOLLOW_read_statement_in_operand1534);
					read_statement66=read_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, read_statement66.getTree());

					}
					break;
				case 8 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:157:9: compound_expression
					{
					root_0 = (Node)adaptor.nil();


					pushFollow(FOLLOW_compound_expression_in_operand1544);
					compound_expression67=compound_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, compound_expression67.getTree());

					}
					break;
				case 9 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:158:9: if_statement
					{
					root_0 = (Node)adaptor.nil();


					pushFollow(FOLLOW_if_statement_in_operand1554);
					if_statement68=if_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, if_statement68.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "operand"


	public static class print_statement_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "print_statement"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:161:1: print_statement : PRINT ^ LPAREN ! expression ( COMMA ! expression )* RPAREN !;
	public final NootParser.print_statement_return print_statement() throws RecognitionException {
		NootParser.print_statement_return retval = new NootParser.print_statement_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token PRINT69=null;
		Token LPAREN70=null;
		Token COMMA72=null;
		Token RPAREN74=null;
		ParserRuleReturnScope expression71 =null;
		ParserRuleReturnScope expression73 =null;

		Node PRINT69_tree=null;
		Node LPAREN70_tree=null;
		Node COMMA72_tree=null;
		Node RPAREN74_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:162:5: ( PRINT ^ LPAREN ! expression ( COMMA ! expression )* RPAREN !)
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:162:9: PRINT ^ LPAREN ! expression ( COMMA ! expression )* RPAREN !
			{
			root_0 = (Node)adaptor.nil();


			PRINT69=(Token)match(input,PRINT,FOLLOW_PRINT_in_print_statement1577); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			PRINT69_tree = new TypeAdoptedNode(PRINT69) ;
			root_0 = (Node)adaptor.becomeRoot(PRINT69_tree, root_0);
			}

			LPAREN70=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_print_statement1583); if (state.failed) return retval;
			pushFollow(FOLLOW_expression_in_print_statement1586);
			expression71=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression71.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:162:52: ( COMMA ! expression )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==COMMA) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:162:53: COMMA ! expression
					{
					COMMA72=(Token)match(input,COMMA,FOLLOW_COMMA_in_print_statement1589); if (state.failed) return retval;
					pushFollow(FOLLOW_expression_in_print_statement1592);
					expression73=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression73.getTree());

					}
					break;

				default :
					break loop18;
				}
			}

			RPAREN74=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_print_statement1596); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "print_statement"


	public static class read_statement_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "read_statement"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:165:1: read_statement : READ ^ LPAREN ! IDENTIFIER ( COMMA ! IDENTIFIER )* RPAREN !;
	public final NootParser.read_statement_return read_statement() throws RecognitionException {
		NootParser.read_statement_return retval = new NootParser.read_statement_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token READ75=null;
		Token LPAREN76=null;
		Token IDENTIFIER77=null;
		Token COMMA78=null;
		Token IDENTIFIER79=null;
		Token RPAREN80=null;

		Node READ75_tree=null;
		Node LPAREN76_tree=null;
		Node IDENTIFIER77_tree=null;
		Node COMMA78_tree=null;
		Node IDENTIFIER79_tree=null;
		Node RPAREN80_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:166:5: ( READ ^ LPAREN ! IDENTIFIER ( COMMA ! IDENTIFIER )* RPAREN !)
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:166:9: READ ^ LPAREN ! IDENTIFIER ( COMMA ! IDENTIFIER )* RPAREN !
			{
			root_0 = (Node)adaptor.nil();


			READ75=(Token)match(input,READ,FOLLOW_READ_in_read_statement1621); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			READ75_tree = new TypeAdoptedNode(READ75) ;
			root_0 = (Node)adaptor.becomeRoot(READ75_tree, root_0);
			}

			LPAREN76=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_read_statement1627); if (state.failed) return retval;
			IDENTIFIER77=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_read_statement1630); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER77_tree = new IdentifierNode(IDENTIFIER77) ;
			adaptor.addChild(root_0, IDENTIFIER77_tree);
			}

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:166:67: ( COMMA ! IDENTIFIER )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==COMMA) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:166:68: COMMA ! IDENTIFIER
					{
					COMMA78=(Token)match(input,COMMA,FOLLOW_COMMA_in_read_statement1636); if (state.failed) return retval;
					IDENTIFIER79=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_read_statement1639); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER79_tree = new IdentifierNode(IDENTIFIER79) ;
					adaptor.addChild(root_0, IDENTIFIER79_tree);
					}

					}
					break;

				default :
					break loop19;
				}
			}

			RPAREN80=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_read_statement1646); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "read_statement"


	public static class compound_expression_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "compound_expression"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:169:1: compound_expression : LCURLY ^ ( command )* RCURLY !;
	public final NootParser.compound_expression_return compound_expression() throws RecognitionException {
		NootParser.compound_expression_return retval = new NootParser.compound_expression_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token LCURLY81=null;
		Token RCURLY83=null;
		ParserRuleReturnScope command82 =null;

		Node LCURLY81_tree=null;
		Node RCURLY83_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:170:5: ( LCURLY ^ ( command )* RCURLY !)
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:170:9: LCURLY ^ ( command )* RCURLY !
			{
			root_0 = (Node)adaptor.nil();


			LCURLY81=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_compound_expression1670); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LCURLY81_tree = new TypeAdoptedNode(LCURLY81) ;
			root_0 = (Node)adaptor.becomeRoot(LCURLY81_tree, root_0);
			}

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:170:34: ( command )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( ((LA20_0 >= BOOL && LA20_0 <= CHARACTER)||LA20_0==FALSE||(LA20_0 >= IDENTIFIER && LA20_0 <= LCURLY)||(LA20_0 >= LPAREN && LA20_0 <= MINUS)||LA20_0==NEGATION||LA20_0==NUMBER||LA20_0==PRINT||LA20_0==READ||LA20_0==TRUE||LA20_0==WHILE) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:170:34: command
					{
					pushFollow(FOLLOW_command_in_compound_expression1676);
					command82=command();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, command82.getTree());

					}
					break;

				default :
					break loop20;
				}
			}

			RCURLY83=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_compound_expression1679); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "compound_expression"


	public static class if_statement_return extends ParserRuleReturnScope {
		Node tree;
		@Override
		public Node getTree() { return tree; }
	};


	// $ANTLR start "if_statement"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:173:1: if_statement : IF ^ expression THEN ! expression ( ELSE ! expression )? FI !;
	public final NootParser.if_statement_return if_statement() throws RecognitionException {
		NootParser.if_statement_return retval = new NootParser.if_statement_return();
		retval.start = input.LT(1);

		Node root_0 = null;

		Token IF84=null;
		Token THEN86=null;
		Token ELSE88=null;
		Token FI90=null;
		ParserRuleReturnScope expression85 =null;
		ParserRuleReturnScope expression87 =null;
		ParserRuleReturnScope expression89 =null;

		Node IF84_tree=null;
		Node THEN86_tree=null;
		Node ELSE88_tree=null;
		Node FI90_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:174:5: ( IF ^ expression THEN ! expression ( ELSE ! expression )? FI !)
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:174:9: IF ^ expression THEN ! expression ( ELSE ! expression )? FI !
			{
			root_0 = (Node)adaptor.nil();


			IF84=(Token)match(input,IF,FOLLOW_IF_in_if_statement1700); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IF84_tree = new TypeAdoptedNode(IF84) ;
			root_0 = (Node)adaptor.becomeRoot(IF84_tree, root_0);
			}

			pushFollow(FOLLOW_expression_in_if_statement1706);
			expression85=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression85.getTree());

			THEN86=(Token)match(input,THEN,FOLLOW_THEN_in_if_statement1708); if (state.failed) return retval;
			pushFollow(FOLLOW_expression_in_if_statement1711);
			expression87=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression87.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:174:58: ( ELSE ! expression )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==ELSE) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:174:59: ELSE ! expression
					{
					ELSE88=(Token)match(input,ELSE,FOLLOW_ELSE_in_if_statement1714); if (state.failed) return retval;
					pushFollow(FOLLOW_expression_in_if_statement1717);
					expression89=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression89.getTree());

					}
					break;

			}

			FI90=(Token)match(input,FI,FOLLOW_FI_in_if_statement1721); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Node)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Node)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "if_statement"

	// $ANTLR start synpred1_Noot
	public final void synpred1_Noot_fragment() throws RecognitionException {
		// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:111:8: ( IDENTIFIER BECOMES )
		// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:111:9: IDENTIFIER BECOMES
		{
		match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred1_Noot1029); if (state.failed) return;

		match(input,BECOMES,FOLLOW_BECOMES_in_synpred1_Noot1031); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_Noot

	// $ANTLR start synpred2_Noot
	public final void synpred2_Noot_fragment() throws RecognitionException {
		// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:116:9: ( IDENTIFIER BECOMES )
		// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:116:10: IDENTIFIER BECOMES
		{
		match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred2_Noot1080); if (state.failed) return;

		match(input,BECOMES,FOLLOW_BECOMES_in_synpred2_Noot1082); if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_Noot

	// Delegated rules

	public final boolean synpred2_Noot() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_Noot_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_Noot() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_Noot_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_NOOT_in_program843 = new BitSet(new long[]{0x00014512187A0380L});
	public static final BitSet FOLLOW_command_in_program846 = new BitSet(new long[]{0x00014512187A0380L});
	public static final BitSet FOLLOW_EOF_in_program849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_in_command872 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_command874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_command884 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_command886 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_declaration911 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_CHAR_in_declaration919 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_BOOL_in_declaration927 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration934 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration939 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention963 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention969 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_assignment995 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BECOMES_in_assignment1000 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_assignment_extention_in_assignment1006 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_assignment_extention1036 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BECOMES_in_assignment_extention1041 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_assignment_extention_in_assignment_extention1047 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_assignment_extention1056 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_expression1087 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_statement_in_expression1097 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_level6_in_expression1107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_while_statement1130 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_while_statement1133 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_in_while_statement1135 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_while_statement1138 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_OD_in_while_statement1140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_level5_in_expression_level61165 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_OR_in_expression_level61168 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_expression_level5_in_expression_level61174 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_expression_level4_in_expression_level51199 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_AND_in_expression_level51202 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_expression_level4_in_expression_level51208 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_expression_level3_in_expression_level41233 = new BitSet(new long[]{0x00000004C1810002L});
	public static final BitSet FOLLOW_LESS_in_expression_level41237 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_LESSEQ_in_expression_level41245 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_EQ_in_expression_level41253 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_NEQ_in_expression_level41261 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_MOREEQ_in_expression_level41269 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_MORE_in_expression_level41277 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_expression_level3_in_expression_level41284 = new BitSet(new long[]{0x00000004C1810002L});
	public static final BitSet FOLLOW_expression_level2_in_expression_level31310 = new BitSet(new long[]{0x0000008010000002L});
	public static final BitSet FOLLOW_PLUS_in_expression_level31314 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_MINUS_in_expression_level31322 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_expression_level2_in_expression_level31329 = new BitSet(new long[]{0x0000008010000002L});
	public static final BitSet FOLLOW_expression_level1_in_expression_level21356 = new BitSet(new long[]{0x0000000120001002L});
	public static final BitSet FOLLOW_MULTIPLY_in_expression_level21360 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_DEVIDE_in_expression_level21368 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_MODULO_in_expression_level21376 = new BitSet(new long[]{0x00004512185A0200L});
	public static final BitSet FOLLOW_expression_level1_in_expression_level21383 = new BitSet(new long[]{0x0000000120001002L});
	public static final BitSet FOLLOW_MINUS_in_expression_level11411 = new BitSet(new long[]{0x00004510085A0200L});
	public static final BitSet FOLLOW_NEGATION_in_expression_level11419 = new BitSet(new long[]{0x00004510085A0200L});
	public static final BitSet FOLLOW_operand_in_expression_level11427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_operand1448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_operand1455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand1469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand1482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_operand1495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_operand1508 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_operand1511 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RPAREN_in_operand1513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_statement_in_operand1524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_statement_in_operand1534 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compound_expression_in_operand1544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_statement_in_operand1554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_print_statement1577 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAREN_in_print_statement1583 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_print_statement1586 = new BitSet(new long[]{0x0000080000000400L});
	public static final BitSet FOLLOW_COMMA_in_print_statement1589 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_print_statement1592 = new BitSet(new long[]{0x0000080000000400L});
	public static final BitSet FOLLOW_RPAREN_in_print_statement1596 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_READ_in_read_statement1621 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAREN_in_read_statement1627 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_read_statement1630 = new BitSet(new long[]{0x0000080000000400L});
	public static final BitSet FOLLOW_COMMA_in_read_statement1636 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_read_statement1639 = new BitSet(new long[]{0x0000080000000400L});
	public static final BitSet FOLLOW_RPAREN_in_read_statement1646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LCURLY_in_compound_expression1670 = new BitSet(new long[]{0x00014712187A0380L});
	public static final BitSet FOLLOW_command_in_compound_expression1676 = new BitSet(new long[]{0x00014712187A0380L});
	public static final BitSet FOLLOW_RCURLY_in_compound_expression1679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_if_statement1700 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_if_statement1706 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_THEN_in_if_statement1708 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_if_statement1711 = new BitSet(new long[]{0x0000000000048000L});
	public static final BitSet FOLLOW_ELSE_in_if_statement1714 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_if_statement1717 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_FI_in_if_statement1721 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_synpred1_Noot1029 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BECOMES_in_synpred1_Noot1031 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_synpred2_Noot1080 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BECOMES_in_synpred2_Noot1082 = new BitSet(new long[]{0x0000000000000002L});
}
