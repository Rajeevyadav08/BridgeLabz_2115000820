package Feb24;

import java.io.*;
import java.sql.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; // Change DB name
        String username = "your_username"; // Change your DB username
        String password = "your_password"; // Change your DB password
        String csvFile = "employees.csv";

        exportDataToCSV(jdbcURL, username, password, csvFile);
    }

    public static void exportDataToCSV(String jdbcURL, String username, String password, String csvFile) {
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                writer.write(id + "," + name + "," + department + "," + salary);
                writer.newLine();
            }

            System.out.println("CSV report generated: " + csvFile);

        } catch (SQLException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
