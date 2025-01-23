import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();
        int originalNumber = number;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10; 
            int cube = digit * digit * digit; 
            sum += cube; 
            number /= 10; 
        }
        if (originalNumber == sum) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
    }
}