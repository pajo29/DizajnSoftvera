package gui.tree.treeModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Observable;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;


@SuppressWarnings("serial")
public class Node extends Observable implements MutableTreeNode, Serializable
{

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

	public void addChild(Node childNode) {
		childNode.parent = this;
		children.add(childNode);
	}
	
	public Node addNewChild() {
		return null;
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
		// TODO Auto-generated method stub
		
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
	
	public TreePath getPath() { //Not needed right now
		
		TreeNode node = this;
		List<Object> nodes = new ArrayList<Object>();
		
		nodes.add(node);
		node = node.getParent();
		
		while (node != null) {
			nodes.add(0, node);
			node = node.getParent();
		}
		
		return nodes.isEmpty() ? null : new TreePath(nodes.toArray());
	}

}
