package noot.ast;

import org.antlr.runtime.Token;

public class TypeAdoptedNode extends Node {
	
		// This needs to be mutable for the check on the becomes operator
		private Node typeDefiningChild;
		
		public TypeAdoptedNode() { super(); }
		public TypeAdoptedNode(Token t) { super(t); }
		public TypeAdoptedNode(TypeAdoptedNode n) { super(n); }
		public TypeAdoptedNode dupNode() { return new TypeAdoptedNode(this); } 
		
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
		
		public Node getTypeDefiningChild()
		{
			return this.typeDefiningChild;
		}
		
		public void setTypeDefiningChild(Node typeDefiningChild)
		{
			if(this.children.contains(typeDefiningChild))
				this.typeDefiningChild = typeDefiningChild;
		}
		
		
}
