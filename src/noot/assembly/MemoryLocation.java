package noot.assembly;

import noot.ast.DeclarationNode;

public class MemoryLocation {

	private DeclarationNode declaration;
	
	public MemoryLocation() {}
	
	public MemoryLocation(DeclarationNode declaration)
	{
		this.setDeclaration(declaration);
	}

	public DeclarationNode getDeclaration() {
		return declaration;
	}

	public void setDeclaration(DeclarationNode declaration) {
		this.declaration = declaration;
	}
}
