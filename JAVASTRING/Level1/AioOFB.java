/*Write a program to demonstrate ArrayIndexOutOfBoundsException
Hint => 
Define a variable of array of names and take input from the user
Write a Method to generate the Exception. Here access index larger then the length of the array. This will generate a runtime exception and abruptly stop the program. 
Write the Method to demonstrate ArrayIndexOutOfBoundsException. Here access index larger then the length of the array. This will generate a runtime exception. Use the try-catch block to handle the ArrayIndexOutOfBoundsException and the generic runtime exception
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
*/
import java.util.Scanner;

public class AioOFb
 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take array size input
        System.out.print("Enter number of names: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Input names into array
        String[] names = new String[n];
        System.out.println("Enter " + n + " names:");
        for (int i = 0; i < n; i++) {
            names[i] = scanner.nextLine();
        }

        System.out.println("\nCalling method to generate ArrayIndexOutOfBoundsException (unhandled):");
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException in main!");
        }

        System.out.println("\nCalling method that handles ArrayIndexOutOfBoundsException:");
        demonstrateExceptionHandling(names);
    }

    // Generate ArrayIndexOutOfBoundsException without handling
    public static void generateException(String[] arr) {
        // Access index out of bounds (arr length + 1)
        System.out.println("Accessing invalid index: " + arr[arr.length]);
    }

    // Handle ArrayIndexOutOfBoundsException using try-catch
    public static void demonstrateExceptionHandling(String[] arr) {
        try {
            System.out.println("Accessing invalid index: " + arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException! Invalid array index.");
        } catch (RuntimeException e) {
            System.out.println("Some other runtime exception.");
        }
    }
}
