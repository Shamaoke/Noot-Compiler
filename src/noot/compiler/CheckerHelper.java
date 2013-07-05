package noot.compiler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import noot.ast.*;
import noot.ast.Node.NodeType;

public class CheckerHelper {

	private int scopingLevel = 0;

	private HashMap<String,DeclarationNode> currentDeclarationsMap = new HashMap<String,DeclarationNode>();
	private Stack<HashMap<String, DeclarationNode>> declarationsStack = new Stack<HashMap<String,DeclarationNode>>();

	/** 
	 * Opens a new scope. 
	 * @ensures this.scopingLevel() == old.scopingLevel()+1;
	 */
	public void openScope()  {
		scopingLevel++;
		declarationsStack.push(currentDeclarationsMap);
		currentDeclarationsMap = new HashMap<String,DeclarationNode>(currentDeclarationsMap);
	}

	/** 
	 * Closes the current scope. All identifiers in 
	 * the current scope will be removed from the SymbolTable.
	 * @requires old.scopingLevel() > -1;
	 * @ensures  this.scopingLevel() == old.scopingLevel()-1;
	 */
	public void closeScope() {
		if(scopingLevel > -1) scopingLevel--;
		currentDeclarationsMap = declarationsStack.pop();
	}

	/** Returns the current scope level. */
	public int scopingLevel() {
		return scopingLevel;
	}

	/** 
	 * Enters an id together with an entry into this SymbolTable 
	 * using the current scope level. The entry's level is set to 
	 * currentLevel().
	 * @requires id != null && id.length() > 0 && entry != null;
	 * @ensures  this.retrieve(id).getLevel() == currentLevel();
	 * @throws SymbolTableException when there is no valid 
	 *    current scope level, or when the id is already declared 
	 *    on the current level. 
	 */
	public void declare(DeclarationNode node)
			throws CheckerException { 
		node.setDeclarationLevel(scopingLevel);

		IdentifierNode identifierNode = node.getIdentifierNode();

		if(identifierNode == null)  // Used for easy debugging of an misconfigured Checker grammar.
			throw new NullPointerException("Declaration does not have an identifier");

		if(currentDeclarationsMap.get(identifierNode.getText()) != null &&
				currentDeclarationsMap.get(identifierNode.getText()).getDeclarationLevel() == scopingLevel)
			throw new CheckerException(identifierNode.getText()+" on line: " + identifierNode.getLine() + " has already been declared on current level");

		currentDeclarationsMap.put(identifierNode.getText(),node);
	}

	/** 
	 * Get the Entry corresponding with id whose level is
	 * the highest; in other words, that is defined last.
	 * @return  Entry of this id on the highest level
	 *          null if this SymbolTable does not contain id 
	 */
	public void linkToDeclaration(IdentifierNode node) 
			throws CheckerException {

		DeclarationNode declarationNode = currentDeclarationsMap.get(node.getText()); // body nog toe te voegen

		if(declarationNode == null)
		{
			throw new CheckerException(node.getText()+" on line: " + node.getLine() + " has not been declared.");
		}
		else
		{
			node.setDeclarationNode(declarationNode);
		}
	}

	public void checkExpressionsForType(List<Node> expressions, NodeType type, Node operator) throws CheckerException
	{	
		for (int i = 0; i < expressions.size(); i++)
		{
			Node expression = expressions.get(i);
			
			if(expression == null) // Used for easy debugging of an misconfigured Checker grammar.
				throw new NullPointerException("Expression(" + i + ") is null while checking for operator (" + operator.getText() + ").");
			
			if(expression.getNodeType() != type)
				throw new CheckerException(expression.getNodeType() +" expression on line: " + expression.getLine() + " needs to be " + type + " in order to use it with the " + operator.getText() + " operator.");
		}
	}
	
	public void checkExpressionsForEqualType(List<Node> expressions, Node operator) throws CheckerException
	{	
		NodeType type = null;
		
		for (int i = 0; i < expressions.size(); i++)
		{
			Node expression = expressions.get(i);
			
			if(expression == null) // Used for easy debugging of an misconfigured Checker grammar.
				throw new NullPointerException("Expression(" + i + ") is null while checking for operator (" + operator.getText() + ").");
			
			if(type == null)
				type = expression.getNodeType();
			else if(expression.getNodeType() != type)
				throw new CheckerException(expression.getNodeType() +" expression on line: " + expression.getLine() + " expected to be " + type + " so all expressions have the same type, this is needed in order to use the " + operator.getText() + " operator.");
		}
	}

}
