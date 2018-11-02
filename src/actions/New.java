package actions;

import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import main.MainFrame;
import main.MainSplitPane;
import tree.model.Component;


public class New extends AbstractGEDAction
{
	
	public New()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control T"));
		putValue(SMALL_ICON, loadIcon("images/newFile.png"));
		putValue(NAME, "mNew component");
		putValue(SHORT_DESCRIPTION, "New component");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Object cmp = MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
		if(cmp instanceof Component)
		{
			Component component = (Component)cmp;
			Component newComponent = new Component("Komponenta "+(component.getChildCount()+1));
			component.addChild(newComponent);
			SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
		}
	}
}
