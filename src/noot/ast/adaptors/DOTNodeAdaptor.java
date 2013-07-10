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
package noot.ast.adaptors;

/**
 * The Class DOTNodeAdaptor.
 * 
 * This class has been added to be able to create more meaningful
 * DOT file visualizations. Dot file visualizations will be created
 * when compiling a piece of Noot code. These visualizations can be
 * opened using an application called Graphviz.
 * 
 * This class overrides the getText method to make it print meaningful
 * token descriptions.
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
