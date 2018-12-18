package gui.menu;

import main.MainFrame;

import javax.swing.JMenu;

@SuppressWarnings("serial")
public class MenuEdit extends JMenu
{

	public MenuEdit()
	{
		if(MainFrame.getInstance().getUser().getRole().equals("operativni korisnik"))
		{
			add(MainFrame.getInstance().getActionManager().getUndoAction());
			add(MainFrame.getInstance().getActionManager().getRedoAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getCopyAction());
			add(MainFrame.getInstance().getActionManager().getPasteAction());
		}
		else
		{
			add(MainFrame.getInstance().getActionManager().getUndoAction());
			add(MainFrame.getInstance().getActionManager().getRedoAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getCopyAction());
			add(MainFrame.getInstance().getActionManager().getCutAction());
			add(MainFrame.getInstance().getActionManager().getPasteAction());
		}

		setText("Edit");
	}
}
