package gui.toolbar;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import main.MainFrame;

@SuppressWarnings("serial")
public class MainToolBar extends JPanel
{
	
	private JToolBar mainToolBar;
	
	public MainToolBar()
	{
		super(new BorderLayout());
		mainToolBar = new JToolBar();
		
		if(MainFrame.getInstance().getUser().getRole().equals("operativni korisnik"))
		{
			mainToolBar.add(MainFrame.getInstance().getActionManager().getOpenAction());
			mainToolBar.addSeparator();
			mainToolBar.add(MainFrame.getInstance().getActionManager().getExportAction());
			mainToolBar.add(MainFrame.getInstance().getActionManager().getImportAction());
			mainToolBar.addSeparator();
			mainToolBar.add(MainFrame.getInstance().getActionManager().getSaveAction());
			mainToolBar.add(MainFrame.getInstance().getActionManager().getSaveAsAction());
			mainToolBar.addSeparator();
			mainToolBar.add(MainFrame.getInstance().getActionManager().getExitAction());
		}
		else
		{
			mainToolBar.add(MainFrame.getInstance().getActionManager().getNewAction());
			mainToolBar.addSeparator();
			mainToolBar.add(MainFrame.getInstance().getActionManager().getOpenAction());
			mainToolBar.add(MainFrame.getInstance().getActionManager().getEditAction());
			mainToolBar.add(MainFrame.getInstance().getActionManager().getRemoveAction());
			mainToolBar.addSeparator();
			mainToolBar.add(MainFrame.getInstance().getActionManager().getExportAction());
			mainToolBar.add(MainFrame.getInstance().getActionManager().getImportAction());
			mainToolBar.addSeparator();
			mainToolBar.add(MainFrame.getInstance().getActionManager().getSaveAction());
			mainToolBar.add(MainFrame.getInstance().getActionManager().getSaveAsAction());
			mainToolBar.addSeparator();
			mainToolBar.add(MainFrame.getInstance().getActionManager().getExitAction());
		}
		
		add(mainToolBar, BorderLayout.PAGE_START);
	}
	

}
