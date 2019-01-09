<<<<<<< HEAD
package parameters.desktopShortcut;

import tree.treeModel.Node;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


@SuppressWarnings("serial")
public class DesktopShortcutView extends JPanel implements Observer
{
	private JLabel name;
	private JLabel label;
	private JCheckBox checkBox;

	private Node node;
	
	public DesktopShortcutView(String label, Node node, boolean simulation, String lookAndFeel)
	{
		this.node = node;
		node.addObserver(this);
		name = new JLabel(node.getName());
		this.label = new JLabel(label);
		checkBox = new JCheckBox("Desktop shortcut");

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		if(lookAndFeel.equals("Dark"))
		{
			this.setBackground(Color.BLACK);
			checkBox.setBackground(Color.BLACK);
		}

		if(!simulation)
			add(name);
		add(this.label);
		add(checkBox);
	}

	public JCheckBox getCheckBox()
	{
		return checkBox;
	}

	@Override
	public void update(Observable observable, Object o)
	{
		this.node = (Node)o;
		this.name.setText(node.getName());
	}
}
=======
package parameters.desktopShortcut;

import tree.treeModel.Node;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


@SuppressWarnings("serial")
public class DesktopShortcutView extends JPanel implements Observer
{
	private JLabel name;
	private JLabel label;
	private JCheckBox checkBox;

	private Node node;
	
	public DesktopShortcutView(String label, Node node, boolean simulation, String lookAndFeel)
	{
		this.node = node;
		node.addObserver(this);
		name = new JLabel(node.getName());
		this.label = new JLabel(label);
		checkBox = new JCheckBox("Desktop shortcut");

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		if(lookAndFeel.equals("Dark"))
		{
			this.setBackground(Color.BLACK);
			checkBox.setBackground(Color.BLACK);
		}

		if(!simulation)
			add(name);
		add(this.label);
		add(checkBox);
	}

	public JCheckBox getCheckBox()
	{
		return checkBox;
	}

	@Override
	public void update(Observable observable, Object o)
	{
		this.node = (Node)o;
		this.name.setText(node.getName());
	}
}
>>>>>>> 4ffd20ae8b5902ea28b0c604686b86a6f030c2fa
