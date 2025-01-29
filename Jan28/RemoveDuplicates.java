package Jan28;

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        String result = "";
        boolean[] seen = new boolean[256];

        for (char ch : input.toCharArray()) {
            if (!seen[ch]) {
                result += ch;
                seen[ch] = true;
            }
        }

        System.out.println("String after removing duplicates: " + result);
    }
}
