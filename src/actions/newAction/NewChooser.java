package actions.newAction;

import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import parameters.parametar.model.ParametarModel;
import parameters.parametar.model.PredefinedParametarType;
import tree.treeModel.Module;
import tree.treeModel.Node;
import tree.treeModel.Parametar;
import gui.MainSplitPane;

@SuppressWarnings("serial")
public class NewChooser extends JDialog
{
	private JComboBox<String> types;
	private String[] availableTypes = {"Autor", "Naziv", "Pokretanje nakon instalacije", "Desktop shortcut", "Uslovi koriscenja", "Look and Feel", "Logo", "Path", "Custom"};
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
				case "Naziv":
				 	pmc = new ParametarModel("Naziv", PredefinedParametarType.NAME);
				 	component.addChild(new Parametar(pmc.getName(), pmc));
				 	break;
				case "Desktop shortcut":
					pmc = new ParametarModel("Desktop shortcut", PredefinedParametarType.DESKTOP_SHORTCUT);
					component.addChild(new Parametar(pmc.getName(), pmc));
				break;
					case "Uslovi koriscenja":
					pmc = new ParametarModel("Uslovi koriscenja", PredefinedParametarType.TERMS_OF_USE);
					component.addChild(new Parametar(pmc.getName(), pmc));
					break;
				case "Look and Feel":
					pmc = new ParametarModel("Look and feel", PredefinedParametarType.LOOK_AND_FEEL);
					component.addChild(new Parametar(pmc.getName(), pmc));
					break;
				case "Pokretanje nakon instalacije":
					pmc = new ParametarModel("Pokretanje nakon instalacije", PredefinedParametarType.START_AFTER_INSTALL);
					component.addChild(new Parametar(pmc.getName(), pmc));
					break;
				case "Logo":
					pmc = new ParametarModel("Logo", PredefinedParametarType.LOGO);
					component.addChild(new Parametar(pmc.getName(), pmc));
					break;
				case "Autor":
					pmc = new ParametarModel("Autor", PredefinedParametarType.AUTHOR);
					component.addChild(new Parametar(pmc.getName(), pmc));
					break;
				case "Path":
					pmc = new ParametarModel("Path", PredefinedParametarType.PATH);
					component.addChild(new Parametar(pmc.getName(), pmc));
					break;
				case "Custom":
					new CustomDialog(component);
					dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
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
