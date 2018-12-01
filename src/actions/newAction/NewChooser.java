package actions.newAction;

import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gui.parameters.about.model.About;
import gui.parameters.desktopShortcut.model.DestkopShortcut;
import gui.parameters.lookAndFeel.model.LookAndFeel;
import gui.parameters.model.ParametarConfig;
import gui.parameters.path.model.Path;
import gui.tree.treeModel.Module;
import gui.tree.treeModel.Node;
import gui.tree.treeModel.Parametar;
import main.MainSplitPane;

@SuppressWarnings("serial")
public class NewChooser extends JFrame
{
	private JComboBox<String> types;
	private String[] availableTypes = {"Path", "Desktop shortcut", "About", "Look and Feel"};
	private JComboBox<String> moduleParametarComboBox;
	private String[] moduleParametar = {"Module", "Parametar"};
	private JButton chooseButton;
	
	private Node component;
	public NewChooser(Node component, boolean module)
	{
		this.component = component;
		JPanel panel = new JPanel();
		if(module)
		{
			types = new JComboBox<String>(availableTypes);
			chooseButton = new JButton("Choose");
			chooseButton.addActionListener(e-> {
				chooseType(true);
			});
			panel.add(types);
		}
		else
		{
			moduleParametarComboBox = new JComboBox<String>(moduleParametar);
			chooseButton = new JButton("Choose");
			chooseButton.addActionListener(e-> {
				chooseType(false);
			});
			panel.add(moduleParametarComboBox);
		}
		
		panel.add(chooseButton);
		
		add(panel);
		
		setSize(400, 150);
		setLocationRelativeTo(null);
		setTitle("Odabir parametra");
		setVisible(true);
	}
	
	public void chooseType(boolean module)
	{
		ParametarConfig pmc = null;
		if(module)
		{
			switch((String)types.getSelectedItem())
			{
			case "Path":
				 pmc = new Path("Path parametar");
				 break;
			case "Desktop shortcut":
				pmc = new DestkopShortcut("Desktop shortcut parametar");
				break;
			case "About":
				pmc = new About("About parametar");
				break;
			case "Look and Feel":
				pmc = new LookAndFeel("Look and feel parametar");
				break;
			}
			component.addChild(new Parametar(pmc.getName(), pmc));
		}
		else
		{
			
			switch((String)moduleParametarComboBox.getSelectedItem())
			{
			case "Module":
				 Module mod = new Module("Modul: " + (component.getChildCount() + 1));
				 component.addChild(mod);
				 break;
			case "Parametar":
				new NewChooser(component, true);
				break;
			}
		}
			
		
		SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		
		
	}
	
}
