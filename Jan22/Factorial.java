import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();
        scanner.close();
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return;
        }
        int factorial = 1; 
        int i = 1; 
        while (i <= number) {
            factorial *= i; 
            i++; 
        }
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}