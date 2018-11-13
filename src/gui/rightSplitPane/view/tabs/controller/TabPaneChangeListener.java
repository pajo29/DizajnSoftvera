package gui.rightSplitPane.view.tabs.controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.rightSplitPane.view.tabs.model.TabPane;

public class TabPaneChangeListener implements ChangeListener
{

	
	private TabPane tbPane;
	private boolean firstAdd = true;
	
	public TabPaneChangeListener(TabPane tbPane)
	{
		this.tbPane = tbPane;
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0)
	{
		update();
	}
	
	private void update()
	{
		if(!firstAdd)
		{
		if(tbPane.isCheckChange())
			tbPane.update();
		
		else
		{
			tbPane.setCheckChange(true);
			tbPane.update();
		}
		}
		firstAdd = false;
	}
	
	public void setFirstAdd(boolean firstAdd)
	{
		this.firstAdd = firstAdd;
	}

}
