/*Write a program to split the text into words, compare the result with the split() method and display the result 
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to find the length of the String without using the built-in length() method. 
Create a Method to split the text into words using the charAt() method without using the String built-in split() method and return the words. Use the following logic
Firstly Count the number of words in the text and create an array to store the indexes of the spaces for each word in a 1D array
Then Create an array to store the words and use the indexes to extract the words
Create a method to compare the two String arrays and return a boolean
The main function calls the user-defined method and the built-in split() method. Call the user defined method to compare the two string arrays and display the result
*/

import java.util.Scanner;

public class Text&Word {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take complete text input
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        // Split using user-defined method
        String[] customSplit = splitTextUsingCharAt(text);

        // Split using built-in split()
        String[] builtInSplit = text.split(" ");

        // Display both arrays
        System.out.println("Custom split words:");
        printStringArray(customSplit);

        System.out.println("Built-in split words:");
        printStringArray(builtInSplit);

        // Compare arrays using custom comparison method
        boolean arraysEqual = compareStringArrays(customSplit, builtInSplit);
        System.out.println("Are both split results equal? " + arraysEqual);
    }

    // Method to find the length of string without length()
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

    // Method to split text into words without using
