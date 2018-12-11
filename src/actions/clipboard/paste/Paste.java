package actions.clipboard.paste;

import actions.AbstractGEDAction;
import gui.messageHandler.MessageHandler;
import gui.messageHandler.MessageType;
import gui.tree.treeModel.*;
import main.MainFrame;
import main.MainSplitPane;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;

public class Paste extends AbstractGEDAction
{

    public Paste()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V"));
        putValue(SMALL_ICON, loadIcon("../../images/paste.png"));
        putValue(NAME, "Paste");
        putValue(SHORT_DESCRIPTION, "Paste file");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        Transferable clipboardContent = MainFrame.getInstance().getClipboard().getContents(MainFrame.getInstance());
        try
        {
            if(clipboardContent != null)
            {
                if (clipboardContent.isDataFlavorSupported(new DataFlavor(Class.forName("gui.tree.treeModel.Parametar"), "Selected Parametar")))
                {
                    Parametar node = (Parametar) clipboardContent.getTransferData(new DataFlavor(Class.forName("gui.tree.treeModel.Parametar"), "Selected Parametar"));
                        MainFrame.getInstance().getActionManager().getNewAction().addNewChild(new Parametar(node));
                }
            }
            else
            {
                MessageHandler.handleEvent(MessageType.CLIPBOARD_EMPTY);
            }
            MainSplitPane.getInstance().getTree().clearSelection();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
