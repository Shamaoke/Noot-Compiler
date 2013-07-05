package noot.assembly;

import java.util.ArrayList;

public class IdentifierIndex extends ArrayList<String> {

	private static final long serialVersionUID = 1L;
	private Program program;

	public IdentifierIndex(Program aProgram)
	{
		this.program = aProgram;
	}

	public boolean add(String obj)
	{
		program.pushInstruction(new Instruction("PUSH","1","Declaring "+obj));
		return super.add(obj);
	}

	public int indexOfIdentifier(String identifier)
	{
		for(int i = 0; i < this.size(); i ++)
		{
			if(this.get(i).equals(identifier)) return i;
		}
		return -1;
	}

	public String addressOfIdentifier(String identifier)
	{
		int indexOfIdentifier = this.indexOfIdentifier(identifier);

		if(indexOfIdentifier < 0) return null;

		return Integer.toString(indexOfIdentifier)+"[SB]";
	}
}
