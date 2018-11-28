package actions;

import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.KeyStroke;

import gui.exceptionHandler.ExceptionHandler;
import gui.exceptionHandler.ExceptionType;
import gui.tree.treeModel.Node;
import main.MainSplitPane;


@SuppressWarnings("serial")
public class SaveAs extends AbstractGEDAction
{

	public SaveAs()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control shift S"));
		putValue(SMALL_ICON, loadIcon("images/saveAs.png"));
		putValue(NAME, "mSaveAs");
		putValue(SHORT_DESCRIPTION, "Save As");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Node node = (Node)MainSplitPane.getInstance().getTree().getPathForRow(0).getLastPathComponent();
		try
		{
			FileOutputStream fos = new FileOutputStream("test.ser");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(node);
			out.close();
			fos.close();
		}
		catch(IOException ee)
		{
			ee.printStackTrace();
			ExceptionHandler.handleEvent(ExceptionType.SERIALISATION_FAIL);
		}
	}
	
	

}
