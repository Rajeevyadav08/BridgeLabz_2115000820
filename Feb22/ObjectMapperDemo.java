package Feb22;

import java.lang.reflect.Field;
import java.util.Map;

// Step 1: Define a Sample Class
class User {
    private String name;
    private int age;
    private boolean isActive;

    public User() {} // Default constructor required

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", isActive=" + isActive + "}";
    }
}

// Step 2: Implement a Custom Object Mapper
class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance(); // Create a new instance

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                Field field;
                try {
                    field = clazz.getDeclaredField(entry.getKey());
                } catch (NoSuchFieldException e) {
                    continue; // Ignore fields not present in class
                }

                field.setAccessible(true); // Allow access to private fields
                field.set(instance, convertValue(entry.getValue(), field.getType())); // Set field value
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to map properties to object", e);
        }
    }

    private static Object convertValue(Object value, Class<?> targetType) {
        if (value == null) return null;
        if (targetType.isAssignableFrom(value.getClass())) return value;

        if (targetType == int.class || targetType == Integer.class) return Integer.parseInt(value.toString());
        if (targetType == boolean.class || targetType == Boolean.class) return Boolean.parseBoolean(value.toString());
        if (targetType == double.class || targetType == Double.class) return Double.parseDouble(value.toString());
        if (targetType == long.class || targetType == Long.class) return Long.parseLong(value.toString());

        return value; // Fallback for unsupported types
    }
}

// Step 3: Test the Object Mapping
import java.util.HashMap;

public class ObjectMapperDemo {
    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Alice");
        data.put("age", 25);
        data.put("isActive", "true"); // String, but should be converted to boolean

        User user = ObjectMapper.toObject(User.class, data);
        System.out.println(user);
    }
}

