// $ANTLR 3.5 /Users/Thijs/Development/noot/src/noot/compiler/Noot.g 2013-07-05 16:03:52

  package noot.compiler;
  import noot.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class NootLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public NootLexer() {} 
	public NootLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public NootLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/Thijs/Development/noot/src/noot/compiler/Noot.g"; }

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:12:5: ( '&&' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:12:7: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "APOSTROPHE"
	public final void mAPOSTROPHE() throws RecognitionException {
		try {
			int _type = APOSTROPHE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:13:12: ( '\\'' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:13:14: '\\''
			{
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "APOSTROPHE"

	// $ANTLR start "BECOMES"
	public final void mBECOMES() throws RecognitionException {
		try {
			int _type = BECOMES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:14:9: ( ':=' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:14:11: ':='
			{
			match(":="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BECOMES"

	// $ANTLR start "BOOL"
	public final void mBOOL() throws RecognitionException {
		try {
			int _type = BOOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:15:6: ( 'bool' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:15:8: 'bool'
			{
			match("bool"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOL"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:16:6: ( 'char' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:16:8: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:17:7: ( ',' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:17:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "DEVIDE"
	public final void mDEVIDE() throws RecognitionException {
		try {
			int _type = DEVIDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:18:8: ( '/' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:18:10: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEVIDE"

	// $ANTLR start "DO"
	public final void mDO() throws RecognitionException {
		try {
			int _type = DO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:19:4: ( 'do' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:19:6: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DO"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:20:6: ( 'else' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:20:8: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:21:4: ( '==' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:21:6: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:22:7: ( 'false' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:22:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "FI"
	public final void mFI() throws RecognitionException {
		try {
			int _type = FI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:23:4: ( 'fi' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:23:6: 'fi'
			{
			match("fi"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FI"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:24:4: ( 'if' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:24:6: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:25:5: ( 'int' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:25:7: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "LCURLY"
	public final void mLCURLY() throws RecognitionException {
		try {
			int _type = LCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:26:8: ( '{' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:26:10: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LCURLY"

	// $ANTLR start "LESS"
	public final void mLESS() throws RecognitionException {
		try {
			int _type = LESS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:27:6: ( '<' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:27:8: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESS"

	// $ANTLR start "LESSEQ"
	public final void mLESSEQ() throws RecognitionException {
		try {
			int _type = LESSEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:28:8: ( '<=' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:28:10: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESSEQ"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:29:8: ( '(' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:29:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:30:7: ( '-' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:30:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MODULO"
	public final void mMODULO() throws RecognitionException {
		try {
			int _type = MODULO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:31:8: ( '%' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:31:10: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MODULO"

	// $ANTLR start "MORE"
	public final void mMORE() throws RecognitionException {
		try {
			int _type = MORE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:32:6: ( '>' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:32:8: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MORE"

	// $ANTLR start "MOREEQ"
	public final void mMOREEQ() throws RecognitionException {
		try {
			int _type = MOREEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:33:8: ( '>=' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:33:10: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOREEQ"

	// $ANTLR start "MULTIPLY"
	public final void mMULTIPLY() throws RecognitionException {
		try {
			int _type = MULTIPLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:34:10: ( '*' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:34:12: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTIPLY"

	// $ANTLR start "NEGATION"
	public final void mNEGATION() throws RecognitionException {
		try {
			int _type = NEGATION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:35:10: ( '!' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:35:12: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEGATION"

	// $ANTLR start "NEQ"
	public final void mNEQ() throws RecognitionException {
		try {
			int _type = NEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:36:5: ( '!=' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:36:7: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEQ"

	// $ANTLR start "NOOT"
	public final void mNOOT() throws RecognitionException {
		try {
			int _type = NOOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:37:6: ( 'noot' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:37:8: 'noot'
			{
			match("noot"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOOT"

	// $ANTLR start "OD"
	public final void mOD() throws RecognitionException {
		try {
			int _type = OD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:38:4: ( 'od' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:38:6: 'od'
			{
			match("od"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OD"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:39:4: ( '||' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:39:6: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:40:6: ( '+' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:40:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:41:7: ( 'print' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:41:9: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "RCURLY"
	public final void mRCURLY() throws RecognitionException {
		try {
			int _type = RCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:42:8: ( '}' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:42:10: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RCURLY"

	// $ANTLR start "READ"
	public final void mREAD() throws RecognitionException {
		try {
			int _type = READ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:43:6: ( 'read' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:43:8: 'read'
			{
			match("read"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "READ"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:44:8: ( ')' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:44:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:45:11: ( ';' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:45:13: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:46:6: ( 'then' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:46:8: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:47:6: ( 'true' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:47:8: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:48:7: ( 'while' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:48:9: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:180:5: ( LETTER ( LETTER | DIGIT )* )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:180:9: LETTER ( LETTER | DIGIT )*
			{
			mLETTER(); 

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:180:16: ( LETTER | DIGIT )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENTIFIER"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:184:5: ( ( DIGIT )+ )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:184:9: ( DIGIT )+
			{
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:184:9: ( DIGIT )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "CHARACTER"
	public final void mCHARACTER() throws RecognitionException {
		try {
			int _type = CHARACTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:188:5: ( APOSTROPHE LETTER APOSTROPHE )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:188:8: APOSTROPHE LETTER APOSTROPHE
			{
			mAPOSTROPHE(); 

			mLETTER(); 

			mAPOSTROPHE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHARACTER"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:192:5: ( '//' ( . )* '\\n' )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:192:9: '//' ( . )* '\\n'
			{
			match("//"); 

			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:192:14: ( . )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\n') ) {
					alt3=2;
				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:192:14: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop3;
				}
			}

			match('\n'); 
			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:197:5: ( ( ' ' | '\\t' | '\\f' | '\\r' | '\\n' )+ )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:197:9: ( ' ' | '\\t' | '\\f' | '\\r' | '\\n' )+
			{
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:197:9: ( ' ' | '\\t' | '\\f' | '\\r' | '\\n' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||(LA4_0 >= '\f' && LA4_0 <= '\r')||LA4_0==' ') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:201:17: ( ( '0' .. '9' ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "LOWER"
	public final void mLOWER() throws RecognitionException {
		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:202:17: ( ( 'a' .. 'z' ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:
			{
			if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOWER"

	// $ANTLR start "UPPER"
	public final void mUPPER() throws RecognitionException {
		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:203:17: ( ( 'A' .. 'Z' ) )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPPER"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:204:17: ( LOWER | UPPER )
			// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:8: ( AND | APOSTROPHE | BECOMES | BOOL | CHAR | COMMA | DEVIDE | DO | ELSE | EQ | FALSE | FI | IF | INT | LCURLY | LESS | LESSEQ | LPAREN | MINUS | MODULO | MORE | MOREEQ | MULTIPLY | NEGATION | NEQ | NOOT | OD | OR | PLUS | PRINT | RCURLY | READ | RPAREN | SEMICOLON | THEN | TRUE | WHILE | IDENTIFIER | NUMBER | CHARACTER | COMMENT | WS )
		int alt5=42;
		alt5 = dfa5.predict(input);
		switch (alt5) {
			case 1 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:10: AND
				{
				mAND(); 

				}
				break;
			case 2 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:14: APOSTROPHE
				{
				mAPOSTROPHE(); 

				}
				break;
			case 3 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:25: BECOMES
				{
				mBECOMES(); 

				}
				break;
			case 4 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:33: BOOL
				{
				mBOOL(); 

				}
				break;
			case 5 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:38: CHAR
				{
				mCHAR(); 

				}
				break;
			case 6 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:43: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 7 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:49: DEVIDE
				{
				mDEVIDE(); 

				}
				break;
			case 8 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:56: DO
				{
				mDO(); 

				}
				break;
			case 9 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:59: ELSE
				{
				mELSE(); 

				}
				break;
			case 10 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:64: EQ
				{
				mEQ(); 

				}
				break;
			case 11 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:67: FALSE
				{
				mFALSE(); 

				}
				break;
			case 12 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:73: FI
				{
				mFI(); 

				}
				break;
			case 13 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:76: IF
				{
				mIF(); 

				}
				break;
			case 14 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:79: INT
				{
				mINT(); 

				}
				break;
			case 15 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:83: LCURLY
				{
				mLCURLY(); 

				}
				break;
			case 16 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:90: LESS
				{
				mLESS(); 

				}
				break;
			case 17 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:95: LESSEQ
				{
				mLESSEQ(); 

				}
				break;
			case 18 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:102: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 19 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:109: MINUS
				{
				mMINUS(); 

				}
				break;
			case 20 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:115: MODULO
				{
				mMODULO(); 

				}
				break;
			case 21 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:122: MORE
				{
				mMORE(); 

				}
				break;
			case 22 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:127: MOREEQ
				{
				mMOREEQ(); 

				}
				break;
			case 23 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:134: MULTIPLY
				{
				mMULTIPLY(); 

				}
				break;
			case 24 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:143: NEGATION
				{
				mNEGATION(); 

				}
				break;
			case 25 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:152: NEQ
				{
				mNEQ(); 

				}
				break;
			case 26 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:156: NOOT
				{
				mNOOT(); 

				}
				break;
			case 27 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:161: OD
				{
				mOD(); 

				}
				break;
			case 28 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:164: OR
				{
				mOR(); 

				}
				break;
			case 29 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:167: PLUS
				{
				mPLUS(); 

				}
				break;
			case 30 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:172: PRINT
				{
				mPRINT(); 

				}
				break;
			case 31 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:178: RCURLY
				{
				mRCURLY(); 

				}
				break;
			case 32 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:185: READ
				{
				mREAD(); 

				}
				break;
			case 33 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:190: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 34 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:197: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 35 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:207: THEN
				{
				mTHEN(); 

				}
				break;
			case 36 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:212: TRUE
				{
				mTRUE(); 

				}
				break;
			case 37 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:217: WHILE
				{
				mWHILE(); 

				}
				break;
			case 38 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:223: IDENTIFIER
				{
				mIDENTIFIER(); 

				}
				break;
			case 39 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:234: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 40 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:241: CHARACTER
				{
				mCHARACTER(); 

				}
				break;
			case 41 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:251: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 42 :
				// /Users/Thijs/Development/noot/src/noot/compiler/Noot.g:1:259: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA5 dfa5 = new DFA5(this);
	static final String DFA5_eotS =
		"\2\uffff\1\43\1\uffff\2\40\1\uffff\1\50\2\40\1\uffff\2\40\1\uffff\1\60"+
		"\3\uffff\1\62\1\uffff\1\64\2\40\2\uffff\1\40\1\uffff\1\40\2\uffff\2\40"+
		"\5\uffff\2\40\2\uffff\1\76\2\40\1\101\1\102\1\40\6\uffff\1\40\1\105\7"+
		"\40\1\uffff\2\40\2\uffff\1\117\1\40\1\uffff\5\40\1\126\1\127\1\130\1\40"+
		"\1\uffff\1\132\1\40\1\134\1\135\1\136\1\40\3\uffff\1\140\1\uffff\1\141"+
		"\3\uffff\1\142\3\uffff";
	static final String DFA5_eofS =
		"\143\uffff";
	static final String DFA5_minS =
		"\1\11\1\uffff\1\101\1\uffff\1\157\1\150\1\uffff\1\57\1\157\1\154\1\uffff"+
		"\1\141\1\146\1\uffff\1\75\3\uffff\1\75\1\uffff\1\75\1\157\1\144\2\uffff"+
		"\1\162\1\uffff\1\145\2\uffff\2\150\5\uffff\1\157\1\141\2\uffff\1\60\1"+
		"\163\1\154\2\60\1\164\6\uffff\1\157\1\60\1\151\1\141\1\145\1\165\1\151"+
		"\1\154\1\162\1\uffff\1\145\1\163\2\uffff\1\60\1\164\1\uffff\1\156\1\144"+
		"\1\156\1\145\1\154\3\60\1\145\1\uffff\1\60\1\164\3\60\1\145\3\uffff\1"+
		"\60\1\uffff\1\60\3\uffff\1\60\3\uffff";
	static final String DFA5_maxS =
		"\1\175\1\uffff\1\172\1\uffff\1\157\1\150\1\uffff\1\57\1\157\1\154\1\uffff"+
		"\1\151\1\156\1\uffff\1\75\3\uffff\1\75\1\uffff\1\75\1\157\1\144\2\uffff"+
		"\1\162\1\uffff\1\145\2\uffff\1\162\1\150\5\uffff\1\157\1\141\2\uffff\1"+
		"\172\1\163\1\154\2\172\1\164\6\uffff\1\157\1\172\1\151\1\141\1\145\1\165"+
		"\1\151\1\154\1\162\1\uffff\1\145\1\163\2\uffff\1\172\1\164\1\uffff\1\156"+
		"\1\144\1\156\1\145\1\154\3\172\1\145\1\uffff\1\172\1\164\3\172\1\145\3"+
		"\uffff\1\172\1\uffff\1\172\3\uffff\1\172\3\uffff";
	static final String DFA5_acceptS =
		"\1\uffff\1\1\1\uffff\1\3\2\uffff\1\6\3\uffff\1\12\2\uffff\1\17\1\uffff"+
		"\1\22\1\23\1\24\1\uffff\1\27\3\uffff\1\34\1\35\1\uffff\1\37\1\uffff\1"+
		"\41\1\42\2\uffff\1\46\1\47\1\52\1\2\1\50\2\uffff\1\51\1\7\6\uffff\1\21"+
		"\1\20\1\26\1\25\1\31\1\30\11\uffff\1\10\2\uffff\1\14\1\15\2\uffff\1\33"+
		"\11\uffff\1\16\6\uffff\1\4\1\5\1\11\1\uffff\1\32\1\uffff\1\40\1\43\1\44"+
		"\1\uffff\1\13\1\36\1\45";
	static final String DFA5_specialS =
		"\143\uffff}>";
	static final String[] DFA5_transitionS = {
			"\2\42\1\uffff\2\42\22\uffff\1\42\1\24\3\uffff\1\21\1\1\1\2\1\17\1\34"+
			"\1\23\1\30\1\6\1\20\1\uffff\1\7\12\41\1\3\1\35\1\16\1\12\1\22\2\uffff"+
			"\32\40\6\uffff\1\40\1\4\1\5\1\10\1\11\1\13\2\40\1\14\4\40\1\25\1\26\1"+
			"\31\1\40\1\33\1\40\1\36\2\40\1\37\3\40\1\15\1\27\1\32",
			"",
			"\32\44\6\uffff\32\44",
			"",
			"\1\45",
			"\1\46",
			"",
			"\1\47",
			"\1\51",
			"\1\52",
			"",
			"\1\53\7\uffff\1\54",
			"\1\55\7\uffff\1\56",
			"",
			"\1\57",
			"",
			"",
			"",
			"\1\61",
			"",
			"\1\63",
			"\1\65",
			"\1\66",
			"",
			"",
			"\1\67",
			"",
			"\1\70",
			"",
			"",
			"\1\71\11\uffff\1\72",
			"\1\73",
			"",
			"",
			"",
			"",
			"",
			"\1\74",
			"\1\75",
			"",
			"",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"\1\77",
			"\1\100",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"\1\103",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\104",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111",
			"\1\112",
			"\1\113",
			"\1\114",
			"",
			"\1\115",
			"\1\116",
			"",
			"",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"\1\120",
			"",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"\1\131",
			"",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"\1\133",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"\1\137",
			"",
			"",
			"",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"",
			"",
			"",
			"\12\40\7\uffff\32\40\6\uffff\32\40",
			"",
			"",
			""
	};

	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
	static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
	static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
	static final short[][] DFA5_transition;

	static {
		int numStates = DFA5_transitionS.length;
		DFA5_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
		}
	}

	protected class DFA5 extends DFA {

		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = DFA5_eot;
			this.eof = DFA5_eof;
			this.min = DFA5_min;
			this.max = DFA5_max;
			this.accept = DFA5_accept;
			this.special = DFA5_special;
			this.transition = DFA5_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( AND | APOSTROPHE | BECOMES | BOOL | CHAR | COMMA | DEVIDE | DO | ELSE | EQ | FALSE | FI | IF | INT | LCURLY | LESS | LESSEQ | LPAREN | MINUS | MODULO | MORE | MOREEQ | MULTIPLY | NEGATION | NEQ | NOOT | OD | OR | PLUS | PRINT | RCURLY | READ | RPAREN | SEMICOLON | THEN | TRUE | WHILE | IDENTIFIER | NUMBER | CHARACTER | COMMENT | WS );";
		}
	}

}
