package actions;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import main.MainFrame;
import main.MainSplitPane;

@SuppressWarnings("serial")
public class SaveAs extends AbstractGEDAction
{

	public SaveAs()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control shift S"));
		putValue(SMALL_ICON, loadIcon("images/saveAs.png"));
		putValue(NAME, "mSaveAs");
		putValue(SHORT_DESCRIPTION, "Save As");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
	}
	
	

}
