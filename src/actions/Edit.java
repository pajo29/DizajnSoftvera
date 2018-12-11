package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

import gui.messageHandler.MessageHandler;
import gui.messageHandler.MessageType;
import gui.parameters.parametar.model.ParametarModel;
import gui.parameters.parametar.view.ParametarView;
import gui.tree.treeModel.Parametar;
import main.MainSplitPane;

@SuppressWarnings("serial")
public class Edit extends AbstractGEDAction
{
	public Edit()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_3, ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, loadIcon("images/edit.png"));
		putValue(NAME, "Edit");
		putValue(SHORT_DESCRIPTION, "Edit parametar");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		edit();
	}
	
	public void edit()
	{
		try
		{
		Parametar node = (Parametar)MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
		MainSplitPane.getInstance().getSplitPane().setUpSide(ParametarView.createGUI(((ParametarModel)node.getParametar()).isPredefined(), ((ParametarModel)node.getParametar()).getGUI(), ((ParametarModel)node.getParametar()).getContent(), ((ParametarModel)node.getParametar()).getLabel()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MessageHandler.handleEvent(MessageType.WRONG_COMPONENT_SELECTED_PARAMETAR);
		}
	}

}