package actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import gui.tree.model.Component;
import main.MainFrame;
import main.MainSplitPane;

public class Exit extends AbstractGEDAction
{

	public Exit()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control E"));
		putValue(SMALL_ICON, loadIcon("images/exit.png"));
		putValue(NAME, "mExit");
		putValue(SHORT_DESCRIPTION, "Exit program");
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		closing();
	}
	
	public void closing()
	{
		if(MainFrame.getInstance().getActionManager().isChanges())
		{
		JOptionPane joptionPane = new JOptionPane();
		int result = joptionPane.showConfirmDialog(null, "Da li zelite da sacuvate promene?", "Stablo", JOptionPane.YES_NO_CANCEL_OPTION);
		if(result == JOptionPane.YES_OPTION)
		{
			MainFrame.getInstance().getActionManager().getSaveAction().save();
			System.exit(0);
		}
		if(result == JOptionPane.NO_OPTION)
			System.exit(0);
		if(result == JOptionPane.CANCEL_OPTION)
			return;
		}
		else
			System.exit(0);
		
	}

}
