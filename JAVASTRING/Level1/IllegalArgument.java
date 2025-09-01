/* Write a program to demonstrate IllegalArgumentException
Hint => 
Define a variable of type String and take user input to assign a value
Write a Method to generate the Exception. Here use the subString() and set the start index to be greater than the end index. This will generate a runtime exception and abruptly stop the program. 
Write the Method to demonstrate IllegalArgumentException. Here use the subString() and set the start index to be greater than the end index. This will generate a runtime exception. Use the try-catch block to handle the IllegalArgumentException and the generic runtime exception
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
*/
import java.util.Scanner;

public class IllegalArgument {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take string input
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        System.out.println("\nGenerating exception (unhandled):");
        try {
            generateException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException in main!");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException in main!");
        }

        System.out.println("\nHandling exception properly:");
        demonstrateExceptionHandling(text);
    }

    // Method that generates Exception by invalid substring indices, no handling inside
    public static void generateException(String s) {
        // Intentionally setting start index > end index
        String result = s.substring(5, 2);  // will throw StringIndexOutOfBoundsException
        System.out.println("Substring result: " + result);
    }

    // Method to handle IllegalArgumentException and general RuntimeException
    public static void demonstrateExceptionHandling(String s) {
        try {
            String result = s.substring(5, 2);  // invalid: start > end
            System.out.println("Substring result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException! Invalid substring indices.");
        } catch (RuntimeException e) {
            // StringIndexOutOfBoundsException is a RuntimeException subclass
            System.out.println("Caught RuntimeException (probably index out of bounds).");
        }
    }
}
