package gui.parameters.lookAndFeel.model;

import gui.parameters.lookAndFeel.view.LookAndFeelView;
import gui.parameters.model.ParametarConfig;

@SuppressWarnings("serial")
public class LookAndFeel extends ParametarConfig 
{
	
	private LookAndFeelType type;
	
	public LookAndFeel(String name)
	{
		super(name, "Izaberite temu za instalaciju");
		super.gui = new LookAndFeelView(this);
	}

	public LookAndFeelType getType() {
		return type;
	}

	public void setType(LookAndFeelType type) {
		this.type = type;
	}

}
