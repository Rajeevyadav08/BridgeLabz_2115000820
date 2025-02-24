package Feb22;

import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class PrivateMethodInvoker {
    public static void main(String[] args) {
        try {
            // Create an instance of Calculator
            Calculator calculator = new Calculator();

            // Get the private method "multiply" using Reflection
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true); // Bypass access restrictions

            // Invoke the private method
            int result = (int) multiplyMethod.invoke(calculator, 5, 4);

            // Display the result
            System.out.println("Result of multiplication: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
