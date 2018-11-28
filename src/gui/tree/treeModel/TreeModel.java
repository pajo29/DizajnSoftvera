package gui.tree.treeModel;

import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("serial")
public class TreeModel extends DefaultTreeModel
{
		public TreeModel(SoftwareCompany swcmp)
		{
			super(swcmp);
		}
}