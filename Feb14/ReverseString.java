package Feb14;

import java.util.Scanner;
public class ReverseString {
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println("Reversed string: " + reverseString(input));
        scanner.close();
    }
}
