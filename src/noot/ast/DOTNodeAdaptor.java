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
package noot.ast;

// TODO: Auto-generated Javadoc
/**
 * The Class DOTNodeAdaptor.
 */
public class DOTNodeAdaptor extends NodeAdaptor {
	
	/* (non-Javadoc)
	 * @see org.antlr.runtime.tree.CommonTreeAdaptor#getText(java.lang.Object)
	 */
	public String getText(Object o)
	{
		return o.toString();
	}

}
