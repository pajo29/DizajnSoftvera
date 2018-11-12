package actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class ExportToMsExcell extends AbstractGEDAction
{
	
	public ExportToMsExcell()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control L"));
		putValue(SMALL_ICON, loadIcon("images/excel.png"));
		putValue(NAME, "mExptoMsExcell");
		putValue(SHORT_DESCRIPTION, "Export to Excell");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}

}
