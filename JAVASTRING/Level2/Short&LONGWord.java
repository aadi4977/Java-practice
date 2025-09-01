/*Write a program to split the text into words and find the shortest and longest strings in a given text
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to split the text into words using the charAt() method without using the String built-in split() method and return the words.
Create a method to find and return a string's length without using the length() method. 
Create a method to take the word array and return a 2D String array of the word and its corresponding length. Use String built-in function String.valueOf() to generate the String value for the number
Create a Method that takes the 2D array of word and corresponding length as parameters, find the shortest and longest string and return them in an 1D int array. 
The main function calls the user-defined methods and displays the result.
*/

import java.util.Scanner;

public class Short&LONGWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        // Split text into words manually
        String[] words = splitTextUsingCharAt(text);

        // Create 2D array [word, length as string]
        String[][] wordsWithLengths = getWordsWithLengths(words);

        // Find shortest and longest word indices
        int[] shortestLongestIndices = findShortestLongestIndices(wordsWithLengths);

        // Display shortest and longest words
        System.out.println("\nShortest word: " + wordsWithLengths[shortestLongestIndices[0]][0] +
                " (Length: " + wordsWithLengths[shortestLongestIndices[0]][1] + ")");
        System.out.println("Longest word: " + wordsWithLengths[shortestLongestIndices[1]][0] +
                " (Length: " + wordsWithLengths[shortestLongestIndices[1]][1] + ")");
    }

    // Split string into words without split()
    public static String[] splitTextUsingCharAt(String s) {
        int len = findStringLength(s);
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') wordCount++;
        }

        int[] spaceIndices = new int[wordCount - 1];
        int spaceIdx = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') spaceIndices[spaceIdx++] = i;
        }

        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount; i++) {
            int end = (i < wordCount - 1) ? spaceIndices[i] : len;
            words[i] = substringByCharAt(s, start, end);
            start = end + 1;
        }
        return words;
    }

    // Find string length without length()
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

    // Extract substring using charAt()
    public static String substringByCharAt(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Create a 2D array of words and their lengths as strings
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            int length = findStringLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(length);
        }
        return result;
    }

    // Find indices of shortest and longest words in the 2D array
    public static int[] findShortestLongestIndices(String[][] wordsWithLengths) {
        int shortestIndex = 0;
        int longestIndex = 0;
        int shortestLength = Integer.parseInt(wordsWithLengths[0][1]);
        int longestLength = Integer.parseInt(wordsWithLengths[0][1]);

        for (int i = 1; i < wordsWithLengths.length; i++) {
            int currentLen = Integer.parseInt(wordsWithLengths[i][1]);
            if (currentLen < shortestLength) {
                shortestLength = currentLen;
                shortestIndex = i;
            }
            if (currentLen > longestLength) {
                longestLength = currentLen;
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }
}
