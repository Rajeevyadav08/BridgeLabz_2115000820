package Feb13;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] ages = new int[n];
        System.out.println("Enter the ages of the students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
            if (ages[i] < 10 || ages[i] > 18) {
                System.out.println("Invalid age! Please enter an age between 10 and 18.");
                i--;
            }
        }

        countingSort(ages, 10, 18);

        System.out.println("Sorted Ages: " + Arrays.toString(ages));

        scanner.close();
    }

    public static void countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Count the occurrences of each age
        for (int age : arr) {
            count[age - min]++;
        }

        // Compute cumulative frequency
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in the correct position
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy sorted array back to the original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
