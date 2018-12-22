package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

import messageHandler.MessageHandler;
import messageHandler.MessageType;
import parameters.parametar.model.ParametarModel;
import parameters.parametar.view.ParametarView;
import tree.treeModel.Parametar;
import gui.MainSplitPane;

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
		MainSplitPane.getInstance().getSplitPane().setContent(ParametarView.createGUI(((ParametarModel)node.getParametar()).isPredefined(), ((ParametarModel)node.getParametar()).getGUI(), ((ParametarModel)node.getParametar()).getContent(), ((ParametarModel)node.getParametar()).getLabel(), node, false, "Light"), node);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			MessageHandler.handleEvent(MessageType.WRONG_COMPONENT_SELECTED_PARAMETAR);
		}
	}

}