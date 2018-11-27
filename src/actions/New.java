package actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import gui.rightSplitPane.view.tabs.model.TabPane;
import gui.tree.treeModel.Component;
import main.MainFrame;
import main.MainSplitPane;


@SuppressWarnings("serial")
public class New extends AbstractGEDAction
{
	
	public New()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control T"));
		putValue(SMALL_ICON, loadIcon("images/newFile.png"));
		putValue(NAME, "mNew file");
		putValue(SHORT_DESCRIPTION, "New file");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Object cmp = MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
		
		if(cmp == null)
		{
			MainFrame.getInstance().getActionManager().noComponentSelected();
			return;
		}
		
		if(cmp instanceof Component)
		{
			Component component = (Component)cmp;
			Component newComponent = new Component("Komponenta "+(component.getChildCount()+1));
			component.addChild(newComponent);
			TabPane.getInstance().update();
			SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
		}
		MainFrame.getInstance().getActionManager().setChanges(true);
	}
}
