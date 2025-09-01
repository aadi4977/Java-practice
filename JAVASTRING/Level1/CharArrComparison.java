
/*Write a program to return all the characters in a string using the user-defined method,  compare the result with the String built-in toCharArray() method, and display the result
Hint => 
Take user input using the  Scanner next() method to take the text into a String variable
Write a method to return the characters in a string without using the toCharArray() 
Write a method to compare two string arrays and return a boolean result
In the main() call the user-defined method and the String built-in ​​toCharArray() method, compare the 2 arrays, and finally display the result
*/


import java.util.Scanner;

public class CharArrComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the string
        System.out.print("Enter a string: ");
        String input = scanner.next();

        // Get characters using user-defined method
        char[] userDefinedChars = getCharsManually(input);

        // Get characters using built-in toCharArray()
        char[] builtInChars = input.toCharArray();

        // Display both arrays for clarity
        System.out.print("Characters using user-defined method: ");
        printCharArray(userDefinedChars);

        System.out.print("Characters using built-in toCharArray(): ");
        printCharArray(builtInChars);

        // Compare both arrays using comparison method
        boolean areEqual = compareCharArrays(userDefinedChars, builtInChars);

        // Display comparison result
        System.out.println("Are both character arrays equal? " + areEqual);
    }

    // User-defined method to extract characters without using toCharArray()
    public static char[] getCharsManually(String str) {
        int length = str.length();
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    // Helper method to print char array
    public static void printCharArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
