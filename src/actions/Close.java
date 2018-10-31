package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class Close extends AbstractGEDAction
{
	public Close()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_3, ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, loadIcon("images/close.png"));
		putValue(NAME, "mClose");
		putValue(SHORT_DESCRIPTION, "Close");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
