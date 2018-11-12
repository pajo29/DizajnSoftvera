package gui.tree.model;

public class Component extends Node
{
	
	private String content = "";
	private int leafCounter = 0;
	
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
	
	public int getLeafCount(Component cmp, int counter, int limit)
	{
		leafCounter = 0;
		leafCounter(cmp, counter, limit);
		return leafCounter;
	}
	
	private void leafCounter(Component cmp, int counter, int limit)
	{
		if(counter == limit)
			return;
		
		if(cmp.getChildAt(counter).isLeaf())
			leafCounter++;
			
		
		if(!cmp.getChildAt(counter).isLeaf())
			leafCounter((Component)cmp.getChildAt(counter), 0, cmp.getChildAt(counter).getChildCount());
		
		leafCounter(cmp, counter+1, limit);
	}
}
