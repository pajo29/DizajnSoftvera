package users.model;

import messageHandler.MessageHandler;
import messageHandler.MessageType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class UserDatabase
{

    private static UserDatabase instance = null; //TODO Napraviti da moze parametar u parametar (Slozeni parametar) ARGHJASDKDL

    private ArrayList<User> users;

    private UserDatabase()
    {
     users = new ArrayList<>();
    }

    public void loadUsers()
    {
        try
        {
            FileReader fr = new FileReader("korisnici.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null)
            {
                String[] userStats = line.split(";");
                User user = new User(Integer.parseInt(userStats[0]), userStats[1], userStats[2], userStats[3], userStats[4]);
                if(!users.contains(user))
                    users.add(user);
            }
        }
        catch (Exception e)
        {
            MessageHandler.handleEvent(MessageType.USERS_NOT_FOUND);
        }

        for(User usr: users)
        {
            System.out.println(usr);
        }

    }

    public static UserDatabase getInstance()
    {
        if(instance == null) instance = new UserDatabase();
        return instance;
    }

}
