package noot.ast;

import org.antlr.runtime.Token;

public class NumericalExpressionNode extends Node {

	protected int value = 0;
	public NumericalExpressionNode() { super(); }
	public NumericalExpressionNode(Token t) { super(t); }
	public NumericalExpressionNode(NumericalExpressionNode n) { super(n); }
	public NumericalExpressionNode dupNode() { return new NumericalExpressionNode(this); } 

	/** Get the List value of this node. */
	public int getValue() { return value; }

	/** Set the List value of this node. */
	public void setValue(int value) { this.value = value; }
	
	public NodeType getNodeType()
	{
		return NodeType.INT;
	}

	public String toString() {
		
		String s = super.toString();
		//s = s + " {NumExpr}";
		return s;
	}
}
