/* Write a program to demonstrate StringIndexOutOfBoundsException
Hint => 
Define a variable of type String and take user input to assign a value
Write a Method to generate the Exception. Access the index using charAt() beyond the length of the String. This will generate a runtime exception and abruptly stop the program.
Write the Method to demonstrate StringIndexOutOfBoundsException. Access the index using charAt() beyond the length of the String. Then write try catch block for Exception while accessing the String method
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
*/

    import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for string
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        System.out.println("\nCalling method to generate StringIndexOutOfBoundsException (unhandled):");
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException in main!");
        }

        System.out.println("\nCalling method to handle StringIndexOutOfBoundsException:");
        demonstrateExceptionHandling(text);
    }

    // Method to generate StringIndexOutOfBoundsException without handling
    public static void generateException(String s) {
        // Access index beyond string length leads to exception
        System.out.println("Character at invalid index: " + s.charAt(s.length())); // invalid index
    }

    // Method to demonstrate handling of StringIndexOutOfBoundsException
    public static void demonstrateExceptionHandling(String s) {
        try {
            System.out.println("Character at invalid index: " + s.charAt(s.length())); // invalid index
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught! Index out of bounds for string length " + s.length());
        }
    }
}
