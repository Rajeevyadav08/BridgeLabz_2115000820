package Feb25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class asd {
    public static void main(String[] args) throws Exception {
        String json = "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":25},{\"name\":\"Charlie\",\"age\":35}]";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        List<JsonNode> filteredUsers = new ArrayList<>();
        for (JsonNode node : rootNode) {
            if (node.get("age").asInt() > 25) {
                filteredUsers.add(node);
            }
        }

        System.out.println(objectMapper.writeValueAsString(filteredUsers));
    }
}
