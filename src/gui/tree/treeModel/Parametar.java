package gui.tree.treeModel;

public class Parametar extends Node {
	
	public Parametar(String name)
	{
		super(name);
	}
	
	@Override
	public Node addNewChild()
	{
		Component component = new Component("Komponenta: "+(getChildCount()+1));
		addChild(component);
		
		return component;
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}

}
