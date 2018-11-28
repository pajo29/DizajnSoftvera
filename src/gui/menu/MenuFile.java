package gui.menu;


import javax.swing.JMenu;
import main.MainFrame;

@SuppressWarnings("serial")
public class MenuFile extends JMenu{

	
	
	public MenuFile()
	{		
		add(MainFrame.getInstance().getActionManager().getNewAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getOpenAction());
		add(MainFrame.getInstance().getActionManager().getEditAction());
		add(MainFrame.getInstance().getActionManager().getRemoveAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getSaveAction());
		add(MainFrame.getInstance().getActionManager().getSaveAsAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getExitAction());
		
		setText("File");
	}
	
}
