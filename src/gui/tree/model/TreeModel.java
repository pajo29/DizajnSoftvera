package gui.tree.model;

import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("serial")
public class TreeModel extends DefaultTreeModel
{
		public TreeModel(Component component)
		{
			super(component);
		}
		
		public void addComponent(Component component)
		{ //TODO See if usable
			((Component)getRoot()).addChild(component);
		}
}