import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static int generateGuess(int low, int high) {
        return low + random.nextInt(high - low + 1);
    }

    static String getUserFeedback(int guess) {
        System.out.println("Is your number " + guess + "? (high/low/correct): ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        int low = 1, high = 100;
        String feedback = "";
        System.out.println("Think of a number between 1 and 100.");

        while (!feedback.equals("correct")) {
            int guess = generateGuess(low, high);
            feedback = getUserFeedback(guess);
            if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }
        }
        System.out.println("Hooray! I guessed your number.");
    }
}
