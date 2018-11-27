package gui.rightSplitPane.view.tabs.controller;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import gui.rightSplitPane.view.ComponentView;
import gui.rightSplitPane.view.tabs.model.Tab;
import gui.rightSplitPane.view.tabs.model.TabPane;
import gui.tree.treeModel.Component;
import main.MainFrame;

public class TabController
{

	private TabPane tabPane;
	
	public TabController(TabPane tabPane)
	{
		this.tabPane = tabPane;
	}
	
	public void addTab(Component cmp)
	{
		Tab tab = new Tab(cmp);
		if(!tabPane.getTabs().contains(tab))
		{
			tabPane.addTab(cmp.getName(), new ImageIcon("src/actions/images/editing.png"), tab);
			tabPane.getTabs().add(tab);
		}
		else
		{
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ova komponenta je vec otvorena", "!!", JOptionPane.WARNING_MESSAGE);
		}
		tabPane.setCheckChange(false);
	}
	
	public void renameTab(gui.tree.model.Component cmp)
	{
		for(int i = 0; i < tabPane.getTabs().size(); i++)
		{
			if(cmp == tabPane.getTabs().get(i).getCmp())
			{
				tabPane.setTitleAt(i, cmp.getName());
			}
		}
		tabPane.update();
		tabPane.setCheckChange(false);
	}
	
	public void removeTab(Tab tab)
	{
		for(int i = 0; i < tabPane.getTabs().size(); i++)
		{
			if(tabPane.getTabs().get(i) == tab)
			{
				tabPane.remove(i);
				tabPane.getTabs().remove(tab);
			}
		}
		tabPane.setCheckChange(false);
		if(tabPane.getTabs().isEmpty())
		{
			tabPane.getTbChangeListener().setFirstAdd(true);
			ComponentView.getInstance().empty();
		}
		else
			tabPane.update();
	}
	
	public void removeTab(Component component)
	{
		for(int i = 0; i < tabPane.getTabs().size(); i++)
		{
			if(tabPane.getTabs().get(i).getCmp() == component)
			{
				tabPane.remove(i);
				tabPane.getTabs().remove(i);
			}
		}
		tabPane.setCheckChange(false);
		if(tabPane.getTabs().isEmpty())
		{
			tabPane.getTbChangeListener().setFirstAdd(true);
			ComponentView.getInstance().empty();
		}
		else
			tabPane.update();
	}
	
	public void removeAllTabs()
	{
		tabPane.removeAll();
		tabPane.getTabs().clear();
		tabPane.setCheckChange(false);
		tabPane.getTbChangeListener().setFirstAdd(true);
		ComponentView.getInstance().empty();
	}
	
	public void selectTab(gui.tree.model.Component cmp)
	{
		for(int i = 0; i < tabPane.getTabs().size(); i++)
		{
			if(cmp == tabPane.getTabs().get(i).getCmp())
			{
				tabPane.setSelectedIndex(i);
				ComponentView.getInstance().setData(cmp, tabPane.getTabs().get(tabPane.getSelectedIndex()));
			}
		}
		tabPane.setCheckChange(false);
	}
}
