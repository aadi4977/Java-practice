/*Write a program to find and return the length of a string without using the length() method 
Hint => 
Take user input using the Scanner next() method 
Create a method to find and return a string's length without using the built-in length() method. The logic for this is to use the infinite loop to count each character till the charAt() method throws a runtime exception, handles the exception, and then return the count
The main function calls the user-defined method as well as the built-in length() method and displays the result
*/

import java.util.Scanner;

public class Length {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a string
        System.out.print("Enter a string: ");
        String input = scanner.next();

        // Use custom method to find length without length()
        int customLength = findStringLength(input);

        // Use built-in length() method
        int builtInLength = input.length();

        // Display both lengths
        System.out.println("Length calculated without length(): " + customLength);
        System.out.println("Length using built-in length(): " + builtInLength);
    }

    // Method to find string length using charAt() and catching exception
    public static int findStringLength(String s) {
        int count = 0;

        while (true) {
            try {
                s.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                // No more characters, end of string reached
                break;
            }
        }

        return count;
    }
}
