package gui.parameters.desktopShortcut.model;

import gui.parameters.desktopShortcut.view.DesktopShortcutView;
import gui.parameters.model.ParametarConfig;

@SuppressWarnings("serial")
public class DestkopShortcut extends ParametarConfig
{
	private boolean content;
	
	public DestkopShortcut(String name)
	{
		super(name, "Da li zelite precicu na Vasem Desktopu?");
		super.gui = new DesktopShortcutView(this);
	}


	public boolean isContent() {
		return content;
	}

	public void setContent(boolean content) {
		this.content = content;
	}
	
	
}
