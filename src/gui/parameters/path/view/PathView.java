package gui.parameters.path.view;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.parameters.path.model.Path;
import main.MainFrame;

@SuppressWarnings("serial")
public class PathView extends JPanel{
	
	private JLabel label;
	private JTextField adress;
	private JButton browseButton;
	
	private Path pathModel;
	
	public PathView(Path pathModel)
	{
		this.pathModel = pathModel;
		label = new JLabel(this.pathModel.getLabel());
		adress = new JTextField();
		adress.setMinimumSize(new Dimension(500, 35));
		adress.setPreferredSize(new Dimension(500, 35));
		adress.setMaximumSize(new Dimension(500, 35));
		browseButton = new JButton(MainFrame.getInstance().getActionManager().getBrowseAction());
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(label);
		
		JPanel panel = new JPanel();
		panel.add(adress);
		panel.add(browseButton);
		
		add(panel);
	}
	
	public Path getPathModel() {
		return pathModel;
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
