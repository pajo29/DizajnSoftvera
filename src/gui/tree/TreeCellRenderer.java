package gui.tree;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;
import javax.swing.tree.DefaultTreeCellRenderer;

import javafx.beans.property.SetProperty;


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
        	  if(value instanceof tree.model.Component)
              {
           	   if(((tree.model.Component)value).getName().contains("Glavna"))
           		   setIcon(new ImageIcon("src/actions/images/mainComponent.png"));
           	   else
           		   setIcon(new ImageIcon("src/actions/images/component.png"));
              }
          }  
        	 
        	  
          return this;
}

}
