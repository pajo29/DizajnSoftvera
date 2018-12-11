package gui.parameters.desktopShortcut;

import javax.swing.*;


@SuppressWarnings("serial")
public class DesktopShortcutView extends JPanel
{
	
	private JLabel label;
	private JCheckBox checkBox;
	
	public DesktopShortcutView(String label)
	{
		this.label = new JLabel(label);
		checkBox = new JCheckBox("Desktop shortcut");

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(this.label);
		add(checkBox);
	}

}
