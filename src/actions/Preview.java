package actions;

import gui.MainSplitPane;
import installationSimulation.Simulation;
import main.MainFrame;
import tree.treeModel.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Preview extends AbstractGEDAction
{

    public Preview()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control shift P"));
        putValue(SMALL_ICON, loadIcon("images/preview.png"));
        putValue(NAME, "Preview");
        putValue(SHORT_DESCRIPTION, "Preview product installation");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        Simulation sim = new Simulation((Product) MainSplitPane.getInstance().getTree().getLastSelectedPathComponent());
    }
}
