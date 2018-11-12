package gui.rightSplitPane.view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
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
	
	private JPanel firstPanel;
	private JPanel secondPanel;
	private JPanel thirdPanel;
	private JPanel fourthPanel;
	private JPanel fifthPanel;
	
	private DownSide()
	{
		txName = new JTextField();
		txName.setEditable(false);
		txName.setPreferredSize(new Dimension(400, 40));
		
		txContent = new JTextField();
		txContent.setEditable(false);
		txContent.setPreferredSize(new Dimension(400, 40));
		
		txParent = new JTextField();
		txParent.setEditable(false);
		txParent.setPreferredSize(new Dimension(400, 40));
		
		txChildren = new JTextField();
		txChildren.setEditable(false);
		txChildren.setPreferredSize(new Dimension(400, 40));
		
		txLeafs = new JTextField();
		txLeafs.setEditable(false);
		txLeafs.setPreferredSize(new Dimension(400, 40));
		
		firstPanel = new JPanel();
		secondPanel = new JPanel();
		thirdPanel = new JPanel();
		fourthPanel = new JPanel();
		fifthPanel = new JPanel();
		
		firstPanel.add(new JLabel("Naziv: "));
		firstPanel.add(txName);
		
		secondPanel.add(new JLabel("Sadrzaj: "));
		secondPanel.add(txContent);
		
		thirdPanel.add(new JLabel("Roditelj: "));
		thirdPanel.add(txParent);
		
		fourthPanel.add(new JLabel("Direktna deca: "));
		fourthPanel.add(txChildren);
		
		fifthPanel.add(new JLabel("Listovi: "));
		fifthPanel.add(txLeafs);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(firstPanel);
		add(secondPanel);
		add(thirdPanel);
		add(fourthPanel);
		add(fifthPanel);
		
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
		txLeafs.setText(""+((Component)arg).getLeafCount((Component)arg, 0, ((Component)arg).getChildCount()));
	}
	
	public void setData(Component cmp)
	{
		txName.setText(cmp.getName());
		txContent.setText(cmp.getContent());
		txParent.setText(cmp.getParent().toString());
		txChildren.setText(""+cmp.getChildCount());
		txLeafs.setText(""+cmp.getLeafCount(cmp, 0, cmp.getChildCount()));
	}
}
