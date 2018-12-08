package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Copy extends AbstractGEDAction
{

    public Copy()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
        putValue(SMALL_ICON, loadIcon("images/copy.png"));
        putValue(NAME, "Copy");
        putValue(SHORT_DESCRIPTION, "Copy file");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {

    }
}
