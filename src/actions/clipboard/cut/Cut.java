package actions.clipboard.cut;

import actions.AbstractGEDAction;
import actions.clipboard.NodeSelection;
import gui.tree.treeModel.Node;
import main.MainFrame;
import main.MainSplitPane;

import javax.swing.*;
import javax.swing.tree.MutableTreeNode;
import java.awt.event.ActionEvent;

public class Cut extends AbstractGEDAction
{

    public Cut()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
        putValue(SMALL_ICON, loadIcon("../../images/cut.png"));
        putValue(NAME, "cut");
        putValue(SHORT_DESCRIPTION, "cut file");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        Node selectedNode;
        selectedNode = (Node) MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
        NodeSelection nodeSelection = new NodeSelection(selectedNode);
        MainFrame.getInstance().getClipboard().setContents(nodeSelection, MainFrame.getInstance());
        ((Node)selectedNode.getParent()).remove((MutableTreeNode) selectedNode);
    }
}
