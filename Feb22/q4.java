package Feb22;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Step 2: Apply the annotation in TaskManager class
class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Rajeev")
    public void completeTask() {
        System.out.println("Task is being completed.");
    }
}

// Step 3: Retrieve annotation details using Reflection API
public class q4{
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Task Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }

        // Calling the annotated method
        TaskManager manager = new TaskManager();
        manager.completeTask();
    }
}
