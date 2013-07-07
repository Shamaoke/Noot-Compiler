package noot.assembly;

import java.util.Stack;

public class InstructionBlock extends Stack<Instruction> {

	private static final long serialVersionUID = 1L;
	public int labelIdentifier = -1;
	
	public InstructionBlock(int aLabel)
	{
		this.labelIdentifier = aLabel;
	}
	
	public Instruction push(Instruction instruction)
	{
		if(this.size() == 0) instruction.setLabel(this.referenceLabel());
		return super.push(instruction);
	}
	
	public String referenceLabel()
	{
		return "L" + Integer.toString(labelIdentifier);
	}
	
	public String jumpLabel() // without argument = false
	{

		return "L" + Integer.toString(labelIdentifier) + "[CB]";
	}
	
}
