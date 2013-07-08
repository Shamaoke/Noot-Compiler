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

// TODO: Auto-generated Javadoc
/**
 * The Class Instruction.
 */
public class Instruction {

	/** The instruction. */
	private String instruction;

	/** The argument. */
	private String argument = null;
	
	/** The length specifier. */
	private int lengthSpecifier = -1;
	
	/** The label. */
	private String label = null;
	
	/** The comment. */
	private String comment = null;
	
	/**
	 * Instantiates a new instruction.
	 *
	 * @param aInstruction the a instruction
	 */
	public Instruction(String aInstruction)
	{
		this.instruction = aInstruction;
	}

	/**
	 * Instantiates a new instruction.
	 *
	 * @param aInstruction the a instruction
	 * @param aArgument the a argument
	 */
	public Instruction(String aInstruction, String aArgument)
	{
		this.instruction = aInstruction;
		this.argument = aArgument;
	}

	/**
	 * Instantiates a new instruction.
	 *
	 * @param aInstruction the a instruction
	 * @param aArgument the a argument
	 * @param aLengthSpecifier the a length specifier
	 */
	public Instruction(String aInstruction, String aArgument, int aLengthSpecifier)
	{
		this.instruction = aInstruction;
		this.argument = aArgument;
		this.lengthSpecifier = aLengthSpecifier;
	}

	/**
	 * Instantiates a new instruction.
	 *
	 * @param aInstruction the a instruction
	 * @param aArgument the a argument
	 * @param aComment the a comment
	 */
	public Instruction(String aInstruction, String aArgument, String aComment)
	{
		this.instruction = aInstruction;
		this.argument = aArgument;
		this.comment = aComment;
	}

	/**
	 * Instantiates a new instruction.
	 *
	 * @param aInstruction the a instruction
	 * @param aArgument the a argument
	 * @param aLengthSpecifier the a length specifier
	 * @param aComment the a comment
	 */
	public Instruction(String aInstruction, String aArgument, int aLengthSpecifier, String aComment)
	{
		this.instruction = aInstruction;
		this.argument = aArgument;
		this.lengthSpecifier = aLengthSpecifier;
		this.comment = aComment;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String result = "";

		if(label != null) result = result + label.toUpperCase() + ": ";
		
		int spacesToAdd = 8 - result.length();
		while(spacesToAdd > 0) 
		{
			result = result + " ";
			spacesToAdd--;
		}
		
		result = result + instruction;
		
		if(lengthSpecifier > -1) result = result + "("+ lengthSpecifier + ")";
		
		if(argument != null)
		{
			spacesToAdd = 20 - result.length();
			while(spacesToAdd > 0) 
			{
				result = result + " ";
				spacesToAdd--;
			}
				result = result + " " + argument;
		}
		
		if(comment != null)
		{
			spacesToAdd = 30 - result.length();
			while(spacesToAdd > 0) 
			{
				result = result + " ";
				spacesToAdd--;
			}

			result = result + " ; " + comment;
		}

		return result + "\n";
	}
	
	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
	 * Sets the argument.
	 *
	 * @param argument the new argument
	 */
	public void setArgument(String argument) {
		this.argument = argument;
	}
	
	/**
	 * Gets the instruction.
	 *
	 * @return the instruction
	 */
	public String getInstruction() {
		return instruction;
	}

	/**
	 * Gets the argument.
	 *
	 * @return the argument
	 */
	public String getArgument() {
		return argument;
	}
}
