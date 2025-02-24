package Feb22;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @Inject Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

// Step 2: Create Service Classes (Dependencies)
class ServiceA {
    public void doSomething() {
        System.out.println("ServiceA is doing something...");
    }
}

class ServiceB {
    public void doSomething() {
        System.out.println("ServiceB is performing an action...");
    }
}

// Step 3: Define a Class That Needs Dependencies
class Consumer {
    @Inject
    private ServiceA serviceA;

    @Inject
    private ServiceB serviceB;

    public void execute() {
        serviceA.doSomething();
        serviceB.doSomething();
    }
}

// Step 4: Implement a Simple DI Container
class DIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public DIContainer() {
        // Pre-register dependencies (simulating component scanning)
        instances.put(ServiceA.class, new ServiceA());
        instances.put(ServiceB.class, new ServiceB());
    }

    public void injectDependencies(Object object) {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true); // Allow access to private fields
                try {
                    // Inject instance from the container
                    field.set(object, instances.get(field.getType()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

// Step 5: Demonstrate Dependency Injection
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();

        // Create Consumer instance (without manually setting dependencies)
        Consumer consumer = new Consumer();

        // Inject dependencies dynamically
        container.injectDependencies(consumer);

        // Execute the method to see if dependencies are injected correctly
        consumer.execute();
    }
}
