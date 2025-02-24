package Feb22;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

// Step 2: Create a User class to simulate user roles
class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Step 3: Create a SecureService class with restricted methods
class SecureService {
    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task executed successfully.");
    }

    @RoleAllowed("USER")
    public void performUserTask() {
        System.out.println("User task executed successfully.");
    }
}

// Step 4: Create a Utility Class for Role-Based Access Control
class AccessControl {
    public static void invokeMethod(User user, Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (roleAllowed.value().equals(user.getRole())) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied! User role '" + user.getRole() + "' is not allowed to execute '" + methodName + "'.");
                }
            } else {
                method.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Step 5: Test Role-Based Access Control
public class RoleBasedAccessControl {
    public static void main(String[] args) {
        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        SecureService service = new SecureService();

        System.out.println("Attempting to perform admin task:");
        AccessControl.invokeMethod(adminUser, service, "performAdminTask"); // Should succeed

        System.out.println("\nAttempting to perform admin task with a normal user:");
        AccessControl.invokeMethod(normalUser, service, "performAdminTask"); // Should deny access

        System.out.println("\nAttempting to perform user task:");
        AccessControl.invokeMethod(normalUser, service, "performUserTask"); // Should succeed

        System.out.println("\nAttempting to perform user task with an admin:");
        AccessControl.invokeMethod(adminUser, service, "performUserTask"); // Should succeed
    }
}

