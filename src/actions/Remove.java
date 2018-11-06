package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import main.MainSplitPane;

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
		Object cmp = MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
		
		tree.model.Component component = (tree.model.Component)cmp;
		((tree.model.Component)component.getParent()).remove((MutableTreeNode)cmp);
		
		SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
	}

}
