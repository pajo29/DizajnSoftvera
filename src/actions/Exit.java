package actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

public class Exit extends AbstractGEDAction
{

	public Exit()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control E"));
		putValue(SMALL_ICON, loadIcon("images/exit.png"));
		putValue(NAME, "mExit");
		putValue(SHORT_DESCRIPTION, "Exit program");
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
			System.exit(0);
	}

}
