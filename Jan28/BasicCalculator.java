package Jan28;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        
        System.out.println("Choose an operation: +, -, *, /");
        char operation = scanner.next().charAt(0);
        
        double result = 0;
        boolean validOperation = true;
        
        switch (operation) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                if (num2 != 0) {
                    result = divide(num1, num2);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Invalid operation. Please choose +, -, *, or /.");
                validOperation = false;
        }
        
        if (validOperation) {
            System.out.println("Result: " + result);
        }
    }
    
    private static double add(double a, double b) {
        return a + b;
    }
    
    private static double subtract(double a, double b) {
        return a - b;
    }
    
    private static double multiply(double a, double b) {
        return a * b;
    }
    
    private static double divide(double a, double b) {
        return a / b;
    }
}

