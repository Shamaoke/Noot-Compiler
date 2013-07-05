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
 * The Class IdentifierNode.
 */
public class IdentifierNode extends Node {

	/** The declaration node. */
	private DeclarationNode declarationNode;
	
	/**
	 * Instantiates a new identifier node.
	 */
	public IdentifierNode() { super(); }
	
	/**
	 * Instantiates a new identifier node.
	 *
	 * @param t the t
	 */
	public IdentifierNode(Token t) { super(t); }
	
	/**
	 * Instantiates a new identifier node.
	 *
	 * @param n the n
	 */
	public IdentifierNode(IdentifierNode n) { super(n); }
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#dupNode()
	 */
	public IdentifierNode dupNode() { return new IdentifierNode(this); } 

	/**
	 * Sets the declaration node.
	 *
	 * @param node the new declaration node
	 */
	public void setDeclarationNode(DeclarationNode node)
	{
		this.declarationNode = node;
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
