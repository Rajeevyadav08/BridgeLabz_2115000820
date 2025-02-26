package Feb25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXmlConverter {
    public static void main(String[] args) throws Exception {
        String json = "{ \"name\": \"Alice\", \"age\": 30, \"email\": \"alice@example.com\" }";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        System.out.println(xml);
    }
}
