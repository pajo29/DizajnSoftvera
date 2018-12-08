package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Cut extends AbstractGEDAction
{

    public Cut()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
        putValue(SMALL_ICON, loadIcon("images/cut.png"));
        putValue(NAME, "Cut");
        putValue(SHORT_DESCRIPTION, "Cut file");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
    }
}
