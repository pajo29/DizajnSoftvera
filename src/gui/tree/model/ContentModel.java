package gui.tree.model;

import java.util.Observable;

public class ContentModel extends Observable
{
	public ContentModel()
	{
		
	}
	
	public void updateContent(gui.tree.model.Component cmp, String content)
	{
		cmp.setContent(content);
		
		setChanged();
		notifyObservers(cmp);
	}
}
