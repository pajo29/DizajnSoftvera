package gui.parameters.path;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MainFrame;

@SuppressWarnings("serial")
public class PathView extends JPanel{
	
	private JLabel label;
	private JTextField adress;
	private JButton browseButton;
	

	public PathView(String label)
	{
		this.label = new JLabel(label);
		adress = new JTextField();
		adress.setMinimumSize(new Dimension(500, 35));
		adress.setPreferredSize(new Dimension(500, 35));
		adress.setMaximumSize(new Dimension(500, 35));
		browseButton = new JButton(MainFrame.getInstance().getActionManager().getBrowseAction());
		browseButton.addActionListener(e->{MainFrame.getInstance().getActionManager().getBrowseAction().browseForPath();});
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(this.label);
		
		JPanel panel = new JPanel();
		panel.add(adress);
		panel.add(browseButton);
		add(panel);
	}
	

	public JLabel getLabel() {
		return label;
	}

	public JTextField getAdress() {
		return adress;
	}

	public JButton getBrowseButton() {
		return browseButton;
	}

}
