package command;

import gui.MainSplitPane;
import main.MainFrame;
import tree.treeModel.Node;

import javax.swing.*;
import javax.swing.tree.MutableTreeNode;
import java.util.ArrayList;

public class RemoveCommand extends AbstractCommand
{

    private Node nodeParent;
    private Node node;

    private ArrayList<Node> removedNodes;

    private int removeIndex;

    public RemoveCommand(Node node)
    {
        this.node = node;
        nodeParent = (Node)node.getParent();
    }

    @Override
    public void doCommand()
    {
        if (node == MainSplitPane.getInstance().getTree().getPathForRow(0).getLastPathComponent())
        {
            removedNodes = new ArrayList<>();
            for(Node n:  ((Node) node).getChildren())
            {
                removedNodes.add(n);
            }
            MainSplitPane.getInstance().getSplitPane().remove();
            ((Node) node).getChildren().clear();
        }
        else
        {
            MainSplitPane.getInstance().getSplitPane().checkForRemove(node);
            removeIndex = nodeParent.getChildren().indexOf(node);
            node.removeFromParent();
        }

        SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
        MainSplitPane.getInstance().getTree().clearSelection();
        MainFrame.getInstance().getActionManager().setChanges(true);
    }

    @Override
    public void undoCommand()
    {
        if(removedNodes != null)
        {
            for(Node n: removedNodes)
            {
                node.addChild(n);
            }
        }
        else
        {
            nodeParent.addChild(node);
        }
        SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
        MainSplitPane.getInstance().getTree().clearSelection();
        MainFrame.getInstance().getActionManager().setChanges(true);
    }
}
