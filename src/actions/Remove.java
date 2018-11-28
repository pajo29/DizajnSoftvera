package actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import gui.tree.treeModel.Node;
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
		
		if(cmp == null)
		{
			MainFrame.getInstance().getActionManager().noComponentSelected();
			return;
		}
		
		if(removeNotification((Node)cmp) == JOptionPane.YES_OPTION)
		{
		if(cmp == MainSplitPane.getInstance().getTree().getPathForRow(0).getLastPathComponent())
		{
			
				((Node)cmp).getChildren().clear();
		}
		else
		{
		Node component = (Node)cmp;
		((Node)component.getParent()).remove((MutableTreeNode)cmp);
		}
		SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
		MainFrame.getInstance().getActionManager().setChanges(true);
		}
	}
	
	private int removeNotification(Node cmp)
	{
		int res = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?\nBice obrisano\n"
				+ cmp.getChildCount() + " deteta i " + cmp.getLeafCount(0, cmp.getChildCount())+" lista", "Paznja", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		return res;
	}

}
