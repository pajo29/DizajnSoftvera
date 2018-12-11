package actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import gui.messageHandler.MessageHandler;
import gui.messageHandler.MessageType;
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
		putValue(NAME, "Remove");
		putValue(SHORT_DESCRIPTION, "Remove component");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		remove();
	}
	
	public void remove()
	{
			Object cmp = MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();

			if (cmp == null)
			{
				MessageHandler.handleEvent(MessageType.NO_COMPONENT_SELECTED);
				return;
			}

			int rez = MessageHandler.handleEvent(MessageType.NODE_REMOVAL);

			if (rez == JOptionPane.YES_OPTION)
			{
				if (cmp == MainSplitPane.getInstance().getTree().getPathForRow(0).getLastPathComponent())
				{

					((Node) cmp).getChildren().clear();
				} else
				{
					Node component = (Node) cmp;
					((Node) component.getParent()).remove((MutableTreeNode) cmp);
				}
				SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
				MainSplitPane.getInstance().getTree().clearSelection();
				MainFrame.getInstance().getActionManager().setChanges(true);
			}
	}

}
