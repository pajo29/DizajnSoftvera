package gui.tree.controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.menu.treePopupMenu.PopupMenu;
import main.MainFrame;
import main.MainSplitPane;

import javax.swing.*;
import javax.swing.tree.TreePath;

public class TreeListener extends MouseAdapter implements MouseListener
{
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(e.getClickCount() == 1 && e.isAltDown())
		{
				MainFrame.getInstance().getActionManager().getEditAction().edit();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		int selectedRow = MainSplitPane.getInstance().getTree().getClosestRowForLocation(e.getX(), e.getY());
		TreePath path = MainSplitPane.getInstance().getTree().getPathForRow(selectedRow);
		Rectangle treeBounds = MainSplitPane.getInstance().getTree().getUI().getPathBounds(MainSplitPane.getInstance().getTree(), path);

		if(SwingUtilities.isRightMouseButton(e)) {
			if(treeBounds.contains(e.getX(), e.getY()))
			{
				MainSplitPane.getInstance().getTree().setSelectionRow(selectedRow);
				Popup(e, MainSplitPane.getInstance().getTree().getPathForRow(selectedRow));
			}

		}
		else
			{
			if(!treeBounds.contains(e.getX(), e.getY())) {
				SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
				MainSplitPane.getInstance().getTree().clearSelection();
			}
		}
	}
		

	private void Popup(MouseEvent e, TreePath path)
	{
		PopupMenu pm = new PopupMenu(path);
		pm.show(e.getComponent(), e.getX(), e.getY());
	}

}
