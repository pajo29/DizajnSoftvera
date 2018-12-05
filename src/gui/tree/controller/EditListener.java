package gui.tree.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.tree.treePopupMenu.PopupMenu;
import main.MainFrame;

public class EditListener extends MouseAdapter implements MouseListener
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
		if(e.isPopupTrigger())
		{
			Popup(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	private void Popup(MouseEvent e)
	{
		PopupMenu pm = new PopupMenu();
		pm.show(e.getComponent(), e.getX(), e.getY());
	}

}
