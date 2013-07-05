package noot.ast;

import org.antlr.runtime.Token;

public class CharacterNode extends Node {

	public CharacterNode() { super(); }
	public CharacterNode(Token t) { super(t); }
	public CharacterNode(CharacterNode n) { super(n); }
	public CharacterNode dupNode() { return new CharacterNode(this); } 
	
	public NodeType getNodeType()
	{
		return NodeType.CHAR;
	}
}
