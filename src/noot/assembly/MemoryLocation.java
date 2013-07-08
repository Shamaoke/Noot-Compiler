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

// TODO: Auto-generated Javadoc
/**
 * The Class MemoryLocation.
 */
public class MemoryLocation {

	/** The declaration. */
	private DeclarationNode declaration;
	
	/**
	 * Instantiates a new memory location.
	 */
	public MemoryLocation() {}
	
	/**
	 * Instantiates a new memory location.
	 *
	 * @param declaration the declaration
	 */
	public MemoryLocation(DeclarationNode declaration)
	{
		this.setDeclaration(declaration);
	}

	/**
	 * Gets the declaration.
	 *
	 * @return the declaration
	 */
	public DeclarationNode getDeclaration() {
		return declaration;
	}

	/**
	 * Sets the declaration.
	 *
	 * @param declaration the new declaration
	 */
	public void setDeclaration(DeclarationNode declaration) {
		this.declaration = declaration;
	}
}
