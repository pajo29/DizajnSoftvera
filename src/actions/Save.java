package actions;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.KeyStroke;

import gui.messageHandler.MessageHandler;
import gui.messageHandler.MessageType;
import main.MainFrame;


@SuppressWarnings("serial")
public class Save extends AbstractGEDAction
{ 
	
	public Save()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));
		putValue(SMALL_ICON, loadIcon("images/save.png"));
		putValue(NAME, "Save");
		putValue(SHORT_DESCRIPTION, "Save");
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		try {
			MainFrame.getInstance().getActionManager().getSaveAsAction().save(MainFrame.getInstance().getActionManager().getDefaultFile());
		} catch (IOException e) {
			e.printStackTrace();
			MessageHandler.handleEvent(MessageType.SERIALISATION_FAIL);
		}
	}
	
}