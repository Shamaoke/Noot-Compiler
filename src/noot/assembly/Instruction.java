package noot.assembly;

public class Instruction {

	public String instruction;
	public String argument = null;
	public int lengthSpecifier = -1;
	public String label = null;
	public String comment = null;

	public Instruction(String aInstruction)
	{
		this.instruction = aInstruction;
	}

	public Instruction(String aInstruction, String aArgument)
	{
		this.instruction = aInstruction;
		this.argument = aArgument;
	}

	public Instruction(String aInstruction, String aArgument, int aLengthSpecifier)
	{
		this.instruction = aInstruction;
		this.argument = aArgument;
		this.lengthSpecifier = aLengthSpecifier;
	}

	public Instruction(String aInstruction, String aArgument, String aComment)
	{
		this.instruction = aInstruction;
		this.argument = aArgument;
		this.comment = aComment;
	}

	public Instruction(String aInstruction, String aArgument, int aLengthSpecifier, String aComment)
	{
		this.instruction = aInstruction;
		this.argument = aArgument;
		this.lengthSpecifier = aLengthSpecifier;
		this.comment = aComment;
	}

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

}
