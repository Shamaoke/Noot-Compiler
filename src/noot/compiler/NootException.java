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

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;

// TODO: Auto-generated Javadoc
/**
 * The Class NootException.
 */
public class NootException extends RecognitionException {
	
    /** The msg. */
    private String msg;
    
    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 24162462L; // for Serializable

    // Ctor which only requires the error message to be printed.
    /**
     * Instantiates a new noot exception.
     *
     * @param msg the msg
     */
    public NootException(String msg) {
        super();
        this.msg = msg;
    }

    // Ctor that takes a node of the AST tree (i.e. IDENTIFIER) and
    // the error message to build a more informative error message.
    /**
     * Instantiates a new noot exception.
     *
     * @param tree the tree
     * @param msg the msg
     */
    public NootException(Tree tree, String msg) {
        super();
        this.msg = tree.getText() +
                " (" + tree.getLine() +
                ":" + tree.getCharPositionInLine() +
                ") " + msg;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return this.msg;
    }
}