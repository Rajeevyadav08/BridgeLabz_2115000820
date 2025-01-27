package Jan27;
import java.util.Scanner;

public class QuotientAndRemainder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dividend: ");
        int dividend = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        int[] result = findRemainderAndQuotient(dividend, divisor);

        System.out.println("Quotient: " + result[0]);
        System.out.println("Remainder: " + result[1]);

        scanner.close();
    }

    public static int[] findRemainderAndQuotient(int dividend, int divisor) {
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        int[] result = {quotient, remainder};
        return result;
    }
}