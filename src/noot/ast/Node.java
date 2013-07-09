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

/**
 * The Class Node.
 * 
 * This subclass of CommonTree is used to check for the contextual constrains
 * of the Noot language. Furthermore it is used to annotate the AST with important
 * information such as type information and if the Node yields a return value.
 */
public class Node extends CommonTree {

	/**
	 * The Enum NodeType.
	 * Use this Enumeration to check and compare
	 * the type of Node objects
	 */
	public enum NodeType {
		/** Void NodeType. */
		VOID, 
		/** Integer NodeType. */
		INT, 
		/** Boolean NodeType. */
		BOOL, 
		/** Character NodeType. */
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
	 * @param t the Token
	 */
	public Node(Token t) { super(t); }

	/**
	 * Instantiates a new node.
	 *
	 * @param n the Node
	 */
	public Node(Node n) { super(n); }

	/* (non-Javadoc)
	 * @see org.antlr.runtime.tree.CommonTree#dupNode()
	 */
	public Node dupNode() { return new Node(this); } 

	/**
	 * Gets the node type.
	 *
	 * Subclasses should override this method.
	 * 
	 * @return the node type
	 */
	public NodeType getNodeType()
	{
		return NodeType.VOID;
	}

	/**
	 * Should ignore return value.
	 * 
	 * This method will be used in the code generator to check
	 * if this node yields a return value.
	 *
	 * @return true, if the return value of this node should be ignored
	 */
	public boolean shouldIgnoreReturnValue()
	{
		return ignoreReturnValue;
	}

	/**
	 * Sets the ignore return value.
	 * 
	 * Set this value to true if the node should not yield a return value
	 * the default behavior is that it does.
	 * 
	 * This will be propagated through all the ValuePropagatingChildren.
	 * 
	 * This important for code generation.
	 *
	 * @param ignoreReturnValue the new ignore return value
	 */
	public void setIgnoreReturnValue(boolean ignoreReturnValue)
	{
		this.ignoreReturnValue = ignoreReturnValue;

		for(Node child : ValuePropagatingChildren)
			child.setIgnoreReturnValue(this.shouldIgnoreReturnValue());
	}

	/**
	 * Adds the value propagating child.
	 * 
	 * If setIgnoreReturnValue() is called on this Node it will be
	 * propagated through all the ValuePropagatingChildren. This
	 * is needed to support value returning in nested CompoundExpressions
	 * for example.
	 *
	 * @require ValuePropagatingChild != null
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
	 * If setIgnoreReturnValue() is called on this Node it will be
	 * propagated through all the ValuePropagatingChildren. This
	 * is needed to support value returning in nested CompoundExpressions
	 * for example.
	 * 
	 * @require list != null
	 * @param list the list
	 */
	public void addValuePropagatingChildren(List<Node> list)
	{
		for(Node child : list)
			this.addValuePropagatingChild(child);
	}
	
	/* (non-Javadoc)
	 * @see org.antlr.runtime.tree.CommonTree#toString()
	 * 
	 * This method is added to be used by the DOTNodeAdaptor and
	 * the toTreeString() method. So these contain more meaningful
	 * information.
	 */
	public String toString()
	{	
		String s = super.toString();

		String ignoreResultString = this.ignoreReturnValue ? " ir" : "";

		if(this.getNodeType() != NodeType.VOID)
			s = s + "[" + this.getNodeType() + ignoreResultString + "]";
		else if (!ignoreResultString.equals(""))
			s = s + "[" + ignoreResultString + " ]";

		return s;
	}

}
