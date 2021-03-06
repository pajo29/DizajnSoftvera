package gui.menu.treePopupMenu;

import javax.swing.JPopupMenu;
import javax.swing.tree.TreePath;

import tree.treeModel.Module;
import tree.treeModel.Parametar;
import tree.treeModel.Product;
import tree.treeModel.SoftwareCompany;
import main.MainFrame;

@SuppressWarnings("serial")
public class PopupMenu extends JPopupMenu {
	
	public PopupMenu(TreePath path)
	{
		if(MainFrame.getInstance().getUser().getRole().equals("operativni korisnik"))
		{
			if (path.getLastPathComponent() instanceof SoftwareCompany)
			{
				add(MainFrame.getInstance().getActionManager().getOpenAction());
				add(MainFrame.getInstance().getActionManager().getImportAction());
			}
			if (path.getLastPathComponent() instanceof Product)
			{
				add(MainFrame.getInstance().getActionManager().getExportAction());
				addSeparator();
				add(MainFrame.getInstance().getActionManager().getPasteAction());
			}
			if (path.getLastPathComponent() instanceof Module)
			{
				add(MainFrame.getInstance().getActionManager().getPasteAction());
			}
			if (path.getLastPathComponent() instanceof Parametar)
			{
			}
		}
		else
		{
			if (path.getLastPathComponent() instanceof SoftwareCompany)
			{
				add(MainFrame.getInstance().getActionManager().getNewAction());
				addSeparator();
				add(MainFrame.getInstance().getActionManager().getOpenAction());
				add(MainFrame.getInstance().getActionManager().getImportAction());
				addSeparator();
				add(MainFrame.getInstance().getActionManager().getRemoveAction());
				addSeparator();
			}
			if (path.getLastPathComponent() instanceof Product)
			{
				add(MainFrame.getInstance().getActionManager().getNewAction());
				addSeparator();
				add(MainFrame.getInstance().getActionManager().getExportAction());
				addSeparator();
				add(MainFrame.getInstance().getActionManager().getEditAction());
				add(MainFrame.getInstance().getActionManager().getRemoveAction());
				addSeparator();
				add(MainFrame.getInstance().getActionManager().getPasteAction());
			}
			if (path.getLastPathComponent() instanceof Module)
			{
				add(MainFrame.getInstance().getActionManager().getNewAction());
				addSeparator();
				add(MainFrame.getInstance().getActionManager().getRemoveAction());
				addSeparator();
				add(MainFrame.getInstance().getActionManager().getPasteAction());
			}
			if (path.getLastPathComponent() instanceof Parametar)
			{
				add(MainFrame.getInstance().getActionManager().getEditAction());
				add(MainFrame.getInstance().getActionManager().getRemoveAction());
			}
		}
	}

}
