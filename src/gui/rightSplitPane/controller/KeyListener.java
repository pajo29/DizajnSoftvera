package gui.rightSplitPane.controller;

import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import main.MainSplitPane;

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
		MainSplitPane.getInstance().getTree().getContentModel().updateContent(cmp, txArea.getText());
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

}
