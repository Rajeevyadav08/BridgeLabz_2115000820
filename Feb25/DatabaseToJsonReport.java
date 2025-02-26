package Feb25;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; 
        String user = "root"; 
        String password = "password"; 

        String query = "SELECT id, name, age, email FROM users";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            List<Map<String, Object>> userList = new ArrayList<>();

            while (rs.next()) {
                Map<String, Object> userMap = new HashMap<>();
                userMap.put("id", rs.getInt("id"));
                userMap.put("name", rs.getString("name"));
                userMap.put("age", rs.getInt("age"));
                userMap.put("email", rs.getString("email"));
                userList.add(userMap);
            }

            String jsonReport = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(userList);
            System.out.println(jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
