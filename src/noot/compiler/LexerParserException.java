/*
 * @author Thijs Scheepers <thijs@label305.com>
 * Copyright (c) 2013 Thijs Scheepers.
 *
 * This source is subject to the BSD License.
 * Please see the LICENSE file for more information.
 * All other rights reserved.
 *
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY 
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 * 
 */
package noot.compiler;

// TODO: Auto-generated Javadoc
/**
 * The Class LexerParserException.
 * 
 * This custom class extends RuntimeException and is here
 * to be used in the Lexer and Parser grammar. Since Antlr
 * does not have a convenient way to halt the program on 
 * a recoverable Lexer or Parser error we will use this
 * class as an extention of the RuntimeException.
 * 
 * RuntimeExceptions may be thrown in java without adding
 * throws to an method declaration. This is needed because
 * we need to override the ReportError method of the Antlr
 * Lexer and Parser. This is done in the Noot grammar.
 */
public class LexerParserException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4782135047891258428L;
	
	/** The message you could use for printing for example. */
    private String msg;
	
	/**
	 * Instantiates a new noot exception.
	 * 
	 * Constructor which only requires the error message to be printed.
	 *
	 * @param msg the msg
	 */
    public LexerParserException(String msg) {
        super();
        this.msg = msg;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return this.msg;
    }

}
