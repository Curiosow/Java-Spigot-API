

// By Curiosow

import java.sql.SQLException;

public class DatabaseManager
{

    private DbConnexion gradeConnexion;

    public DatabaseManager()
    {
        this.gradeConnexion = new DbConnexion(new DbCredentials("INSERT IP", "INSERT USER", "INSERT PASSWORD", "INSERT DATABASE", 3306));
    }

    public DbConnexion getGradeConnexion()
    {
        return gradeConnexion;
    }

    public void close()
    {
        try
        {
            this.gradeConnexion.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
