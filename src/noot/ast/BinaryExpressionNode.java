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

/**
 * The Class BinaryExpressionNode.
 * 
 * Nodes with a default boolean return type can be
 * represented by the BinaryExpressionNode
 */
public class BinaryExpressionNode extends Node {
	
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

	/* (non-Javadoc)
	 * @see noot.ast.Node#getNodeType()
	 */
	public NodeType getNodeType()
	{
		return NodeType.BOOL;
	}
	
}
