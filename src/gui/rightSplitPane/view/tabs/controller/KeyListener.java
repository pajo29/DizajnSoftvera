package gui.rightSplitPane.view.tabs.controller;

import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

import actions.ActionManager;

public class KeyListener implements java.awt.event.KeyListener
{
	
	private gui.tree.model.Component cmp;
	private JTextArea txArea;
	
	public KeyListener(gui.tree.model.Component cmp, JTextArea txArea)
	{
		this.cmp = cmp;
		this.txArea = txArea;
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		cmp.updateContent(txArea.getText());
		ActionManager.getInstace().setChanges(true);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

}
