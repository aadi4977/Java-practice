/*Write a program to find vowels and consonants in a string and display the count of  Vowels and Consonants in the string
Hint => 
Create a method to check if the character is a vowel or consonant and return the result. The logic used here is as follows:
Convert the character to lowercase if it is an uppercase letter using the ASCII values of the characters
Check if the character is a vowel or consonant and return Vowel, Consonant, or Not a Letter
Create a Method to Method to find vowels and consonants in a string using charAt() method and finally return the count of vowels and consonants in an array
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
*/

import java.util.Scanner;

public class VowelConsonant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Get counts of vowels and consonants
        int[] counts = countVowelsAndConsonants(input);

        // Display results
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }

    // Method to count vowels and consonants
    public static int[] countVowelsAndConsonants(String s) {
        int vowelCount = 0;
        int consonantCount = 0;

        int len = findStringLength(s);
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            String result = isVowelOrConsonant(ch);
            if (result.equals("Vowel")) {
                vowelCount++;
            } else if (result.equals("Consonant")) {
                consonantCount++;
            }
            // Ignore "Not a Letter"
        }

        return new int[]{vowelCount, consonantCount};
    }

    // Method to check if a character is vowel, consonant or not letter
    public static String isVowelOrConsonant(char ch) {
        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if it's a letter a-z
        if (ch < 'a' || ch > 'z') {
            return "Not a Letter";
        }

        // Check vowels
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        }

        // Else consonant
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
}
