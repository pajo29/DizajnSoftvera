package gui.rightSplitPane.view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class ComponentView extends JPanel implements Observer
{
	private static ComponentView instance = null;
	
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
	
//	private Node component = null;
	
	private ComponentView()
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
		
		fourthPanel.add(new JLabel("Deca: "));
		fourthPanel.add(txChildren);
		
		fifthPanel.add(new JLabel("Listovi: "));
		fifthPanel.add(txLeafs);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(firstPanel);
		add(secondPanel);
		add(thirdPanel);
		add(fourthPanel);
		add(fifthPanel);
		
		
	}
	
	public static ComponentView getInstance()
	{
		if(instance == null)
		{
			instance = new ComponentView();
		}
		return instance;
	}
	
	@Override
	public void update(Observable o, Object arg)
	{
//		txName.setText(component.getName());
//		txContent.setText(component.getContent());
//		if(component.getParent() == null)
//			txParent.setText("*Nema roditelja, glavna komponenta*");
//		else
//			txParent.setText(component.getParent().toString());
//		txChildren.setText(""+component.getChildCount());
//		txLeafs.setText(""+component.getLeafCount(component, 0, component.getChildCount()));
	}
	
//	public void setData(Component cmp, Tab tab)
//	{
//		txName.setText(cmp.getName());
//		txContent.setText(cmp.getContent());
//		if(cmp.getParent() == null)
//		{
//			txParent.setText("*Nema roditelja, glavna komponenta*");
//		}
//		else
//			txParent.setText(cmp.getParent().toString());
//		txChildren.setText(""+cmp.getChildCount());
//		txLeafs.setText(""+cmp.getLeafCount(cmp, 0, cmp.getChildCount()));
//		component = cmp;
//		cmp.addObserver(this);
//	}
	
	public void empty()
	{
		txName.setText("");
		txContent.setText("");
		txParent.setText("");
		txChildren.setText("");
		txLeafs.setText("");
	}
}
