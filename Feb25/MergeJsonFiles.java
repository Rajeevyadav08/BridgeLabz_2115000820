package Feb25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class MergeJsonFiles {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json1 = objectMapper.readTree(new File("file1.json"));
        JsonNode json2 = objectMapper.readTree(new File("file2.json"));

        ObjectNode mergedJson = objectMapper.createObjectNode();
        mergedJson.setAll((ObjectNode) json1);
        mergedJson.setAll((ObjectNode) json2);

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));
    }
}
