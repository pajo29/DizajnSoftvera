package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import main.MainFrame;

public class MenuFile extends JMenu{

	private static MenuFile instance = null;
	
	private JMenuItem mNew;
	private JMenuItem mOpen;
	private JMenuItem mClose;
	private JMenuItem mSwitch;
	private JMenuItem mSave;
	private JMenuItem mSaveAs;
	private JMenuItem mExit;
	
	private JMenu subMExport;
	private JMenuItem mExpToPdf;
	private JMenuItem mExpToExc;
	private JMenuItem mExpToWord;
	
	private JMenu subMImport;
	
	private MenuFile()
	{
		mNew = new JMenuItem("mNew", new ImageIcon("src/images/newFile.png"));
		mNew.setAccelerator(KeyStroke.getKeyStroke("control T"));
		mNew.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ovo nazalost jos nista ne radi :(", "New", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		mOpen = new JMenuItem("mOpen", new ImageIcon("src/images/open.png"));
		mOpen.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
		mClose = new JMenuItem("mClose", new ImageIcon("src/images/close.png"));
		mClose.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_3, ActionEvent.ALT_MASK));
		mSwitch = new JMenuItem("mSwitch", new ImageIcon("src/images/switch.png"));
		mSwitch.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_4, ActionEvent.ALT_MASK));
		mSave = new JMenuItem("mSave", new ImageIcon("src/images/save.png"));
		mSave.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_5, ActionEvent.ALT_MASK));
		mSaveAs = new JMenuItem("mSaveAs", new ImageIcon("src/images/saveAs.png"));
		mSaveAs.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_6, ActionEvent.ALT_MASK));
		mExit = new JMenuItem("mExit", new ImageIcon("src/images/exit.png"));
		mExit.setAccelerator(KeyStroke.getKeyStroke("control E"));
		mExit.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
				
			}
		});
		
		subMExport = new JMenu("mExport");
		subMImport = new JMenu("mImport");
		
		mExpToPdf = new JMenuItem("mExpToPDF", new ImageIcon("src/images/pdf.png"));
		mExpToPdf.setAccelerator(KeyStroke.getKeyStroke("control P"));
		
		mExpToExc = new JMenuItem("mExptoMsExcell", new ImageIcon("src/images/excel.png"));
		mExpToExc.setAccelerator(KeyStroke.getKeyStroke("control X"));
		
		mExpToWord = new JMenuItem("mExpToMsWord", new ImageIcon("src/images/word.png"));
		KeyStroke mExpToWordStroke = KeyStroke.getKeyStroke("control W");
		mExpToWord.setAccelerator(mExpToWordStroke);
		
		
		
		
		add(mNew);
		addSeparator();
		add(mOpen);
		add(mClose);
		add(mSwitch);
		addSeparator();
		add(mSave);
		add(mSaveAs);
		addSeparator();
		add(subMExport);
		subMExport.add(mExpToPdf);
		subMExport.add(mExpToExc);
		subMExport.add(mExpToWord);
		//
		add(subMImport);
		addSeparator();
		add(mExit);
		
		setText("File");
	}
	
	public static MenuFile getInstance()
	{
		if(instance == null)
		{
			instance = new MenuFile();
		}
		return instance;
	}
}
