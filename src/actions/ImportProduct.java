package actions;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import messageHandler.MessageHandler;
import messageHandler.MessageType;
import tree.treeModel.Node;
import tree.treeModel.Product;
import tree.treeModel.SoftwareCompany;
import main.MainFrame;
import gui.MainSplitPane;

@SuppressWarnings("serial")
public class ImportProduct extends AbstractGEDAction
{
	public ImportProduct() 
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control shift I"));
		putValue(SMALL_ICON, loadIcon("images/import.png"));
		putValue(NAME, "Import product");
		putValue(SHORT_DESCRIPTION, "Import company product");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
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
			if(node instanceof Product)
			{
				SoftwareCompany root = (SoftwareCompany)MainSplitPane.getInstance().getTree().getPathForRow(0).getLastPathComponent();
				root.addChild((Product)node);
				SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
				return;
			}
			}
			if(res == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
		}
		catch(Exception ee)
		{
			MessageHandler.handleEvent(MessageType.DESERIALISATION_FAIL);
		}
	}
	}


