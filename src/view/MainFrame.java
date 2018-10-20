package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	
	private static MainFrame instance = null;
	
	private MainFrame()
	{
		add(MenuBar.getInstance(), BorderLayout.NORTH);
		add(MainToolBar.getInstance());
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(screenSize.width/2, screenSize.height/2);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("InstaFram RN75/18");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
