package tree.model;

import javax.swing.tree.DefaultTreeModel;

public class TreeModel extends DefaultTreeModel
{
		public TreeModel()
		{
			super(new Component("Glavna komponenta"));
		}
		
		public void addComponent(Component component)
		{ //TODO See if usable
			((Component)getRoot()).addChild(component);
		}
}
