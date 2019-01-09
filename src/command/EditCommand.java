package command;

import gui.MainSplitPane;
import main.MainFrame;
import tree.treeModel.Node;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditCommand extends AbstractCommand
{
    private Node node;
    private ActionEvent e;
    private String oldName;

    public EditCommand(ActionEvent e, Node node)
    {
        this.e = e;
        this.node = node;
        this.oldName = node.getName();
    }

    @Override
    public void doCommand()
    {
        node.setName(e.getActionCommand());
        SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
        MainSplitPane.getInstance().getTree().clearSelection();
        MainFrame.getInstance().getActionManager().setChanges(true);
    }

    @Override
    public void undoCommand()
    {
        node.setName(oldName);
        SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
        MainSplitPane.getInstance().getTree().clearSelection();
        MainFrame.getInstance().getActionManager().setChanges(true);
    }
}
