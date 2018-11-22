package gui.rightSplitPane.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.rightSplitPane.view.tabs.model.Tab;
import gui.rightSplitPane.view.tabs.model.TabPane;

public class ClosingActionListener implements ActionListener
{

	private Tab tab;
	
	public ClosingActionListener(Tab tab)
	{
		this.tab = tab;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		TabPane.getInstance().getController().removeTab(tab);
	}

}
