import java.util.Scanner;

public class ArrayInputSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10]; 
        double total = 0.0;
        int index = 0;

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double input = scanner.nextDouble();

            if (input <= 0) {
                break;
            }

            if (index >= 10) {
                System.out.println("Array limit reached.");
                break; 
            }

            numbers[index++] = input; 
        }
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }
        System.out.print("Entered numbers: ");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.println("Sum of numbers: " + total);
    }
}