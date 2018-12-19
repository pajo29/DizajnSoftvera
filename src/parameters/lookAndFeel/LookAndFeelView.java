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
			changePicture();
		});
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel panel = new JPanel();

		add(name);
		panel.add(this.label);
		panel.add(theme);
		add(panel);
		add(imageDisplay);
	}
	
	private void changePicture()
	{
		switch((String)theme.getSelectedItem())
		{
		case "Light":
			image = new ImageIcon("src/actions/images/lightTheme.png");
			imageDisplay.setIcon(image);
			break;
		case "Dark":
			image = new ImageIcon("src/actions/images/darkTheme.png");
			imageDisplay.setIcon(image);
			break;
		}
		((Parametar)node).getParametar().setContent((String)theme.getSelectedItem());
	}

	@Override
	public void update(Observable observable, Object o)
	{
		this.node = (Node)o;
		this.name.setText(node.getName());
	}
}
