package Jan28;

import java.util.Scanner;

public class MaxOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three integers:");
        int num1 = getInput(scanner);
        int num2 = getInput(scanner);
        int num3 = getInput(scanner);
        
        int max = findMax(num1, num2, num3);
        System.out.println("The maximum number is: " + max);
    }
    
    private static int getInput(Scanner scanner) {
        return scanner.nextInt();
    }
    
    private static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}

