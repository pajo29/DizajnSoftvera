package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import main.MainFrame;

public class Save extends AbstractGEDAction
{ 
	
	public Save()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));
		putValue(SMALL_ICON, loadIcon("images/save.png"));
		putValue(NAME, "mSave");
		putValue(SHORT_DESCRIPTION, "Save");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
