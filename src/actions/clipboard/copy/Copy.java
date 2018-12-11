package actions.clipboard.copy;

import actions.AbstractGEDAction;
import actions.clipboard.NodeSelection;
import gui.messageHandler.MessageHandler;
import gui.messageHandler.MessageType;
import gui.tree.treeModel.Node;
import gui.tree.treeModel.Parametar;
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
    }
}
