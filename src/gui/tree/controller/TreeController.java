package gui.tree.controller;

import gui.tree.treeModel.Parametar;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class TreeController implements TreeSelectionListener
{
	public void valueChanged(TreeSelectionEvent e)
	{
		System.out.println(e.getPath());
	}
	
	

}