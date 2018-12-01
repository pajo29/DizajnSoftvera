package actions.parametersActions;

import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import actions.AbstractGEDAction;
import gui.parameters.path.view.PathView;
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
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	public void browseForPath()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int res = fileChooser.showOpenDialog(MainFrame.getInstance());
		
		
		if(res == JFileChooser.APPROVE_OPTION)
		{
			((PathView)MainSplitPane.getInstance().getSplitPane().getUpSide()).getAdress().setText(fileChooser.getSelectedFile().getAbsolutePath());
			((PathView)MainSplitPane.getInstance().getSplitPane().getUpSide()).getPathModel().setContent(fileChooser.getSelectedFile().getAbsolutePath());;
		}
	}
	
	public void browseForLogo()
	{
		
	}

}
