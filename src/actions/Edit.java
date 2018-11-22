package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import gui.rightSplitPane.view.ComponentView;
import gui.rightSplitPane.view.tabs.model.TabPane;
import gui.tree.model.Component;
import main.MainFrame;
import main.MainSplitPane;

@SuppressWarnings("serial")
public class Edit extends AbstractGEDAction
{
	public Edit()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_3, ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, loadIcon("images/edit.png"));
		putValue(NAME, "mEdit");
		putValue(SHORT_DESCRIPTION, "Edit");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		edit();
	}
	
	public void edit()
	{
		Component cmp = (Component)MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
		if(cmp == null)
		{
			MainFrame.getInstance().getActionManager().noComponentSelected();
			return;
		}
		TabPane.getInstance().getController().addTab(cmp);
		ComponentView.getInstance().setData(cmp, TabPane.getInstance().getTabs().get(TabPane.getInstance().getSelectedIndex()));
		TabPane.getInstance().getController().selectTab(cmp);
	}

}