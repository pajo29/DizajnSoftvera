package main;


import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import gui.rightSplitPane.view.SplitPane;
import gui.tree.Tree;
import gui.tree.model.Component;

@SuppressWarnings("serial")
public class MainSplitPane extends JSplitPane
{
	
	/*
	 * Author Pavle Prica
	 */
	private static MainSplitPane instance = null;
	
	private SplitPane splitPane;
	
	private Tree tree;
	private gui.tree.model.TreeModel treeModel;
	
	private MainSplitPane()
	{
	}
	
	public void initialise()
	{
		int result = JOptionPane.showConfirmDialog(null, "Da li želite da ucitate neko stablo?", "Stablo", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION)
		{
			Component openFile = MainFrame.getInstance().getActionManager().getOpenAction().openFile(true);
			if(openFile == null)
				setTree(new Component("Glavna komponenta"));
			else
				setTree(openFile);
			SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
		}
		if(result == JOptionPane.NO_OPTION)
			setTree(new Component("Glavna komponenta"));
		
		splitPane = new SplitPane();
		
		setRightComponent(splitPane);
		setDividerLocation(230);
		setLeftComponent(tree);
	}
	
	public void setTree(Component component)
	{
		tree = new Tree();
		treeModel = new gui.tree.model.TreeModel(component);
		tree.setModel(treeModel);
	}
	
	public static MainSplitPane getInstance()
	{
		if(instance == null)
		{
			instance = new MainSplitPane();
			instance.initialise();
		}
			
		return instance;
	}

	public SplitPane getSplitPane()
	{
		return splitPane;
	}

	public Tree getTree()
	{
		return tree;
	}

	public gui.tree.model.TreeModel getTreeModel()
	{
		return treeModel;
	}
	
	
}
