package actions.clipboard.paste;

import actions.AbstractGEDAction;
import command.PasteCommand;
import messageHandler.MessageHandler;
import messageHandler.MessageType;
import tree.treeModel.*;
import main.MainFrame;
import gui.MainSplitPane;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Paste extends AbstractGEDAction
{

    private boolean cut = false;

    public Paste()
    {
        putValue(SMALL_ICON, loadIcon("../../images/paste.png"));
        putValue(NAME, "Paste");
        putValue(SHORT_DESCRIPTION, "Paste file");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        Transferable clipboardContent = MainFrame.getInstance().getClipboard().getContents(MainFrame.getInstance());
        if(!(MainSplitPane.getInstance().getTree().getLastSelectedPathComponent() instanceof Module))
        {
            if(!(MainSplitPane.getInstance().getTree().getLastSelectedPathComponent() instanceof Product))
            {
                MessageHandler.handleEvent(MessageType.WRONG_TYPE_IN_CLIPBOARD);
                return;
            }

        }
        try
        {
            if(clipboardContent != null)
            {
                if (clipboardContent.isDataFlavorSupported(new DataFlavor(Class.forName("java.util.ArrayList"), "Selected Parametar")))
                {
                        ArrayList<Parametar> parametars = (ArrayList<Parametar>) clipboardContent.getTransferData(new DataFlavor(Class.forName("java.util.ArrayList"), "Selected Parametar"));
                        if(cut)
                        {
                            MainFrame.getInstance().getCommandManager().addCommand(new PasteCommand(parametars, (Node) MainSplitPane.getInstance().getTree().getLastSelectedPathComponent(), true));
                            cut = false;
                        }
                        else
                        {
                            MainFrame.getInstance().getCommandManager().addCommand(new PasteCommand(parametars, (Node) MainSplitPane.getInstance().getTree().getLastSelectedPathComponent(), false));
                        }
                }
            }
            else
            {
                MessageHandler.handleEvent(MessageType.CLIPBOARD_EMPTY);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setCut(boolean cut)
    {
        this.cut = cut;
    }
}
