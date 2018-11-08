package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeModel;

import gui.rightSplitPane.SplitPane;
import gui.toolbar.MainToolBar;
import gui.tree.Tree;
import gui.tree.model.Component;

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
		splitPane = new SplitPane();
		
		int result = JOptionPane.showConfirmDialog(null, "Da li �elite da ucitate neko stablo?", "Stablo", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION)
		{
			setTree(MainFrame.getInstance().getActionManager().getOpenAction().openFile(true));
			SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
		}
		if(result == JOptionPane.NO_OPTION)
			setTree(new Component("Glavna komponenta"));
		
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
