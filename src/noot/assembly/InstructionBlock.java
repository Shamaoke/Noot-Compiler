package noot.assembly;

import java.util.ArrayList;

public class InstructionBlock extends ArrayList<Instruction> {

	private static final long serialVersionUID = 1L;
	public int labelIdentifier = -1;
	public InstructionBlock jumpTo;
	private boolean finalized = false;
	
	public InstructionBlock(int aLabel)
	{
		this.labelIdentifier = aLabel;
	}
	
	public InstructionBlock(int aLabel, InstructionBlock theJumpTo)
	{
		this.labelIdentifier = aLabel;
		this.jumpTo = theJumpTo;
	}
	
	public void finalizeBlock()
	{
		if(this.size() > 0)
		{
			if(this.labelIdentifier >= 0) this.get(0).setLabel(this.referenceLabel());
			if(this.jumpTo != null) this.add(new Instruction("JUMP", jumpTo.referenceLabel()));
		}
		
		finalized = true;
	}
	
	public boolean isFinalized()
	{
		return this.finalized;
	}
	
	public String referenceLabel()
	{
		return "L" + Integer.toString(labelIdentifier);
	}
	
	public String jumpLabel() // without argument = false
	{

		return "L" + Integer.toString(labelIdentifier) + "[CB]";
	}
	
	public static String label(int labelIdentifier, boolean argument)
	{
		return (argument) ? "L" + Integer.toString(labelIdentifier) + "[CB]" : "L" + Integer.toString(labelIdentifier);
	}
}
