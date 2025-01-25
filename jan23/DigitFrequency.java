import java.util.Scanner;

public class DigitFrequency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] frequency = findDigitFrequencies(number);

        System.out.println("Frequency of each digit:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Digit " + i + ": " + frequency[i]);
        }
    }

    public static int[] findDigitFrequencies(int number) {
        int[] frequency = new int[10];

        while (number > 0) {
            int digit = number % 10;
            frequency[digit]++;
            number /= 10;
        }

        return frequency;
    }
}