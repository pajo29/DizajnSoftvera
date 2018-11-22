package actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class ExportToWord extends AbstractGEDAction
{

	public ExportToWord()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control O"));
		putValue(SMALL_ICON, loadIcon("images/word.png"));
		putValue(NAME, "mExpToMsWord");
		putValue(SHORT_DESCRIPTION, "Export to Word");
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
