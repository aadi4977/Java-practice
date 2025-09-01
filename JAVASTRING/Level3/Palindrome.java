/*Write a program to to check if a text is palindrome and display the result
Hint => 
A palindrome is a word, phrase, number, or other sequence of characters that reads the same forward and backward
Logic 1: Write a method to compare the characters from the start and end of the string to determine whether the text is palindrome. The logic used here is as follows:
Set the start and end indexes of the text
Loop through the text and compare the characters from the start and the end of the string. If the characters are not equal, return false
Logic 2: Write a recursive method to compare the characters from the start and end of the text passed as parameters using recursion. The logic used here is as follows:
First, check if the start index is greater than or equal to the end index, then return true.
If the characters at the start and end indexes are not equal, return false.
Otherwise, call the method recursively with the start index incremented by 1 and the end index
Logic 3: Write a Method to compare the characters from the start and end of the text using character arrays. The logic used here is as follows:
Firstly Write a Method to reverse a string using the charAt() method and return the reversal array.
Create a character array using the String method toCharArray() and also create a reverse array. Compare the characters in the original and reverse arrays to do a Palindrome check
In the main function take user inputs, call user-defined methods, and displays result.
Finally, in the main method do palindrome check using the three logic and display result
*/

import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to check palindrome: ");
        String text = scanner.nextLine();

        // Logic 1: Iterative check
        boolean resultIterative = isPalindromeIterative(text);
        System.out.println("Iterative check: " + (resultIterative ? "Palindrome" : "Not a Palindrome"));

        // Logic 2: Recursive check
        boolean resultRecursive = isPalindromeRecursive(text, 0, text.length() - 1);
        System.out.println("Recursive check: " + (resultRecursive ? "Palindrome" : "Not a Palindrome"));

        // Logic 3: Using character arrays and manual reversal
        boolean resultCharArray = isPalindromeUsingCharArrays(text);
        System.out.println("Char array check: " + (resultCharArray ? "Palindrome" : "Not a Palindrome"));
    }

    // Logic 1: Iterative palindrome checking
    public static boolean isPalindromeIterative(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive palindrome checking
    public static boolean isPalindromeRecursive(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(s, start + 1, end - 1);
    }

    // Logic 3: Palindrome check using char arrays and reversal
    public static boolean isPalindromeUsingCharArrays(String s) {
        char[] original = s.toCharArray();
        char[] reversed = reverseStringUsingCharAt(s);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    // Helper method: reverse string using charAt()
    public static char[] reverseStringUsingCharAt(String s) {
        int len = s.length();
        char[] reversed = new char[len];

        for (int i = 0; i < len; i++) {
            reversed[i] = s.charAt(len - 1 - i);
        }

        return reversed;
    }
}
