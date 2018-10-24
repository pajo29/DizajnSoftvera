package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import rightSplitPane.SplitPane;
import toolbar.MainToolBar;

public class MainSplitPane extends JSplitPane
{
	private SplitPane splitPane;
	
	public MainSplitPane()
	{
		splitPane = new SplitPane();
		
		setRightComponent(splitPane);
		setDividerLocation(230);
		setLeftComponent(new JTextArea());
	}
}
