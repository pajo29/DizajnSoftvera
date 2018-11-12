package gui.rightSplitPane.view.tabs.model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.rightSplitPane.view.DownSide;
import gui.rightSplitPane.view.tabs.controller.TabController;
import gui.tree.model.Component;
import main.MainFrame;
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
		controller = new TabController();
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
//		tabs.get(i).getTxArea().setText(((Component)arg).getContent());
		System.out.println(((Component)arg).getContent());
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
