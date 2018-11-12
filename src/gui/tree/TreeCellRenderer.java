package gui.tree;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;



@SuppressWarnings("serial")
public class TreeCellRenderer extends DefaultTreeCellRenderer
{
	
	public TreeCellRenderer()
	{
		
	}
	
	public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {
                super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row,hasFocus);
                
          
          
          if(sel)
        	  setIcon(new ImageIcon("src/actions/images/selected.png"));
          else
          {
        	  if(value instanceof gui.tree.model.Component)
              {
           	   if(((gui.tree.model.Component)value).getParent() == null)
           		   setIcon(new ImageIcon("src/actions/images/mainComponent.png"));
           	   else
           		   setIcon(new ImageIcon("src/actions/images/component.png"));
              }
          }  
        	 
        	  
          return this;
}

}
