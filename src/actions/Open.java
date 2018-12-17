package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import messageHandler.MessageHandler;
import messageHandler.MessageType;
import tree.treeModel.Node;
import tree.treeModel.SoftwareCompany;
import tree.treeModel.TreeModel;
import main.MainFrame;
import gui.MainSplitPane;

@SuppressWarnings("serial")
public class Open extends AbstractGEDAction
{
	
	
	public Open()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, loadIcon("images/open.png"));
		putValue(NAME, "Open");
		putValue(SHORT_DESCRIPTION, "Open workspace");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Node node = openFile();
		if(node != null)
			MainSplitPane.getInstance().getTree().setModel(new TreeModel((SoftwareCompany)node));
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
			
            MainFrame.getInstance().getActionManager().setCurrentDir(fileChooser.getSelectedFile());
            MainFrame.getInstance().getActionManager().setChanges(false);
            MainSplitPane.getInstance().getSplitPane().reset();
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
			MessageHandler.handleEvent(MessageType.DESERIALISATION_FAIL);
		}
		return null;
	}
}
	
	