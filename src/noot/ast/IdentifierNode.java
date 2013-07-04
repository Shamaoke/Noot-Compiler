package noot.ast;

import org.antlr.runtime.Token;

public class IdentifierNode extends Node {

	private DeclarationNode declarationNode;
	
	public IdentifierNode() { super(); }
	public IdentifierNode(Token t) { super(t); }
	public IdentifierNode(IdentifierNode n) { super(n); }
	public IdentifierNode dupNode() { return new IdentifierNode(this); } 

	public void setDeclarationNode(DeclarationNode node)
	{
		this.declarationNode = node;
	}
	
	public NodeType getNodeType()
	{
		return this.declarationNode.getDeclaredType();
	}
	
	public String toString() {
		
		String s = super.toString();
		
		if(this.declarationNode != null)
		{
			s = s + "{" + this.getNodeType() + "}";
		}
		
		return s;
	}
	
}
