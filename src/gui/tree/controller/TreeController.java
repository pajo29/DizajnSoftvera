package gui.tree.controller;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import gui.tree.model.Component;
import main.MainFrame;


public class TreeController implements TreeSelectionListener
{
	public void valueChanged(TreeSelectionEvent e)
	{
		System.out.println(e.getPath());
	}

}