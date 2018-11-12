package gui.rightSplitPane.view.tabs.model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTabbedPane;

import gui.rightSplitPane.view.ComponentView;
import gui.rightSplitPane.view.tabs.controller.TabController;
import gui.tree.model.Component;
import main.MainSplitPane;

@SuppressWarnings("serial")
public class TabPane extends JTabbedPane implements Observer
{
	
	private static TabPane instance = null;
	
	private ArrayList<Tab> tabs;
	
	private TabController controller;
	
	private TabPane()
	{
		MainSplitPane.getInstance().getTree().getContentModel().addObserver(this);
		tabs = new ArrayList<>();
		controller = new TabController(this);
	}
	
	public static TabPane getInstance()
	{
		if(instance == null)
		{
			instance = new TabPane();
		}
		return instance;
	}
	
	@Override
	public void update(Observable o, Object arg)
	{
		int i = 0;
		for(i = 0; i < tabs.size(); i++)
		{
			if(((Component)arg).getContent().equals(tabs.get(i).getTxArea().getText()))
			{
				break;
			}
		}
		System.out.println(((Component)arg).getContent());
	}
	
	public void update()
	{
		if(getSelectedIndex() != -1)
			ComponentView.getInstance().setData(TabPane.getInstance().getTabs().get(TabPane.getInstance().getSelectedIndex()).getCmp(), tabs.get(getSelectedIndex()));
	}

	public ArrayList<Tab> getTabs()
	{
		return tabs;
	}

	public TabController getController()
	{
		return controller;
	}
	
	
	
}
