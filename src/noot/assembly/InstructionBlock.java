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

/**
 * The Class InstructionBlock.
 * 
 * Stack to represent an instruction block. An instruction block
 * is a list of instructions starting with an instruction with a jump label.
 * 
 * The fist Instruction pushed to the block will get the instruction
 * block label assigned to it.
 */
public class InstructionBlock extends Stack<Instruction> {
	
	/** serialVersionUID used for serialization */
	private static final long serialVersionUID = 9189059759052574955L;
	
	/** The label identifier. */
	public int labelIdentifier = -1;
	
	/**
	 * Instantiates a new instruction block.
	 * 
	 * The labelIdentifier should be unique, this is will be
	 * used to jump to this instruction block.
	 *
	 * @param labelIdentifier the a labelIdentifier
	 */
	public InstructionBlock(int labelIdentifier)
	{
		this.labelIdentifier = labelIdentifier;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Stack#push(java.lang.Object)
	 */
	public Instruction push(Instruction instruction)
	{
		if(this.size() == 0) instruction.setLabel("L" + labelIdentifier);
		return super.push(instruction);
	}
	
	/**
	 * Jump label.
	 * 
	 * Get label for use with the JUMP instruction.
	 * An example output could be "L1[CB]".
	 * 
	 * @return a string containing the labelIdentifier with needed extra additions
	 */
	public String jumpLabel() // without argument = false
	{
		return "L" + Integer.toString(labelIdentifier) + "[CB]";
	}
	
}
