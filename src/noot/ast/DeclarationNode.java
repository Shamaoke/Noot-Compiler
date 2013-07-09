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

/**
 * The Class DeclarationNode.
 * 
 * This node represents a declaration. It can be used to identify
 * the type of associated IdentifierNodes. These Nodes can't be accessed
 * through this object but this instances of DeclarationNode van be
 * accessed through them.
 * 
 * The DeclarationNode also contains information about the scoping
 * level and if it represents a constant or not.
 */
public class DeclarationNode extends Node {
	
	/** The declaration scoping level. */
	private int declarationLevel = 0;
	
	/** Constant, if true this declaration represents a constant . */
	private boolean constant = false;
	
	/**
	 * Instantiates a new declaration node.
	 */
	public DeclarationNode() { super(); }
	
	/**
	 * Instantiates a new declaration node.
	 *
	 * @param t the Token
	 */
	public DeclarationNode(Token t) { super(t); }
	
	/**
	 * Instantiates a new declaration node.
	 *
	 * @param n the DeclarationNode
	 */
	public DeclarationNode(DeclarationNode n) { super(n); }
	
	/* (non-Javadoc)
	 * @see noot.ast.Node#dupNode()
	 */
	public DeclarationNode dupNode() { return new DeclarationNode(this); } 
	
	/**
	 * Gets the declaration scoping level.
	 * 
	 * @return the scoping level on which this declaration has been done
	 */
	public int getDeclarationLevel()
	{
		return this.declarationLevel;
	}
	
	/**
	 * Sets the declaration scoping level.
	 * 
	 * @ensure this.getDeclarationLevel() == declarationLevel
	 * @param declarationLevel the scoping level on which this declaration has been done
	 */
	public void setDeclarationLevel(int declarationLevel) {
		this.declarationLevel = declarationLevel;
	}
	
	/**
	 * Gets the associated identifier node used in the declaration.
	 * This should only be used for logging and debugging not for evaluation
	 * because other identifier nodes could be connected to this declaration.
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
	 * Use this method to get the type of associated IdentifierNodes.
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

	/**
	 * Checks if this declaration represents a constant.
	 *
	 * @return true, if is this declaration is a constant
	 */
	public boolean isConstant() {
		return constant;
	}

	/**
	 * Sets the if this declaration is a constant.
	 *
	 * @param constant true if declaration is a constant false if it is a variable
	 */
	public void setConstant(boolean constant) {
		this.constant = constant;
	}
	
}
