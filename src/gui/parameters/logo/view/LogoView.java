package gui.parameters.logo.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.parameters.logo.model.Logo;

public class LogoView extends JPanel
{
	private JLabel label;
	private JLabel imageView; //TODO
	
	private Logo model;
	
	public LogoView(Logo model)
	{
		this.model = model;
		
	}

}
