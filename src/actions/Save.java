package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import main.MainFrame;
import main.MainSplitPane;
import tree.model.Component;

public class Save extends AbstractGEDAction
{ 
	
	public Save()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));
		putValue(SMALL_ICON, loadIcon("images/save.png"));
		putValue(NAME, "mSave");
		putValue(SHORT_DESCRIPTION, "Save");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		StringBuilder sb = new StringBuilder();
		tree.model.Component component = (Component) MainSplitPane.getInstance().getTree().getPathForRow(0).getLastPathComponent();
		
		if(MainFrame.getInstance().getActionManager().getDefaultFile() == null)
		{
			
			
			File file = null;
			
			sb.append(component.toString() + "\n");
			saveNewTree(component, sb, 0, component.getChildCount(), 1);
			String upis = sb.toString().substring(0, sb.toString().length()-1);
			try
			{
				JFileChooser fileChooser = new JFileChooser();
				int res = fileChooser.showOpenDialog(MainFrame.getInstance());
				
				if(res == JFileChooser.APPROVE_OPTION)
				{
					file = fileChooser.getSelectedFile();
					FileWriter fw = new FileWriter(file);
					fw.write(upis);
					fw.close();
				}
				
				sb = null;
				upis = null;
				
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
			MainFrame.getInstance().getActionManager().setDefaultFile(file);
			file = null;
		}
		else
		{
			sb = new StringBuilder();
			sb.append(component.toString() + "\n");
			saveNewTree(component, sb, 0, component.getChildCount(), 1);
			try
			{
				String upis = sb.toString().substring(0, sb.toString().length()-1);
				FileWriter fw = new FileWriter(MainFrame.getInstance().getActionManager().getDefaultFile());
				fw.write(upis);
				fw.close();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
			}
			sb = null;
		}
	}
	
	
	private void saveNewTree(tree.model.Component component, StringBuilder sb, int counter, int limit, int level)
	{
		if(counter == limit)
			return;
		
		sb.append(level + "~" + component.getChildAt(counter).toString() + "\n");
		
		if(!component.getChildAt(counter).isLeaf())
		{
			saveNewTree((tree.model.Component)component.getChildAt(counter), sb, 0, ((tree.model.Component)component.getChildAt(counter)).getChildCount(), level+1);
		}
			saveNewTree(component, sb, counter+1, limit, level);
	}

}
