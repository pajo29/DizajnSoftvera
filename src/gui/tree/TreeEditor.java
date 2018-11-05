package gui.tree;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;


public class TreeEditor extends DefaultTreeCellEditor implements ActionListener
{
	
	private Object object = null;
	private JTextField edit = null;
	
	public TreeEditor(JTree arg0, DefaultTreeCellRenderer arg1)
	{
		super(arg0, arg1);
	}
	
	@Override
	public Component getTreeCellEditorComponent(JTree tree,
			Object value,
			boolean isSelected,
			boolean expanded,
			boolean leaf,
			int row)
	{
		super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);
		
		object = value;
		edit = new JTextField(value.toString());
		edit.addActionListener(this);
		
		
		
		return edit;
	}
	
	public boolean isCellEditable(EventObject arg0) {
		if (arg0 instanceof MouseEvent)
			if (((MouseEvent)arg0).getClickCount()==3){
				return true;
			}
				return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(object instanceof tree.model.Component)
		{
		((tree.model.Component)object).setName(e.getActionCommand());
		}
	}
	
	
}
