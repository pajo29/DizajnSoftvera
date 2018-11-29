package gui.tree.treeModel;

import gui.parameters.model.ParametarConfig;

@SuppressWarnings("serial")
public class Parametar extends Node {
	
	private ParametarConfig parametar;
	
	public Parametar(String name, ParametarConfig parametar)
	{
		super(name);
		this.parametar = parametar;
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}

	public ParametarConfig getParametar() {
		return parametar;
	}

}
