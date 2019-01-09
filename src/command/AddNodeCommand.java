package command;

import gui.MainSplitPane;
import main.MainFrame;
import tree.treeModel.Node;

import javax.swing.*;

public class AddNodeCommand extends  AbstractCommand
{

    private Node node;
    private Node newNode;

    public AddNodeCommand(Node node, Node newNode)
    {
        this.node = node;
        this.newNode = newNode;
    }

    @Override
    public void doCommand()
    {
        node.addChild(newNode);
        SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
        MainFrame.getInstance().getActionManager().setChanges(true);
    }

    @Override
    public void undoCommand()
    {
        newNode.removeFromParent();
        SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
        MainFrame.getInstance().getActionManager().setChanges(true);
    }
}
