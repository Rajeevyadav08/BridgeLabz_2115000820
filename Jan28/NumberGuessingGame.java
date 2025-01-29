package Jan28;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Think of a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
        playGame();
    }

    private static void playGame() {
        int low = LOWER_BOUND;
        int high = UPPER_BOUND;
        int guess;
        String feedback;

        while (true) {
            guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct')");
            feedback = getUserFeedback();

            if (feedback.equals("correct")) {
                System.out.println("Great! The computer guessed your number.");
                break;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }

            if (low > high) {
                System.out.println("Hmm, something went wrong. Please restart the game and provide correct feedback.");
                break;
            }
        }
    }

    private static int generateGuess(int low, int high) {
        return low + random.nextInt(high - low + 1);
    }

    private static String getUserFeedback() {
        String feedback;
        while (true) {
            feedback = scanner.next().toLowerCase();
            if (feedback.equals("high") || feedback.equals("low") || feedback.equals("correct")) {
                return feedback;
            }
            System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
        }
    }
}

