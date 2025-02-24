package Feb22;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define a Sample Class
class User {
    private String name;
    private int age;
    private boolean isActive;

    public User(String name, int age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }
}

// Step 2: Implement a JSON Serializer Using Reflection
class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, String> jsonMap = new HashMap<>();

            // Iterate through all fields of the object
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true); // Allow access to private fields
                Object value = field.get(obj);
                jsonMap.put(field.getName(), formatValue(value));
            }

            // Convert Map to JSON-like string
            return jsonMap.toString().replace("=", ": ");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "{}";
        }
    }

    private static String formatValue(Object value) {
        if (value instanceof String) {
            return "\"" + value + "\""; // Wrap Strings in quotes
        }
        return value.toString();
    }
}

// Step 3: Test the JSON Serialization
public class JsonReflectionDemo {
    public static void main(String[] args) {
        User user = new User("Alice", 25, true);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
