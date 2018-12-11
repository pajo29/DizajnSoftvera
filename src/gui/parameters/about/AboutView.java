package gui.parameters.about;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AboutView extends JPanel
{
	private JLabel label;
	private JTextArea aboutField;
	

	public AboutView(String label)
	{
		this.label = new JLabel(label);
		aboutField = new JTextArea();
		aboutField.setMinimumSize(new Dimension(500, 300));
		aboutField.setPreferredSize(new Dimension(500, 300));
		aboutField.setMaximumSize(new Dimension(500, 300));

		
		add(this.label);
		add(aboutField);
	}

	public JLabel getLabel() {
		return label;
	}

	public JTextArea getAboutField() {
		return aboutField;
	}

}
