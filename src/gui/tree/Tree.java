package gui.tree;

import javax.swing.JTree;

import gui.tree.controller.EditListener;
import gui.tree.controller.TreeController;

@SuppressWarnings("serial")
public class Tree extends JTree
{
	
	
	public Tree()
	{
		addTreeSelectionListener(new TreeController());
		setCellEditor(new TreeEditor(this, new TreeCellRenderer()));
		setCellRenderer(new TreeCellRenderer());
		addMouseListener(new EditListener());
		setEditable(true);
	}
	
}
