import Util.ConnectionUtil;
import Util.FileUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQL sublanguage: DDL (Data Definition Language)
 *
 * The truncate keyword allows us to remove all records from a table but doesn't delete the table itself.
 *
 * The syntax for truncating a table:
 * TRUNCATE TABLE table_name;
 */
public class Truncate {

    /**
     *      Song Table Diagram:
     *      |      title        |        artist         |
     *      ---------------------------------------------
     *      |'Let it be'        |'Beatles'              |
     *      |'Imagine'          |'Beatles'              |
     *      |'Kashmir'          |'Led Zeppelin'         |
     */
    public void problem2(){
        /**
         * problem2: remove all the records from the table "song". Please refer to the README.MD for where to place your code. 
         */
        String sql = FileUtil.parseSQLFile("problem2.sql");



        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            s.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("problem2: " + e.getMessage() + '\n');
        }
    }
}
