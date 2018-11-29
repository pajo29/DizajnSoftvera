package gui.rightSplitPane.view;


import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class SplitPane extends JSplitPane
{
	private JPanel upSide;
	private JPanel downSide;
	
	@SuppressWarnings("deprecation")
	public SplitPane()
	{
		
		downSide = ComponentView.getInstance();
		upSide = new JPanel();
		
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

	public void setUpSide(JPanel upSide) {
		this.upSide = upSide;
		setTopComponent(upSide);
		setDividerLocation(400);
	}

	public void setDownSide(JPanel downSide) {
		this.downSide = downSide;
	}
	
	

}
