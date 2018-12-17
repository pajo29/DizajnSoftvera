package tree;

import javax.swing.JTree;

import tree.controller.TreeListener;
import tree.controller.TreeController;

@SuppressWarnings("serial")
public class Tree extends JTree
{
	
	
	public Tree()
	{
		addTreeSelectionListener(new TreeController());
		setCellEditor(new TreeEditor(this, new TreeCellRenderer()));
		setCellRenderer(new TreeCellRenderer());
		addMouseListener(new TreeListener());
		setEditable(true);
	}

}
