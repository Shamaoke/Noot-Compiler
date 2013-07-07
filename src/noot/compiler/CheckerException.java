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

import org.antlr.runtime.tree.Tree;

public class CheckerException extends NootException {

	private static final long serialVersionUID = 6841118816451063086L;
	
	public CheckerException(String msg)
	{
		super(msg);
	}
	
	public CheckerException(Tree tree, String msg)
	{
		super(tree,msg);
	}
}