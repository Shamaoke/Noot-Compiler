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

/**
 * The Class Instruction.
 * 
 * Instruction objects can be seen as string templates to be used
 * for output as assembly for Noot.
 * 
 * The toString() method has been adjusted to print a nice representation.
 * 
 * An example representation is:
 * "L0:     STORE(1)     5[SB]     ; Assigning a"
 * 
 * Here is "L0" the label
 * "STORE" the instruction
 * "1" the lengthSpecifier
 * "5[SB]" the argument
 * "; Assigning a" the comment
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
	 * @param instruction the instruction
	 */
	public Instruction(String instruction)
	{
		this.instruction = instruction;
	}

	/**
	 * Instantiates a new instruction.
	 *
	 * @param instruction the instruction
	 * @param argument the argument
	 */
	public Instruction(String instruction, String argument)
	{
		this.instruction = instruction;
		this.argument = argument;
	}

	/**
	 * Instantiates a new instruction.
	 *
	 * @param instruction the instruction
	 * @param argument the argument
	 * @param lengthSpecifier the length specifier
	 */
	public Instruction(String instruction, String argument, int lengthSpecifier)
	{
		this.instruction = instruction;
		this.argument = argument;
		this.lengthSpecifier = lengthSpecifier;
	}

	/**
	 * Instantiates a new instruction.
	 *
	 * @param instruction the instruction
	 * @param argument the argument
	 * @param comment the comment
	 */
	public Instruction(String instruction, String argument, String comment)
	{
		this.instruction = instruction;
		this.argument = argument;
		this.comment = comment;
	}

	/**
	 * Instantiates a new instruction.
	 *
	 * @param instruction the instruction
	 * @param argument the argument
	 * @param lengthSpecifier the length specifier
	 * @param comment the comment
	 */
	public Instruction(String instruction, String argument, int lengthSpecifier, String comment)
	{
		this.instruction = instruction;
		this.argument = argument;
		this.lengthSpecifier = lengthSpecifier;
		this.comment = comment;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel()
	{
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label)
	{
		this.label = label;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment)
	{
		this.comment = comment;
	}

	/**
	 * Sets the argument.
	 *
	 * @param argument the new argument
	 */
	public void setArgument(String argument)
	{
		this.argument = argument;
	}

	/**
	 * Gets the instruction.
	 *
	 * @return the instruction
	 */
	public String getInstruction()
	{
		return instruction;
	}

	/**
	 * Gets the argument.
	 *
	 * @return the argument
	 */
	public String getArgument()
	{
		return argument;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String result = "";

		if(label != null) result = result + label.toUpperCase() + ": ";

		int spacesToAdd = 8 - result.length(); // To print nice indentation
		while(spacesToAdd > 0) 
		{
			result = result + " ";
			spacesToAdd--;
		}

		result = result + instruction;

		if(lengthSpecifier > -1) result = result + "("+ lengthSpecifier + ")";

		if(argument != null)
		{
			spacesToAdd = 20 - result.length(); // To print nice indentation
			while(spacesToAdd > 0) 
			{
				result = result + " ";
				spacesToAdd--;
			}
			result = result + " " + argument;
		}

		if(comment != null)
		{
			spacesToAdd = 30 - result.length(); // To print nice indentation
			while(spacesToAdd > 0) 
			{
				result = result + " ";
				spacesToAdd--;
			}

			result = result + " ; " + comment;
		}

		return result + "\n";
	}
}
