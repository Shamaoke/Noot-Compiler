// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/compiler/Noot.g 2013-07-04 12:03:42

  package noot.compiler;


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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:71:1: program : NOOT ^ ( command )+ EOF ;
	public final NootParser.program_return program() throws RecognitionException {
		NootParser.program_return retval = new NootParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NOOT1=null;
		Token EOF3=null;
		ParserRuleReturnScope command2 =null;

		Object NOOT1_tree=null;
		Object EOF3_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:72:5: ( NOOT ^ ( command )+ EOF )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:72:7: NOOT ^ ( command )+ EOF
			{
			root_0 = (Object)adaptor.nil();


			NOOT1=(Token)match(input,NOOT,FOLLOW_NOOT_in_program831); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NOOT1_tree = (Object)adaptor.create(NOOT1);
			root_0 = (Object)adaptor.becomeRoot(NOOT1_tree, root_0);
			}

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:72:13: ( command )+
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:72:13: command
					{
					pushFollow(FOLLOW_command_in_program834);
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

			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_program837); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EOF3_tree = (Object)adaptor.create(EOF3);
			adaptor.addChild(root_0, EOF3_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class command_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "command"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:75:1: command : ( declaration SEMICOLON !| expression SEMICOLON !);
	public final NootParser.command_return command() throws RecognitionException {
		NootParser.command_return retval = new NootParser.command_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SEMICOLON5=null;
		Token SEMICOLON7=null;
		ParserRuleReturnScope declaration4 =null;
		ParserRuleReturnScope expression6 =null;

		Object SEMICOLON5_tree=null;
		Object SEMICOLON7_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:76:5: ( declaration SEMICOLON !| expression SEMICOLON !)
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:76:8: declaration SEMICOLON !
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_declaration_in_command859);
					declaration4=declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration4.getTree());

					SEMICOLON5=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_command861); if (state.failed) return retval;
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:77:8: expression SEMICOLON !
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expression_in_command871);
					expression6=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression6.getTree());

					SEMICOLON7=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_command873); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "command"


	public static class declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declaration"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:80:1: declaration : ( INT ^| CHAR ^| BOOL ^) IDENTIFIER declaration_extention ;
	public final NootParser.declaration_return declaration() throws RecognitionException {
		NootParser.declaration_return retval = new NootParser.declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INT8=null;
		Token CHAR9=null;
		Token BOOL10=null;
		Token IDENTIFIER11=null;
		ParserRuleReturnScope declaration_extention12 =null;

		Object INT8_tree=null;
		Object CHAR9_tree=null;
		Object BOOL10_tree=null;
		Object IDENTIFIER11_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:81:5: ( ( INT ^| CHAR ^| BOOL ^) IDENTIFIER declaration_extention )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:81:9: ( INT ^| CHAR ^| BOOL ^) IDENTIFIER declaration_extention
			{
			root_0 = (Object)adaptor.nil();


			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:81:9: ( INT ^| CHAR ^| BOOL ^)
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:81:10: INT ^
					{
					INT8=(Token)match(input,INT,FOLLOW_INT_in_declaration898); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT8_tree = (Object)adaptor.create(INT8);
					root_0 = (Object)adaptor.becomeRoot(INT8_tree, root_0);
					}

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:81:17: CHAR ^
					{
					CHAR9=(Token)match(input,CHAR,FOLLOW_CHAR_in_declaration903); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CHAR9_tree = (Object)adaptor.create(CHAR9);
					root_0 = (Object)adaptor.becomeRoot(CHAR9_tree, root_0);
					}

					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:81:25: BOOL ^
					{
					BOOL10=(Token)match(input,BOOL,FOLLOW_BOOL_in_declaration908); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BOOL10_tree = (Object)adaptor.create(BOOL10);
					root_0 = (Object)adaptor.becomeRoot(BOOL10_tree, root_0);
					}

					}
					break;

			}

			IDENTIFIER11=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration912); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER11_tree = (Object)adaptor.create(IDENTIFIER11);
			adaptor.addChild(root_0, IDENTIFIER11_tree);
			}

			pushFollow(FOLLOW_declaration_extention_in_declaration914);
			declaration_extention12=declaration_extention();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration_extention12.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration"


	public static class declaration_extention_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declaration_extention"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:84:1: declaration_extention : ( COMMA ^ IDENTIFIER declaration_extention )? ;
	public final NootParser.declaration_extention_return declaration_extention() throws RecognitionException {
		NootParser.declaration_extention_return retval = new NootParser.declaration_extention_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA13=null;
		Token IDENTIFIER14=null;
		ParserRuleReturnScope declaration_extention15 =null;

		Object COMMA13_tree=null;
		Object IDENTIFIER14_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:85:5: ( ( COMMA ^ IDENTIFIER declaration_extention )? )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:85:9: ( COMMA ^ IDENTIFIER declaration_extention )?
			{
			root_0 = (Object)adaptor.nil();


			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:85:9: ( COMMA ^ IDENTIFIER declaration_extention )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==COMMA) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:85:10: COMMA ^ IDENTIFIER declaration_extention
					{
					COMMA13=(Token)match(input,COMMA,FOLLOW_COMMA_in_declaration_extention938); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA13_tree = (Object)adaptor.create(COMMA13);
					root_0 = (Object)adaptor.becomeRoot(COMMA13_tree, root_0);
					}

					IDENTIFIER14=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration_extention941); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER14_tree = (Object)adaptor.create(IDENTIFIER14);
					adaptor.addChild(root_0, IDENTIFIER14_tree);
					}

					pushFollow(FOLLOW_declaration_extention_in_declaration_extention943);
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
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration_extention"


	public static class assignment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:88:1: assignment : IDENTIFIER BECOMES ^ assignment_extention ;
	public final NootParser.assignment_return assignment() throws RecognitionException {
		NootParser.assignment_return retval = new NootParser.assignment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IDENTIFIER16=null;
		Token BECOMES17=null;
		ParserRuleReturnScope assignment_extention18 =null;

		Object IDENTIFIER16_tree=null;
		Object BECOMES17_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:89:5: ( IDENTIFIER BECOMES ^ assignment_extention )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:89:9: IDENTIFIER BECOMES ^ assignment_extention
			{
			root_0 = (Object)adaptor.nil();


			IDENTIFIER16=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignment964); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER16_tree = (Object)adaptor.create(IDENTIFIER16);
			adaptor.addChild(root_0, IDENTIFIER16_tree);
			}

			BECOMES17=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_assignment966); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BECOMES17_tree = (Object)adaptor.create(BECOMES17);
			root_0 = (Object)adaptor.becomeRoot(BECOMES17_tree, root_0);
			}

			pushFollow(FOLLOW_assignment_extention_in_assignment969);
			assignment_extention18=assignment_extention();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_extention18.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment"


	public static class assignment_extention_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignment_extention"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:92:1: assignment_extention : ( ( IDENTIFIER BECOMES )=> IDENTIFIER BECOMES ^ assignment_extention | expression );
	public final NootParser.assignment_extention_return assignment_extention() throws RecognitionException {
		NootParser.assignment_extention_return retval = new NootParser.assignment_extention_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IDENTIFIER19=null;
		Token BECOMES20=null;
		ParserRuleReturnScope assignment_extention21 =null;
		ParserRuleReturnScope expression22 =null;

		Object IDENTIFIER19_tree=null;
		Object BECOMES20_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:93:5: ( ( IDENTIFIER BECOMES )=> IDENTIFIER BECOMES ^ assignment_extention | expression )
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:93:8: ( IDENTIFIER BECOMES )=> IDENTIFIER BECOMES ^ assignment_extention
					{
					root_0 = (Object)adaptor.nil();


					IDENTIFIER19=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignment_extention999); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER19_tree = (Object)adaptor.create(IDENTIFIER19);
					adaptor.addChild(root_0, IDENTIFIER19_tree);
					}

					BECOMES20=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_assignment_extention1001); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BECOMES20_tree = (Object)adaptor.create(BECOMES20);
					root_0 = (Object)adaptor.becomeRoot(BECOMES20_tree, root_0);
					}

					pushFollow(FOLLOW_assignment_extention_in_assignment_extention1004);
					assignment_extention21=assignment_extention();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_extention21.getTree());

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:94:8: expression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expression_in_assignment_extention1013);
					expression22=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression22.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment_extention"


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:97:1: expression : ( ( IDENTIFIER BECOMES )=> assignment | print_statement | read_statement | while_statement | if_statement | expression_level6 );
	public final NootParser.expression_return expression() throws RecognitionException {
		NootParser.expression_return retval = new NootParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope assignment23 =null;
		ParserRuleReturnScope print_statement24 =null;
		ParserRuleReturnScope read_statement25 =null;
		ParserRuleReturnScope while_statement26 =null;
		ParserRuleReturnScope if_statement27 =null;
		ParserRuleReturnScope expression_level628 =null;


		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:98:5: ( ( IDENTIFIER BECOMES )=> assignment | print_statement | read_statement | while_statement | if_statement | expression_level6 )
			int alt6=6;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				int LA6_1 = input.LA(2);
				if ( (synpred2_Noot()) ) {
					alt6=1;
				}
				else if ( (true) ) {
					alt6=6;
				}

				}
				break;
			case PRINT:
				{
				alt6=2;
				}
				break;
			case READ:
				{
				alt6=3;
				}
				break;
			case WHILE:
				{
				alt6=4;
				}
				break;
			case IF:
				{
				alt6=5;
				}
				break;
			case CHARACTER:
			case FALSE:
			case LCURLY:
			case LPAREN:
			case MINUS:
			case NEGATION:
			case NUMBER:
			case TRUE:
				{
				alt6=6;
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
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:98:9: ( IDENTIFIER BECOMES )=> assignment
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_assignment_in_expression1044);
					assignment23=assignment();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment23.getTree());

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:99:9: print_statement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_print_statement_in_expression1054);
					print_statement24=print_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, print_statement24.getTree());

					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:100:9: read_statement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_read_statement_in_expression1064);
					read_statement25=read_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, read_statement25.getTree());

					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:101:9: while_statement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_while_statement_in_expression1074);
					while_statement26=while_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, while_statement26.getTree());

					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:102:9: if_statement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_if_statement_in_expression1084);
					if_statement27=if_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, if_statement27.getTree());

					}
					break;
				case 6 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:103:9: expression_level6
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expression_level6_in_expression1094);
					expression_level628=expression_level6();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level628.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class print_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "print_statement"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:106:1: print_statement : PRINT ^ LPAREN ! expression ( COMMA ! expression )* RPAREN !;
	public final NootParser.print_statement_return print_statement() throws RecognitionException {
		NootParser.print_statement_return retval = new NootParser.print_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PRINT29=null;
		Token LPAREN30=null;
		Token COMMA32=null;
		Token RPAREN34=null;
		ParserRuleReturnScope expression31 =null;
		ParserRuleReturnScope expression33 =null;

		Object PRINT29_tree=null;
		Object LPAREN30_tree=null;
		Object COMMA32_tree=null;
		Object RPAREN34_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:107:5: ( PRINT ^ LPAREN ! expression ( COMMA ! expression )* RPAREN !)
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:107:9: PRINT ^ LPAREN ! expression ( COMMA ! expression )* RPAREN !
			{
			root_0 = (Object)adaptor.nil();


			PRINT29=(Token)match(input,PRINT,FOLLOW_PRINT_in_print_statement1113); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			PRINT29_tree = (Object)adaptor.create(PRINT29);
			root_0 = (Object)adaptor.becomeRoot(PRINT29_tree, root_0);
			}

			LPAREN30=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_print_statement1116); if (state.failed) return retval;
			pushFollow(FOLLOW_expression_in_print_statement1119);
			expression31=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression31.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:107:35: ( COMMA ! expression )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==COMMA) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:107:36: COMMA ! expression
					{
					COMMA32=(Token)match(input,COMMA,FOLLOW_COMMA_in_print_statement1122); if (state.failed) return retval;
					pushFollow(FOLLOW_expression_in_print_statement1125);
					expression33=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression33.getTree());

					}
					break;

				default :
					break loop7;
				}
			}

			RPAREN34=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_print_statement1129); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "print_statement"


	public static class read_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "read_statement"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:110:1: read_statement : READ ^ LPAREN ! expression ( COMMA ! expression )* RPAREN !;
	public final NootParser.read_statement_return read_statement() throws RecognitionException {
		NootParser.read_statement_return retval = new NootParser.read_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token READ35=null;
		Token LPAREN36=null;
		Token COMMA38=null;
		Token RPAREN40=null;
		ParserRuleReturnScope expression37 =null;
		ParserRuleReturnScope expression39 =null;

		Object READ35_tree=null;
		Object LPAREN36_tree=null;
		Object COMMA38_tree=null;
		Object RPAREN40_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:111:5: ( READ ^ LPAREN ! expression ( COMMA ! expression )* RPAREN !)
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:111:9: READ ^ LPAREN ! expression ( COMMA ! expression )* RPAREN !
			{
			root_0 = (Object)adaptor.nil();


			READ35=(Token)match(input,READ,FOLLOW_READ_in_read_statement1154); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			READ35_tree = (Object)adaptor.create(READ35);
			root_0 = (Object)adaptor.becomeRoot(READ35_tree, root_0);
			}

			LPAREN36=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_read_statement1157); if (state.failed) return retval;
			pushFollow(FOLLOW_expression_in_read_statement1160);
			expression37=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression37.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:111:34: ( COMMA ! expression )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==COMMA) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:111:35: COMMA ! expression
					{
					COMMA38=(Token)match(input,COMMA,FOLLOW_COMMA_in_read_statement1163); if (state.failed) return retval;
					pushFollow(FOLLOW_expression_in_read_statement1166);
					expression39=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression39.getTree());

					}
					break;

				default :
					break loop8;
				}
			}

			RPAREN40=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_read_statement1170); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "read_statement"


	public static class while_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "while_statement"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:114:1: while_statement : WHILE ^ expression DO ! expression OD !;
	public final NootParser.while_statement_return while_statement() throws RecognitionException {
		NootParser.while_statement_return retval = new NootParser.while_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WHILE41=null;
		Token DO43=null;
		Token OD45=null;
		ParserRuleReturnScope expression42 =null;
		ParserRuleReturnScope expression44 =null;

		Object WHILE41_tree=null;
		Object DO43_tree=null;
		Object OD45_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:115:5: ( WHILE ^ expression DO ! expression OD !)
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:115:9: WHILE ^ expression DO ! expression OD !
			{
			root_0 = (Object)adaptor.nil();


			WHILE41=(Token)match(input,WHILE,FOLLOW_WHILE_in_while_statement1195); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			WHILE41_tree = (Object)adaptor.create(WHILE41);
			root_0 = (Object)adaptor.becomeRoot(WHILE41_tree, root_0);
			}

			pushFollow(FOLLOW_expression_in_while_statement1198);
			expression42=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression42.getTree());

			DO43=(Token)match(input,DO,FOLLOW_DO_in_while_statement1200); if (state.failed) return retval;
			pushFollow(FOLLOW_expression_in_while_statement1203);
			expression44=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression44.getTree());

			OD45=(Token)match(input,OD,FOLLOW_OD_in_while_statement1205); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "while_statement"


	public static class if_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "if_statement"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:118:1: if_statement : IF ^ expression THEN ! expression ( ELSE ! expression )? FI !;
	public final NootParser.if_statement_return if_statement() throws RecognitionException {
		NootParser.if_statement_return retval = new NootParser.if_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IF46=null;
		Token THEN48=null;
		Token ELSE50=null;
		Token FI52=null;
		ParserRuleReturnScope expression47 =null;
		ParserRuleReturnScope expression49 =null;
		ParserRuleReturnScope expression51 =null;

		Object IF46_tree=null;
		Object THEN48_tree=null;
		Object ELSE50_tree=null;
		Object FI52_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:119:5: ( IF ^ expression THEN ! expression ( ELSE ! expression )? FI !)
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:119:9: IF ^ expression THEN ! expression ( ELSE ! expression )? FI !
			{
			root_0 = (Object)adaptor.nil();


			IF46=(Token)match(input,IF,FOLLOW_IF_in_if_statement1226); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IF46_tree = (Object)adaptor.create(IF46);
			root_0 = (Object)adaptor.becomeRoot(IF46_tree, root_0);
			}

			pushFollow(FOLLOW_expression_in_if_statement1229);
			expression47=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression47.getTree());

			THEN48=(Token)match(input,THEN,FOLLOW_THEN_in_if_statement1231); if (state.failed) return retval;
			pushFollow(FOLLOW_expression_in_if_statement1234);
			expression49=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression49.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:119:41: ( ELSE ! expression )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==ELSE) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:119:42: ELSE ! expression
					{
					ELSE50=(Token)match(input,ELSE,FOLLOW_ELSE_in_if_statement1237); if (state.failed) return retval;
					pushFollow(FOLLOW_expression_in_if_statement1240);
					expression51=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression51.getTree());

					}
					break;

			}

			FI52=(Token)match(input,FI,FOLLOW_FI_in_if_statement1244); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "if_statement"


	public static class compound_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "compound_expression"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:122:1: compound_expression : LCURLY ^ ( command )* RCURLY !;
	public final NootParser.compound_expression_return compound_expression() throws RecognitionException {
		NootParser.compound_expression_return retval = new NootParser.compound_expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LCURLY53=null;
		Token RCURLY55=null;
		ParserRuleReturnScope command54 =null;

		Object LCURLY53_tree=null;
		Object RCURLY55_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:123:5: ( LCURLY ^ ( command )* RCURLY !)
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:123:9: LCURLY ^ ( command )* RCURLY !
			{
			root_0 = (Object)adaptor.nil();


			LCURLY53=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_compound_expression1268); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LCURLY53_tree = (Object)adaptor.create(LCURLY53);
			root_0 = (Object)adaptor.becomeRoot(LCURLY53_tree, root_0);
			}

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:123:17: ( command )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= BOOL && LA10_0 <= CHARACTER)||LA10_0==FALSE||(LA10_0 >= IDENTIFIER && LA10_0 <= LCURLY)||(LA10_0 >= LPAREN && LA10_0 <= MINUS)||LA10_0==NEGATION||LA10_0==NUMBER||LA10_0==PRINT||LA10_0==READ||LA10_0==TRUE||LA10_0==WHILE) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:123:17: command
					{
					pushFollow(FOLLOW_command_in_compound_expression1271);
					command54=command();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, command54.getTree());

					}
					break;

				default :
					break loop10;
				}
			}

			RCURLY55=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_compound_expression1274); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "compound_expression"


	public static class expression_level6_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression_level6"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:126:1: expression_level6 : ( expression_level5 ( OR ^ expression_level5 )* | compound_expression );
	public final NootParser.expression_level6_return expression_level6() throws RecognitionException {
		NootParser.expression_level6_return retval = new NootParser.expression_level6_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OR57=null;
		ParserRuleReturnScope expression_level556 =null;
		ParserRuleReturnScope expression_level558 =null;
		ParserRuleReturnScope compound_expression59 =null;

		Object OR57_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:127:5: ( expression_level5 ( OR ^ expression_level5 )* | compound_expression )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==CHARACTER||LA12_0==FALSE||LA12_0==IDENTIFIER||(LA12_0 >= LPAREN && LA12_0 <= MINUS)||LA12_0==NEGATION||LA12_0==NUMBER||LA12_0==TRUE) ) {
				alt12=1;
			}
			else if ( (LA12_0==LCURLY) ) {
				alt12=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:127:9: expression_level5 ( OR ^ expression_level5 )*
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expression_level5_in_expression_level61298);
					expression_level556=expression_level5();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level556.getTree());

					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:127:27: ( OR ^ expression_level5 )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==OR) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:127:28: OR ^ expression_level5
							{
							OR57=(Token)match(input,OR,FOLLOW_OR_in_expression_level61301); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							OR57_tree = (Object)adaptor.create(OR57);
							root_0 = (Object)adaptor.becomeRoot(OR57_tree, root_0);
							}

							pushFollow(FOLLOW_expression_level5_in_expression_level61304);
							expression_level558=expression_level5();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level558.getTree());

							}
							break;

						default :
							break loop11;
						}
					}

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:128:9: compound_expression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_compound_expression_in_expression_level61316);
					compound_expression59=compound_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, compound_expression59.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression_level6"


	public static class expression_level5_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression_level5"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:131:1: expression_level5 : expression_level4 ( AND ^ expression_level4 )* ;
	public final NootParser.expression_level5_return expression_level5() throws RecognitionException {
		NootParser.expression_level5_return retval = new NootParser.expression_level5_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AND61=null;
		ParserRuleReturnScope expression_level460 =null;
		ParserRuleReturnScope expression_level462 =null;

		Object AND61_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:132:5: ( expression_level4 ( AND ^ expression_level4 )* )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:132:9: expression_level4 ( AND ^ expression_level4 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expression_level4_in_expression_level51339);
			expression_level460=expression_level4();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level460.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:132:27: ( AND ^ expression_level4 )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==AND) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:132:28: AND ^ expression_level4
					{
					AND61=(Token)match(input,AND,FOLLOW_AND_in_expression_level51342); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND61_tree = (Object)adaptor.create(AND61);
					root_0 = (Object)adaptor.becomeRoot(AND61_tree, root_0);
					}

					pushFollow(FOLLOW_expression_level4_in_expression_level51345);
					expression_level462=expression_level4();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level462.getTree());

					}
					break;

				default :
					break loop13;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression_level5"


	public static class expression_level4_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression_level4"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:135:1: expression_level4 : expression_level3 ( ( LESS ^| LESSEQ ^| EQ ^| NEQ ^| MOREEQ ^| MORE ^) expression_level3 )* ;
	public final NootParser.expression_level4_return expression_level4() throws RecognitionException {
		NootParser.expression_level4_return retval = new NootParser.expression_level4_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LESS64=null;
		Token LESSEQ65=null;
		Token EQ66=null;
		Token NEQ67=null;
		Token MOREEQ68=null;
		Token MORE69=null;
		ParserRuleReturnScope expression_level363 =null;
		ParserRuleReturnScope expression_level370 =null;

		Object LESS64_tree=null;
		Object LESSEQ65_tree=null;
		Object EQ66_tree=null;
		Object NEQ67_tree=null;
		Object MOREEQ68_tree=null;
		Object MORE69_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:136:5: ( expression_level3 ( ( LESS ^| LESSEQ ^| EQ ^| NEQ ^| MOREEQ ^| MORE ^) expression_level3 )* )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:136:9: expression_level3 ( ( LESS ^| LESSEQ ^| EQ ^| NEQ ^| MOREEQ ^| MORE ^) expression_level3 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expression_level3_in_expression_level41370);
			expression_level363=expression_level3();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level363.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:136:27: ( ( LESS ^| LESSEQ ^| EQ ^| NEQ ^| MOREEQ ^| MORE ^) expression_level3 )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==EQ||(LA15_0 >= LESS && LA15_0 <= LESSEQ)||(LA15_0 >= MORE && LA15_0 <= MOREEQ)||LA15_0==NEQ) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:136:28: ( LESS ^| LESSEQ ^| EQ ^| NEQ ^| MOREEQ ^| MORE ^) expression_level3
					{
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:136:28: ( LESS ^| LESSEQ ^| EQ ^| NEQ ^| MOREEQ ^| MORE ^)
					int alt14=6;
					switch ( input.LA(1) ) {
					case LESS:
						{
						alt14=1;
						}
						break;
					case LESSEQ:
						{
						alt14=2;
						}
						break;
					case EQ:
						{
						alt14=3;
						}
						break;
					case NEQ:
						{
						alt14=4;
						}
						break;
					case MOREEQ:
						{
						alt14=5;
						}
						break;
					case MORE:
						{
						alt14=6;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}
					switch (alt14) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:136:29: LESS ^
							{
							LESS64=(Token)match(input,LESS,FOLLOW_LESS_in_expression_level41374); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							LESS64_tree = (Object)adaptor.create(LESS64);
							root_0 = (Object)adaptor.becomeRoot(LESS64_tree, root_0);
							}

							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:136:37: LESSEQ ^
							{
							LESSEQ65=(Token)match(input,LESSEQ,FOLLOW_LESSEQ_in_expression_level41379); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							LESSEQ65_tree = (Object)adaptor.create(LESSEQ65);
							root_0 = (Object)adaptor.becomeRoot(LESSEQ65_tree, root_0);
							}

							}
							break;
						case 3 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:136:47: EQ ^
							{
							EQ66=(Token)match(input,EQ,FOLLOW_EQ_in_expression_level41384); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							EQ66_tree = (Object)adaptor.create(EQ66);
							root_0 = (Object)adaptor.becomeRoot(EQ66_tree, root_0);
							}

							}
							break;
						case 4 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:136:53: NEQ ^
							{
							NEQ67=(Token)match(input,NEQ,FOLLOW_NEQ_in_expression_level41389); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NEQ67_tree = (Object)adaptor.create(NEQ67);
							root_0 = (Object)adaptor.becomeRoot(NEQ67_tree, root_0);
							}

							}
							break;
						case 5 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:136:60: MOREEQ ^
							{
							MOREEQ68=(Token)match(input,MOREEQ,FOLLOW_MOREEQ_in_expression_level41394); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							MOREEQ68_tree = (Object)adaptor.create(MOREEQ68);
							root_0 = (Object)adaptor.becomeRoot(MOREEQ68_tree, root_0);
							}

							}
							break;
						case 6 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:136:70: MORE ^
							{
							MORE69=(Token)match(input,MORE,FOLLOW_MORE_in_expression_level41399); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							MORE69_tree = (Object)adaptor.create(MORE69);
							root_0 = (Object)adaptor.becomeRoot(MORE69_tree, root_0);
							}

							}
							break;

					}

					pushFollow(FOLLOW_expression_level3_in_expression_level41403);
					expression_level370=expression_level3();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level370.getTree());

					}
					break;

				default :
					break loop15;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression_level4"


	public static class expression_level3_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression_level3"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:139:1: expression_level3 : expression_level2 ( ( PLUS ^| MINUS ^) expression_level2 )* ;
	public final NootParser.expression_level3_return expression_level3() throws RecognitionException {
		NootParser.expression_level3_return retval = new NootParser.expression_level3_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PLUS72=null;
		Token MINUS73=null;
		ParserRuleReturnScope expression_level271 =null;
		ParserRuleReturnScope expression_level274 =null;

		Object PLUS72_tree=null;
		Object MINUS73_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:140:5: ( expression_level2 ( ( PLUS ^| MINUS ^) expression_level2 )* )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:140:9: expression_level2 ( ( PLUS ^| MINUS ^) expression_level2 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expression_level2_in_expression_level31429);
			expression_level271=expression_level2();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level271.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:140:27: ( ( PLUS ^| MINUS ^) expression_level2 )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==MINUS||LA17_0==PLUS) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:140:28: ( PLUS ^| MINUS ^) expression_level2
					{
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:140:28: ( PLUS ^| MINUS ^)
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==PLUS) ) {
						alt16=1;
					}
					else if ( (LA16_0==MINUS) ) {
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
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:140:29: PLUS ^
							{
							PLUS72=(Token)match(input,PLUS,FOLLOW_PLUS_in_expression_level31433); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							PLUS72_tree = (Object)adaptor.create(PLUS72);
							root_0 = (Object)adaptor.becomeRoot(PLUS72_tree, root_0);
							}

							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:140:37: MINUS ^
							{
							MINUS73=(Token)match(input,MINUS,FOLLOW_MINUS_in_expression_level31438); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							MINUS73_tree = (Object)adaptor.create(MINUS73);
							root_0 = (Object)adaptor.becomeRoot(MINUS73_tree, root_0);
							}

							}
							break;

					}

					pushFollow(FOLLOW_expression_level2_in_expression_level31442);
					expression_level274=expression_level2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level274.getTree());

					}
					break;

				default :
					break loop17;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression_level3"


	public static class expression_level2_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression_level2"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:143:1: expression_level2 : expression_level1 ( ( MULTIPLY ^| DEVIDE ^| MODULO ^) expression_level1 )* ;
	public final NootParser.expression_level2_return expression_level2() throws RecognitionException {
		NootParser.expression_level2_return retval = new NootParser.expression_level2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MULTIPLY76=null;
		Token DEVIDE77=null;
		Token MODULO78=null;
		ParserRuleReturnScope expression_level175 =null;
		ParserRuleReturnScope expression_level179 =null;

		Object MULTIPLY76_tree=null;
		Object DEVIDE77_tree=null;
		Object MODULO78_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:144:5: ( expression_level1 ( ( MULTIPLY ^| DEVIDE ^| MODULO ^) expression_level1 )* )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:144:9: expression_level1 ( ( MULTIPLY ^| DEVIDE ^| MODULO ^) expression_level1 )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expression_level1_in_expression_level21469);
			expression_level175=expression_level1();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level175.getTree());

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:144:27: ( ( MULTIPLY ^| DEVIDE ^| MODULO ^) expression_level1 )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==DEVIDE||LA19_0==MODULO||LA19_0==MULTIPLY) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:144:28: ( MULTIPLY ^| DEVIDE ^| MODULO ^) expression_level1
					{
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:144:28: ( MULTIPLY ^| DEVIDE ^| MODULO ^)
					int alt18=3;
					switch ( input.LA(1) ) {
					case MULTIPLY:
						{
						alt18=1;
						}
						break;
					case DEVIDE:
						{
						alt18=2;
						}
						break;
					case MODULO:
						{
						alt18=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 18, 0, input);
						throw nvae;
					}
					switch (alt18) {
						case 1 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:144:29: MULTIPLY ^
							{
							MULTIPLY76=(Token)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression_level21473); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							MULTIPLY76_tree = (Object)adaptor.create(MULTIPLY76);
							root_0 = (Object)adaptor.becomeRoot(MULTIPLY76_tree, root_0);
							}

							}
							break;
						case 2 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:144:41: DEVIDE ^
							{
							DEVIDE77=(Token)match(input,DEVIDE,FOLLOW_DEVIDE_in_expression_level21478); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DEVIDE77_tree = (Object)adaptor.create(DEVIDE77);
							root_0 = (Object)adaptor.becomeRoot(DEVIDE77_tree, root_0);
							}

							}
							break;
						case 3 :
							// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:144:51: MODULO ^
							{
							MODULO78=(Token)match(input,MODULO,FOLLOW_MODULO_in_expression_level21483); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							MODULO78_tree = (Object)adaptor.create(MODULO78);
							root_0 = (Object)adaptor.becomeRoot(MODULO78_tree, root_0);
							}

							}
							break;

					}

					pushFollow(FOLLOW_expression_level1_in_expression_level21487);
					expression_level179=expression_level1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_level179.getTree());

					}
					break;

				default :
					break loop19;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression_level2"


	public static class expression_level1_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression_level1"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:147:1: expression_level1 : ( MINUS ^| NEGATION ^)? operand ;
	public final NootParser.expression_level1_return expression_level1() throws RecognitionException {
		NootParser.expression_level1_return retval = new NootParser.expression_level1_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MINUS80=null;
		Token NEGATION81=null;
		ParserRuleReturnScope operand82 =null;

		Object MINUS80_tree=null;
		Object NEGATION81_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:148:5: ( ( MINUS ^| NEGATION ^)? operand )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:148:9: ( MINUS ^| NEGATION ^)? operand
			{
			root_0 = (Object)adaptor.nil();


			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:148:9: ( MINUS ^| NEGATION ^)?
			int alt20=3;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==MINUS) ) {
				alt20=1;
			}
			else if ( (LA20_0==NEGATION) ) {
				alt20=2;
			}
			switch (alt20) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:148:10: MINUS ^
					{
					MINUS80=(Token)match(input,MINUS,FOLLOW_MINUS_in_expression_level11515); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS80_tree = (Object)adaptor.create(MINUS80);
					root_0 = (Object)adaptor.becomeRoot(MINUS80_tree, root_0);
					}

					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:148:19: NEGATION ^
					{
					NEGATION81=(Token)match(input,NEGATION,FOLLOW_NEGATION_in_expression_level11520); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NEGATION81_tree = (Object)adaptor.create(NEGATION81);
					root_0 = (Object)adaptor.becomeRoot(NEGATION81_tree, root_0);
					}

					}
					break;

			}

			pushFollow(FOLLOW_operand_in_expression_level11525);
			operand82=operand();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, operand82.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression_level1"


	public static class operand_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "operand"
	// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:151:1: operand : ( ( TRUE | FALSE ) | IDENTIFIER | NUMBER | CHARACTER | LPAREN ! expression RPAREN !);
	public final NootParser.operand_return operand() throws RecognitionException {
		NootParser.operand_return retval = new NootParser.operand_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set83=null;
		Token IDENTIFIER84=null;
		Token NUMBER85=null;
		Token CHARACTER86=null;
		Token LPAREN87=null;
		Token RPAREN89=null;
		ParserRuleReturnScope expression88 =null;

		Object set83_tree=null;
		Object IDENTIFIER84_tree=null;
		Object NUMBER85_tree=null;
		Object CHARACTER86_tree=null;
		Object LPAREN87_tree=null;
		Object RPAREN89_tree=null;

		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:152:5: ( ( TRUE | FALSE ) | IDENTIFIER | NUMBER | CHARACTER | LPAREN ! expression RPAREN !)
			int alt21=5;
			switch ( input.LA(1) ) {
			case FALSE:
			case TRUE:
				{
				alt21=1;
				}
				break;
			case IDENTIFIER:
				{
				alt21=2;
				}
				break;
			case NUMBER:
				{
				alt21=3;
				}
				break;
			case CHARACTER:
				{
				alt21=4;
				}
				break;
			case LPAREN:
				{
				alt21=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:152:9: ( TRUE | FALSE )
					{
					root_0 = (Object)adaptor.nil();


					set83=input.LT(1);
					if ( input.LA(1)==FALSE||input.LA(1)==TRUE ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set83));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;
				case 2 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:153:9: IDENTIFIER
					{
					root_0 = (Object)adaptor.nil();


					IDENTIFIER84=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operand1560); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER84_tree = (Object)adaptor.create(IDENTIFIER84);
					adaptor.addChild(root_0, IDENTIFIER84_tree);
					}

					}
					break;
				case 3 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:154:9: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER85=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_operand1570); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER85_tree = (Object)adaptor.create(NUMBER85);
					adaptor.addChild(root_0, NUMBER85_tree);
					}

					}
					break;
				case 4 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:155:9: CHARACTER
					{
					root_0 = (Object)adaptor.nil();


					CHARACTER86=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_operand1580); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CHARACTER86_tree = (Object)adaptor.create(CHARACTER86);
					adaptor.addChild(root_0, CHARACTER86_tree);
					}

					}
					break;
				case 5 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:156:9: LPAREN ! expression RPAREN !
					{
					root_0 = (Object)adaptor.nil();


					LPAREN87=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_operand1590); if (state.failed) return retval;
					pushFollow(FOLLOW_expression_in_operand1593);
					expression88=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression88.getTree());

					RPAREN89=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_operand1595); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "operand"

	// $ANTLR start synpred1_Noot
	public final void synpred1_Noot_fragment() throws RecognitionException {
		// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:93:8: ( IDENTIFIER BECOMES )
		// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:93:9: IDENTIFIER BECOMES
		{
		match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred1_Noot992); if (state.failed) return;

		match(input,BECOMES,FOLLOW_BECOMES_in_synpred1_Noot994); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_Noot

	// $ANTLR start synpred2_Noot
	public final void synpred2_Noot_fragment() throws RecognitionException {
		// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:98:9: ( IDENTIFIER BECOMES )
		// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:98:10: IDENTIFIER BECOMES
		{
		match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred2_Noot1037); if (state.failed) return;

		match(input,BECOMES,FOLLOW_BECOMES_in_synpred2_Noot1039); if (state.failed) return;

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



	public static final BitSet FOLLOW_NOOT_in_program831 = new BitSet(new long[]{0x00014512187A0380L});
	public static final BitSet FOLLOW_command_in_program834 = new BitSet(new long[]{0x00014512187A0380L});
	public static final BitSet FOLLOW_EOF_in_program837 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_in_command859 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_command861 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_command871 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_command873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_declaration898 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_CHAR_in_declaration903 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_BOOL_in_declaration908 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration912 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration914 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_declaration_extention938 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration_extention941 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_declaration_extention_in_declaration_extention943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_assignment964 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BECOMES_in_assignment966 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_assignment_extention_in_assignment969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_assignment_extention999 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BECOMES_in_assignment_extention1001 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_assignment_extention_in_assignment_extention1004 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_assignment_extention1013 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_expression1044 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_statement_in_expression1054 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_statement_in_expression1064 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_statement_in_expression1074 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_statement_in_expression1084 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_level6_in_expression1094 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_print_statement1113 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAREN_in_print_statement1116 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_print_statement1119 = new BitSet(new long[]{0x0000080000000400L});
	public static final BitSet FOLLOW_COMMA_in_print_statement1122 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_print_statement1125 = new BitSet(new long[]{0x0000080000000400L});
	public static final BitSet FOLLOW_RPAREN_in_print_statement1129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_READ_in_read_statement1154 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAREN_in_read_statement1157 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_read_statement1160 = new BitSet(new long[]{0x0000080000000400L});
	public static final BitSet FOLLOW_COMMA_in_read_statement1163 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_read_statement1166 = new BitSet(new long[]{0x0000080000000400L});
	public static final BitSet FOLLOW_RPAREN_in_read_statement1170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_while_statement1195 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_while_statement1198 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_in_while_statement1200 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_while_statement1203 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_OD_in_while_statement1205 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_if_statement1226 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_if_statement1229 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_THEN_in_if_statement1231 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_if_statement1234 = new BitSet(new long[]{0x0000000000048000L});
	public static final BitSet FOLLOW_ELSE_in_if_statement1237 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_if_statement1240 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_FI_in_if_statement1244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LCURLY_in_compound_expression1268 = new BitSet(new long[]{0x00014712187A0380L});
	public static final BitSet FOLLOW_command_in_compound_expression1271 = new BitSet(new long[]{0x00014712187A0380L});
	public static final BitSet FOLLOW_RCURLY_in_compound_expression1274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_level5_in_expression_level61298 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_OR_in_expression_level61301 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_expression_level5_in_expression_level61304 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_compound_expression_in_expression_level61316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_level4_in_expression_level51339 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_AND_in_expression_level51342 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_expression_level4_in_expression_level51345 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_expression_level3_in_expression_level41370 = new BitSet(new long[]{0x00000004C1810002L});
	public static final BitSet FOLLOW_LESS_in_expression_level41374 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_LESSEQ_in_expression_level41379 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_EQ_in_expression_level41384 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_NEQ_in_expression_level41389 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_MOREEQ_in_expression_level41394 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_MORE_in_expression_level41399 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_expression_level3_in_expression_level41403 = new BitSet(new long[]{0x00000004C1810002L});
	public static final BitSet FOLLOW_expression_level2_in_expression_level31429 = new BitSet(new long[]{0x0000008010000002L});
	public static final BitSet FOLLOW_PLUS_in_expression_level31433 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_MINUS_in_expression_level31438 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_expression_level2_in_expression_level31442 = new BitSet(new long[]{0x0000008010000002L});
	public static final BitSet FOLLOW_expression_level1_in_expression_level21469 = new BitSet(new long[]{0x0000000120001002L});
	public static final BitSet FOLLOW_MULTIPLY_in_expression_level21473 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_DEVIDE_in_expression_level21478 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_MODULO_in_expression_level21483 = new BitSet(new long[]{0x00004012180A0200L});
	public static final BitSet FOLLOW_expression_level1_in_expression_level21487 = new BitSet(new long[]{0x0000000120001002L});
	public static final BitSet FOLLOW_MINUS_in_expression_level11515 = new BitSet(new long[]{0x00004010080A0200L});
	public static final BitSet FOLLOW_NEGATION_in_expression_level11520 = new BitSet(new long[]{0x00004010080A0200L});
	public static final BitSet FOLLOW_operand_in_expression_level11525 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_operand1544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_operand1560 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_operand1570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARACTER_in_operand1580 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_operand1590 = new BitSet(new long[]{0x00014512185A0200L});
	public static final BitSet FOLLOW_expression_in_operand1593 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RPAREN_in_operand1595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_synpred1_Noot992 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BECOMES_in_synpred1_Noot994 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_synpred2_Noot1037 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BECOMES_in_synpred2_Noot1039 = new BitSet(new long[]{0x0000000000000002L});
}
