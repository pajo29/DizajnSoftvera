package actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.plaf.synth.SynthSpinnerUI;

import messageHandler.MessageHandler;
import messageHandler.MessageType;
import tree.treeModel.Node;
import tree.treeModel.Product;
import main.MainFrame;
import gui.MainSplitPane;
import installationSimulation.Install;

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
					File file = fileChooser.getSelectedFile();
					boolean b = file.mkdir() ? true : false;
					System.out.println(b);
					
					
					FileOutputStream fos = new FileOutputStream(new File(file.getAbsolutePath()+"\\PROIZVOD "+product.getName()));
					ObjectOutputStream out = new ObjectOutputStream(fos);
					out.writeObject(product);
					out.close();
					fos.close();
					
					if(!product.getLogoURL().equals(""))
					{
						try
						{
							System.out.println(product.getLogoURL());
							 Path source = Paths.get(product.getLogoURL());
						     Path destination = Paths.get(file.getAbsolutePath()+File.separatorChar+product.getLogoName());

						            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
						}
						catch(Exception e)
						{
							
						}
					}
					
				} catch (Exception e1) {
					MessageHandler.handleEvent(MessageType.SERIALISATION_FAIL);
				}
			}
		}
	}

}
