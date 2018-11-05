package gui.tree;

import javax.swing.JTree;

import tree.controller.TreeController;

public class Tree extends JTree
{
	public Tree()
	{
		addTreeSelectionListener(new TreeController());
		setCellEditor(new TreeEditor(this, new TreeCellRenderer()));
		setCellRenderer(new TreeCellRenderer());
		setEditable(true);
	}
	
}
