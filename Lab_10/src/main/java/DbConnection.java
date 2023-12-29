import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connection = null;
    public static Connection GetConnection() throws SQLException
    {
        if (connection != null)
        {
            return connection;
        }
        else
        {
            System.out.println("Trying to connect...");

            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            String dbURL = "jdbc:sqlserver://localhost;database=Java_10;encrypt=true;trustServerCertificate=true;";
            String user = "sa";
            String pass = "r00t.R00T";
            connection = DriverManager.getConnection(dbURL, user, pass);

            if (connection != null) {
                System.out.println("Connected...");
            }
            return connection;
        }
    }
}