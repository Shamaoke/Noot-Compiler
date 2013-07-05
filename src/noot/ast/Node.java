package noot.ast;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

public class Node extends CommonTree {
	
	public enum NodeType {
	    VOID, INT, BOOL, CHAR 
	}
	
	public Node() { super(); }
	public Node(Token t) { super(t); }
	public Node(Node n) { super(n); }
	public Node dupNode() { return new Node(this); } 
	
	public NodeType getNodeType()
	{
		return NodeType.VOID;
	}

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
