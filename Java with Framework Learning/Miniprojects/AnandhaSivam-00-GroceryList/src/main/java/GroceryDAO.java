import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A DAO is a class that mediates the transformation of data between the format of objects in Java to rows in a
 * database. The methods here are mostly filled out, you will just need to add a SQL statement.
 *
 * We may assume that the database has already created a table named 'Grocery'.
 * It contains a single column, named 'grocery_name' of type varchar(255).
 * The table will be automatically created by the databaseSetup() method in GroceryMain.java.
 */
public class GroceryDAO {


    /**
     * TODO: Select all of the rows of the Grocery table.
     * You only need to change the sql String, the rest of the method is already complete.
     * @return a List of all the groceries contained within the database.
     */
    public List<String> getAllGroceries(){
        Connection connection = ConnectionUtil.getConnection();
        List<String> groceries = new ArrayList<>();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM Grocery";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                groceries.add(rs.getString("grocery_name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return groceries;
    }
    /**
     * TODO: Insert a new row into the Grocery table, which contains a column named grocery_name.
     * A parameter groceryName is also provided, which should be the value used for grocery_name when inserting a
     * grocery. For instance, calling groceryDAO.addGrocery("bread"); should insert a record into the grocery table
     * with the value 'bread' for the grocery_name column.
     *
     * You should use the preparedStatement syntax for filling in unknown parameters with a '?'.
     * For instance, an insert statement would be written as:
     * String sql = "INSERT INTO TABLE (Column1, Column2) VALUES (?, ?)"
     * The question marks can be filled in by the methods setString, setInt, etc of the PreparedStatement. They follow
     * this format, where the first argument identifies the question mark to be filled (left to right, starting
     * from one) and the second argument identifies the variable to be used:
     * preparedStatement.setString(1,int1);
     * preparedStatement.setInt(2,string2);
     *
     * @param groceryName the name of the grocery passed in from the GroceryService.
     */
    public void addGrocery(String groceryName){
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = "INSERT INTO Grocery (grocery_name) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            //add code that leverages ps.setString here
            ps.setString(1, groceryName);

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
