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

import noot.compiler.NootParser;

import org.antlr.runtime.Token;

// TODO: Auto-generated Javadoc
/**
 * The Class DeclarationNode.
 */
public class DeclarationNode extends Node {
	
	/** The declaration level. */
	private int declarationLevel = 0;
	
	/**
	 * Instantiates a new declaration node.
	 */
	public DeclarationNode() { super(); }
	
	/**
	 * Instantiates a new declaration node.
	 *
	 * @param t the t
	 */
	public DeclarationNode(Token t) { super(t); }
	
	/**
	 * Instantiates a new declaration node.
	 *
	 * @param n the n
	 */
	public DeclarationNode(DeclarationNode n) { super(n); }
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#dupNode()
	 */
	public DeclarationNode dupNode() { return new DeclarationNode(this); } 
	
	/**
	 * Gets the declaration level.
	 *
	 * @return the declaration level
	 */
	public int getDeclarationLevel()
	{
		return this.declarationLevel;
	}
	
	/**
	 * Sets the declaration level.
	 *
	 * @param declarationLevel the new declaration level
	 */
	public void setDeclarationLevel(int declarationLevel) {
		this.declarationLevel = declarationLevel;
	}
	
	/**
	 * Gets the identifier node.
	 *
	 * @return the identifier node
	 */
	public IdentifierNode getIdentifierNode()
	{
		if(this.getChild(0) != null && this.getChild(0) instanceof IdentifierNode)
			return (IdentifierNode)this.getChild(0);
		else
			return null;
	}
	
	/**
	 * Gets the declared type.
	 *
	 * @return the declared type
	 */
	public NodeType getDeclaredType()
	{
		if(this.getType() == NootParser.COMMA && this.getParent() instanceof DeclarationNode)
		{
			return ((DeclarationNode)this.getParent()).getDeclaredType();
		}
		else if(this.getType() == NootParser.INT)
		{
			return NodeType.INT;
		}
		else if(this.getType() == NootParser.CHAR)
		{
			return NodeType.CHAR;
		}
		else if(this.getType() == NootParser.BOOL)
		{
			return NodeType.BOOL;
		}
			
		return NodeType.VOID;
	}
	
}
