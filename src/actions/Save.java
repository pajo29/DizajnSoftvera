package actions;

import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;

import gui.tree.treeModel.Component;
import main.MainFrame;
import main.MainSplitPane;

@SuppressWarnings("serial")
public class Save extends AbstractGEDAction
{ 
	
	public Save()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));
		putValue(SMALL_ICON, loadIcon("images/save.png"));
		putValue(NAME, "mSave");
		putValue(SHORT_DESCRIPTION, "Save");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		save(false);
	}
	
	public void save(boolean closing)
	{
		StringBuilder sb = new StringBuilder();
		gui.tree.model.Component component = (Component) MainSplitPane.getInstance().getTree().getPathForRow(0).getLastPathComponent();
		
		if(MainFrame.getInstance().getActionManager().getDefaultFile() == null)
		{
			MainFrame.getInstance().getActionManager().getSaveAsAction().saveAs(closing);
		}
		else
		{
			sb = new StringBuilder();
			sb.append(component.toString() + "\n");
			MainFrame.getInstance().getActionManager().getSaveAsAction().saveNewTree(component, sb, 0, component.getChildCount(), 1);
			try
			{
				String upis = sb.toString().substring(0, sb.toString().length()-1);
				MainFrame.getInstance().getActionManager().getSaveAsAction().writeToFile(MainFrame.getInstance().getActionManager().getDefaultFile(), upis);
				MainFrame.getInstance().getActionManager().setChanges(false);
				upis = null;
				sb = null;
				if(closing)
					System.exit(0);
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
			}
		}
		
	}
	
}
