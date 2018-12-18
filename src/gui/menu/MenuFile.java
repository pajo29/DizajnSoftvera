package gui.menu;


import javax.swing.JMenu;
import main.MainFrame;

@SuppressWarnings("serial")
public class MenuFile extends JMenu{

	
	
	public MenuFile()
	{
		if(MainFrame.getInstance().getUser().getRole().equals("operativni korisnik"))
		{
			add(MainFrame.getInstance().getActionManager().getOpenAction());
			add(MainFrame.getInstance().getActionManager().getSaveAction());
			add(MainFrame.getInstance().getActionManager().getSaveAsAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getExportAction());
			add(MainFrame.getInstance().getActionManager().getImportAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getExitAction());
		}
		else
		{
			add(MainFrame.getInstance().getActionManager().getNewAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getOpenAction());
			add(MainFrame.getInstance().getActionManager().getEditAction());
			add(MainFrame.getInstance().getActionManager().getRemoveAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getExportAction());
			add(MainFrame.getInstance().getActionManager().getImportAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getSaveAction());
			add(MainFrame.getInstance().getActionManager().getSaveAsAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getExitAction());
		}
		setText("File");
	}
	
}
