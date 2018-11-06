package gui.menu;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MenuAbout extends JMenu
{

	private JMenuItem about;
	
	public MenuAbout()
	{
		about = new JMenuItem("O projektantu");
		about.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JFrame aboutFrame = new JFrame("O projektantu");
				Toolkit tk = Toolkit.getDefaultToolkit();
				Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
				
				JPanel panel = new JPanel();
				
				JLabel picAbout = new JLabel();
				JLabel labelAbout = new JLabel("Pavle Prica - RN 75/2018");
				
				ImageIcon img = new ImageIcon("src/actions/images/about.jpg");
				picAbout.setIcon(img);
				
				panel.add(picAbout);
				panel.add(labelAbout);
				aboutFrame.add(panel, BorderLayout.CENTER);
				
				aboutFrame.setSize(size.width/4, size.height/2);
				aboutFrame.setLocationRelativeTo(null);
				aboutFrame.setVisible(true);
			}
		});
		
		
		add(about);
		setText("About");
	}
}
