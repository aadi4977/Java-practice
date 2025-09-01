/*Write a program to trim the leading and trailing spaces from a string using the charAt() method 
Hint => 
Create a method to trim the leading and trailing spaces from a string using the charAt() method. Inside the method run a couple of loops to trim leading and trailing spaces and determine the starting and ending points with no spaces. Return the start point and end point in an array
Write a method to create a substring from a string using the charAt() method with the string, start, and end index as the parameters
Write a method to compare two strings using the charAt() method and return a boolean result
The main function calls the user-defined trim and substring methods to get the text after trimming the leading and trailing spaces. Post that use the String built-in method trim() to trim spaces and compare the two strings. And finally display the result
*/

import java.util.Scanner;

public class Trim {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string with possible leading/trailing spaces
        System.out.print("Enter a string (may have leading/trailing spaces): ");
        String input = scanner.nextLine();

        // Get start and end index after trimming using user-defined method
        int[] trimmedBounds = trimSpacesUsingCharAt(input);

        // Extract trimmed substring manually
        String customTrimmed = substringByCharAt(input, trimmedBounds[0], trimmedBounds[1] + 1);

        // Trim using built-in method
        String builtInTrimmed = input.trim();

        // Display both results
        System.out.println("Custom trimmed string: \"" + customTrimmed + "\"");
        System.out.println("Built-in trimmed string: \"" + builtInTrimmed + "\"");

        // Compare the two trimmed strings
        boolean areEqual = compareStringsUsingCharAt(customTrimmed, builtInTrimmed);
        System.out.println("Are both trimmed strings equal? " + areEqual);
    }

    // Method to find starting and ending indices without spaces
    public static int[] trimSpacesUsingCharAt(String s) {
        int len = findStringLength(s);
        int start = 0;
        int end = len - 1;

        // Find first non-space from start
        while (start < len && s.charAt(start) == ' ') {
            start++;
        }

        // Find last non-space from end
        while (end >= start && s.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Extract substring manually
    public static String substringByCharAt(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Compare strings manually
    public static boolean compareStringsUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }

        return true;
    }

    // Find string length without using length()
    public static int findStringLength(String s) {
        int count = 0;
        while(true) {
            try {
                s.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }
}
