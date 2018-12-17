package actions;

import messageHandler.MessageHandler;
import messageHandler.MessageType;
import tree.treeModel.Node;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class WorkspaceLoader
{

    public static Node programStart()
    {
        Node node = null;

        try
        {
            FileInputStream fis = new FileInputStream("workspace.ser");
            ObjectInputStream in = new ObjectInputStream(fis);
            node = (Node) in.readObject();
            in.close();
            fis.close();

            return node;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            MessageHandler.handleEvent(MessageType.DESERIALISATION_FAIL);
        }
        return null;
    }
}
