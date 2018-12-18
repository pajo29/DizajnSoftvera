package actions.clipboard.cut;

import actions.AbstractGEDAction;
import actions.clipboard.NodeSelection;
import messageHandler.MessageHandler;
import messageHandler.MessageType;
import tree.treeModel.Node;
import main.MainFrame;
import gui.MainSplitPane;

import javax.swing.*;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Cut extends AbstractGEDAction
{

    public Cut()
    {
        putValue(SMALL_ICON, loadIcon("../../images/cut.png"));
        putValue(NAME, "Cut");
        putValue(SHORT_DESCRIPTION, "Cut file");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        ArrayList<Node> selectedNodes = new ArrayList<Node>();
        TreePath[] paths = MainSplitPane.getInstance().getTree().getSelectionPaths();
        try
        {
            for(int i = 0; i < paths.length; i++)
            {
                selectedNodes.add((Node)paths[i].getLastPathComponent());
            }
        }
        catch (Exception e)
        {
            MessageHandler.handleEvent(MessageType.WRONG_TYPE_TO_COPY);
            return;
        }
        NodeSelection nodeSelection = new NodeSelection(selectedNodes);
        MainFrame.getInstance().getClipboard().setContents(nodeSelection, MainFrame.getInstance());
        for(Node nodes: selectedNodes)
        {
            ((Node)nodes.getParent()).remove((MutableTreeNode) nodes);
        }
    }
}
