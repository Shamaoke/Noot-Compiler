/*
 * @author Thijs Scheepers <thijs@label305.com>
 * Copyright (c) 2013 Thijs Scheepers. All Right Reserved.
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


import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTreeAdaptor;

// TODO: Auto-generated Javadoc
/**
 * The Class NodeAdaptor.
 */
public class NodeAdaptor extends CommonTreeAdaptor {
	
	/* (non-Javadoc)
	 * @see org.antlr.runtime.tree.CommonTreeAdaptor#create(org.antlr.runtime.Token)
	 */
	public Object create(Token t) {
		return new Node(t);
	}
}
