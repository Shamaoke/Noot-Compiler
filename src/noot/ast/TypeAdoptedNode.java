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
 * The Class TypeAdoptedNode.
 */
public class TypeAdoptedNode extends Node {
	
		/** The type defining child. */
		private Node typeDefiningChild;
		
		/**
		 * Instantiates a new type adopted node.
		 */
		public TypeAdoptedNode() { super(); }
		
		/**
		 * Instantiates a new type adopted node.
		 *
		 * @param t the t
		 */
		public TypeAdoptedNode(Token t) { super(t); }
		
		/**
		 * Instantiates a new type adopted node.
		 *
		 * @param n the n
		 */
		public TypeAdoptedNode(TypeAdoptedNode n) { super(n); }
		
		/* (non-Javadoc)
		 * @see noot.ast.Node#dupNode()
		 */
		public TypeAdoptedNode dupNode() { return new TypeAdoptedNode(this); } 
		
		/* (non-Javadoc)
		 * @see noot.ast.Node#getNodeType()
		 */
		public NodeType getNodeType()
		{
			if(typeDefiningChild != null)
			{
				return typeDefiningChild.getNodeType();
			}
			else
			{
				return NodeType.VOID;
			}
		}
		
		/**
		 * Gets the type defining child.
		 *
		 * @return the type defining child
		 */
		public Node getTypeDefiningChild()
		{
			return this.typeDefiningChild;
		}
		
		/**
		 * Sets the type defining child.
		 *
		 * @param typeDefiningChild the new type defining child
		 */
		public void setTypeDefiningChild(Node typeDefiningChild)
		{
			if(this.children.contains(typeDefiningChild))
			{
				this.typeDefiningChild = typeDefiningChild;
			}
		}
		
		
}
