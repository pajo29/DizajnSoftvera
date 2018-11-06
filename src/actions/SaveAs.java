package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import gui.tree.Tree;
import main.MainFrame;
import main.MainSplitPane;
import tree.Node.Node;
import tree.model.Component;

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
		tree.model.Component component = (Component) MainSplitPane.getInstance().getTree().getPathForRow(0).getLastPathComponent();
		
		StringBuilder sb = new StringBuilder();
		sb.append(component.toString() + "\n");
		saveNewTree(component, sb, 0, component.getChildCount(), 1);
		String upis = sb.toString().substring(0, sb.toString().length()-1);
		try
		{
			JFileChooser fileChooser = new JFileChooser();
			int res = fileChooser.showOpenDialog(MainFrame.getInstance());
			
			if(res == JFileChooser.APPROVE_OPTION)
			{
				System.out.println(sb.toString());
				FileWriter fw = new FileWriter(fileChooser.getSelectedFile());
				fw.write(upis);
				fw.close();
				MainFrame.getInstance().getActionManager().setDefaultFile(fileChooser.getSelectedFile());
			}
			
			sb = null;
			upis = null;
			
		} catch (IOException e1)
		{
			e1.printStackTrace();
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
