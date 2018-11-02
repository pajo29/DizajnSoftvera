package gui.tree;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import tree.controller.TreeController;

public class Tree extends JTree
{
	public Tree()
	{
		addTreeSelectionListener(new TreeController());
		setCellEditor(new TreeEditor(this, new DefaultTreeCellRenderer()));
		setCellRenderer(new TreeCellRenderer());
		setEditable(true);
	}
	
}
