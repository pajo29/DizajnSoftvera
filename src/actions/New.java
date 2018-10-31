package actions;

import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import main.MainFrame;


public class New extends AbstractGEDAction
{
	
	public New()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control T"));
		putValue(SMALL_ICON, loadIcon("images/newFile.png"));
		putValue(NAME, "mFile");
		putValue(SHORT_DESCRIPTION, "New file");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ovo nazalost jos nista ne radi :(", "New", JOptionPane.INFORMATION_MESSAGE);
	}
}
