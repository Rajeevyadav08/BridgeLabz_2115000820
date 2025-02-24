package Feb22;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// Step 2: Create a User class with annotated fields
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    public User(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }
}

// Step 3: Implement the JSON Serialization Utility
class JsonSerializer {
    public static String serialize(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, String> jsonMap = new HashMap<>();

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);

                if (field.isAnnotationPresent(JsonField.class)) {
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    String key = annotation.name();
                    String value = field.get(obj).toString();
                    jsonMap.put(key, "\"" + value + "\"");
                }
            }

            // Convert map to JSON string
            StringBuilder jsonString = new StringBuilder("{");
            jsonMap.forEach((key, value) -> jsonString.append("\"").append(key).append("\": ").append(value).append(", "));
            
            if (jsonString.length() > 1) {
                jsonString.setLength(jsonString.length() - 2); // Remove trailing comma
            }
            
            jsonString.append("}");
            return jsonString.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }
}

// Step 4: Test JSON Serialization
public class JsonFieldSerializer {
    public static void main(String[] args) {
        User user = new User("Rajeev", 25, "rajeev@example.com");
        String json = JsonSerializer.serialize(user);
        System.out.println(json);
    }
}
