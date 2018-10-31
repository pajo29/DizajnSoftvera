package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class Open extends AbstractGEDAction
{
	
	public Open()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, loadIcon("images/open.png"));
		putValue(NAME, "mOpen");
		putValue(SHORT_DESCRIPTION, "Open File");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}

}
