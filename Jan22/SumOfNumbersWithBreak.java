import java.util.Scanner;
public class SumOfNumbersWithBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double number;
        while (true) { 
            System.out.print("Enter a number (enter 0 or a negative number to stop): ");
            number = scanner.nextDouble();
            if (number <= 0) { 
                break; 
            }
            total += number; 
        }
        scanner.close();
        System.out.println("Sum of entered numbers: " + total);
    }
}