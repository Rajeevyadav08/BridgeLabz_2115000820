package Feb22;

import java.lang.annotation.*;
import java.lang.reflect.Field;

// Step 1: Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// Step 2: Create the User class with validation logic
class User {
    @MaxLength(10) // Restrict username to a maximum of 10 characters
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    private void validateMaxLength(String username) {
        try {
            Field field = User.class.getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                int maxLength = annotation.value();
                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength + " characters");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

// Step 3: Test the validation logic
public class MaxLengthValidator {
    public static void main(String[] args) {
        try {
            User user1 = new User("Rajeev"); // Valid username
            System.out.println("User1 created with username: " + user1.getUsername());

            User user2 = new User("VeryLongUsername"); // Exceeds max length
            System.out.println("User2 created with username: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}
