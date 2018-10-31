package gui.toolbar;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import main.MainFrame;

public class MainToolBar extends JPanel
{
	
	private JToolBar mainToolBar;
	
	public MainToolBar()
	{
		super(new BorderLayout());
		mainToolBar = new JToolBar();
		
		
		mainToolBar.add(MainFrame.getInstance().getActionManager().getNewAction());
		mainToolBar.addSeparator();
		mainToolBar.add(MainFrame.getInstance().getActionManager().getOpenAction());
		mainToolBar.add(MainFrame.getInstance().getActionManager().getCloseAction());
		mainToolBar.add(MainFrame.getInstance().getActionManager().getSwitchAction());
		mainToolBar.addSeparator();
		mainToolBar.add(MainFrame.getInstance().getActionManager().getSaveAction());
		mainToolBar.add(MainFrame.getInstance().getActionManager().getSaveAction());
		mainToolBar.addSeparator();
		mainToolBar.add(MainFrame.getInstance().getActionManager().getExitAction());
		
		add(mainToolBar, BorderLayout.PAGE_START);
	}
	

}
