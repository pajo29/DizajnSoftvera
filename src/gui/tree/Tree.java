package gui.tree;

import javax.swing.JTree;

import gui.tree.controller.EditListener;
import gui.tree.controller.TreeController;
import gui.tree.model.ContentModel;

public class Tree extends JTree
{
	
	private ContentModel model;
	
	public Tree()
	{
		model = new ContentModel();
		addTreeSelectionListener(new TreeController());
		setCellEditor(new TreeEditor(this, new TreeCellRenderer()));
		setCellRenderer(new TreeCellRenderer());
		addMouseListener(new EditListener());
		setEditable(true);
	}
	
	public ContentModel getContentModel()
	{
		return model;
	}
	
}
