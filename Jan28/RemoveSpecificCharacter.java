package Jan28;
import java.util.Scanner;
public class RemoveSpecificCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter the character to remove: ");
        char charToRemove = scanner.next().charAt(0);
        scanner.close();

        String result = input.replaceAll(String.valueOf(charToRemove), "");
        
        System.out.println("Modified String: " + result);
    }
}

