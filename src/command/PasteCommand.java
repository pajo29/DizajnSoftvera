package command;

import gui.MainSplitPane;
import main.MainFrame;
import tree.treeModel.Node;
import tree.treeModel.Parametar;

import javax.swing.*;
import javax.swing.tree.MutableTreeNode;
import java.util.ArrayList;

public class PasteCommand extends AbstractCommand
{

    private ArrayList<Parametar> copiedParametars;
    private ArrayList<Parametar> pastedParametars;

    private Node selectedComponent;

    private boolean cut;

    public PasteCommand(ArrayList<Parametar> copiedParametars, Node selectedComponent, boolean cut)
    {
        this.copiedParametars = copiedParametars;
        this.selectedComponent = selectedComponent;
        pastedParametars = new ArrayList<>();
        this.cut = cut;
    }

    @Override
    public void doCommand()
    {
        if(cut)
        {
            for(Node nodes: copiedParametars)
            {
                nodes.removeFromParent();
            }
        }
        for (Parametar par : copiedParametars)
        {
            Parametar parm = new Parametar(par);
            selectedComponent.addChild(parm);
            pastedParametars.add(parm);
        }
        SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
        MainSplitPane.getInstance().getTree().clearSelection();
        MainFrame.getInstance().getActionManager().setChanges(true);
    }

    @Override
    public void undoCommand()
    {
        if(cut)
        {
            for (Parametar par : copiedParametars)
            {
                ((Node)par.getParent()).addChild(par);
            }
        }
            for (Parametar par : pastedParametars)
            {
                par.removeFromParent();
            }
            SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
            MainSplitPane.getInstance().getTree().clearSelection();
            MainFrame.getInstance().getActionManager().setChanges(true);
    }
}
