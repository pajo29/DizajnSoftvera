package gui;


import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import actions.WorkspaceLoader;
import main.MainFrame;
import messageHandler.MessageHandler;
import messageHandler.MessageType;
import gui.rightSplitPane.ParametarView;
import tree.view.Tree;
import tree.treeModel.Node;
import tree.treeModel.SoftwareCompany;

import java.io.File;

@SuppressWarnings("serial")
public class MainSplitPane extends JSplitPane
{
	
	/*
	 * Author Pavle Prica
	 */
	private static MainSplitPane instance = null;
	
	private ParametarView splitPane;
	
	private Tree tree;
	private tree.treeModel.TreeModel treeModel;
	
	private MainSplitPane()
	{
	}
	
	public void initialise()
	{
		splitPane = ParametarView.getInstance();
		File file = new File("workspace.ser");
		if(file.exists())
		{
			int rez = MessageHandler.handleEvent(MessageType.PROGRAM_START);

			if (rez == JOptionPane.YES_OPTION)
			{
				Node node = WorkspaceLoader.programStart();
				if (node == null)
					setTree(new SoftwareCompany("Softverska kompanija"));
				else
					setTree((SoftwareCompany) node);
			} else
			{
				setTree(new SoftwareCompany("Softverska kompanija"));
				setNodes();
			}
		}
		else
		{
			setTree(new SoftwareCompany("Softverska kompanija"));
			setNodes();
		}

		setRightComponent(splitPane);
		setDividerLocation(230);
		setLeftComponent(tree);
	}
	
	public void setTree(SoftwareCompany scmp)
	{
		tree = new Tree();
		treeModel = new tree.treeModel.TreeModel(scmp);
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

	public ParametarView getSplitPane()
	{
		return splitPane;
	}

	public Tree getTree()
	{
		return tree;
	}

	public tree.treeModel.TreeModel getTreeModel()
	{
		return treeModel;
	}

	private void setNodes()
	{
		MainFrame.getInstance().setTitle("InstaFram RN 75/18 Pavle Prica");
	}
	
	
}