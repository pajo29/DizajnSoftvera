package actions.newAction;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import actions.AbstractGEDAction;
import gui.messageHandler.MessageHandler;
import gui.messageHandler.MessageType;
import gui.tree.treeModel.Module;
import gui.tree.treeModel.Parametar;
import gui.tree.treeModel.Product;
import gui.tree.treeModel.SoftwareCompany;
import main.MainFrame;
import main.MainSplitPane;


@SuppressWarnings("serial")
public class New extends AbstractGEDAction
{
	
	public New()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control T"));
		putValue(SMALL_ICON, loadIcon("../images/newFile.png"));
		putValue(NAME, "mNew file");
		putValue(SHORT_DESCRIPTION, "New file");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Object cmp = MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
		
		if(cmp == null)
		{
			MessageHandler.handleEvent(MessageType.NO_COMPONENT_SELECTED);
			return;
		}
		
		if(cmp instanceof SoftwareCompany)
		{
			SoftwareCompany component = (SoftwareCompany)cmp;
			Product newComponent = new Product("Proizvod: "+(component.getChildCount()+1));
			component.addChild(newComponent);
		}
		if(cmp instanceof Product)
		{
			Product component = (Product)cmp;
			new NewChooser(component, false);
		}
		if(cmp instanceof Module)
		{
			Module component = (Module)cmp;
			new NewChooser(component, true);
		}
		if(cmp instanceof Parametar)
		{
			MessageHandler.handleEvent(MessageType.PARAMETAR_SELECTED);
			return;
		}
		SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
		
		
		MainFrame.getInstance().getActionManager().setChanges(true);
	}
}
