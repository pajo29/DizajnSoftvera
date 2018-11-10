package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import gui.rightSplitPane.view.DownSide;
import gui.rightSplitPane.view.tabs.TabPane;
import gui.tree.model.Component;
import main.MainSplitPane;

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
		TabPane.getInstance().addTab(cmp);
		DownSide.getInstance().getTxArea().setText(cmp.getContent());
		TabPane.getInstance().selectTab(cmp);
	}

}
