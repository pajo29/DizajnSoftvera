package tree.treeNode;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import tree.model.WorkSpace;

public class Node implements TreeNode
{

	private String name;
	private Node parent;
	private ArrayList<Node> children;
	
	public Node(String name)
	{
		this.name = name;
		this.parent = null;
		this.children = new ArrayList<>();
	}
	
	public void addChild(Node child)
	{
		child.setParent(this);
		if(child instanceof WorkSpace)
		{
			child.setName("Workspace");
		}
		else
		{
			child.setName("Komponentna");
		}
		children.add(child);
	}
	
	@Override
	public Enumeration children()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowsChildren()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int childIndex)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndex(TreeNode node)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TreeNode getParent()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf()
	{
		// TODO Auto-generated method stub
		return false;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ArrayList<Node> getChildren()
	{
		return children;
	}

	public void setChildren(ArrayList<Node> children)
	{
		this.children = children;
	}

	public void setParent(Node parent)
	{
		this.parent = parent;
	}

}
