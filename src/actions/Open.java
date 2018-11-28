package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import gui.exceptionHandler.ExceptionHandler;
import gui.exceptionHandler.ExceptionType;
import gui.tree.treeModel.Node;
import main.MainFrame;

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
		openFile();
	}
	
	public Node openFile()
	{
		Node node = null;
		try
		{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(MainFrame.getInstance().getActionManager().getCurrentDir());
			int res = fileChooser.showOpenDialog(MainFrame.getInstance());
			
			if(res == JFileChooser.APPROVE_OPTION)
			{
			FileInputStream fis = new FileInputStream(fileChooser.getSelectedFile());
			ObjectInputStream in = new ObjectInputStream(fis);
			node = (Node)in.readObject();
			in.close();
			fis.close();
			
			MainFrame.getInstance().getActionManager().setDefaultFile(fileChooser.getSelectedFile());
            MainFrame.getInstance().getActionManager().setCurrentDir(fileChooser.getSelectedFile());
            
            return node;
			}
			if(res == JFileChooser.CANCEL_OPTION)
			{
				return null;
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			ExceptionHandler.handleEvent(ExceptionType.SERIALISATION_FAIL);
		}
		return null;
	}
}
	
	