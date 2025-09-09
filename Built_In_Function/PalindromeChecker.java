import java.util.Scanner;

public class PalindromeChecker {
    static Scanner scanner = new Scanner(System.in);

    static String getInput() {
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    static boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    static void displayResult(boolean res) {
        System.out.println(res ? "It is a palindrome." : "It is not a palindrome.");
    }

    public static void main(String[] args) {
        String input = getInput();
        boolean res = isPalindrome(input);
        displayResult(res);
    }
}
