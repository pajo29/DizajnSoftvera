package actions;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import gui.tree.treeModel.Component;
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
		saveAs(false);
	}
	
	public void saveAs(boolean closing)
	{
		gui.tree.model.Component component = (Component) MainSplitPane.getInstance().getTree().getPathForRow(0).getLastPathComponent();
		
		StringBuilder sb = new StringBuilder();
		sb.append(component.toString() + "\n");
		saveNewTree(component, sb, 0, component.getChildCount(), 1);
		String upis = sb.toString().substring(0, sb.toString().length()-1);
		try
		{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(MainFrame.getInstance().getActionManager().getCurrentDir());
			int res = fileChooser.showSaveDialog(MainFrame.getInstance());
			
			if(res == JFileChooser.APPROVE_OPTION)
			{
				writeToFile(fileChooser.getSelectedFile(), upis);
				MainFrame.getInstance().getActionManager().setDefaultFile(fileChooser.getSelectedFile());
				MainFrame.getInstance().getActionManager().setCurrentDir(fileChooser.getSelectedFile());
				MainFrame.getInstance().getActionManager().setChanges(false);
				if(closing)
					System.exit(0);
			}
			if(res == JFileChooser.CANCEL_OPTION)
			{
				MainFrame.getInstance().getActionManager().setDefaultFile(null);
				MainFrame.getInstance().getActionManager().setChanges(true);
				return;
			}
			sb = null;
			upis = null;
			
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	public void writeToFile(File file, String upis) throws Exception
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		String[] podeljenUpis = upis.split("\n");
		bw.write(podeljenUpis[0]);
		for(int i = 1; i < podeljenUpis.length; i++)
		{
			bw.newLine();
			bw.write(podeljenUpis[i]);
		}
		bw.close();
	}
	
	public void saveNewTree(gui.tree.model.Component component, StringBuilder sb, int counter, int limit, int level)
	{
		if(counter == limit)
			return;
		
		sb.append(level + "~" + component.getChildAt(counter).toString() + ";" + ((gui.tree.model.Component)component.getChildAt(counter)).getContent() + "\n");
		
		if(!component.getChildAt(counter).isLeaf())
			saveNewTree((gui.tree.model.Component)component.getChildAt(counter), sb, 0, ((gui.tree.model.Component)component.getChildAt(counter)).getChildCount(), level+1);
		
		saveNewTree(component, sb, counter+1, limit, level);
	}

}
