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
		if(this.labelIdentifier >= 0) this.get(0).label = this.referenceLabel();
		if(this.jumpTo != null) this.add(new Instruction("JUMP", jumpTo.referenceLabel()));
		finalized = true;
		
		for(Instruction instruction : this)
			System.out.print(instruction.toString());
	}
	
	public boolean isFinalized()
	{
		return this.finalized;
	}
	
	public String referenceLabel()
	{
		return this.referenceLabel(false);
	}
	
	public String referenceLabel(boolean argument) // without argument = false
	{

		return InstructionBlock.label(this.labelIdentifier,argument);
	}
	
	public static String label(int labelIdentifier, boolean argument)
	{
		return (argument) ? "L" + Integer.toString(labelIdentifier) + "[CB]" : "L" + Integer.toString(labelIdentifier);
	}
}
