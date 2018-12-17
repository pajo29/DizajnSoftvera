package parameters.lookAndFeel;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LookAndFeelView extends JPanel 
{
	private JLabel label;

	private JComboBox<String> theme;
	
	private ImageIcon image;
	private JLabel imageDisplay;
	
	private String[] themeChooser = {"Light", "Dark"};
	
	public LookAndFeelView(String label)
	{
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
	}

}
