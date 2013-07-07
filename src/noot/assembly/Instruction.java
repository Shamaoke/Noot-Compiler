package noot.assembly;

public class Instruction {

	private String instruction;

	private String argument = null;
	private int lengthSpecifier = -1;
	private String label = null;
	private String comment = null;
	
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
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setArgument(String argument) {
		this.argument = argument;
	}
	
	public String getInstruction() {
		return instruction;
	}

	public String getArgument() {
		return argument;
	}
}
