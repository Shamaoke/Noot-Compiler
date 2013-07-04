package noot.compiler;
import java.util.ArrayList;
import java.util.HashMap;
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
		
		if(identifierNode == null)
			throw new CheckerException("Declaration does not have an identifier");
		
		if(currentDeclarationsMap.get(identifierNode.getText()) != null &&
				currentDeclarationsMap.get(identifierNode.getText()).getDeclarationLevel() == scopingLevel)
			throw new CheckerException("Entry already declared on current level");
		
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
			throw new CheckerException(node.getText()+" had not been declared.");
		}
		else
		{
			node.setDeclarationNode(declarationNode);
		}
	}

}
