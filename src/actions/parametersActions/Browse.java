package actions.parametersActions;

import java.awt.event.ActionEvent;

import javax.swing.*;

import actions.AbstractGEDAction;
import parameters.logo.LogoView;
import main.MainFrame;
import gui.MainSplitPane;
import parameters.path.PathView;

@SuppressWarnings("serial")
public class Browse extends AbstractGEDAction{
	
	public Browse()
	{
		putValue(SMALL_ICON, loadIcon("../images/open.png"));
		putValue(NAME, "Browse");
		putValue(SHORT_DESCRIPTION, "Browse where to install");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
	}

	public void browseForPath()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int res = fileChooser.showOpenDialog(MainFrame.getInstance());


		if(res == JFileChooser.APPROVE_OPTION)
		{
			((PathView)MainSplitPane.getInstance().getSplitPane().getPanel()).getBrowsePath().setText(fileChooser.getSelectedFile().getAbsolutePath());
			SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getSplitPane().getPanel());
		}
	}

	public void browseForLogo()
	{
		JFileChooser fileChooser = new JFileChooser();
		int res = fileChooser.showOpenDialog(MainFrame.getInstance());


		if(res == JFileChooser.APPROVE_OPTION)
		{
			((LogoView)MainSplitPane.getInstance().getSplitPane().getPanel()).getLabel().setIcon(new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath()));
			SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getSplitPane().getPanel());
		}
	}


}
