package gui.menu.treePopupMenu;

import javax.swing.JPopupMenu;

import main.MainFrame;

@SuppressWarnings("serial")
public class PopupMenu extends JPopupMenu {
	
	public PopupMenu()
	{
		add(MainFrame.getInstance().getActionManager().getNewAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getOpenAction());
		add(MainFrame.getInstance().getActionManager().getExportAction());
		add(MainFrame.getInstance().getActionManager().getImportAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getEditAction());
		add(MainFrame.getInstance().getActionManager().getRemoveAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getCopyAction());
		add(MainFrame.getInstance().getActionManager().getCutAction());
		add(MainFrame.getInstance().getActionManager().getPasteAction());
	}

}
