package tree.model;

import tree.Node.Node;

public class Component extends Node
{
	
	
	public Component(String name)
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
		return getName();
	}
}
