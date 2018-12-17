package users.model;

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

    }

    public static UserDatabase getInstance()
    {
        if(instance == null) instance = new UserDatabase();
        return instance;
    }

}
