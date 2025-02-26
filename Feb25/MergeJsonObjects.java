package Feb25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonObjects {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // First JSON object
            String json1 = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\" }";
            JsonNode node1 = objectMapper.readTree(json1);

            // Second JSON object
            String json2 = "{ \"age\": 25, \"city\": \"New York\" }";
            JsonNode node2 = objectMapper.readTree(json2);

            // Merge both JSON objects
            ObjectNode mergedNode = objectMapper.createObjectNode();
            mergedNode.setAll((ObjectNode) node1);
            mergedNode.setAll((ObjectNode) node2);

            // Convert merged object to JSON string
            String mergedJson = objectMapper.writeValueAsString(mergedNode);
            System.out.println(mergedJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
