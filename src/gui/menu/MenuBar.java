package gui.menu;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar{
	
	
	private JMenu menuFile;
	private JMenu menuView;
	private JMenu menuTools;
	
	private JMenu menuPara;
	private JMenu menuHelp;
	private JMenu menuAbout;
	
	public MenuBar()
	{
		
		
		menuFile = new MenuFile();
		menuView = new MenuView();
		menuTools = new MenuTools();
		
		menuPara = new MenuParametrizacija();
		menuHelp = new MenuHelp();
		menuAbout = new MenuAbout();
		
		
		
		
		add(menuFile);
		add(menuView);
		add(menuTools);
		add(Box.createHorizontalGlue());
		add(menuPara);
		add(menuHelp);
		add(menuAbout);
		
		
	}
	
}
