package gui.parameters.logo.view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.parameters.logo.model.Logo;
import main.MainFrame;

@SuppressWarnings("serial")
public class LogoView extends JPanel
{
	private JLabel label;
	private JLabel imageView; 
	
	private JButton browseButton;
	
	private Logo model;
	
	public LogoView(Logo model)
	{
		this.model = model;
		label = new JLabel(this.model.getLabel());
		imageView = new JLabel();
		browseButton = new JButton(MainFrame.getInstance().getActionManager().getBrowseAction());
		browseButton.addActionListener(e ->
		{MainFrame.getInstance().getActionManager().getBrowseAction().browseForLogo();});
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(browseButton);
		
		add(panel);
		add(imageView);
	}

	public JLabel getLabel() {
		return label;
	}

	public JLabel getImageView() {
		return imageView;
	}

	public JButton getBrowseButton() {
		return browseButton;
	}

	public Logo getModel() {
		return model;
	}

}
