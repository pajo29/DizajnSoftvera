package gui.rightSplitPane;


import javax.swing.*;


@SuppressWarnings("serial")
public class ParametarView extends JPanel
{

	private static ParametarView instance = null;

	private JPanel panel;


	private ParametarView()
	{
		panel = new JPanel();
		add(panel);

	}
	public static ParametarView getInstance()
	{
		if(instance == null) instance = new ParametarView();
		return instance;
	}


	public void setContent(JPanel upSide) {
		panel = upSide;
		this.remove(0);
		this.add(panel);
		SwingUtilities.updateComponentTreeUI(this);
	}

	public void reset()
	{

	}

	public JPanel getPanel()
	{
		return panel;
	}
}
