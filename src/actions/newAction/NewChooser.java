package actions.newAction;

import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gui.parameters.desktopShortcut.model.DestkopShortcut;
import gui.parameters.model.ParametarConfig;
import gui.parameters.path.model.Path;
import gui.tree.treeModel.Node;
import gui.tree.treeModel.Parametar;
import main.MainSplitPane;

@SuppressWarnings("serial")
public class NewChooser extends JFrame
{
	private JComboBox<String> types;
	private String[] availableTypes = {"Path", "Desktop shortcut"};
	private JButton chooseButton;
	
	private Node component;
	public NewChooser(Node component)
	{
		this.component = component;
		types = new JComboBox<String>(availableTypes);
		chooseButton = new JButton("Choose");
		chooseButton.addActionListener(e-> {
			chooseType();
		});
		
		JPanel panel = new JPanel();
		
		
		panel.add(types);
		panel.add(chooseButton);
		
		add(panel);
		
		setSize(400, 150);
		setLocationRelativeTo(null);
		setTitle("Odabir parametra");
		setVisible(true);
	}
	
	public void chooseType()
	{
		ParametarConfig pmc = null;
		switch((String)types.getSelectedItem())
		{
		case "Path":
			 pmc = new Path("Path parametar");
			 break;
		case "Desktop shortcut":
			pmc = new DestkopShortcut("Desktop shortcut parametar");
			break;
		}
		
		
		component.addChild(new Parametar(pmc.getName(), pmc));
		SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
}
