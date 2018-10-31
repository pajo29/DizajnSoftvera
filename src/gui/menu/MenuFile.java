package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import main.MainFrame;

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
		add(MainFrame.getInstance().getActionManager().getCloseAction());
		add(MainFrame.getInstance().getActionManager().getSwitchAction());
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
