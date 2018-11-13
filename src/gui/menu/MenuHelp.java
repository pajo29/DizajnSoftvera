package gui.menu;

import javax.swing.JMenu;

import main.MainFrame;

@SuppressWarnings("serial")
public class MenuHelp extends JMenu
{

	
	public MenuHelp()
	{
		add(MainFrame.getInstance().getActionManager().getHelpAction());
		setText("Pomoc");
	}
}
