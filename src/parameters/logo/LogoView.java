package parameters.logo;

import javax.swing.*;

import main.MainFrame;
import parameters.parametar.model.ParametarModel;
import tree.treeModel.Node;
import tree.treeModel.Parametar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class LogoView extends JPanel implements Observer
{
	private JLabel name;
	private JLabel label;
	private JLabel imageView; 
	
	private JButton browseButton;

	private Node node;

	public LogoView(String label, Node node)
	{
		this.node = node;
		node.addObserver(this);
		name = new JLabel(node.getName());
		this.label = new JLabel(label);
		imageView = new JLabel();
		Image img = new ImageIcon(((Parametar)node).getParametar().getContent()).getImage();
		img = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imageView.setIcon(new ImageIcon(img));
		browseButton = new JButton(MainFrame.getInstance().getActionManager().getBrowseAction());
		browseButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				MainFrame.getInstance().getActionManager().getBrowseAction().browseForLogo();
			}
		});

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel panel = new JPanel();
		panel.add(this.label);
		panel.add(browseButton);

		add(name);
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


	@Override
	public void update(Observable observable, Object o)
	{
		if(o instanceof ParametarModel)
		{
			ParametarModel par = (ParametarModel)o;
			Image img = new ImageIcon(par.getContent()).getImage();
			img = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			imageView.setIcon(new ImageIcon(img));
			return;
		}
		if(o instanceof Node)
		{
			this.node = (Node)o;
			this.name.setText(node.getName());
		}

	}

	public Node getNode()
	{
		return node;
	}
}
