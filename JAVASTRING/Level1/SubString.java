
/* Write a program to create a substring from a String using the charAt() method. Also, use the String built-in method substring() to find the substring of the text. Finally Compare the the two strings and display the results
Hint => 
Take user input using the  Scanner next() method to take the String variable and also the start and the end index to get the substring from the given text
Write a method to create a substring from a string using the charAt() method with the string, start, and end index as the parameters
Write a method to compare two strings using the charAt() method and return a boolean result
Use the String built-in method substring() to get the substring and compare the two strings. And finally display the result
*/

import java.util.Scanner;

public class SubstringComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input original string
        System.out.print("Enter the original string: ");
        String original = scanner.next();

        // Input start and end indices for substring
        System.out.print("Enter the start index (inclusive): ");
        int start = scanner.nextInt();

        System.out.print("Enter the end index (exclusive): ");
        int end = scanner.nextInt();

        // Validate indices (basic)
        if (start < 0 || end > original.length() || start > end) {
            System.out.println("Invalid indices. Please ensure 0 <= start <= end <= length.");
            return;
        }

        // Create substring using charAt() method
        String charAtSubstring = createSubstringUsingCharAt(original, start, end);

        // Create substring using built-in substring() method
        String builtInSubstring = original.substring(start, end);

        // Display both substrings
        System.out.println("Substring using charAt(): " + charAtSubstring);
        System.out.println("Substring using built-in substring(): " + builtInSubstring);

        // Compare both substrings using charAt comparison method
        boolean areEqual = compareUsingCharAt(charAtSubstring, builtInSubstring);

        // Display comparison result
        System.out.println("Are both substrings equal? " + areEqual);
    }

    // Method to construct substring using charAt
    public static String createSubstringUsingCharAt(String s, int start, int end) {
        StringBuilder substring = new StringBuilder();

        for (int i = start; i < end; i++) {
            substring.append(s.charAt(i));
        }

        return substring.toString();
    }

    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}
