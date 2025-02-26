package Feb25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
    public static void main(String[] args) {
        String json = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\", \"age\": 25 }";
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);
            System.out.println("Valid JSON: " + jsonNode.toString());
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
