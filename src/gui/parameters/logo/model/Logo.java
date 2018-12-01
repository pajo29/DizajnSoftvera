package gui.parameters.logo.model;

import java.awt.Image;

import gui.parameters.logo.view.LogoView;
import gui.parameters.model.ParametarConfig;

@SuppressWarnings("serial")
public class Logo extends ParametarConfig 
{

	private Image content;
	
	public Logo(String name)
	{
		super(name, "Izaberite logo za vasu instalaciju");
		super.gui = new LogoView(this);
	}

	public Image getContent() {
		return content;
	}

	public void setContent(Image content) {
		this.content = content;
	}
}
