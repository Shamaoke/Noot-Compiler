package noot.assembly;

import java.util.ArrayList;

public class Program extends ArrayList<InstructionBlock> {

	private static final long serialVersionUID = 1L;

	public InstructionBlock currentBlock;
	public IdentifierIndex identifiers;

	public Program()
	{
		currentBlock = new InstructionBlock(0);
		identifiers = new IdentifierIndex(this);
	}
	
	public InstructionBlock blockWithLabel(String label)
	{
		for(InstructionBlock block : this)
			if(block.referenceLabel().equals(label)) return block;
		return null;
	}

	public boolean add(InstructionBlock block) 
	{
		block.finalizeBlock();
		
		if(block == currentBlock)
			currentBlock = new InstructionBlock(block.labelIdentifier + 1);
		
		return super.add(block);
	}
	
	public void pushBlock()
	{
		this.add(this.currentBlock);
	}

	public void pushInstruction(Instruction instruction)
	{
		currentBlock.add(instruction);
	}

	public int pushCount()
	{
		int result = 0;

		for(InstructionBlock block : this)
		{
			for(Instruction instruction : block)
				if(instruction.instruction.equalsIgnoreCase("PUSH")) result += Integer.parseInt(instruction.argument);
		}

		return result;
	}

	public void finalize()
	{
		currentBlock.add(new Instruction("POP", Integer.toString(this.pushCount()),0));
		currentBlock.add(new Instruction("HALT"));

		this.add(currentBlock);
	}
}
