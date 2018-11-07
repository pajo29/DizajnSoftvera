package gui.tree.model;

public class Component extends Node
{
	
	private String content = "";
	
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
		return super.toString();
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}
