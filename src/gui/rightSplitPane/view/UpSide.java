package gui.rightSplitPane.view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gui.rightSplitPane.view.tabs.TabPane;
import gui.toolbar.MainToolBar;
import main.MainFrame;

public class UpSide extends JPanel
{
	
	private MainToolBar toolBar;
	private TabPane tabPane;
	
	public UpSide()
	{
		toolBar = new MainToolBar();
		tabPane = TabPane.getInstance();

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(toolBar);

		add(tabPane);
		
	}

	public TabPane getTabPane()
	{
		return tabPane;
	}

}
