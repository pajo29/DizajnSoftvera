package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.tree.TreeModel;

import gui.rightSplitPane.SplitPane;
import gui.toolbar.MainToolBar;
import gui.tree.Tree;

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
		splitPane = new SplitPane();
		
		tree = new Tree();
		treeModel = new gui.tree.model.TreeModel();
		tree.setModel(treeModel);
		
		
		setRightComponent(splitPane);
		setDividerLocation(230);
		setLeftComponent(tree);
	}
	
	public static MainSplitPane getInstance()
	{
		if(instance == null)
			instance = new MainSplitPane();
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
