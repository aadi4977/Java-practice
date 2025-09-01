/*Write a program to compare two strings using the charAt() method and check the result with the built-in String equals() method
Hint => 
Take user input using the  Scanner next() method for 2 String variables
Write a method to compare two strings using the charAt() method and return a boolean result
Use the String Built-In method to check if the results are the same and display the result 
*/


import java.util.Scanner;

public class StrComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take two string inputs
        System.out.print("Enter first string: ");
        String str1 = scanner.next();

        System.out.print("Enter second string: ");
        String str2 = scanner.next();

        // Compare using custom charAt method
        boolean charAtComparison = compareUsingCharAt(str1, str2);

        // Compare using built-in equals method
        boolean equalsComparison = str1.equals(str2);

        // Display results
        System.out.println("\nComparison using charAt(): " + charAtComparison);
        System.out.println("Comparison using equals(): " + equalsComparison);

        // Check if both methods produce the same result
        if (charAtComparison == equalsComparison) {
            System.out.println("Both methods yield the same result.");
        } else {
            System.out.println("Results from both methods differ.");
        }
    }

    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {
        // If lengths differ, strings are different
        if (s1.length() != s2.length()) {
            return false;
        }

        // Compare each character
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
