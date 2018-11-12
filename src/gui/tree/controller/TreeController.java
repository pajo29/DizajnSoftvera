package gui.tree.controller;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class TreeController implements TreeSelectionListener
{
	public void valueChanged(TreeSelectionEvent e)
	{
		System.out.println(e.getPath());
	}
	
	

}