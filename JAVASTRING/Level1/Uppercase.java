/*Write a program to convert the complete text to uppercase and compare the results
Hint => 
Take user input using the  Scanner nextLine() method to take the complete text into a String variable
Write a method using the String built-in charAt() method to convert each character if it is lowercase to the uppercase. Use the logic ASCII value of 'a' is 97 and 'A' is 65 so the difference is 32, similarly ASCII value of 'b' is 98 and 'B' is 66 so the difference is 32, and so on
Write a method to compare two strings using the charAt() method and return a boolean result
In the main() use the String built-in method toUpperCase() to get the uppercase text and compare the two strings using the user-defined method. And finally display the result
*/


import java.util.Scanner;

public class UppercaseConversionComparison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take complete text input
        System.out.print("Enter some text: ");
        String input = scanner.nextLine();

        // Convert using user-defined method
        String customUppercase = convertToUpperUsingCharAt(input);

        // Convert using built-in method
        String builtInUppercase = input.toUpperCase();

        // Display both results
        System.out.println("Custom uppercase conversion: " + customUppercase);
        System.out.println("Built-in toUpperCase(): " + builtInUppercase);

        // Compare the two results using a custom compare method
        boolean isEqual = compareStringsUsingCharAt(customUppercase, builtInUppercase);

        // Display comparison result
        System.out.println("Are both uppercase strings equal? " + isEqual);
    }

    // Convert to uppercase using charAt() and ASCII manipulation
    public static String convertToUpperUsingCharAt(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Check if char is lowercase a-z (ASCII 97 to 122)
            if (ch >= 'a' && ch <= 'z') {
                // Convert to uppercase by subtracting 32
                ch = (char) (ch - 32);
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
