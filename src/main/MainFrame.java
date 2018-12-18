package main;

import java.awt.BorderLayout;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import actions.ActionManager;
import gui.MainSplitPane;
import listeners.CloseListener;
import gui.menu.MenuBar;
import gui.statusBar.StatusBarView;
import gui.toolbar.MainToolBar;
import users.model.User;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ClipboardOwner
{
	
	/**
	 * Author Pavle Prica
	 */
	private static MainFrame instance = null;
	private ActionManager actionManager;
	private MainSplitPane mainSplitPane;

	private Clipboard clipboard;

	private User user;
	
	private MainFrame(User user)
	{
		this.user = user;
	}
	
	private void initialise()
	{
		actionManager = ActionManager.getInstace();
		mainSplitPane = MainSplitPane.getInstance();
		clipboard = new Clipboard("InstaFram clipboard");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(new MenuBar());
		panel.add(new MainToolBar());
		
		add(panel, BorderLayout.NORTH);
		add(mainSplitPane);
		add(new StatusBarView(user), BorderLayout.SOUTH);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new CloseListener());
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public Clipboard getClipboard()
	{
		return clipboard;
	}
	
	public ActionManager getActionManager()
	{
		return actionManager;
	}

	public static MainFrame getInstance(User user)
	{
		if(instance == null)
		{
			instance = new MainFrame(user);
			instance.initialise();
		}
		return instance;
	}

	public static MainFrame getInstance()
	{
		return instance;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable transferable)
	{

	}
}
