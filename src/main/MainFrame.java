package main;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import actions.ActionManager;
import gui.menu.MenuBar;
import gui.statusBar.StatusBarView;
import gui.toolbar.MainToolBar;

public class MainFrame extends JFrame {
	
	/**
	 * Author Pavle Prica
	 */
	private static MainFrame instance = null;
	private ActionManager actionManager;
	private MainSplitPane mainSplitPane;
	
	private MainFrame()
	{
	}
	
	private void initialise()
	{
		actionManager = ActionManager.getInstace();
		mainSplitPane = MainSplitPane.getInstance();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(new MenuBar());
		panel.add(new MainToolBar());
		
		add(panel, BorderLayout.NORTH);
		add(mainSplitPane);
		add(new StatusBarView(), BorderLayout.SOUTH);
		
		
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("InstaFram RN75/18");
		setVisible(true);
	}
	
	public ActionManager getActionManager()
	{
		return actionManager;
	}

	public static MainFrame getInstance()
	{
		if(instance == null)
		{
			instance = new MainFrame();
			instance.initialise();
		}
		return instance;
	}

}
