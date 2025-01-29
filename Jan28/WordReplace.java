package Jan28;
import java.util.Scanner;
public class WordReplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        System.out.print("Enter the word to be replaced: ");
        String wordToReplace = scanner.nextLine();
        System.out.print("Enter the word to replace with: ");
        String replacementWord = scanner.nextLine();
        scanner.close();
        String modifiedSentence = replaceWord(sentence, wordToReplace, replacementWord);
        System.out.println("Modified Sentence: " + modifiedSentence);
    }
    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
        String[] words = sentence.split("\\s+");
        StringBuilder modifiedSentence = new StringBuilder();
        for (String word : words) {
            if (word.equals(wordToReplace)) {
                modifiedSentence.append(replacementWord).append(" ");
            } else {
                modifiedSentence.append(word).append(" ");
            }
        }
        return modifiedSentence.toString().trim();
    }
}

