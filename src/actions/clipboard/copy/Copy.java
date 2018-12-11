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
import javax.swing.tree.TreePath;
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
        ArrayList<Node> selectedNodes = new ArrayList<Node>();
        TreePath[] paths = MainSplitPane.getInstance().getTree().getSelectionPaths();
        try
        {
            for(int i = 0; i < paths.length; i++)
            {
                if(paths[i].getLastPathComponent() instanceof Parametar)
                    selectedNodes.add((Node) paths[i].getLastPathComponent());
                else
                {
                    MessageHandler.handleEvent(MessageType.WRONG_TYPE_TO_COPY);
                    return;
                }
            }
        }
        catch (Exception e)
        {
            MessageHandler.handleEvent(MessageType.WRONG_TYPE_TO_COPY);
            return;
        }
        NodeSelection nodeSelection = new NodeSelection(selectedNodes);
        MainFrame.getInstance().getClipboard().setContents(nodeSelection, MainFrame.getInstance());
    }
}
