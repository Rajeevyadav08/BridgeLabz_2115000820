package Jan27;

import java.util.Arrays;

public class NumberChecker1 {

    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static int[] storeDigits(int number) {
        int digitCount = countDigits(number);
        int[] digits = new int[digitCount];
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int sumOfDigits(int number) {
        int[] digits = storeDigits(number);
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int number) {
        int[] digits = storeDigits(number);
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number) {
        int sumOfDigits = sumOfDigits(number);
        return number % sumOfDigits == 0;
    }

    public static int[][] findDigitFrequencies(int number) {
        int[] digits = storeDigits(number);
        int[][] frequencies = new int[10][2]; // 10 digits (0-9), 2 columns (digit, frequency)

        for (int i = 0; i < 10; i++) {
            frequencies[i][0] = i; // Initialize digit column
        }

        for (int digit : digits) {
            frequencies[digit][1]++; // Increment frequency of the digit
        }

        return frequencies;
    }

    public static void main(String[] args) {
        int number = 153; // Example number

        System.out.println("Number of digits: " + countDigits(number));
        System.out.println("Sum of digits: " + sumOfDigits(number));
        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(number));

        if (isHarshadNumber(number)) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is not a Harshad Number.");
        }

        int[][] digitFrequencies = findDigitFrequencies(number);
        System.out.println("Digit Frequencies:");
        for (int[] row : digitFrequencies) {
            System.out.println(Arrays.toString(row));
        }
    }
}
