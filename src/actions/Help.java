package actions;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainFrame;

@SuppressWarnings("serial")
public class Help extends AbstractGEDAction
{
	
	public Help()
	{
		putValue(SMALL_ICON, loadIcon("images/help.png"));
		putValue(NAME, "Precice");
		putValue(SHORT_DESCRIPTION, "Precice za komande");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JFrame helpFrame = new JFrame("Pomoc");
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		JPanel pnNew = new JPanel();
		JLabel picLbNew = new JLabel(new ImageIcon("src/actions/images/newFile.png"));
		JLabel lbNew = new JLabel("New File - Ctrl-T");
		pnNew.add(picLbNew);
		pnNew.add(lbNew);
		
		JPanel pnOpen = new JPanel();
		JLabel picLbOpen = new JLabel(new ImageIcon("src/actions/images/open.png"));
		JLabel lbOpen = new JLabel("Open File - Alt-2");
		pnOpen.add(picLbOpen);
		pnOpen.add(lbOpen);
		
		JPanel pnEdit = new JPanel();
		JLabel picLbEdit = new JLabel(new ImageIcon("src/actions/images/edit.png"));
		JLabel lbEdit = new JLabel("Edit - Alt-3; Drzanjem Alt-a i klikom na komponentu u stablu");
		pnEdit.add(picLbEdit);
		pnEdit.add(lbEdit);
		
		JPanel pnRemove = new JPanel();
		JLabel picLbRemove = new JLabel(new ImageIcon("src/actions/images/remove.png"));
		JLabel lbRemove = new JLabel("Remove - Ctrl-W");
		pnRemove.add(picLbRemove);
		pnRemove.add(lbRemove);
		
		JPanel pnSave = new JPanel();
		JLabel picLbSave = new JLabel(new ImageIcon("src/actions/images/save.png"));
		JLabel lbSave = new JLabel("Save - Ctrl-S");
		pnSave.add(picLbSave);
		pnSave.add(lbSave);
		
		JPanel pnSaveAs = new JPanel();
		JLabel picLbSaveAs = new JLabel(new ImageIcon("src/actions/images/saveAs.png"));
		JLabel lbSaveAs = new JLabel("Save As - Ctrl-Shift-S");
		pnSaveAs.add(picLbSaveAs);
		pnSaveAs.add(lbSaveAs);
		
		JPanel pnExit = new JPanel();
		JLabel picLbExit = new JLabel(new ImageIcon("src/actions/images/exit.png"));
		JLabel lbExit = new JLabel("Exit program - Ctrl-E");
		pnExit.add(picLbExit);
		pnExit.add(lbExit);
		
		JPanel pnRename = new JPanel();
		JLabel picLbRename = new JLabel(new ImageIcon("src/actions/images/editing.png"));
		JLabel lbRename = new JLabel("Rename component - Drzanjem Ctr-a i klikom na komponentu u stablu");
		pnRename.add(picLbRename);
		pnRename.add(lbRename);
		
		
		
		panel.add(pnNew);
		panel.add(pnOpen);
		panel.add(pnEdit);
		panel.add(pnRemove);
		panel.add(pnSave);
		panel.add(pnSaveAs);
		panel.add(pnExit);
		panel.add(pnRename);
		helpFrame.add(panel, BorderLayout.CENTER);
		
		
		helpFrame.setSize(size.width/4, size.height/2);
		helpFrame.setLocationRelativeTo(null);
		helpFrame.setVisible(true);
	}

}
