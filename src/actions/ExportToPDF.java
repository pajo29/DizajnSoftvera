package actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class ExportToPDF extends AbstractGEDAction
{
	
	public ExportToPDF()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control P"));
		putValue(SMALL_ICON, loadIcon("images/pdf.png"));
		putValue(NAME, "mExpToPDF");
		putValue(SHORT_DESCRIPTION, "Export to PDF");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}

}
