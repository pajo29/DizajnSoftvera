package gui.tree;

import javax.swing.JTree;

import gui.tree.controller.TreeListener;
import gui.tree.controller.TreeController;
import gui.tree.controller.TreeSelectionModel;

@SuppressWarnings("serial")
public class Tree extends JTree
{
	
	
	public Tree()
	{
		addTreeSelectionListener(new TreeController());
		setCellEditor(new TreeEditor(this, new TreeCellRenderer()));
		setCellRenderer(new TreeCellRenderer());
		addMouseListener(new TreeListener());
//		setSelectionModel(new TreeSelectionModel());
		setEditable(true);
	}

}
