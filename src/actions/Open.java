package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import gui.tree.treeModel.Component;
import main.MainFrame;
import main.MainSplitPane;

@SuppressWarnings("serial")
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
		openFile(false);
	}
	
	public Component openFile(boolean programStart)
	{
		if(programStart)
		{
			ActionManager.getInstace().setChanges(false);
			
			FileReader fileReader = null;
			BufferedReader bufferedReader = null;
			try
			{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(MainFrame.getInstance().getActionManager().getCurrentDir());
			int res = fileChooser.showOpenDialog(MainFrame.getInstance());
			
			if(res == JFileChooser.APPROVE_OPTION)
			{
				fileReader = new FileReader(fileChooser.getSelectedFile());
				bufferedReader = new BufferedReader(fileReader);
				component = new Component(bufferedReader.readLine());
				
				loadFile(component, bufferedReader, 1, bufferedReader.readLine());
				
				componentSet = false;
				fileReader = null;
				bufferedReader = null;
				MainFrame.getInstance().getActionManager().setDefaultFile(fileChooser.getSelectedFile());
				MainFrame.getInstance().getActionManager().setCurrentDir(fileChooser.getSelectedFile());
				return component;
			}
			if(res == JFileChooser.CANCEL_OPTION)
			{
				programStart = false;
				return null;
			}
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		
		
		Object cmp = MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
		if(cmp == null)
		{
			MainFrame.getInstance().getActionManager().noComponentSelected();
			return null;
		}
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try
		{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(MainFrame.getInstance().getActionManager().getCurrentDir());
		
		int res = fileChooser.showOpenDialog(MainFrame.getInstance());
		
		if(res == JFileChooser.APPROVE_OPTION)
		{
			fileReader = new FileReader(fileChooser.getSelectedFile());
			bufferedReader = new BufferedReader(fileReader);
			component = new Component(bufferedReader.readLine());
			
			loadFile(component, bufferedReader, 1, bufferedReader.readLine());
			((gui.tree.model.Component)cmp).addChild(component);
			
			SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
			componentSet = false;
			fileReader = null;
			bufferedReader = null;
		}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		return null;
	}
	
	private void loadFile(gui.tree.model.Component cmp, BufferedReader br, int counter, String line) throws IOException
	{
		
		
			if(line != null && !notComponent(line))
			{
				System.out.println("Usao sam za: " + line);
				((Component)cmp.getChildren().get(cmp.getChildCount()-1)).setContent(((Component)cmp.getChildren().get(cmp.getChildCount()-1)).getContent()+"\n"+line);
				line = br.readLine();
				//Proveriti da li je sledeca linije null
				loadFile(cmp, br, counter, line);
			}
		
			if(line == null)
			{
				componentSet = true;
				return;
			}
			
			
			
			if(!componentSet)
			{
			if(getChildLevel(line) > counter)
			{
				if(!componentSet)
				loadFile(((gui.tree.model.Component)cmp.getChildAt(cmp.getChildCount()-1)), br, counter+1, line);
			}
			}
			
			if(!componentSet)
			{
			if(getChildLevel(line) == counter)
			{
					gui.tree.model.Component component = new Component(getComponentName(line));
					component.setContent(getComponentContent(line));
					cmp.addChild(component);
					line = br.readLine();
					loadFile(cmp, br, counter, line);
			}
			}
			
		    if(line == null)
			{
		    	if(!componentSet)
		    		componentSet = true;
				return;
			}
		    
		    if(!componentSet)
		    {
		    if(getChildLevel(line) < counter)
		    {
		    		loadFile((Component)cmp.getParent(), br, counter-1, line);
		    }
		    }
			
	}
	private boolean test = false;
	private boolean notComponent(String line)
	{
		if(test == false)
		{
		System.out.println(line);
		test = true;
		}
		char[] charLine = line.toCharArray();
		if(Character.isDigit(charLine[0]))
			return true;
		else
			return false;
	}
	
	private String getComponentContent(String line)
	{
		char[] charLine = line.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean componentStart = false;
		
		for(char ch: charLine)
		{
			if(componentStart)
			{
				sb.append(ch);
			}
			if(ch == ';')
				componentStart = true;
		}
		
		return sb.toString();
	}
	
	private String getComponentName(String line)
	{
		char[] charLine = line.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean componentStart = false;
		
		for(char ch: charLine)
		{
			if(ch == ';')
				componentStart = false;
			
			if(componentStart)
			{
				sb.append(ch);
			}
			
			if(ch == '~')
				componentStart = true;
		}
		
		return sb.toString();
	}
	
	private int getChildLevel(String line)
	{
		char[] charLine = line.toCharArray();
		
		int result = 0;
		
		for(char ch: charLine)
		{
			if(ch == '~')
				return result;
			else
				result = result * 10 + Character.getNumericValue(ch);
		}
		
		return 0;
	}

}
