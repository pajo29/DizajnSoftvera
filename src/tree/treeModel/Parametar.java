package tree.treeModel;

import parameters.parametar.model.ParametarModel;

@SuppressWarnings("serial")
public class Parametar extends Node 
{
	
	private ParametarModel parametar;
	
	public Parametar(String name, ParametarModel parametar)
	{
		super(name);
		this.parametar = parametar;
	}

	public Parametar(Node node)
	{
		super(node);
		parametar = ((Parametar)node).getParametar();
	}

	public void parametarChanged()
	{
		setChanged();
		notifyObservers(parametar);
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}

	public ParametarModel getParametar() {
		return parametar;
	}

}
