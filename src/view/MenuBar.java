package view;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	
	private static MenuBar instance = null;
	
	private JMenu menuFile;
	private JMenu menuView;
	private JMenu menuTools;
	
	private JMenu menuPara;
	private JMenu menuHelp;
	private JMenu menuAbout;
	
	
	private MenuBar()
	{
		
		
		menuFile = MenuFile.getInstance();
		menuView = new JMenu("View");
		menuTools = new JMenu("Tools");
		
		menuPara = new JMenu("Parametrizacija");
		menuHelp = new JMenu("Pomoæ");
		menuAbout = new JMenu("About");
		
		
		
		
		add(menuFile);
		add(menuView);
		add(menuTools);
		add(Box.createHorizontalGlue());
		add(menuPara);
		add(menuHelp);
		add(menuAbout);
	}
	
	public static MenuBar getInstance()
	{
		if(instance == null)
			instance = new MenuBar();
		return instance;
	}

}
