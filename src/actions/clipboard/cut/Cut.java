package actions.clipboard.cut;

import actions.AbstractGEDAction;
import actions.clipboard.NodeSelection;
import gui.messageHandler.MessageHandler;
import gui.messageHandler.MessageType;
import gui.tree.treeModel.Node;
import gui.tree.treeModel.Parametar;
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
        putValue(NAME, "Cut");
        putValue(SHORT_DESCRIPTION, "Cut file");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        Parametar selectedNode = null;
        try
        {
            selectedNode = (Parametar) MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
        }
        catch (Exception e)
        {
            MessageHandler.handleEvent(MessageType.WRONG_TYPE_TO_COPY);
            return;
        }
        NodeSelection nodeSelection = new NodeSelection(selectedNode);
        MainFrame.getInstance().getClipboard().setContents(nodeSelection, MainFrame.getInstance());
        ((Node)selectedNode.getParent()).remove((MutableTreeNode) selectedNode);
    }
}
