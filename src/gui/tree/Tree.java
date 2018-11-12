package gui.tree;

import javax.swing.JTree;

import gui.tree.controller.EditListener;
import gui.tree.controller.TreeController;
import gui.tree.model.ComponentModel;

@SuppressWarnings("serial")
public class Tree extends JTree
{
	
	private ComponentModel model;
	
	public Tree()
	{
		model = new ComponentModel();
		addTreeSelectionListener(new TreeController());
		setCellEditor(new TreeEditor(this, new TreeCellRenderer()));
		setCellRenderer(new TreeCellRenderer());
		addMouseListener(new EditListener());
		setEditable(true);
	}
	
	public ComponentModel getContentModel()
	{
		return model;
	}
	
}
