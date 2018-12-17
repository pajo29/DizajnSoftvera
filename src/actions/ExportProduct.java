package actions;

import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import messageHandler.MessageHandler;
import messageHandler.MessageType;
import tree.treeModel.Node;
import tree.treeModel.Product;
import main.MainFrame;
import gui.MainSplitPane;

@SuppressWarnings("serial")
public class ExportProduct extends AbstractGEDAction {

	
	public ExportProduct() 
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control shift P"));
		putValue(SMALL_ICON, loadIcon("images/export.png"));
		putValue(NAME, "Export product");
		putValue(SHORT_DESCRIPTION, "Export company product");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		Node node = (Node)MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
		if(node == null)
		{
			MessageHandler.handleEvent(MessageType.NO_COMPONENT_SELECTED);
			return;
		}
		if(!(node instanceof Product))
		{
			MessageHandler.handleEvent(MessageType.WRONG_COMPONENT_SELECTED_PRODUCT);
			return;
		}
		else
		{
			Product product = (Product)node;
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(MainFrame.getInstance().getActionManager().getCurrentDir());
			int res = fileChooser.showSaveDialog(MainFrame.getInstance());
			
			if(res == JFileChooser.APPROVE_OPTION)
			{
				try {
					FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile());
					ObjectOutputStream out = new ObjectOutputStream(fos);
					out.writeObject(product);
					out.close();
					fos.close();
				} catch (IOException e1) {
					MessageHandler.handleEvent(MessageType.SERIALISATION_FAIL);
				}
			}
		}
	}

}
