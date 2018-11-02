package tree.controller;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import tree.model.Component;


public class TreeController implements TreeSelectionListener
{

	
	public void valueChanged(TreeSelectionEvent e)
	{
		TreePath path = e.getPath();
		for(int i=0; i<path.getPathCount(); i++){
			if(path.getPathComponent(i) instanceof Component)
			{
				System.out.println("getPath: "+e.getPath());
				break;
			}
		}
		
	}

}
