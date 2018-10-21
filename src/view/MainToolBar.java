package view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class MainToolBar extends JPanel
{
	
	private static MainToolBar instance = null;
	
	private JToolBar mainToolBar;
	
	private JButton mNew;
	private JButton mOpen;
	private JButton mClose;
	private JButton mSwitch;
	private JButton mSave;
	private JButton mSaveAs;
	private JButton mExit;
	
	private MainToolBar()
	{
		super(new BorderLayout());
		mainToolBar = new JToolBar();
		
		mNew = new JButton();
		mNew.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ovo nazalost jos nista ne radi :(", "New", JOptionPane.INFORMATION_MESSAGE);		
			}
		});
		mNew.setIcon(new ImageIcon("src/images/newFileBigger.png"));
		
		mOpen = new JButton();
		mOpen.setIcon(new ImageIcon("src/images/openBigger.png"));
		
		mClose = new JButton();
		mClose.setIcon(new ImageIcon("src/images/closeBigger.png"));
		
		mSwitch = new JButton();
		mSwitch.setIcon(new ImageIcon("src/images/switchBigger.png"));
		
		mSave = new JButton();
		mSave.setIcon(new ImageIcon("src/images/saveBigger.png"));
		
		mSaveAs = new JButton();
		mSaveAs.setIcon(new ImageIcon("src/images/saveAsBigger.png"));
		
		mExit = new JButton();
		mExit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		mExit.setIcon(new ImageIcon("src/images/exitBigger.png"));
		
		mainToolBar.add(mNew);
		mainToolBar.addSeparator();
		mainToolBar.add(mOpen);
		mainToolBar.add(mClose);
		mainToolBar.add(mSwitch);
		mainToolBar.addSeparator();
		mainToolBar.add(mSave);
		mainToolBar.add(mSaveAs);
		mainToolBar.addSeparator();
		mainToolBar.add(mExit);
		
		add(mainToolBar, BorderLayout.PAGE_START);
	}
	
	public static MainToolBar getInstance()
	{
		if(instance == null)
			instance = new MainToolBar();
		return instance;
	}

}
