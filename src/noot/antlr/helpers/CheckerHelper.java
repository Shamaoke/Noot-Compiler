/*
 * @author Thijs Scheepers <thijs@label305.com>
 * Copyright (c) 2013 Thijs Scheepers.
 *
 * This source is subject to the BSD License.
 * Please see the LICENSE file for more information.
 * All other rights reserved.
 *
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY 
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 * 
 */

package noot.antlr.helpers;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import noot.ast.*;
import noot.ast.Node.NodeType;
import noot.exceptions.CheckerException;
import noot.exceptions.NootException;

/**
 * The Class CheckerHelper.
 * 
 * This helper class is here to support the Checker. It will help annotating the AST,
 * provide help with Scoping and helps checking for types.
 */
public class CheckerHelper extends ScopeHelper {

	/** The current declarations map.
	 *  This map contains all the accessible declarations on the current level.
	 */
	private HashMap<String,DeclarationNode> currentDeclarationsMap = new HashMap<String,DeclarationNode>();

	/** The declarations stack.
	 *  This Stack contains all the maps for all the declaration levels.
	 */
	private Stack<HashMap<String, DeclarationNode>> declarationsStack = new Stack<HashMap<String,DeclarationNode>>();

	/* (non-Javadoc)
	 * @see noot.compiler.ScopeHelper#openScope()
	 */
	public void openScope()
	{
		super.openScope();
		declarationsStack.push(currentDeclarationsMap);
		// Copy the current map so all declarations on lower levels are still accessible but overwriteable
		currentDeclarationsMap = new HashMap<String,DeclarationNode>(currentDeclarationsMap); 
	}

	/* (non-Javadoc)
	 * @see noot.compiler.ScopeHelper#closeScope()
	 */
	protected void closeScope() throws NootException
	{
		super.closeScope();
		currentDeclarationsMap = declarationsStack.pop();
	}

	/**
	 * Declare a declaration node.
	 * 
	 * This will add scoping information to the declaration node. And will make it possible to link IdentifierNodes to this
	 * DeclarationNode with the linkToDeclaration(IdentifierNode node) method.
	 * 
	 * This method will throw an exception if node has already been declared with a certain identifier on the current level.
	 *
	 * @require node != null
	 * @param node the declaration node to declare on the current scope level.
	 * @throws CheckerException the checker exception thrown when declaration already declared on current scoping level. 
	 */
	public void declare(DeclarationNode node)
			throws CheckerException { 
		node.setDeclarationLevel(this.scopingLevel());

		IdentifierNode identifierNode = node.getIdentifierNode();

		if(identifierNode == null)  // Used for easy debugging of an misconfigured Checker grammar.
			throw new NullPointerException("Declaration does not have an identifier");

		// Throw exception if declaration has already been done on the current scoping level
		if(currentDeclarationsMap.get(identifierNode.getText()) != null &&
				currentDeclarationsMap.get(identifierNode.getText()).getDeclarationLevel() == this.scopingLevel())
			throw new CheckerException(identifierNode,identifierNode.getText()+" has already been declared in current scope.");

		currentDeclarationsMap.put(identifierNode.getText(),node);
	}

	/**
	 * Link to identifier node to the correct declaration node in the accessible scopes.
	 * 
	 * This will throw an exception if an identifier has not been declared in the accessible scopes.
	 * 
	 * @require node != null
	 * @param node the identifier node to link to a declaration 
	 * @throws CheckerException the checker exception thrown if an identifier has not been declared in the accessible scopes.
	 */
	public void linkToDeclaration(IdentifierNode node) 
			throws CheckerException {

		DeclarationNode declarationNode = currentDeclarationsMap.get(node.getText()); // body nog toe te voegen

		if(declarationNode == null)
		{
			throw new CheckerException(node,node.getText()+" has not been declared.");
		}
		else
		{
			node.setDeclarationNode(declarationNode);
		}
	}

	/**
	 * Check if all input nodes have a specific type.
	 * 
	 * This method throws an exception if that is not the case.
	 *
	 * @require expressions != null
	 * @param expressions the expression nodes to check for the type
	 * @param type the type to check
	 * @param operator the operator, only here for logging and context information when exceptions are thrown
	 * @throws CheckerException the checker exception thrown when type mismatch occurs.
	 */
	public void checkExpressionsForType(List<Node> expressions, NodeType type, Node operator) throws CheckerException
	{	
		for (int i = 0; i < expressions.size(); i++)
		{
			Node expression = expressions.get(i);

			if(expression == null) // Used for easy debugging of an misconfigured Checker grammar.
				throw new NullPointerException("Expression(" + i + ") is null while checking for operator (" + operator.getText() + ").");

			if(expression.getNodeType() != type)
				throw new CheckerException(expression,expression.getNodeType() +" expression needs to be " + type + " in order to use it with the " + operator.getText() + " operator.");
		}
	}

	/**
	 * Check if all the input nodes have the same type.
	 * 
	 * This method throws an exception if that is not the case.
	 *
	 * @require expressions != null
	 * @param expressions the expression nodes to check for the same type
	 * @param operator the operator, only here for logging and context information when exceptions are thrown
	 * @throws CheckerException the checker exception thrown when type mismatch occurs.
	 */
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
				throw new CheckerException(expression,expression.getNodeType() +" expression expected to be " + type + " so all expressions have the same type, this is needed in order to use the " + operator.getText() + " operator.");
		}
	}

}
