package noot.ast;


import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTreeAdaptor;

public class NodeAdaptor extends CommonTreeAdaptor {
	
	public Object create(Token t) {
		return new Node(t);
	}
}
