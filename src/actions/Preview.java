package actions;

import gui.MainSplitPane;
import installationSimulation.Simulation;
import main.MainFrame;
import messageHandler.MessageHandler;
import messageHandler.MessageType;
import tree.treeModel.Node;
import tree.treeModel.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Preview extends AbstractGEDAction
{

    public Preview()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control shift P"));
        putValue(SMALL_ICON, loadIcon("images/preview.png"));
        putValue(NAME, "Preview");
        putValue(SHORT_DESCRIPTION, "Preview product installation");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
    	JFileChooser chooser = new JFileChooser();
    	
    	int res = chooser.showOpenDialog(MainFrame.getInstance());
    	Product product = null;
    	try
    	{
    	if(res == JFileChooser.APPROVE_OPTION)
    	{
    		FileInputStream fis = new FileInputStream(chooser.getSelectedFile());
			ObjectInputStream in = new ObjectInputStream(fis);
			Node node = (Node)in.readObject();
			in.close();
			fis.close();
			if(node instanceof Product)
			{
				product = (Product)node;
				Simulation sim = new Simulation((Product) MainSplitPane.getInstance().getTree().getLastSelectedPathComponent(), product.getChildren().size());
			}
    	}
    	}
    	catch(Exception ee)
		{
			MessageHandler.handleEvent(MessageType.DESERIALISATION_FAIL);
		}
       
        
    }
}
