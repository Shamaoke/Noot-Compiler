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
package noot.assembly;

import noot.ast.DeclarationNode;

/**
 * The Class MemoryLocation.
 * 
 * This will represent a register or memory address. To be used with
 * or without DeclarationNode. Without DeclaratioNode should only be
 * used for helper memory location used by the code generator.
 * 
 * To-Do: If types that require more space are added later this class
 * could be expanded to support size.
 */
public class MemoryLocation {

	/** The declaration. */
	private DeclarationNode declaration;

	/**
	 * Instantiates a new memory location for a helper.
	 */
	public MemoryLocation() {}

	/**
	 * Instantiates a new memory location for a declaration.
	 *
	 * @param declaration the declaration
	 */
	public MemoryLocation(DeclarationNode declaration)
	{
		this.declaration = declaration;
	}

	/**
	 * Gets the declaration if it is set.
	 *
	 * @return the declaration
	 */
	public DeclarationNode getDeclaration()
	{
		return declaration;
	}

}
