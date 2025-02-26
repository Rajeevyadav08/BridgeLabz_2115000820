package Feb25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

public class EmailValidation {
    public static void main(String[] args) throws Exception {
        String schemaJson = "{ \"type\": \"object\", \"properties\": { \"email\": { \"type\": \"string\", \"format\": \"email\" } }, \"required\": [\"email\"] }";
        String validJson = "{ \"email\": \"alice@example.com\" }";
        String invalidJson = "{ \"email\": \"invalid-email\" }";

        ObjectMapper mapper = new ObjectMapper();
        JsonSchema schema = JsonSchemaFactory.byDefault().getJsonSchema(mapper.readTree(schemaJson));

        validateEmail(schema, mapper.readTree(validJson));
        validateEmail(schema, mapper.readTree(invalidJson));
    }

    public static void validateEmail(JsonSchema schema, JsonNode json) throws Exception {
        ProcessingReport report = schema.validate(json);
        System.out.println(report.isSuccess() ? "✅ Valid: " + json : "❌ Invalid: " + report);
    }
}
