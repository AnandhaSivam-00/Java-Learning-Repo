import java.sql.*;

public class JdbcConnectionSupabase {
    private static String url = "jdbc:postgresql://db.aewrshzmncjiepxwjcgc.supabase.co:5432/postgres";
    private static String username = "postgres";
    private static String password = "uSSkSyBsPIEO7x1R";
    public static void main(String args[]) {
        try {
            // Connection conn = DriverManager.getConnection("jdbc:postgresql://db.aewrshzmncjiepxwjcgc.supabase.co:5432/postgres?user=postgres&password=uSSkSyBsPIEO7x1R");
            Connection conn = DriverManager.getConnection(url, username, password);
            // DriverManager used to load the JDBC drivers
            // Connection used to make the physical connection between the database
            System.out.println("Connected to the Supabase...");

            Statement stmt = conn.createStatement(); // Used for executing the static SQL queries
            ResultSet rs = stmt.executeQuery("SELECT * FROM school.school_details");

            while(rs.next()) {
                System.out.println(rs.getString("school_name"));
            }

            conn.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
 
