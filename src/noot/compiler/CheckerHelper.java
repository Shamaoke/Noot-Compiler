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

package noot.compiler;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import noot.ast.*;
import noot.ast.Node.NodeType;
import noot.exceptions.CheckerException;
import noot.exceptions.NootException;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckerHelper.
 */
public class CheckerHelper extends ScopeHelper {

	/** The current declarations map. */
	private HashMap<String,DeclarationNode> currentDeclarationsMap = new HashMap<String,DeclarationNode>();
	
	/** The declarations stack. */
	private Stack<HashMap<String, DeclarationNode>> declarationsStack = new Stack<HashMap<String,DeclarationNode>>();

	/* (non-Javadoc)
	 * @see noot.compiler.ScopeHelper#openScope()
	 */
	public void openScope()
	{
		super.openScope();
		declarationsStack.push(currentDeclarationsMap);
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
	 * Declare.
	 *
	 * @param node the node
	 * @throws CheckerException the checker exception
	 */
	public void declare(DeclarationNode node)
			throws CheckerException { 
		node.setDeclarationLevel(this.scopingLevel());

		IdentifierNode identifierNode = node.getIdentifierNode();

		if(identifierNode == null)  // Used for easy debugging of an misconfigured Checker grammar.
			throw new NullPointerException("Declaration does not have an identifier");

		if(currentDeclarationsMap.get(identifierNode.getText()) != null &&
				currentDeclarationsMap.get(identifierNode.getText()).getDeclarationLevel() == this.scopingLevel())
			throw new CheckerException(identifierNode,identifierNode.getText()+" has already been declared in current scope.");

		currentDeclarationsMap.put(identifierNode.getText(),node);
	}

	/**
	 * Link to declaration.
	 *
	 * @param node the node
	 * @throws CheckerException the checker exception
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
	 * Check expressions for type.
	 *
	 * @param expressions the expressions
	 * @param type the type
	 * @param operator the operator, only here for logging and context information when exceptions are thrown
	 * @throws CheckerException the checker exception
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
	 * Check expressions for equal type.
	 *
	 * @param expressions the expressions
	 * @param operator the operator, only here for logging and context information when exceptions are thrown
	 * @throws CheckerException the checker exception
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
