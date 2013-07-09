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
 * The Class IdentifierNode.
 * 
 * This node represents an identifier. The type of IdentifierNodes
 * is determined by there DeclarationNode. You should always couple
 * a DeclarationNode to an IdentifierNode.
 */
public class IdentifierNode extends Node {

	/**
	 * The declaration node associated with this identifier node.
	 * This node will be used to determine the type of this node.
	 */
	private DeclarationNode declarationNode;

	/**
	 * Instantiates a new identifier node.
	 */
	public IdentifierNode() { super(); }
	
	/**
	 * Instantiates a new identifier node.
	 *
	 * @param t the Token
	 */
	public IdentifierNode(Token t) { super(t); }
	
	/**
	 * Instantiates a new identifier node.
	 *
	 * @param n the IdentifierNode
	 */
	public IdentifierNode(IdentifierNode n) { super(n); }
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#dupNode()
	 */
	public IdentifierNode dupNode() { return new IdentifierNode(this); } 

	/**
	 * Sets the declaration node.
	 * 
	 * This node will be used to determine the type of this node.
	 *
	 * @param node the declaration node
	 */
	public void setDeclarationNode(DeclarationNode node)
	{
		this.declarationNode = node;
	}
	
	/**
	 * Gets the declaration node.
	 * 
	 * This can be used to check if the identifier represents a constant.
	 *
	 * @return the declaration node
	 */
	public DeclarationNode getDeclarationNode()
	{
		return declarationNode;
	}
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#getNodeType()
	 */
	public NodeType getNodeType()
	{
		if(this.declarationNode != null)
		{	
			return this.declarationNode.getDeclaredType();
		}
		return NodeType.VOID;
	}	
	
}
