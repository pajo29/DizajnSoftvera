package actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import gui.messageHandler.MessageHandler;
import gui.messageHandler.MessageType;
import gui.tree.treeModel.Node;
import main.MainFrame;
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
		saveAs();
	}
	
	public void saveAs()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(MainFrame.getInstance().getActionManager().getCurrentDir());
		int res = fileChooser.showSaveDialog(MainFrame.getInstance());
		
		if(res == JFileChooser.APPROVE_OPTION)
		{
			try {
				save(fileChooser.getSelectedFile());
			} catch (IOException e1) {
				e1.printStackTrace();
				MessageHandler.handleEvent(MessageType.SERIALISATION_FAIL);
			}
		}
	}
	
	public void save(File fileToSave) throws IOException
	{
		if(fileToSave == null)
		{
			saveAs();
			return;
		}
		Node node = (Node)MainSplitPane.getInstance().getTree().getPathForRow(0).getLastPathComponent();
		FileOutputStream fos = new FileOutputStream(fileToSave);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(node);
		out.close();
		fos.close();
		
		MainFrame.getInstance().getActionManager().setDefaultFile(fileToSave);
        MainFrame.getInstance().getActionManager().setCurrentDir(fileToSave);
        MainFrame.getInstance().getActionManager().setChanges(false);
	}

}
