package users.model;

import java.io.Serializable;

public class User
{

    private int ID;
    private String name;
    private String username;
    private String password;
    private String role;

    public User(int ID, String name, String username, String password, String role)
    {
        this.ID = ID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString()
    {
        return this.name + " username: " + this.username + " pass: "+this.password;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof User)
        {
            User user = (User)obj;
            return user.getID() == this.getID();
        }
        return false;
    }
}