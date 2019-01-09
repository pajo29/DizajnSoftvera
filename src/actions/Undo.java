package actions;

import main.MainFrame;
import messageHandler.MessageHandler;
import messageHandler.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Undo extends AbstractGEDAction
{
    public Undo()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control Z"));
        putValue(SMALL_ICON, loadIcon("images/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo action");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        MainFrame.getInstance().getCommandManager().undoCommand();
    }
}
