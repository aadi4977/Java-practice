/*Write a program to demonstrate NumberFormatException
Hint => 
Define a variable to take user input as a String 
Use Integer.parseInt() to generate this exception. Integer.parseInt() is a built-in function in java.lang.Integer class to extract the number from text. In case the text does not contain numbers the method will throw NumberFormatException which is a runtime exception
Write a Method to generate the Exception. Use Integer.parseInt(text) to extract number from the text. This will generate a runtime exception and abruptly stop the program. 
Write the Method to demonstrate NumberFormatException. Use Integer.parseInt(text) to extract number from the text. This will generate a runtime exception. Use the try-catch block to handle the NumberFormatException as well as the generic runtime exception
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
*/

import java.util.Scanner;

public class NumberFormatException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input as string
        System.out.print("Enter a string representing a number: ");
        String input = scanner.nextLine();

        System.out.println("\nGenerating NumberFormatException (unhandled):");
        try {
            generateException(input);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException in main!");
        } catch (RuntimeException e) {
            System.out.println("Caught some other RuntimeException in main!");
        }

        System.out.println("\nHandling NumberFormatException properly:");
        demonstrateExceptionHandling(input);
    }

    // Method that generates NumberFormatException without catching it
    public static void generateException(String text) {
        // This will throw NumberFormatException if text is not a valid integer
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }

    // Method that demonstrates handling NumberFormatException
    public static void demonstrateExceptionHandling(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Oops! That's not a valid number.");
        } catch (RuntimeException e) {
            System.out.println("Some other runtime exception happened.");
        }
    }
}
