package users.model;

import messageHandler.MessageHandler;
import messageHandler.MessageType;

import java.io.*;
import java.util.ArrayList;

public class UserDatabase
{

    private static UserDatabase instance = null;

    private ArrayList<User> users;

    private UserDatabase()
    {
     users = new ArrayList<>();
    }

    public void loadUsers()
    {
        users.clear();
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
            try
            {
                FileWriter fw = new FileWriter("korisnici.txt");
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }
            return;
        }

    }

    public void addUser(User user)
    {
        try
        {
            FileWriter fw = new FileWriter("korisnici.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            String str = "";
            str += user.getID()+";"+user.getName()+";"+user.getUsername()+";"+user.getPassword()+";"+user.getRole();
            bw.newLine();
            bw.write(str);

            bw.close();
            fw.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public User findUserByUserAndPass(String username, String password)
    {
        for(User user: users)
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                return user;
            }
        }
        return null;
    }

    public boolean checkIfUserExists(User user)
    {
        for (User usr: users)
        {
            if(usr.getUsername().equals(user.getUsername()) && usr.getPassword().equals(user.getPassword()))
            {
                return true;
            }

        }
        return false;
    }

    public ArrayList<User> getUsers()
    {
        return users;
    }

    public static UserDatabase getInstance()
    {
        if(instance == null) instance = new UserDatabase();
        return instance;
    }

}
