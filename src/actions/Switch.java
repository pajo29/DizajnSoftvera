package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class Switch extends AbstractGEDAction
{
	
	public Switch()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_4, ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, loadIcon("images/switch.png"));
		putValue(NAME, "mSwitch");
		putValue(SHORT_DESCRIPTION, "Switch");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
