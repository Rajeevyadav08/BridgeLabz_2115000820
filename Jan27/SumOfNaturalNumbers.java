package Jan27;

import java.util.Scanner;
public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        int sum = calculateSum(n);

        System.out.println("Sum of first " + n + " natural numbers: " + sum);

        scanner.close();
    }
    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
