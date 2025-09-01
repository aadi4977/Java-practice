/*Write a program to find the frequency of characters in a string using nested loops and display the result
Hint => 
Create a method to find the frequency of characters in a string and return the characters and their frequencies in a 1D array. The logic used here is as follows:
Create an array to store the frequency of each character in the text and an array to store the characters in the text using the toCharArray() method
Loops to Find the frequency of each character in the text and store the result in a frequency array. For this use a Nested Loop with an Outer loop to iterate through each character in the text and initialize the frequency of each character to 1. And an Inner loop to check for duplicate characters. In case of duplicate increment the frequency value and set the duplicate characters to '0' to avoid counting them again.
Create a 1D String array to store the characters and their frequencies. For this Iterate through the characters in the text and store the characters and their frequencies 
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
*/

import java.util.Scanner;

public class Frequency3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Get frequency data
        String[] frequencyData = findFrequency(input);

        // Display characters and their frequencies
        System.out.println("Character\tFrequency");
        System.out.println("-------------------------");
        for (String data : frequencyData) {
            System.out.println(data);
        }
    }

    // Method to find frequency of characters using nested loops
    public static String[] findFrequency(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] freq = new int[len];

        // Initialize frequency for all characters as 1
        for (int i = 0; i < len; i++) {
            freq[i] = 1;
        }

        // Nested loop to count frequency and mark duplicates with '0'
        for (int i = 0; i < len; i++) {
            // Skip if already marked as duplicate
            if (chars[i] == '0') {
                continue;
            }

            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    // Mark duplicate character
                    chars[j] = '0';
                }
            }
        }

        // Count unique characters to size the result array
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                uniqueCount++;
            }
        }

        // Create result string array to hold character and frequency
        String[] result = new String[uniqueCount];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + "\t\t" + freq[i];
                index++;
            }
        }

        return result;
    }
}
