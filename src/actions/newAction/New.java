package actions.newAction;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import actions.AbstractGEDAction;
import command.AddNodeCommand;
import messageHandler.MessageHandler;
import messageHandler.MessageType;
import tree.treeModel.*;
import main.MainFrame;
import gui.MainSplitPane;


@SuppressWarnings("serial")
public class New extends AbstractGEDAction
{
	
	public New()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control T"));
		putValue(SMALL_ICON, loadIcon("../images/newFile.png"));
		putValue(NAME, "mNew file");
		putValue(SHORT_DESCRIPTION, "New file");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		addNewChild(null);
	}

	public void addNewChild(Node node)
	{
		if(node != null)
		{
			Object cmp = MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();

			if (cmp == null)
			{
				MessageHandler.handleEvent(MessageType.NO_COMPONENT_SELECTED);
				return;
			}
			else
			{
				if (cmp instanceof Module)
				{
					if (node instanceof Parametar)
						MainFrame.getInstance().getCommandManager().addCommand(new AddNodeCommand((Module)cmp, (Parametar)node));
					else
						MessageHandler.handleEvent(MessageType.WRONG_TYPE_IN_CLIPBOARD);
				}
				else
				{
					if (cmp instanceof Product)
					{
						if (node instanceof Parametar)
							MainFrame.getInstance().getCommandManager().addCommand(new AddNodeCommand((Product)cmp, (Parametar)node));
						else
							MessageHandler.handleEvent(MessageType.WRONG_TYPE_IN_CLIPBOARD);

					}
				}

			}
		}
		else
		{
			Object cmp = MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();

			if (cmp == null)
			{
				MessageHandler.handleEvent(MessageType.NO_COMPONENT_SELECTED);
				return;
			}

			if (cmp instanceof SoftwareCompany)
			{
				SoftwareCompany component = (SoftwareCompany) cmp;
				new NewProductDialog(component);

			}

			if (cmp instanceof Product)
			{
				Product component = (Product) cmp;
				new NewChooser(component, false);
			}
			if (cmp instanceof Module)
			{
				Module component = (Module) cmp;
				new NewChooser(component, true);
			}
			if (cmp instanceof Parametar)
			{
				MessageHandler.handleEvent(MessageType.PARAMETAR_SELECTED);
				return;
			}

		}
		SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());


		MainFrame.getInstance().getActionManager().setChanges(true);
	}
}
