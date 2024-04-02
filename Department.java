import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Department department = new Department(1, "IT");

        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/departments";
        String user = "your_username";
        String password = "your_password";

        // SQL query to insert data into department table
        String sql = "INSERT INTO department (id, name) VALUES (" + department.getId() + ", '" + department.getName() + "')";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            // Execute the SQL statement
            stmt.executeUpdate(sql);
            System.out.println("Department record inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}