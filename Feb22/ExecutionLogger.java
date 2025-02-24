package Feb22;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

// Step 2: Create a Utility Class to Handle Logging
class ExecutionTimer {
    public static void logExecutionTime(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);

        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;

            System.out.println("Execution Time of " + methodName + ": " + executionTime + " nanoseconds");
        }
    }
}

// Step 3: Create a class with methods using @LogExecutionTime
class PerformanceTester {
    @LogExecutionTime
    public void processData() {
        for (int i = 0; i < 1_000_000; i++) {} // Simulating processing
    }

    @LogExecutionTime
    public void computeLargeTask() {
        for (int i = 0; i < 10_000_000; i++) {} // Simulating a heavier task
    }
}

// Step 4: Apply Annotation and Compare Execution Time
public class ExecutionLogger {
    public static void main(String[] args) throws Exception {
        PerformanceTester tester = new PerformanceTester();

        ExecutionTimer.logExecutionTime(tester, "processData");
        ExecutionTimer.logExecutionTime(tester, "computeLargeTask");
    }
}
