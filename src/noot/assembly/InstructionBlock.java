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

import java.util.Stack;

// TODO: Auto-generated Javadoc
/**
 * The Class InstructionBlock.
 */
public class InstructionBlock extends Stack<Instruction> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The label identifier. */
	public int labelIdentifier = -1;
	
	/**
	 * Instantiates a new instruction block.
	 *
	 * @param aLabel the a label
	 */
	public InstructionBlock(int aLabel)
	{
		this.labelIdentifier = aLabel;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Stack#push(java.lang.Object)
	 */
	public Instruction push(Instruction instruction)
	{
		if(this.size() == 0) instruction.setLabel(this.referenceLabel());
		return super.push(instruction);
	}
	
	/**
	 * Reference label.
	 *
	 * @return the string
	 */
	public String referenceLabel()
	{
		return "L" + Integer.toString(labelIdentifier);
	}
	
	/**
	 * Jump label.
	 *
	 * @return the string
	 */
	public String jumpLabel() // without argument = false
	{

		return "L" + Integer.toString(labelIdentifier) + "[CB]";
	}
	
}
