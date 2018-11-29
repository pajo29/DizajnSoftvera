package gui.parameters.desktopShortcut.view;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import gui.parameters.desktopShortcut.model.DestkopShortcut;

@SuppressWarnings("serial")
public class DesktopShortcutView extends JPanel{
	
	private JLabel label;
	private JCheckBox checkBox;
	
	private DestkopShortcut dsModel;
	public DesktopShortcutView(DestkopShortcut dsModel)
	{
		this.dsModel = dsModel;
		label = new JLabel(this.dsModel.getLabel());
		checkBox = new JCheckBox("Desktop shortcut");
		checkBox.addActionListener(e ->
		{
			if(checkBox.isSelected())
				dsModel.setContent(true);
			else
				dsModel.setContent(false);
		});
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(label);
		add(checkBox);
	}

}
