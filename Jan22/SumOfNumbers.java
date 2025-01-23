import java.util.Scanner;
public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double number;
        do {
            System.out.print("Enter a number (enter 0 to stop): ");
            number = scanner.nextDouble();
            total += number; 
        } while (number != 0);
        scanner.close();
        System.out.println("Sum of entered numbers: " + total);
    }
}