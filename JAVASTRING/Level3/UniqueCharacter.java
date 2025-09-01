/*Find unique characters in a string using the charAt() method and display the result
Hint => 
Create a Method to find the length of the text without using the String method length()
Create a method to Find unique characters in a string using the charAt() method and return them as a 1D array. The logic used here is as follows:
Create an array to store the unique characters in the text. The size is the length of the text
Loops to Find the unique characters in the text. Find the unique characters in the text using a nested loop. An outer loop iterates through each character and an inner loop checks if the character is unique by comparing it with the previous characters. If the character is unique, it is stored in the result array
Create a new array to store the unique characters 
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result
*/

import java.util.Scanner;

public class UniqueCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find unique characters
        char[] uniqueChars = findUniqueCharacters(input);

        // Display unique characters
        System.out.print("Unique characters: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // Find length of string without length()
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

    // Find unique characters using charAt() and nested loop
    public static char[] findUniqueCharacters(String s) {
        int len = findStringLength(s);
        char[] unique = new char[len];  // max possible unique is length of string
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            boolean isUnique = true;

            // Check if currentChar appeared before in unique array
            for (int j = 0; j < uniqueCount; j++) {
                if (unique[j] == currentChar) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        // Create new array with exact size to return
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }

        return result;
    }
}
