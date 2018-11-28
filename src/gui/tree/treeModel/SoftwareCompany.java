package gui.tree.treeModel;

public class SoftwareCompany extends Node {
	
	public SoftwareCompany(String name)
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

	//TODO Add to controller, leafCounter for node removal

}
