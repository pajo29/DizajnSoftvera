package gui.tree.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;

import main.MainFrame;

public class EditListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(e.getClickCount() == 3)
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
