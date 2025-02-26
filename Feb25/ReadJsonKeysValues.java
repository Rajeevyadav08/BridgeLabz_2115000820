package Feb25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonKeysValues {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File("data.json"));

        printJson(rootNode, "");
    }

    public static void printJson(JsonNode node, String prefix) {
        if (node.isObject()) {
            for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext(); ) {
                Map.Entry<String, JsonNode> entry = it.next();
                printJson(entry.getValue(), prefix + entry.getKey() + ": ");
            }
        } else if (node.isArray()) {
            for (JsonNode arrayNode : node) {
                printJson(arrayNode, prefix);
            }
        } else {
            System.out.println(prefix + node.asText());
        }
    }
}
