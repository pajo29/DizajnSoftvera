package gui.parameters.lookAndFeel.view;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import gui.parameters.lookAndFeel.model.LookAndFeel;

@SuppressWarnings("serial")
public class LookAndFeelView extends JPanel 
{
	private JLabel label;
	private LookAndFeel model;
	
	private JComboBox<String> theme;
	
	private ImageIcon image;
	private JLabel imageDisplay;
	
	private String[] themeChooser = {"Light", "Dark"};
	
	public LookAndFeelView(LookAndFeel model)
	{
		this.model = model;
		label = new JLabel(this.model.getLabel());
		
		theme = new JComboBox<>(themeChooser);
		
		image = new ImageIcon("src/actions/images/lightTheme.png");
		imageDisplay = new JLabel(image);
		
		theme.addActionListener(e->
		{
			changePicture();
		});
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel panel = new JPanel();
		
		panel.add(label);
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
