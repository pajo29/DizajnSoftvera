package gui.parameters.logo.model;


import javax.swing.ImageIcon;

import gui.parameters.logo.view.LogoView;
import gui.parameters.model.ParametarConfig;

@SuppressWarnings("serial")
public class Logo extends ParametarConfig 
{

	private ImageIcon content;
	
	public Logo(String name)
	{
		super(name, "Izaberite logo za vasu instalaciju");
		super.gui = new LogoView(this);
	}

	public ImageIcon getContent()
	{
		return content;
	}

	public void setContent(ImageIcon content)
	{
		this.content = content;
	}

}
