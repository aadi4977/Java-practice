/*Write a program to find the frequency of characters in a string using the charAt() method and display the result
Hint => 
Create a method to find the frequency of characters in a string using the charAt() method and return the characters and their frequencies in a 2D array. The logic used here is as follows:
Create an array to store the frequency of characters in the text. ASCII values of characters are used as indexes in the array to store the frequency of each character. There are 256 ASCII characters
Loop through the text to find the frequency of characters in the text
Create an array to store the characters and their frequencies
Loop through the characters in the text and store the characters and their frequencies
In the main function take user inputs, call user-defined methods, and displays result.
*/

import java.util.Scanner;

public class Frequency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find frequency of characters
        String[][] freqData = findCharacterFrequency(input);

        // Display characters and their frequencies
        System.out.println("Character\tFrequency");
        System.out.println("-------------------------");
        for (String[] row : freqData) {
            System.out.printf("%-10s\t%s\n", row[0], row[1]);
        }
    }

    public static String[][] findCharacterFrequency(String s) {
        int[] freq = new int[256];  // frequency array for ASCII chars
        int len = findStringLength(s);

        // Count frequency
        for (int i = 0; i < len; i++) {
            freq[s.charAt(i)]++;
        }

        // Count unique characters to size the result
