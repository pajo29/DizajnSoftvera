<<<<<<< HEAD
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
		parametar = new ParametarModel(((Parametar)node).getParametar());
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
=======
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
		parametar = new ParametarModel(((Parametar)node).getParametar());
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
>>>>>>> 4ffd20ae8b5902ea28b0c604686b86a6f030c2fa
