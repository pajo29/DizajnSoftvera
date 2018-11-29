package actions.parametersActions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import actions.AbstractGEDAction;
import main.MainFrame;

@SuppressWarnings("serial")
public class Browse extends AbstractGEDAction{
	
	public Browse()
	{
		putValue(SMALL_ICON, loadIcon("../images/open.png"));
		putValue(NAME, "Browse");
		putValue(SHORT_DESCRIPTION, "Browse where to install");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(MainFrame.getInstance(), "ovo ne radi nista prijatelju", "Ovo je titl", JOptionPane.ERROR_MESSAGE);
	}

}
