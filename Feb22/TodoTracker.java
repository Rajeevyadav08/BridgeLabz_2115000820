package Feb22;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @Todo annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// Step 2: Apply the annotation to multiple methods in a meaningful class
class TaskManager {
    @Todo(task = "Implement user authentication", assignedTo = "Rajeev", priority = "HIGH")
    public void implementAuthentication() {
        System.out.println("Authenticating user...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Amit")
    public void optimizeDatabase() {
        System.out.println("Optimizing database queries...");
    }

    @Todo(task = "Improve UI responsiveness", assignedTo = "Sneha", priority = "LOW")
    public void enhanceUserInterface() {
        System.out.println("Improving UI responsiveness...");
    }
}

// Step 3: Retrieve and print all pending tasks using Reflection
public class TodoTracker {
    public static void main(String[] args) throws Exception {
        Method[] methods = TaskManager.class.getDeclaredMethods();

        System.out.println("Pending Tasks:");
        System.out.println("---------------------------------------------------");

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("---------------------------------------------------");
            }
        }

        // Calling the methods
        TaskManager taskManager = new TaskManager();
        taskManager.implementAuthentication();
        taskManager.optimizeDatabase();
        taskManager.enhanceUserInterface();
    }
}
