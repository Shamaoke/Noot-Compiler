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

// TODO: Auto-generated Javadoc
/**
 * The Class NumericalExpressionNode.
 */
public class NumericalExpressionNode extends Node {

	/** The value. */
	protected int value = 0;
	
	/**
	 * Instantiates a new numerical expression node.
	 */
	public NumericalExpressionNode() { super(); }
	
	/**
	 * Instantiates a new numerical expression node.
	 *
	 * @param t the t
	 */
	public NumericalExpressionNode(Token t) { super(t); }
	
	/**
	 * Instantiates a new numerical expression node.
	 *
	 * @param n the n
	 */
	public NumericalExpressionNode(NumericalExpressionNode n) { super(n); }
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#dupNode()
	 */
	public NumericalExpressionNode dupNode() { return new NumericalExpressionNode(this); } 

	/**
	 * Get the List value of this node.
	 *
	 * @return the value
	 */
	public int getValue() { return value; }

	/**
	 * Set the List value of this node.
	 *
	 * @param value the new value
	 */
	public void setValue(int value) { this.value = value; }
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#getNodeType()
	 */
	public NodeType getNodeType()
	{
		return NodeType.INT;
	}

	/* (non-Javadoc)
	 * @see noot.ast.Node#toString()
	 */
	public String toString()
	{	
		String s = super.toString();
		//s = s + " {NumExpr}";
		return s;
	}
	
}
