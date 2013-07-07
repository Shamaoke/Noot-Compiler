package noot.compiler;

import java.util.Stack;


public class ScopeHelper {
	
	private int scopingLevel = 0;
	private Stack<Integer> holdCloseScopeAtLevel = new Stack<Integer>(); // Needed for special scoping rules while and if statements
	
	public void openScope()
	{
		scopingLevel++;
	}

	public void tryToCloseScope() throws NootException
	{
		if(holdCloseScopeAtLevel.size() == 0 || holdCloseScopeAtLevel.peek().intValue() != scopingLevel)
		{
			closeScope();
		}
	}
	
	protected void closeScope() throws NootException
	{
		if(scopingLevel <= 0)
			throw new NootException("Closing scope when level is already 0");
			
		scopingLevel--;
	}
	
	public void holdUpcommingScope()
	{
		holdCloseScopeAtLevel.push(new Integer(scopingLevel + 1));
	}
	
	public void releaseAndCloseScope() throws NootException
	{
		if(holdCloseScopeAtLevel.size() > 0 && holdCloseScopeAtLevel.peek().intValue() == scopingLevel)
		{
			holdCloseScopeAtLevel.pop();
			this.tryToCloseScope();
		}
	}

	/** 
	 * Returns the current scope level.
	 * @return result >= 0
	 */
	public int scopingLevel()
	{
		return scopingLevel;
	}
}
