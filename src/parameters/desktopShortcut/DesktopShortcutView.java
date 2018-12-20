package parameters.desktopShortcut;

import tree.treeModel.Node;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;


@SuppressWarnings("serial")
public class DesktopShortcutView extends JPanel implements Observer
{
	private JLabel name;
	private JLabel label;
	private JCheckBox checkBox;

	private Node node;
	
	public DesktopShortcutView(String label, Node node)
	{
		this.node = node;
		node.addObserver(this);
		name = new JLabel(node.getName());
		this.label = new JLabel(label);
		checkBox = new JCheckBox("Desktop shortcut");

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(this.label);
		add(checkBox);
	}

	@Override
	public void update(Observable observable, Object o)
	{
		this.node = (Node)o;
		this.name.setText(node.getName());
	}
}
