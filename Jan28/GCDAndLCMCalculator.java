package Jan28;

import java.util.Scanner;

public class GCDAndLCMCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers to calculate their GCD and LCM:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);
        
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("The LCM of " + num1 + " and " + num2 + " is: " + lcm);
    }
    
    private static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }
    
    private static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}
