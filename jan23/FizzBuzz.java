import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            String[] results = fizzBuzz(n);

            for (int i = 0; i < n; i++) {
                System.out.println("Position " + (i + 1) + " = " + results[i]);
            }
        }
    }

    public static String[] fizzBuzz(int n) {
        String[] results = new String[n];

        for (int i = 0; i < n; i++) {
            int num = i + 1; 
            if (num % 3 == 0 && num % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (num % 3 == 0) {
                results[i] = "Fizz";
            } else if (num % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(num);
            }
        }

        return results;
    }
}