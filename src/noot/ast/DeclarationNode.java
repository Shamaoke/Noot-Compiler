package noot.ast;

import noot.compiler.NootParser;

import org.antlr.runtime.Token;

public class DeclarationNode extends Node {
	
	private int declarationLevel = 0;
	
	public DeclarationNode() { super(); }
	public DeclarationNode(Token t) { super(t); }
	public DeclarationNode(DeclarationNode n) { super(n); }
	public DeclarationNode dupNode() { return new DeclarationNode(this); } 
	
	public int getDeclarationLevel()
	{
		return this.declarationLevel;
	}
	
	public void setDeclarationLevel(int declarationLevel) {
		this.declarationLevel = declarationLevel;
	}
	
	public IdentifierNode getIdentifierNode()
	{
		if(this.getChild(0) != null && this.getChild(0) instanceof IdentifierNode)
			return (IdentifierNode)this.getChild(0);
		else
			return null;
	}
	
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
