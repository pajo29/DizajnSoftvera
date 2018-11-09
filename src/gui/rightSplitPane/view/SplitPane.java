package gui.rightSplitPane.view;

import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class SplitPane extends JSplitPane
{
	private JPanel upSide;
	private JPanel downSide;
	
	public SplitPane()
	{
		
		upSide = new UpSide();
		downSide = DownSide.getInstance();
		
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
