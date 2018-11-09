package gui.rightSplitPane.view.tabs;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import gui.tree.model.Component;
import main.MainFrame;
import main.MainSplitPane;

public class TabPane extends JTabbedPane implements Observer
{
	
	private static TabPane instance = null;
	
	private ArrayList<Tab> tabs;
	
	private TabPane()
	{
		MainSplitPane.getInstance().getTree().getContentModel().addObserver(this);
		tabs = new ArrayList<>();
	}
	
	public static TabPane getInstance()
	{
		if(instance == null)
		{
			instance = new TabPane();
		}
		return instance;
	}
	
	public void addTab(Component cmp)
	{
		Tab tab = new Tab(cmp);
		if(!tabs.contains(tab))
		{
			addTab(cmp.getName(), new ImageIcon("src/actions/images/editing.png"), tab);
			tabs.add(tab);
		}
		else
		{
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ova komponenta je vec otvorena", "!!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void removeTab(Tab tab)
	{
		for(int i = 0; i < tabs.size(); i++)
		{
			if(tabs.get(i) == tab)
			{
				remove(i);
				tabs.remove(tab);
			}
		}
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
		tabs.get(i).getTxArea().setText(((Component)arg).getContent());
		System.out.println(((Component)arg).getContent());
	}
	
}
