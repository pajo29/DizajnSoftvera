package actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import gui.rightSplitPane.view.tabs.model.TabPane;
import gui.tree.model.Component;
import main.MainFrame;
import main.MainSplitPane;

@SuppressWarnings("serial")
public class Remove extends AbstractGEDAction
{
	
	public Remove()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control W"));
		putValue(SMALL_ICON, loadIcon("images/remove.png"));
		putValue(NAME, "mRemove");
		putValue(SHORT_DESCRIPTION, "Remove");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		remove();
	}
	
	public void remove()
	{
		Object cmp = MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
		
		if(cmp == MainSplitPane.getInstance().getTree().getPathForRow(0).getLastPathComponent())
		{
			((Component)cmp).getChildren().clear();
			TabPane.getInstance().getController().removeAllTabs();
		}
		else
		{
		gui.tree.model.Component component = (gui.tree.model.Component)cmp;
		TabPane.getInstance().getController().removeTab(component);
		((gui.tree.model.Component)component.getParent()).remove((MutableTreeNode)cmp);
		}
		
		SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
		MainFrame.getInstance().getActionManager().setChanges(true);
	}

}
