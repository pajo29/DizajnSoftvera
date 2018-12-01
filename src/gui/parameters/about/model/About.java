package gui.parameters.about.model;

import gui.parameters.about.view.AboutView;
import gui.parameters.model.ParametarConfig;

@SuppressWarnings("serial")
public class About extends ParametarConfig
{
	
	public String content;
	
	public About(String name)
	{
		super(name, "Upisite opis:");
		super.gui = new AboutView(this);
	}

}
