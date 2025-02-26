package Feb25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonByAge {
    public static void main(String[] args) throws Exception {
        String json = "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":22},{\"name\":\"Charlie\",\"age\":27}]";
        
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);
        
        List<JsonNode> filteredList = new ArrayList<>();
        for (JsonNode node : rootNode) {
            if (node.get("age").asInt() > 25) {
                filteredList.add(node);
            }
        }

        System.out.println(objectMapper.writeValueAsString(filteredList));
    }
}
