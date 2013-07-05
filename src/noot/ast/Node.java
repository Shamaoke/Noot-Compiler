/*
 * @author Thijs Scheepers <thijs@label305.com>
 * Copyright (c) 2013 Thijs Scheepers. All Right Reserved.
 *
 * This source is subject to the BSD Licence.
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
import org.antlr.runtime.tree.CommonTree;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 */
public class Node extends CommonTree {
	
	/**
	 * The Enum NodeType.
	 */
	public enum NodeType {
	    
    	/** The void. */
    	VOID, 
 /** The int. */
 INT, 
 /** The bool. */
 BOOL, 
 /** The char. */
 CHAR 
	}
	
	/**
	 * Instantiates a new node.
	 */
	public Node() { super(); }
	
	/**
	 * Instantiates a new node.
	 *
	 * @param t the t
	 */
	public Node(Token t) { super(t); }
	
	/**
	 * Instantiates a new node.
	 *
	 * @param n the n
	 */
	public Node(Node n) { super(n); }
	
	/* (non-Javadoc)
	 * @see org.antlr.runtime.tree.CommonTree#dupNode()
	 */
	public Node dupNode() { return new Node(this); } 
	
	/**
	 * Gets the node type.
	 *
	 * @return the node type
	 */
	public NodeType getNodeType()
	{
		return NodeType.VOID;
	}

	/* (non-Javadoc)
	 * @see org.antlr.runtime.tree.CommonTree#toString()
	 */
	public String toString()
	{	
		String s = super.toString();
		
		if(this.getNodeType() != NodeType.VOID)
		{
			s = s + "{" + this.getNodeType() + "}";
		}
		
		return s;
	}
}
