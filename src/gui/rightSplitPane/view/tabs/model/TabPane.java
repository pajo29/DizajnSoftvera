package gui.rightSplitPane.view.tabs.model;

import java.util.ArrayList;
import javax.swing.JTabbedPane;

import gui.rightSplitPane.view.ComponentView;
import gui.rightSplitPane.view.tabs.controller.TabController;
import gui.rightSplitPane.view.tabs.controller.TabPaneChangeListener;

@SuppressWarnings("serial")
public class TabPane extends JTabbedPane
{
	
	private static TabPane instance = null;
	
	private ArrayList<Tab> tabs;
	
	private TabController controller;
	
	private boolean checkChange = false;
	
	private TabPaneChangeListener tbChangeListener;
	
	private TabPane()
	{
		tabs = new ArrayList<>();
		controller = new TabController(this);
		tbChangeListener = new TabPaneChangeListener(this);
		addChangeListener(tbChangeListener);
	}
	
	public static TabPane getInstance()
	{
		if(instance == null)
		{
			instance = new TabPane();
		}
		return instance;
	}
	
	public void update() 
	{
		if(getSelectedIndex() != -1)
		{
			ComponentView.getInstance().setData(TabPane.getInstance().getTabs().get(TabPane.getInstance().getSelectedIndex()).getCmp(), tabs.get(getSelectedIndex()));
		}
			
	}

	public ArrayList<Tab> getTabs()
	{
		return tabs;
	}

	public TabController getController()
	{
		return controller;
	}

	public void setCheckChange(boolean checkChange)
	{
		this.checkChange = checkChange;
	}

	public boolean isCheckChange()
	{
		return checkChange;
	}
	
	public TabPaneChangeListener getTbChangeListener()
	{
		return tbChangeListener;
	}
	
}
