/*Write a program to demonstrate NullPointerException. 
Hint => 
Write a Method to generate the Exception. Here define the variable text and initialize it to null. Then call one of the String Method to generate the exception
Write the Method to demonstrate NullPointerException. Here define the variable text and initialize it to null. Then write try catch block for handling the Exception while accessing one of the String method
From the main Firstly call the method to generate the Exception then refactor the code to call the method to handle the RuntimeException
*/

public class NullPointer {

    public static void main(String[] args) {
        // Call method to generate NullPointerException 
        try {
            generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException from generateNullPointerException()");
        }

        // Call method that handles NullPointerException with try-catch
        demonstrateNullPointerExceptionHandling();
    }

    // Method that generates NullPointerException 
    public static void generateNullPointerException() {
        String text = null;
        // This call on a null reference will throw NullPointerException
        System.out.println("Length of text: " + text.length());
    }

    // Method that demonstrates handling of NullPointerException
    public static void demonstrateNullPointerExceptionHandling() {
        String text = null;
        try {
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught! String object is null.");
        }
    }
}
