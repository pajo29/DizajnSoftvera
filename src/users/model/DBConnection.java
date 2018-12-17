package users.model;


import gui.messageHandler.MessageHandler;
import gui.messageHandler.MessageType;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection
{
    private static DBConnection instance = null;

    private Connection con = null;

    private String connectionURL = "jdbc:mysql://s687.loopia.se:3306/elexgarant_co_rs_db_1?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username = "elex@e44527";
    private String password = "Jaksa2003";

    private DBConnection()
    {

    }

    public static DBConnection getInstance()
    {
        if(instance == null) instance = new DBConnection();
        return instance;
    }

    public Connection getConnection(int connectionTry)
    {
        if(con == null)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(connectionURL, username, password);
            }
            catch (Exception e)
            {
                if(connectionTry > 0)
                {
                    con = null;
                    getConnection(connectionTry - 1);
                }
                else
                {
                    MessageHandler.handleEvent(MessageType.CONNECTION_FAILED);
                    e.printStackTrace();
                }
            }
        }
        return con;
    }

    public void closeConnection()
    {
        if(con != null)
        {
            try
            {
                con.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            con = null;
        }
    }
}
