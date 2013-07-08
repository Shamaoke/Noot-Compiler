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

import java.util.ArrayList;
import java.util.List;

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
	
	/** The ignore return value. */
	private boolean ignoreReturnValue = false;
	
	/** The Value propagating children. */
	private ArrayList<Node> ValuePropagatingChildren = new ArrayList<Node>();
	
	

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
		
		String ignoreResultString = this.ignoreReturnValue ? " ir" : "";

		if(this.getNodeType() != NodeType.VOID)
		{
			s = s + "[" + this.getNodeType() + ignoreResultString + "]";
		}
		else if (!ignoreResultString.equals(""))
		{
			s = s + "[" + ignoreResultString + " ]";
		}
		
		return s;
	}

	/**
	 * Should ignore return value.
	 *
	 * @return true, if successful
	 */
	public boolean shouldIgnoreReturnValue() {
		return ignoreReturnValue;
	}

	/**
	 * Sets the ignore return value.
	 *
	 * @param ignoreReturnValue the new ignore return value
	 */
	public void setIgnoreReturnValue(boolean ignoreReturnValue) {
		this.ignoreReturnValue = ignoreReturnValue;
		
		for(Node child : ValuePropagatingChildren)
			child.setIgnoreReturnValue(this.shouldIgnoreReturnValue());
	}
	
	/**
	 * Adds the value propagating child.
	 *
	 * @param ValuePropagatingChild the value propagating child
	 */
	public void addValuePropagatingChild(Node ValuePropagatingChild)
	{
		if(this.children.contains(ValuePropagatingChild))
		{
			ValuePropagatingChildren.add(ValuePropagatingChild);
		}
	}
	
	/**
	 * Adds the value propagating children.
	 *
	 * @param list the list
	 */
	public void addValuePropagatingChildren(List<Node> list)
	{
		for(Node child : list)
			this.addValuePropagatingChild(child);
	}
	
}
