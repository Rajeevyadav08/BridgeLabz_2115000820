import java.util.Scanner;
public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        System.out.println("Odd Numbers:");
        for (int i = 1; i <= number; i++) {
            if (i % 2 != 0) { 
                System.out.print(i + " "); 
            }
        }
        System.out.println();
        System.out.println("Even Numbers:");
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) { 
                System.out.print(i + " "); 
            }
        }
        System.out.println();
    }
}