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
package noot.exceptions;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;

/**
 * The Class NootException.
 * 
 * To be extended and used by generic helpers like the ScopeHelper.
 */
public class NootException extends RecognitionException {

	/** The message you could use for printing for example. */
	private String msg;

	/** The Constant serialVersionUID. */
	public static final long serialVersionUID = 24162462L; // for Serializable

	/**
	 * Instantiates a new noot exception.
	 * 
	 * Constructor which can be used when later an
	 * error message needs to be printed.
	 *
	 * @param message the message
	 */
	public NootException(String msg) {
		super();
		this.msg = msg;
	}

	/**
	 * Instantiates a new noot exception.
	 * 
	 * Constructor that takes a node of the AST tree (i.e. IDENTIFIER) and
	 * the error message to build a more informative error message.
	 *
	 * @param tree the tree
	 * @param message the message
	 */
	public NootException(Tree tree, String msg)
	{
		super();
		this.msg = "" + tree.getText() +
				"[line:" + tree.getLine() +
				" char:" + tree.getCharPositionInLine() +
				"] :: " + msg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage()
	{
		return this.msg;
	}
}