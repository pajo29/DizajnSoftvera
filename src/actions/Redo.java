package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Redo extends AbstractGEDAction
{
    public Redo()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control shift Z"));
        putValue(SMALL_ICON, loadIcon("images/redo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo action");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {

    }
}
