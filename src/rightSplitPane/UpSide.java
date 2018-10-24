package rightSplitPane;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import toolbar.MainToolBar;

public class UpSide extends JPanel
{
	
	private MainToolBar toolBar;
	private JScrollPane scrollPane;
	
	private JTextArea txtArea;
	
	public UpSide()
	{
		toolBar = new MainToolBar();
		
		txtArea = new JTextArea(200, 200);
		scrollPane = new JScrollPane(txtArea);
		
		

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(toolBar);
		scrollPane.setPreferredSize(new Dimension(400, 400));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		
	}

}
