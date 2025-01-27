package Jan27;

import java.util.Scanner;

public class NumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int result = checkNumber(number);

        if (result == -1) {
            System.out.println("The number is negative.");
        } else if (result == 1) {
            System.out.println("The number is positive.");
        } else {
            System.out.println("The number is zero.");
        }

        scanner.close();
    }

    public static int checkNumber(int number) {
        if (number < 0) {
            return -1; // Negative
        } else if (number > 0) {
            return 1; // Positive
        } else {
            return 0; // Zero
        }
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSmallestAndSecondSmallest'");
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findLargestAndSecondLargest'");
    }

    public static int countDigits(int number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countDigits'");
    }

    public static int[] storeDigits(int number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'storeDigits'");
    }

    public static boolean isDuckNumber(int number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isDuckNumber'");
    }

    public static boolean isArmstrongNumber(int number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isArmstrongNumber'");
    }
}