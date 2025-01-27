package Jan27;

import java.util.Scanner;

public class RecursiveSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        scanner.close();

        if (n <= 0) {
            System.out.println("Invalid input. Please enter a natural number.");
            return;
        }

        int recursiveSum = sumOfNaturalNumbersRecursive(n);
        int formulaSum = sumOfNaturalNumbersFormula(n);

        System.out.println("Recursive sum: " + recursiveSum);
        System.out.println("Formula sum: " + formulaSum);

        if (recursiveSum == formulaSum) {
            System.out.println("Both results are correct.");
        } else {
            System.out.println("Results do not match.");
        }
    }

    public static int sumOfNaturalNumbersRecursive(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumOfNaturalNumbersRecursive(n - 1);
        }
    }

    public static int sumOfNaturalNumbersFormula(int n) {
        return (n * (n + 1)) / 2;
    }
}
