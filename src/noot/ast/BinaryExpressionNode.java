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
package noot.ast;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;

// TODO: Auto-generated Javadoc
/**
 * The Class BinaryExpressionNode.
 */
public class BinaryExpressionNode extends Node {
	
	/** The value. */
	protected boolean value = false;
	
	/**
	 * Instantiates a new binary expression node.
	 */
	public BinaryExpressionNode() { super(); }
	
	/**
	 * Instantiates a new binary expression node.
	 *
	 * @param t the t
	 */
	public BinaryExpressionNode(Token t) { super(t); }
	
	/**
	 * Instantiates a new binary expression node.
	 *
	 * @param n the n
	 */
	public BinaryExpressionNode(BinaryExpressionNode n) { super(n); }
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#dupNode()
	 */
	public BinaryExpressionNode dupNode() { return new BinaryExpressionNode(this); } 

	/**
	 * Get the List value of this node.
	 *
	 * @return the value
	 */
	public boolean getValue() { return value; }

	/**
	 * Set the List value of this node.
	 *
	 * @param value the new value
	 */
	public void setValue(boolean value) { this.value = value; }

	/* (non-Javadoc)
	 * @see noot.ast.Node#getNodeType()
	 */
	public NodeType getNodeType()
	{
		return NodeType.BOOL;
	}
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#toString()
	 */
	public String toString() {
		
		String s = super.toString();
		//s = s + " {BinExpr}";
		return s;
	}
}
