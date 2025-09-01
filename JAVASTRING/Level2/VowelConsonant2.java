/*Write a program to find vowels and consonants in a string and display the character type - Vowel, Consonant, or Not a Letter
Hint => 
Create a method to check if the character is a vowel or consonant and return the result. The logic used here is as follows:
Convert the character to lowercase if it is an uppercase letter using the ASCII values of the characters
Check if the character is a vowel or consonant and return Vowel, Consonant, or Not a Letter
Create a Method to find vowels and consonants in a string using charAt() method and return the character and vowel or consonant in a 2D array
Create a Method to display the 2D Array of Strings in a Tabular Format
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result
*/

import java.util.Scanner;

public class VowelConsonant2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input text
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Get 2D array with character and type
        String[][] charTypes = findCharTypes(input);

        // Display the result in tabular form
        displayCharTypes(charTypes);
    }

    // Method to find character types in the string
    public static String[][] findCharTypes(String s) {
        int len = findStringLength(s);
        String[][] result = new String[len][2];

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            String type = getCharType(ch);
            result[i][0] = String.valueOf(ch);
            result[i][1] = type;
        }
        return result;
    }

    // Method to get the character type: Vowel, Consonant or Not a Letter
    public static String getCharType(char ch) {
        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if letter
        if (ch < 'a' || ch > 'z') {
            return "Not a Letter";
        }

        // Vowels
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        }

        // Consonants
        return "Consonant";
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

    // Display the 2D array in table format
    public static void displayCharTypes(String[][] arr) {
        System.out.println("\nCharacter\tType");
        System.out.println("-----------------------");
        for (String[] row : arr) {
            System.out.printf("%-10s\t%s\n", row[0], row[1]);
        }
    }
}
