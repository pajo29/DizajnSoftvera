package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import menu.MenuBar;
import statusBar.StatusBarView;
import toolbar.MainToolBar;

public class MainFrame extends JFrame {
	
	private static MainFrame instance = null;
	
	private MainFrame()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(new MenuBar());
		panel.add(new MainToolBar());
		
		add(panel, BorderLayout.NORTH);
		add(new MainSplitPane());
		add(new StatusBarView(), BorderLayout.SOUTH);
		
		
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("InstaFram RN75/18");
		setVisible(true);
		
	}
	
	public static MainFrame getInstance()
	{
		if(instance == null)
		{
			instance = new MainFrame();
		}
		return instance;
	}

}
