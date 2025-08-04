package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The ConnectionUtil class will be utilized to create an active connection to our database. This class utilizes the singleton design pattern.
 * We will be utilizing an in-memory called h2database for the sql demos.
 */
public class ConnectionUtil {
    // 'url' represents the connection string. Here, we are using an this is an in-memory H2 database
    private static String url = "jdbc:h2:./h2/db";
    // 'username' represents a valid login name for the database. 'sa' is a default value for H2 databases
    private static String username = "sa";
    // 'password' represents the associated password for the database. 'sa' is a default value for H2 databases
    private static String password = "sa";
    
    // The 'connection' object represents the actual connection made to the database. We make it static for easier reference
    private static Connection connection = null;

    /**
     * @return active connection to the database
     */
    public static Connection getConnection(){
        if(connection == null){
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

}
