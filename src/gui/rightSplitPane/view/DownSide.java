package gui.rightSplitPane.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import gui.tree.model.Component;
import main.MainSplitPane;

public class DownSide extends JPanel implements Observer
{

	private static DownSide instance = null;
	
	private JTextArea txArea;
	
	private DownSide()
	{
		txArea = new JTextArea();
		txArea.setEditable(false);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(txArea);
		MainSplitPane.getInstance().getTree().getContentModel().addObserver(this);
	}
	
	public static DownSide getInstance()
	{
		if(instance == null)
		{
			instance = new DownSide();
		}
		return instance;
	}
	@Override
	public void update(Observable o, Object arg)
	{
		txArea.setText(((Component)arg).getContent());
		
	}
	public JTextArea getTxArea()
	{
		return txArea;
	}
	
}
