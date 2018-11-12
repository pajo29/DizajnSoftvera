package gui.rightSplitPane.view;


import javax.swing.JPanel;
import javax.swing.JSplitPane;

import gui.rightSplitPane.view.tabs.view.TabView;

@SuppressWarnings("serial")
public class SplitPane extends JSplitPane
{
	private JPanel upSide;
	private JPanel downSide;
	
	@SuppressWarnings("deprecation")
	public SplitPane()
	{
		
		upSide = new TabView();
		downSide = ComponentView.getInstance();
		
		setOrientation(JSplitPane.VERTICAL_SPLIT);
		setTopComponent(upSide);
		setBottomComponent(downSide);
		setDividerLocation(400);
		disable();
	}

	public JPanel getUpSide()
	{
		return upSide;
	}

	public JPanel getDownSide()
	{
		return downSide;
	}
	
	

}
