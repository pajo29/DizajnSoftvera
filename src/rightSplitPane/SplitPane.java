package rightSplitPane;

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
		downSide = new DownSide();
		
		setOrientation(JSplitPane.VERTICAL_SPLIT);
		setTopComponent(upSide);
		setBottomComponent(downSide);
	}

}
