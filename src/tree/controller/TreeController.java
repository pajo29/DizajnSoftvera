package tree.controller;

import gui.MainSplitPane;
import main.MainFrame;
import tree.treeModel.Node;
import tree.treeModel.Product;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class TreeController implements TreeSelectionListener
{
	public void valueChanged(TreeSelectionEvent e)
	{
		if(!(MainSplitPane.getInstance().getTree().getLastSelectedPathComponent() instanceof Product))
		{
			MainFrame.getInstance().getActionManager().getPreviewAction().setEnabled(false);
		}
		else
		{
			MainFrame.getInstance().getActionManager().getPreviewAction().setEnabled(true);
		}
		System.out.println(e.getPath());
	}
	
	

}