package gui.tree.model;

import java.util.Observable;

public class ComponentModel extends Observable
{
	public ComponentModel()
	{
		
	}
	
	public void updateContent(gui.tree.model.Component cmp, String content)
	{
		cmp.setContent(content);
		
		setChanged();
		notifyObservers(cmp);
	}
}
