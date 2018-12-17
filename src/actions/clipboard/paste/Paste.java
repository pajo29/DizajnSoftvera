package actions.clipboard.paste;

import actions.AbstractGEDAction;
import messageHandler.MessageHandler;
import messageHandler.MessageType;
import tree.treeModel.*;
import main.MainFrame;
import main.MainSplitPane;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
                if (clipboardContent.isDataFlavorSupported(new DataFlavor(Class.forName("java.util.ArrayList"), "Selected Parametar")))
                {
                        ArrayList<Parametar> parametars = (ArrayList<Parametar>) clipboardContent.getTransferData(new DataFlavor(Class.forName("java.util.ArrayList"), "Selected Parametar"));
                        for (Parametar par : parametars)
                        {

                            MainFrame.getInstance().getActionManager().getNewAction().addNewChild(new Parametar(par));
                        }
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
