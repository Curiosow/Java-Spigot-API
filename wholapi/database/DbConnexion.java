

// By Curiosow

import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnexion
{

    private DbCredentials dbCredentials;
    private Connection connection;

    public DbConnexion(DbCredentials dbCredentials)
    {
        this.dbCredentials = dbCredentials;
        this.connect();
    }

    private void connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.dbCredentials.toURL(), this.dbCredentials.getUser(), this.dbCredentials.getPass());

            Bukkit.getConsoleSender().sendMessage("§aLa connexion vers les bases de donnees est un succes.");

        } catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
            Bukkit.broadcastMessage("§4§lCRASH IN CONNEXION TO DATABASE!");
            Bukkit.getServer().shutdown();
        }
    }


    public void close() throws SQLException
    {
        if(this.connection != null)
        {
            if(!this.connection.isClosed())
            {
                this.connection.close();
            }
        }
    }

    public Connection getConnexion() throws SQLException
    {
        if(this.connection != null)
        {
            if(!this.connection.isClosed())
            {
                return this.connection;
            }
        }
        connect();
        return this.connection;
    }

}
