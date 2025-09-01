/*Write a program to find the frequency of characters in a string using unique characters and display the result
Hint => 
Create a method to Find unique characters in a string using the charAt() method and return them as a 1D array.  Use Nested Loops to find the unique characters in the text
Create a method to find the frequency of characters in a string and return the characters and their frequencies in a 2D array. The logic used here is as follows:
Create an array to store the frequency of characters in the text. ASCII values of characters are used as indexes in the array to store the frequency of each character. There are 256 ASCII characters
Loop through the text to find the frequency of characters in the text
Call the uniqueCharacters() method to find the unique characters in the text
Create a 2D String array to store the unique characters and their frequencies. 
Loop through the unique characters and store the characters and their frequencies
In the main function take user inputs, call user-defined methods, and displays result. 
*/

import java.util.Scanner;

public class Frequency2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find unique characters
        char[] uniqueChars = uniqueCharacters(input);

        // Find frequency of each unique character
        String[][] freqData = frequencyOfUniqueChars(input, uniqueChars);

        // Display the results
        System.out.println("Character\tFrequency");
        System.out.println("-------------------------");
        for (String[] row : freqData) {
            System.out.printf("%-10s\t%s\n", row[0], row[1]);
        }
    }

    // Find length of string without length()
    public static int findStringLength(String s) {
        int len = 0;
        while (true) {
            try {
                s.charAt(len);
                len++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return len;
    }

    // Find unique characters using nested loops and charAt()
    public static char[] uniqueCharacters(String s) {
        int len = findStringLength(s);
        char[] temp = new char[len];
        int count = 0;

        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            boolean found = false;

            // Check if curr already in temp array
            for (int j = 0; j < count; j++) {
                if (temp[j] == curr) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                temp[count] = curr;
                count++;
            }
        }

        // Copy unique chars into exact-sized array
        char[] uniqueChars = new char[count];
        for (int i = 0; i < count; i++) {
            uniqueChars[i] = temp[i];
        }
        return uniqueChars;
    }

    // Calculate frequency of unique chars and return 2D String array
    public static String[][] frequencyOfUniqueChars(String s, char[] uniqueChars) {
        int[] freq = new int[256];  // ASCII frequencies
        int len = findStringLength(s);

        // Count frequency for all characters
        for (int i = 0; i < len; i++) {
            freq[s.charAt(i)]++;
        }

        // Create 2D array with unique chars and their frequencies
        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = Character.toString(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }
}
