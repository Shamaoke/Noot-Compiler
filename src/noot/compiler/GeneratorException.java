package noot.compiler;

import org.antlr.runtime.tree.Tree;

public class GeneratorException extends NootException {

	private static final long serialVersionUID = 6841118816451063086L;
	
	public GeneratorException(String msg)
	{
		super(msg);
	}
	
	public GeneratorException(Tree tree, String msg)
	{
		super(tree,msg);
	}
}