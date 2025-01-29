package Jan28;
import java.util.Scanner;
public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        int[] freq = new int[256];
        char maxChar = input.charAt(0);
        int maxCount = 0;
        for (char ch : input.toCharArray()) {
            freq[ch]++;
            if (freq[ch] > maxCount) {
                maxCount = freq[ch];
                maxChar = ch;
            }
        }
        System.out.println("Most Frequent Character: '" + maxChar + "'");
    }
}
