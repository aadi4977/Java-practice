/*Write a program to find the first non-repeating character in a string and show the result
Hint => 
Non-repeating character is a character that occurs only once in the string
Create a Method to find the first non-repeating character in a string using the charAt() method and return the character. The logic used here is as follows:
Create an array to store the frequency of characters in the text. ASCII values of characters are used as indexes in the array to store the frequency of each character. There are 256 ASCII characters
Loop through the text to find the frequency of characters in the text
Loop through the text to find the first non-repeating character in the text by checking the frequency of each character
In the main function take user inputs, call user-defined methods, and displays result. 
*/

import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find first non-repeating character
        char result = findFirstNonRepeatingChar(input);

        if (result != 0) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }

    public static char findFirstNonRepeatingChar(String s) {
        int[] freq = new int[256];  // frequency array for all ASCII chars

        int len = findStringLength(s);

        // Count frequency of each character
        for (int i = 0; i < len; i++) {
            freq[s.charAt(i)]++;
        }

        // Find first character with frequency 1
        for (int i = 0; i < len; i++) {
            if (freq[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }

        // Return 0 char if none found
        return 0;
    }

    // Find length without using length()
    public static int findStringLength(String s) {
        int count = 0;
        while (true) {
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
