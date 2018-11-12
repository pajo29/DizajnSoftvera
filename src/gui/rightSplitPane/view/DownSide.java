package gui.rightSplitPane.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.tree.model.Component;
import main.MainSplitPane;

@SuppressWarnings("serial")
public class DownSide extends JPanel implements Observer
{

	private static DownSide instance = null;
	
	private JTextField txName;
	private JTextField txContent;
	private JTextField txParent;
	private JTextField txChildren;
	private JTextField txLeafs;
	
	private DownSide()
	{
		txName = new JTextField();
		txName.setEditable(false);
		
		txContent = new JTextField();
		txContent.setEditable(false);
		
		txParent = new JTextField();
		txParent.setEditable(false);
		
		txChildren = new JTextField();
		txChildren.setEditable(false);
		
		txLeafs = new JTextField();
		txLeafs.setEditable(false);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(txName);
		add(txContent);
		add(txParent);
		add(txChildren);
		add(txLeafs);
		
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
		txName.setText(((Component)arg).getName());
		txContent.setText(((Component)arg).getContent());
		txParent.setText(((Component)arg).getParent().toString());
		txChildren.setText(""+((Component)arg).getChildCount());
//		txLeafs.setText(((Component)arg).getContent());
	}
	
	public void setData(Component cmp)
	{
		txName.setText(cmp.getName());
		txContent.setText(cmp.getContent());
		txParent.setText(cmp.getParent().toString());
		txChildren.setText(""+cmp.getChildCount());
//		txLeafs.setText(((Component)arg).getContent());
	}
	
	public JTextField getTxName()
	{
		return txName;
	}
	
	
	
}
