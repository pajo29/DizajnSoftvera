package parameters.termsOfUse;

import tree.treeModel.Node;
import tree.treeModel.Parametar;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TermsOfUseView extends JPanel implements Observer
{
	private JLabel name;
	private JLabel label;
	private JTextArea aboutField;
	
	private Node node;

	public TermsOfUseView(String label, Node node, boolean simulation, String lookAndFeel)
	{
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.node = node;
		node.addObserver(this);
		name = new JLabel(node.getName());
		this.label = new JLabel(label);
		aboutField = new JTextArea(((Parametar)node).getParametar().getContent());
		aboutField.setMinimumSize(new Dimension(500, 300));
		aboutField.setPreferredSize(new Dimension(500, 300));
		aboutField.setMaximumSize(new Dimension(500, 300));
		aboutField.addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent keyEvent)
			{

			}

			@Override
			public void keyPressed(KeyEvent keyEvent)
			{

			}

			@Override
			public void keyReleased(KeyEvent keyEvent)
			{
				((Parametar)node).getParametar().setContent(aboutField.getText());
			}
		});

		if(lookAndFeel.equals("Dark"))
		{
			this.setBackground(Color.BLACK);
			aboutField.setBackground(Color.GRAY);

		}
		if(simulation)
		{
			aboutField.setEnabled(false);
			aboutField.setDisabledTextColor(Color.BLACK);
		}
		else
			add(name);
		add(this.label);
		add(aboutField);
	}

	public JLabel getLabel() {
		return label;
	}

	public JTextArea getAboutField() {
		return aboutField;
	}


	@Override
	public void update(Observable observable, Object o)
	{
		this.node = (Node)o;
		name.setText(node.getName());
	}
}
