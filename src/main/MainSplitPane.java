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
import tree.model.*;

public class MainSplitPane extends JSplitPane
{
	private static MainSplitPane instance = null;
	
	private SplitPane splitPane;
	
	private Tree tree;
	private tree.model.TreeModel treeModel;
	
	private MainSplitPane()
	{
		splitPane = new SplitPane();
		
		tree = new Tree();
		treeModel = new tree.model.TreeModel();
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

	public tree.model.TreeModel getTreeModel()
	{
		return treeModel;
	}
	
	
}
