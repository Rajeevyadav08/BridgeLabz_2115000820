import java.util.Scanner;
public class HarshadNumber {
    public static boolean isHarshadNumber(int number) {
        if (number <= 0) {
            return false; // Handle non-positive numbers
        }
        int originalNumber = number;
        int sumOfDigits = 0;
        while (number > 0) {
            int digit = number % 10; 
            sumOfDigits += digit;
            number /= 10; 
        }
        return originalNumber % sumOfDigits == 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();
        if (isHarshadNumber(number)) {
            System.out.println(number + " is a Harshad number.");
        } else {
            System.out.println(number + " is not a Harshad number.");
        }
    }
}