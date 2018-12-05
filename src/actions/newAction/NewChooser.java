package actions.newAction;

import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gui.parameters.parametar.model.ParametarModel;
import gui.parameters.parametar.model.PredefinedParametarType;
import gui.tree.treeModel.Module;
import gui.tree.treeModel.Node;
import gui.tree.treeModel.Parametar;
import main.MainSplitPane;

@SuppressWarnings("serial")
public class NewChooser extends JDialog
{
	private JComboBox<String> types;
	private String[] availableTypes = {"Path", "Desktop shortcut", "About", "Look and Feel", "Logo", "Custom"};
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
		setModalityType(ModalityType.APPLICATION_MODAL);
		setVisible(true);
	}
	
	public void chooseType(boolean module)
	{
		ParametarModel pmc = null;
		if(module)
		{
			switch((String)types.getSelectedItem())
			{
			case "Path":
				 pmc = new ParametarModel("Path", PredefinedParametarType.PATH);
				 component.addChild(new Parametar(pmc.getName(), pmc));
				 break;
			case "Desktop shortcut":
				pmc = new ParametarModel("Desktop shortcut", PredefinedParametarType.DESKTOP_SHORTCUT);
				component.addChild(new Parametar(pmc.getName(), pmc));
				break;
			case "About":
				pmc = new ParametarModel("About parametar", PredefinedParametarType.ABOUT);
				component.addChild(new Parametar(pmc.getName(), pmc));
				break;
			case "Look and Feel":
				pmc = new ParametarModel("Look and feel parametar", PredefinedParametarType.LOOK_AND_FEEL);
				component.addChild(new Parametar(pmc.getName(), pmc));
				break;
			case "Logo":
				pmc = new ParametarModel("Logo parametar", PredefinedParametarType.LOGO);
				case "Custom":
				new CustomDialog(component);
				break;
			}

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
