/*Write a program to convert the complete text to lowercase and compare the results
Hint => 
Take user input using the  Scanner nextLine() method to take the complete text into a String variable
Write a method using the String built-in charAt() method to convert each character if it is uppercase to the lowercase. Use the logic ASCII value of 'a' is 97 and 'A' is 65 so the difference is 32, similarly ASCII value of 'b' is 98 and 'B' is 66 so the difference is 32, and so on
Write a method to compare two strings using the charAt() method and return a boolean result
In the main() use the String built-in method toLowerCase() to get the lowercase text and compare the two strings using the user-defined method. And finally display the result
*/

import java.util.Scanner;

public class LowercaseConversionComparison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take complete text input
        System.out.print("Enter some text: ");
        String input = scanner.nextLine();

        // Convert using user-defined method
        String customLowercase = convertToLowerUsingCharAt(input);

        // Convert using built-in method
        String builtInLowercase = input.toLowerCase();

        // Display both results
        System.out.println("Custom lowercase conversion: " + customLowercase);
        System.out.println("Built-in toLowerCase(): " + builtInLowercase);

        // Compare the two results using custom compare method
        boolean isEqual = compareStringsUsingCharAt(customLowercase, builtInLowercase);

        // Display comparison result
        System.out.println("Are both lowercase strings equal? " + isEqual);
    }

    // Convert to lowercase using charAt() and ASCII manipulation
    public static String convertToLowerUsingCharAt(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Check if char is uppercase A-Z (ASCII 65 to 90)
            if (ch >= 'A' && ch <= 'Z') {
                // Convert to lowercase by adding 32
                ch = (char) (ch + 32);
            }
            result.append(ch);
        }

        return result.toString();
    }

    // Compare two strings using charAt()
    public static boolean compareStringsUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }

        return true;
    }
}
