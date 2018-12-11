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
                if (clipboardContent.isDataFlavorSupported(new DataFlavor(Class.forName("gui.tree.treeModel.Node"), "Children")))
                {
                    Node node = (Node) clipboardContent.getTransferData(new DataFlavor(Class.forName("gui.tree.treeModel.Node"), "Children"));
                    if(node instanceof Product)
                        MainFrame.getInstance().getActionManager().getNewAction().addNewChild(new Product(node));
                    else if(node instanceof Module)
                        MainFrame.getInstance().getActionManager().getNewAction().addNewChild(new Module(node));
                    else if(node instanceof Parametar)
                        MainFrame.getInstance().getActionManager().getNewAction().addNewChild(new Parametar(node));
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
}
