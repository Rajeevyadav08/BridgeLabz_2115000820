package Feb22;

import java.lang.reflect.Field;

// Step 1: Define Configuration Class with a Private Static Field
class Configuration {
    private static String API_KEY = "ORIGINAL-SECRET-KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

// Step 2: Use Reflection to Modify Private Static Field
public class ReflectionModifyStaticField {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Configuration.class;
            Field apiKeyField = clazz.getDeclaredField("API_KEY");

            apiKeyField.setAccessible(true); // Allow modification of private fields

            // Modify the static field's value
            apiKeyField.set(null, "MODIFIED-SECRET-KEY");

            // Print updated value
            System.out.println("Updated API_KEY: " + Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
