package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

import gui.exceptionHandler.ExceptionHandler;
import gui.exceptionHandler.ExceptionType;
import gui.parameters.model.ParametarConfig;
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
		putValue(NAME, "mEdit");
		putValue(SHORT_DESCRIPTION, "Edit");
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
		MainSplitPane.getInstance().getSplitPane().setUpSide(((ParametarConfig)node.getParametar()).getGui());	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExceptionHandler.handleEvent(ExceptionType.WRONG_COMPONENT_SELECTED);
		}
	}

}