package gui.tree;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;


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
                super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);
                
           
               URL imageURL = getClass().getResource("src/actions/images/component.png");
               Icon icon = null;
               if (imageURL != null)                       
                   icon = new ImageIcon(imageURL);
               setIcon(icon);

         
           
          return this;
}

}
