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
 * The Class NumericalExpressionNode.
 * 
 * Nodes with a default numerical return type can be
 * represented by the NumericalExpressionNode. The
 * getNodeType() method will always return NootType.INT
 */
public class NumericalExpressionNode extends Node {
	
	/**
	 * Instantiates a new numerical expression node.
	 */
	public NumericalExpressionNode() { super(); }
	
	/**
	 * Instantiates a new numerical expression node.
	 *
	 * @param t the Token
	 */
	public NumericalExpressionNode(Token t) { super(t); }
	
	/**
	 * Instantiates a new numerical expression node.
	 *
	 * @param n the NumericalExpressionNode
	 */
	public NumericalExpressionNode(NumericalExpressionNode n) { super(n); }
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#dupNode()
	 */
	public NumericalExpressionNode dupNode() { return new NumericalExpressionNode(this); } 
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#getNodeType()
	 */
	public NodeType getNodeType()
	{
		return NodeType.INT;
	}
	
}
