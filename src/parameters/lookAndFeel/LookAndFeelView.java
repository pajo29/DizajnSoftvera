<<<<<<< HEAD
package parameters.lookAndFeel;

import tree.treeModel.Node;
import tree.treeModel.Parametar;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class LookAndFeelView extends JPanel implements Observer
{
	private JLabel name;
	private JLabel label;

	private JComboBox<String> theme;
	
	private ImageIcon image;
	private JLabel imageDisplay;
	
	private String[] themeChooser = {"Light", "Dark"};

	private Node node;
	
	public LookAndFeelView(String label, Node node)
	{

		this.node = node;

		node.addObserver(this);
		name = new JLabel(node.getName());
		this.label = new JLabel(label);
		
		theme = new JComboBox<>(themeChooser);

		
		image = new ImageIcon("src/actions/images/lightTheme.png");
		imageDisplay = new JLabel(image);
		
		theme.addActionListener(e->
		{
			((Parametar)node).getParametar().setContent((String)theme.getSelectedItem());
			changePicture();
		});
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel panel = new JPanel();


		changePicture();
		add(name);
		panel.add(this.label);
		panel.add(theme);
		add(panel);
		add(imageDisplay);
	}
	
	private void changePicture()
	{
		String content = ((Parametar)node).getParametar().getContent();
		if(!content.equals("Dark"))
			content = "Light";
		switch(content)
		{
		case "Light":
			image = new ImageIcon("src/actions/images/lightTheme.png");
			imageDisplay.setIcon(image);
			theme.setSelectedIndex(0);
			break;
		case "Dark":
			image = new ImageIcon("src/actions/images/darkTheme.png");
			imageDisplay.setIcon(image);
			theme.setSelectedIndex(1);
			break;
		}

	}

	@Override
	public void update(Observable observable, Object o)
	{
		this.node = (Node)o;
		this.name.setText(node.getName());
	}
}
=======
package parameters.lookAndFeel;

import tree.treeModel.Node;
import tree.treeModel.Parametar;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class LookAndFeelView extends JPanel implements Observer
{
	private JLabel name;
	private JLabel label;

	private JComboBox<String> theme;
	
	private ImageIcon image;
	private JLabel imageDisplay;
	
	private String[] themeChooser = {"Light", "Dark"};

	private Node node;
	
	public LookAndFeelView(String label, Node node)
	{

		this.node = node;

		node.addObserver(this);
		name = new JLabel(node.getName());
		this.label = new JLabel(label);
		
		theme = new JComboBox<>(themeChooser);

		
		image = new ImageIcon("src/actions/images/lightTheme.png");
		imageDisplay = new JLabel(image);
		
		theme.addActionListener(e->
		{
			((Parametar)node).getParametar().setContent((String)theme.getSelectedItem());
			changePicture();
		});
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel panel = new JPanel();


		changePicture();
		add(name);
		panel.add(this.label);
		panel.add(theme);
		add(panel);
		add(imageDisplay);
	}
	
	private void changePicture()
	{
		String content = ((Parametar)node).getParametar().getContent();
		if(!content.equals("Dark"))
			content = "Light";
		switch(content)
		{
		case "Light":
			image = new ImageIcon("src/actions/images/lightTheme.png");
			imageDisplay.setIcon(image);
			theme.setSelectedIndex(0);
			break;
		case "Dark":
			image = new ImageIcon("src/actions/images/darkTheme.png");
			imageDisplay.setIcon(image);
			theme.setSelectedIndex(1);
			break;
		}

	}

	@Override
	public void update(Observable observable, Object o)
	{
		this.node = (Node)o;
		this.name.setText(node.getName());
	}
}
>>>>>>> 4ffd20ae8b5902ea28b0c604686b86a6f030c2fa
