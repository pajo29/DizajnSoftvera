package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.KeyStroke;

import gui.exceptionHandler.ExceptionHandler;
import gui.exceptionHandler.ExceptionType;
import gui.tree.treeModel.Node;
import main.MainSplitPane;

@SuppressWarnings("serial")
public class Open extends AbstractGEDAction
{
	
	
	public Open()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, loadIcon("images/open.png"));
		putValue(NAME, "mOpen");
		putValue(SHORT_DESCRIPTION, "Open File");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Node node = null;
		try
		{
			FileInputStream fis = new FileInputStream("test.ser");
			ObjectInputStream in = new ObjectInputStream(fis);
			node = (Node)in.readObject();
			in.close();
			fis.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			ExceptionHandler.handleEvent(ExceptionType.SERIALISATION_FAIL);
		}
	}
}
	
	