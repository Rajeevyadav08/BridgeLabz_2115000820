package Feb22;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

// Step 2: Apply the annotation to multiple methods
class Service {
    @ImportantMethod
    public void criticalOperation() {
        System.out.println("Executing critical operation...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void importantTask() {
        System.out.println("Executing important task...");
    }

    public void normalTask() {
        System.out.println("Executing normal task...");
    }
}

// Step 3: Retrieve and print annotated methods using Reflection API
public class q6 {
    public static void main(String[] args) throws Exception {
        Method[] methods = Service.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + " | Importance Level: " + annotation.level());
            }
        }

        // Calling the methods
        Service service = new Service();
        service.criticalOperation();
        service.importantTask();
        service.normalTask();
    }
}
