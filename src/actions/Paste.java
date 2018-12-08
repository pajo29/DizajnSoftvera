package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Paste extends AbstractGEDAction
{

    public Paste()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V"));
        putValue(SMALL_ICON, loadIcon("images/paste.png"));
        putValue(NAME, "Paste");
        putValue(SHORT_DESCRIPTION, "Paste file");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {

    }
}
