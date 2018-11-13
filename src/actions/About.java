package actions;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class About extends AbstractGEDAction
{

	public About()
	{
		putValue(SMALL_ICON, loadIcon("images/about.png"));
		putValue(NAME, "O projektantu");
		putValue(SHORT_DESCRIPTION, "Kratki opis");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		JFrame aboutFrame = new JFrame("O projektantu");
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

}
