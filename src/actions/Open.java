package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import main.MainFrame;
import main.MainSplitPane;
import tree.model.Component;

public class Open extends AbstractGEDAction
{
	
	private boolean componentSet = false;
	
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
		Object cmp = MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
		tree.model.Component component = null;
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try
		{
		JFileChooser fileChooser = new JFileChooser();
		
		int res = fileChooser.showOpenDialog(MainFrame.getInstance());
		
		if(res == JFileChooser.APPROVE_OPTION)
		{
			fileReader = new FileReader(fileChooser.getSelectedFile());
			bufferedReader = new BufferedReader(fileReader);
			component = new Component(bufferedReader.readLine());
			
			
			loadFile(component, bufferedReader, 1, bufferedReader.readLine());
			
			
			((tree.model.Component)cmp).addChild(component);
			
			SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
		}
		
		
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	
	private tree.model.Component loadFile(tree.model.Component cmp, BufferedReader br, int counter, String line) throws IOException
	{
		
			if(line == null)
			{
				return cmp;
			}
			
			if(Integer.parseInt(line.substring(0, 1)) > counter)
			{
				if(!componentSet)
				{
				loadFile(((tree.model.Component)cmp.getChildAt(cmp.getChildCount()-1)), br, counter+1, line);
				}
			}
			
			if(Integer.parseInt(line.substring(0, 1)) == counter)
			{
				if(!componentSet)
				{
					cmp.addChild(new tree.model.Component(line.substring(2)));
					line = br.readLine();
					loadFile(cmp, br, counter, line);
				}
			}
			
		    if(line == null)
			{
		    	if(!componentSet)
		    		componentSet = true;
				
				return null;
			}
		    
		    if(Integer.parseInt(line.substring(0, 1)) < counter)
		    {
		    	if(!componentSet)
		    		loadFile((Component)cmp.getParent(), br, counter-1, line);
		    }
			
			
		 return null;
	}

}
