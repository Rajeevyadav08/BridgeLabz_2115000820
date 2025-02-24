package Feb22;

import java.lang.reflect.Method;

class MathOperations {
    public void slowMethod() {
        try {
            Thread.sleep(500); // Simulating a slow method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fastMethod() {
        for (int i = 0; i < 1000; i++) {} // Fast execution
    }
}

public class MethodExecutionTimer {
    public static void main(String[] args) {
        try {
            // Create an instance of the target class
            MathOperations obj = new MathOperations();
            Class<?> clazz = obj.getClass();

            // Iterate through all methods
            for (Method method : clazz.getDeclaredMethods()) {
                // Measure execution time
                long startTime = System.nanoTime();
                method.invoke(obj); // Invoke the method dynamically
                long endTime = System.nanoTime();

                // Calculate and print execution time
                long executionTime = endTime - startTime;
                System.out.println(method.getName() + " executed in " + executionTime + " nanoseconds.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
