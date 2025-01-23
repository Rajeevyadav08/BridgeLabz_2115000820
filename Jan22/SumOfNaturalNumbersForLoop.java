import java.util.Scanner;
public class SumOfNaturalNumbersForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        scanner.close();
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        int sumFormula = (n * (n + 1)) / 2;
        int sumForLoop = 0;
        for (int i = 1; i <= n; i++) {
            sumForLoop += i;
        }
        if (sumFormula == sumForLoop) {
            System.out.println("Both methods produce the same result: " + sumFormula);
        } else {
            System.out.println("Error: Results do not match.");
        }
    }
}