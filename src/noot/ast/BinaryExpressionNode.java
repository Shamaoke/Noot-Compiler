package noot.ast;

import org.antlr.runtime.Token;

public class BinaryExpressionNode extends Node {
	
	protected boolean value = false;
	public BinaryExpressionNode() { super(); }
	public BinaryExpressionNode(Token t) { super(t); }
	public BinaryExpressionNode(BinaryExpressionNode n) { super(n); }
	public BinaryExpressionNode dupNode() { return new BinaryExpressionNode(this); } 

	/** Get the List value of this node. */
	public boolean getValue() { return value; }

	/** Set the List value of this node. */
	public void setValue(boolean value) { this.value = value; }

	public NodeType getNodeType()
	{
		return NodeType.BOOL;
	}
	
	public String toString() {
		
		String s = super.toString();
		//s = s + " {BinExpr}";
		return s;
	}
}
