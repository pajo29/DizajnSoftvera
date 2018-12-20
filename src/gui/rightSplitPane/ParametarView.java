package gui.rightSplitPane;


import tree.treeModel.Node;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;


@SuppressWarnings("serial")
public class ParametarView extends JPanel implements Observer
{

	private static ParametarView instance = null;

	private JPanel panel;
	private Node activeNode = null;

	private Node node;


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


	public void setContent(JPanel upSide, Node node) {
		panel = upSide;
		this.node = node;
		node.addObserver(this);
		activeNode = node;
		this.remove(0);
		this.add(panel);
		SwingUtilities.updateComponentTreeUI(this);
	}

	public void checkForRemove(Node node)
	{
		if(activeNode == node)
			remove();
	}

	public void remove()
	{
		panel.removeAll();
		SwingUtilities.updateComponentTreeUI(this);
	}

	public JPanel getPanel()
	{
		return panel;
	}

	@Override
	public void update(Observable observable, Object o)
	{
		if(o instanceof Node)
		{
			activeNode = (Node)o;
		}
	}
}
