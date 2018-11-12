package gui.rightSplitPane.view.tabs.view;


import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gui.rightSplitPane.view.tabs.model.TabPane;
import gui.toolbar.MainToolBar;

@SuppressWarnings("serial")
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
