package Jan28;

import java.util.Scanner;

public class FactorialRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to calculate its factorial:");
        int num = scanner.nextInt();
        
        long result = factorial(num);
        System.out.println("The factorial of " + num + " is: " + result);
    }
    
    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}

