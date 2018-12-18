package actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import command.RemoveCommand;
import messageHandler.MessageHandler;
import messageHandler.MessageType;
import tree.treeModel.Node;
import main.MainFrame;
import gui.MainSplitPane;

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
				MainFrame.getInstance().getCommandManager().addCommand(new RemoveCommand((Node)cmp));
			}
	}

}
