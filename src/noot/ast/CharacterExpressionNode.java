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
 * The Class CharacterNode.
 */
public class CharacterExpressionNode extends Node {

	/**
	 * Instantiates a new character node.
	 */
	public CharacterExpressionNode() { super(); }
	
	/**
	 * Instantiates a new character node.
	 *
	 * @param t the t
	 */
	public CharacterExpressionNode(Token t) { super(t); }
	
	/**
	 * Instantiates a new character node.
	 *
	 * @param n the n
	 */
	public CharacterExpressionNode(CharacterExpressionNode n) { super(n); }
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#dupNode()
	 */
	public CharacterExpressionNode dupNode() { return new CharacterExpressionNode(this); } 
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#getNodeType()
	 */
	public NodeType getNodeType()
	{
		return NodeType.CHAR;
	}
	
}
