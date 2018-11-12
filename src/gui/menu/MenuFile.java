package gui.menu;


import javax.swing.JMenu;
import main.MainFrame;

@SuppressWarnings("serial")
public class MenuFile extends JMenu{

	
	private JMenu subMExport;
	private JMenu subMImport;
	
	public MenuFile()
	{		
		subMExport = new JMenu("mExport");
		subMImport = new JMenu("mImport");
		
		
		
		add(MainFrame.getInstance().getActionManager().getNewAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getOpenAction());
		add(MainFrame.getInstance().getActionManager().getEditAction());
		add(MainFrame.getInstance().getActionManager().getRemoveAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getSaveAction());
		add(MainFrame.getInstance().getActionManager().getSaveAsAction());
		addSeparator();
		add(subMExport);
		subMExport.add(MainFrame.getInstance().getActionManager().getExportToPDFAction());
		subMExport.add(MainFrame.getInstance().getActionManager().getExportToMsExcellAction());
		subMExport.add(MainFrame.getInstance().getActionManager().getExportToWordAction());
		//
		add(subMImport);
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getExitAction());
		
		setText("File");
	}
	
}
