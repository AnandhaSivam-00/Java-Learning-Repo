// Create a table name 'EMPLOYEE' with the fields Emp id, Emp Name, 
//Emp_Address, Emp_designation, Emp_department, Emp_Phone No, Emp_Basicpay,
//Emp_HRA, Emp_DA,Emp_TA, Emp_Salary. Calculate the total salary of the employee. 
//[ Total Salary Emp_Basicpay + Emp_HRA + Emp_TA+ Emp_DA] [HRA-10% of basic pay,
//DA 2% of basic pay, TA 2% of basic pay]. List the Employee who gets the 
//highest salary from each department.

import java.sql.*;
import java.util.*;

public class EmployeeDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/<database_name>";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createEmployeeTable(conn);
            insertSampleData(conn);
            updateTotalSalary(conn);
            listHighestPaidEmployees(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createEmployeeTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS EMPLOYEE (" +
                "Emp_id INT PRIMARY KEY," +
                "Emp_Name VARCHAR(100)," +
                "Emp_Address VARCHAR(255)," +
                "Emp_designation VARCHAR(100)," +
                "Emp_department VARCHAR(100)," +
                "Emp_Phone_No VARCHAR(20)," +
                "Emp_Basicpay DECIMAL(10, 2)," +
                "Emp_HRA DECIMAL(10, 2)," +
                "Emp_DA DECIMAL(10, 2)," +
                "Emp_TA DECIMAL(10, 2)," +
                "Emp_Salary DECIMAL(10, 2)" +
                ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    private static void insertSampleData(Connection conn) throws SQLException {
        String sql = "INSERT INTO EMPLOYEE (Emp_id, Emp_Name, Emp_Address, Emp_designation, Emp_department, Emp_Phone_No, Emp_Basicpay) VALUES " +
                "(1, 'John Doe', '123 Main St', 'Manager', 'Sales', '555-1234', 50000)," +
                "(2, 'Jane Smith', '456 Elm St', 'Developer', 'IT', '555-5678', 60000)," +
                "(3, 'Bob Johnson', '789 Oak St', 'Analyst', 'Finance', '555-9012', 55000)," +
                "(4, 'Alice Brown', '321 Pine St', 'Manager', 'IT', '555-3456', 65000)," +
                "(5, 'Charlie Davis', '654 Maple St', 'Salesperson', 'Sales', '555-7890', 45000)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    private static void updateTotalSalary(Connection conn) throws SQLException {
        String sql = "UPDATE EMPLOYEE SET " +
                "Emp_HRA = Emp_Basicpay * 0.10, " +
                "Emp_DA = Emp_Basicpay * 0.02, " +
                "Emp_TA = Emp_Basicpay * 0.02, " +
                "Emp_Salary = Emp_Basicpay + (Emp_Basicpay * 0.10) + (Emp_Basicpay * 0.02) + (Emp_Basicpay * 0.02)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    private static void listHighestPaidEmployees(Connection conn) throws SQLException {
        String sql = "SELECT e1.* FROM EMPLOYEE e1 " +
                "INNER JOIN (SELECT Emp_department, MAX(Emp_Salary) as max_salary " +
                "FROM EMPLOYEE GROUP BY Emp_department) e2 " +
                "ON e1.Emp_department = e2.Emp_department AND e1.Emp_Salary = e2.max_salary " +
                "ORDER BY e1.Emp_department";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Highest paid employees from each department:");
            System.out.println("---------------------------------------------");

            while (rs.next()) {
                System.out.printf("Department: %s\n", rs.getString("Emp_department"));
                System.out.printf("Employee ID: %d\n", rs.getInt("Emp_id"));
                System.out.printf("Name: %s\n", rs.getString("Emp_Name"));
                System.out.printf("Designation: %s\n", rs.getString("Emp_designation"));
                System.out.printf("Total Salary: %.2f\n\n", rs.getDouble("Emp_Salary"));
            }
        }
    }
}