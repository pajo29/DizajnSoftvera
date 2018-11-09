package gui.tree.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

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