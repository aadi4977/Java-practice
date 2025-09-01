/* Write a program to split the text into words and return the words along with their lengths in a 2D array
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to split the text into words using the charAt() method without using the String built-in split() method and return the words.
Create a method to find and return a string's length without using the length() method. 
Create a method to take the word array and return a 2D String array of the word and its corresponding length. Use String built-in function String.valueOf() to generate the String value for the number
The main function calls the user-defined method and displays the result in a tabular format. During display make sure to convert the length value from String to Integer and then display
*/

import java.util.Scanner;

public class SplitWordsWithLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input text
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        // Split the text into words (manual)
        String[] words = splitTextUsingCharAt(text);

        // Get 2D array of words and length strings
        String[][] wordsWithLengths = getWordsWithLengths(words);

        // Display in tabular format
        System.out.println("\nWord\tLength");
        System.out.println("--------------");
        for (String[] row : wordsWithLengths) {
            // Convert length string to integer for display
            int lengthInt = Integer.parseInt(row[1]);
            System.out.printf("%s\t%d\n", row[0], lengthInt);
        }
    }

    // Method to split text into words without using split()
    public static String[] splitTextUsingCharAt(String s) {
        int len = findStringLength(s);

        // Count words by counting spaces
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Collect space indices
        int[] spaceIndices = new int[wordCount - 1];
        int spaceIdx = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                spaceIndices[spaceIdx++] = i;
            }
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

    // Method to find string length without length()
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

    // Method to create 2D array [word, length-as-string]
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int len = findStringLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }

        return result;
    }
}
