package Feb22;

import java.lang.reflect.Method;
import java.util.Scanner;

// Step 1: Define MathOperations Class with Multiple Methods
class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

// Step 2: Use Reflection to Dynamically Invoke Methods
public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Get user input for method name and parameters
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Step 3: Get Class and Method
            Class<?> clazz = MathOperations.class;
            Method method = clazz.getMethod(methodName, int.class, int.class);

            // Step 4: Create Object and Invoke Method Dynamically
            MathOperations mathObj = new MathOperations();
            int result = (int) method.invoke(mathObj, num1, num2);

            // Print the result
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
