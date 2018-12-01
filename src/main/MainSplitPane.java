package main;


import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import gui.messageHandler.MessageHandler;
import gui.messageHandler.MessageType;
import gui.rightSplitPane.view.SplitPane;
import gui.tree.Tree;
import gui.tree.treeModel.Node;
import gui.tree.treeModel.SoftwareCompany;

@SuppressWarnings("serial")
public class MainSplitPane extends JSplitPane
{
	
	/*
	 * Author Pavle Prica
	 */
	private static MainSplitPane instance = null;
	
	private SplitPane splitPane;
	
	private Tree tree;
	private gui.tree.treeModel.TreeModel treeModel;
	
	private MainSplitPane()
	{
	}
	
	public void initialise()
	{
		int rez = MessageHandler.handleEvent(MessageType.PROGRAM_START);
		splitPane = new SplitPane();
		if(rez == JOptionPane.YES_OPTION)
		{
			Node node = (Node)MainFrame.getInstance().getActionManager().getOpenAction().openFile();
			if(node == null)
                setTree(new SoftwareCompany("Softverska kompanija"));
			else
				setTree((SoftwareCompany)node);
		}
		else
		{
			setTree(new SoftwareCompany("Softverska kompanija"));
		}
		
		
		setRightComponent(splitPane);
		setDividerLocation(230);
		setLeftComponent(tree);
	}
	
	public void setTree(SoftwareCompany scmp)
	{
		tree = new Tree();
		treeModel = new gui.tree.treeModel.TreeModel(scmp);
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

	public gui.tree.treeModel.TreeModel getTreeModel()
	{
		return treeModel;
	}
	
	
}
