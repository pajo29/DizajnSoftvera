package gui.menu;

import main.MainFrame;

import javax.swing.JMenu;

@SuppressWarnings("serial")
public class MenuTools extends JMenu
{

	
	public MenuTools()
	{
		add(MainFrame.getInstance().getActionManager().getPreviewAction());
		setText("Tools");
	}
}
