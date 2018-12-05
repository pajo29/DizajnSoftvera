package gui.parameters.logo;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainFrame;

@SuppressWarnings("serial")
public class LogoView extends JPanel
{
	private JLabel label;
	private JLabel imageView; 
	
	private JButton browseButton;
	

	public LogoView(String label)
	{
		this.label = new JLabel(label);
		imageView = new JLabel();
		browseButton = new JButton(MainFrame.getInstance().getActionManager().getBrowseAction());
		browseButton.addActionListener(e ->
		{MainFrame.getInstance().getActionManager().getBrowseAction().browseForLogo();});
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel panel = new JPanel();
		panel.add(this.label);
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


}
