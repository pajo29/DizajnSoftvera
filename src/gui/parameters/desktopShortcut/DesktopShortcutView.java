package gui.parameters.desktopShortcut;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import gui.parameters.parametar.view.ParametarView;

@SuppressWarnings("serial")
public class DesktopShortcutView extends ParametarView
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
