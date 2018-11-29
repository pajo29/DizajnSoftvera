package gui.parameters.about.view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import gui.parameters.about.model.About;

@SuppressWarnings("serial")
public class AboutView extends JPanel
{
	private JLabel label;
	private JTextArea aboutField;
	
	private About about;
	
	public AboutView(About about)
	{
		this.about = about;
		
		label = new JLabel(this.about.getLabel());
		aboutField = new JTextArea();
		aboutField.setMinimumSize(new Dimension(500, 300));
		aboutField.setPreferredSize(new Dimension(500, 300));
		aboutField.setMaximumSize(new Dimension(500, 300));
		
		
		add(label);
		add(aboutField);
	}

	public JLabel getLabel() {
		return label;
	}

	public JTextArea getAboutField() {
		return aboutField;
	}

	public About getAbout() {
		return about;
	}
}
