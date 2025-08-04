import Model.Person;
import Util.ConnectionUtil;
import Util.FileUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Lab2Test {

    /**
     * This test compares the result of the problem1 method to the hardcoded values below which ensures that only the
     * firstname column is retrieved.
     */
    @Test
    public void problem1Test(){
        //arrange
        Person person1 = new Person(0, "Steve", null);
        Person person2 = new Person(0,"Alexa", null);
        Person person3 = new Person(0,"Steve",null);
        Person person4 = new Person(0, "Brandon", null);
        Person person5 = new Person(0,"Adam",null);
        List<Person> expectedResult = new ArrayList<>();
        expectedResult.add(person1);
        expectedResult.add(person2);
        expectedResult.add(person3);
        expectedResult.add(person4);
        expectedResult.add(person5);

        //act
        String sql = FileUtil.parseSQLFile("src/main/lab2.sql");
        if(sql.length() < 2){
            Assert.fail("No SQL statement written in lab1.sql.");
        }
        List<Person> persons = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            ResultSet rs =s.executeQuery(sql);
            while(rs.next()){
                persons.add(new Person(0, rs.getString(1), null));
            }
        } catch (SQLException e) {
            Assert.fail("There was an issue with your SQL statement in lab1.sql: "+e.getMessage());
        }

        //assert
        Assert.assertEquals(expectedResult, persons);
    }

    /**
     * The @Before annotation runs before every test so that way we create the tables required prior to running the test
     */
    @Before
    public void beforeTest(){

        try {

            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql1 = "CREATE TABLE person (id SERIAL PRIMARY KEY, firstname varchar(100), lastname varchar(100));";
            String sql2 = "INSERT INTO person (id, firstname, lastname) VALUES (1, 'Steve', 'Garcia');";
            String sql3 = "INSERT INTO person (id, firstname, lastname) VALUES (2, 'Alexa', 'Smith');";
            String sql4 = "INSERT INTO person (id, firstname, lastname) VALUES (3, 'Steve', 'Jones');";
            String sql5 = "INSERT INTO person (id, firstname, lastname) VALUES (4, 'Brandon', 'Smith');";
            String sql6 = "INSERT INTO person (id, firstname, lastname) VALUES (5, 'Adam', 'Jones');";

            PreparedStatement ps = connection.prepareStatement(sql1 + sql2 + sql3 + sql4 + sql5 + sql6);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("failed creating table");
            e.printStackTrace();
        }
    }

    /**
     * The @After annotation runs after every test so that way we drop the tables to avoid conflicts in future tests
     */
    @After
    public void cleanup(){

        try {

            Connection connection = ConnectionUtil.getConnection();

            String sql = "DROP TABLE person;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("dropping table");
        }
    }
}
