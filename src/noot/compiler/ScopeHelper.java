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

import java.util.Stack;

import noot.exceptions.NootException;

// TODO: Auto-generated Javadoc
/**
 * The Class ScopeHelper.
 * 
 * The ScopeHelper is a class that you can subclass in order to create
 * helper classes for Antlr Tree walkers.
 * 
 * Since almost all Tree walker helpers need to account for scoping this class
 * will provide an generic and complete way to do this.
 */
public class ScopeHelper {
	
	/**
	 * The current scoping level.
	 * Will be incremented by opening a scope
	 * and decremented by closing a scope.
	 * @invariant scopingLevel() >= 0;
	 */
	private int scopingLevel = 0;
	
	/** 
	 * The hold close scope at level integer stack.
	 * This stack will help when an upcoming scope needs to be
	 * held open. It holds the scope levels that needs to be held.
	 */
	private Stack<Integer> holdCloseScopeAtLevel = new Stack<Integer>(); // Needed for special scoping rules while and if statements
	
	/**
	 * Open a new scope.
	 * @ensure new.scopingLevel() == old.scopingLevel() + 1
	 */
	public void openScope()
	{
		scopingLevel++;
	}

	/**
	 * Try to close the current scope.
	 * 
	 * Scope will be closed when it is not held.
	 *
	 * @throws NootException exception will be thrown when requirements are ignored
	 * @require scopingLevel() <= 0
	 */
	public void tryToCloseScope() throws NootException
	{
		if(holdCloseScopeAtLevel.size() == 0 || holdCloseScopeAtLevel.peek().intValue() != scopingLevel)
		{
			closeScope();
		}
	}
	
	/**
	 * Close the current scope.
	 * 
	 * This method is not supposed to be called directly, use tryToCloseScope() or releaseAndCloseScope().
	 * It is here so it can be subclassed. Always call super.closeScope() in the subclassed method.
	 *
	 * @throws NootException exception will be thrown when requirements are ignored
	 * @require scopingLevel() <= 0
	 * @ensure new.scopingLevel() == old.scopingLevel() - 1
	 */
	protected void closeScope() throws NootException
	{
		if(scopingLevel <= 0)
			throw new NootException("Closing scope when level is already 0");
			
		scopingLevel--;
	}
	
	/**
	 * Hold the next upcoming scope.
	 * 
	 * The next opening scope will not be closed by the 
	 * tryToCloseScope() method until either releaseUpcommingScope() has been called
	 * or when the scope is being closed by the releaseAndCloseScope() method.
	 * 
	 * The holding of the scope can be used for special scoping rules with for example
	 * the While and If statements in Noot.
	 */
	public void holdUpcomingScope()
	{
		holdCloseScopeAtLevel.push(new Integer(scopingLevel + 1));
	}
	
	/**
	 * Release the held upcoming scope for closing to be allowed again.
	 * 
	 * The method will return true when holdUpcommingScope() has been called and an
	 * openScope() method has not been called since. Than the upcoming scope will be released.
	 *
	 * @return true, if successful
	 */
	public boolean releaseUpcomingScope()
	{
		if(holdCloseScopeAtLevel.peek() != null && holdCloseScopeAtLevel.peek().equals(new Integer(scopingLevel + 1)))
		{
			holdCloseScopeAtLevel.pop();
			return true;
		}
		return false;
	}
	
	/**
	 * Release and close scope.
	 * 
	 * When the current scope is being held this method will close it anyway.
	 *
	 * @throws NootException the noot exception
	 * @require holdUpcommingScope() has been called and scoping level is the same as when this call occurred.
	 */
	public void releaseAndCloseScope() throws NootException
	{
		if(holdCloseScopeAtLevel.size() > 0 && holdCloseScopeAtLevel.peek().intValue() == scopingLevel)
		{
			holdCloseScopeAtLevel.pop();
			this.tryToCloseScope();
		}
		else
		{
			throw new NootException("Closing held scope when current scope isn't being held");
		}
	}

	/** 
	 * Returns the current scope level.
	 * 
	 * @return result >= 0
	 */
	public int scopingLevel()
	{
		return scopingLevel;
	}
}
