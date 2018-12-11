package actions.clipboard.copy;

import actions.AbstractGEDAction;
import actions.clipboard.NodeSelection;
import gui.tree.treeModel.Node;
import main.MainFrame;
import main.MainSplitPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Copy extends AbstractGEDAction
{

    public Copy()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
        putValue(SMALL_ICON, loadIcon("../../images/copy.png"));
        putValue(NAME, "Copy");
        putValue(SHORT_DESCRIPTION, "Copy file");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        Node selectedNode;
        selectedNode = (Node) MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
        NodeSelection nodeSelection = new NodeSelection(selectedNode);
        MainFrame.getInstance().getClipboard().setContents(nodeSelection, MainFrame.getInstance());
    }
}
