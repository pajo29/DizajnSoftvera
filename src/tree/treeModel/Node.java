package tree.treeModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;


public class Node extends Observable implements MutableTreeNode, Serializable
{
	private static final long serialVersionUID = 1L;
	private String name;
	private Node parent;
	private ArrayList<Node> children;
	private int leafCounter = 0;


	public Node(String name)
	{
		this.name = name;
		this.parent = null;
		this.children = new ArrayList<>();
	}

	public Node(Node node)
	{
		this.name = node.getName();
		this.children = node.getChildren();
	}


	public void addChild(Node childNode) {
		childNode.parent = this;
		children.add(childNode);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Enumeration<Node> children()
	{
		return (Enumeration<Node>)children;
	}

	@Override
	public boolean getAllowsChildren()
	{
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex)
	{
		return children.get(childIndex);
	}

	@Override
	public int getChildCount()
	{
		return children.size();
	}

	@Override
	public int getIndex(TreeNode node)
	{
		return children.indexOf(node);
	}

	@Override
	public TreeNode getParent()
	{
		return parent;
	}

	@Override
	public boolean isLeaf()
	{
		return children.isEmpty();
	}

	@Override
	public void insert(MutableTreeNode child, int index)
	{
		((Node)child.getParent()).addChild((Node)child);
		children.add(index, (Node) child);
	}

	@Override
	public void remove(int index)
	{
		children.remove(index);
		
	}

	@Override
	public void remove(MutableTreeNode node)
	{
		children.remove(node);
	}

	@Override
	public void removeFromParent()
	{
		parent.remove(this);
		
	}

	@Override
	public void setParent(MutableTreeNode newParent)
	{
		parent = (Node) newParent;
		
	}

	@Override
	public void setUserObject(Object object)
	{

	}
	
	@Override
	public String toString()
	{
		return getName();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
		setChanged();
		notifyObservers(this);
	}

	public ArrayList<Node> getChildren()
	{
		return children;
	}

	public int getLeafCount(int counter, int limit)
	{
		leafCounter = 0;
		leafCounter(this, counter, limit);
		return leafCounter;
	}
	
	private void leafCounter(Node cmp, int counter, int limit)
	{
		if(counter == limit)
			return;
		
		if(cmp.getChildAt(counter).isLeaf())
			leafCounter++;
			
		if(!cmp.getChildAt(counter).isLeaf())
			leafCounter((Node)cmp.getChildAt(counter), 0, cmp.getChildAt(counter).getChildCount());
		
		leafCounter(cmp, counter+1, limit);
	}





















	/*
	Author @Pavle Prica
	 */
}
