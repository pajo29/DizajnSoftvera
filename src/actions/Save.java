package actions;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.KeyStroke;

import gui.exceptionHandler.ExceptionHandler;
import gui.exceptionHandler.ExceptionType;
import main.MainFrame;


@SuppressWarnings("serial")
public class Save extends AbstractGEDAction
{ 
	
	public Save()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));
		putValue(SMALL_ICON, loadIcon("images/save.png"));
		putValue(NAME, "mSave");
		putValue(SHORT_DESCRIPTION, "Save");
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		try {
			MainFrame.getInstance().getActionManager().getSaveAsAction().save(MainFrame.getInstance().getActionManager().getDefaultFile());
		} catch (IOException e) {
			e.printStackTrace();
			ExceptionHandler.handleEvent(ExceptionType.SERIALISATION_FAIL);
		}
	}
	
}