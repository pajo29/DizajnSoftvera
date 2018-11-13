package gui.menu;


import javax.swing.JMenu;
import main.MainFrame;

@SuppressWarnings("serial")
public class MenuAbout extends JMenu
{
	public MenuAbout()
	{
		add(MainFrame.getInstance().getActionManager().getAboutAction());
		setText("About");
	}
}
