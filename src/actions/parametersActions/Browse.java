package actions.parametersActions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import actions.AbstractGEDAction;
import parameters.logo.LogoView;
import main.MainFrame;
import main.MainSplitPane;

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
		JFileChooser fileChooser = new JFileChooser();
		int res = fileChooser.showOpenDialog(MainFrame.getInstance());


		if(res == JFileChooser.APPROVE_OPTION)
		{
			((LogoView)MainSplitPane.getInstance().getSplitPane().getPanel()).getLabel().setIcon(new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath()));
		}
	}
	
}
