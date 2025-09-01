import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.lang.Object;
import java.io.InputStream;
import java.sql.Connection;

class Employee {
    private int rollno;
    private int sectionId;
    private String name;
    private int registerNo;
    private int contactNo;

    public Employee(int rollno, int sectionId, String name, int registerNo, int contactNo) {
        this.rollno = rollno;
        this.sectionId = sectionId;
        this.name = name;
        this.registerNo = registerNo;
        this.contactNo = contactNo;
    }

    protected void getDetails() {
        System.out.print(rollno + "\t" + sectionId + "\t" + name + "\t" + registerNo + "\t" + contactNo);
    }
}

public class EmployeeData {
    private static String url = "";
    private static String username = "";
    private static String password = "";

    private static List<Employee> employeeDatas = new ArrayList<>();

    private static void gettingCredientials() {
        Properties props = new Properties();

        try {
            // InputStream stream = ConnectionUtil.class.getClassLoader().getResourceAsStream("application.properties");
        }
        catch(Exception e) {

        }
    }

    private static void displayEmployeeDetails() {
        for(Employee emp : employeeDatas) {
            emp.getDetails();
            System.out.println();
        }
    }

    public static void main(String args[]) {
        try {
            gettingCredientials();
            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connecting to the Supabase...");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM school.student_details;");

            while(rs.next()) {
                employeeDatas.add(new Employee(
                    rs.getInt("roll_no"), 
                    rs.getInt("section_id"), 
                    rs.getString("student_name"),
                    rs.getInt("registration_no"),
                    rs.getInt("contact_no")
                ));
            }

            displayEmployeeDetails();

            conn.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
