import java.util.Scanner;

public class FactorialRecursion {
    static Scanner scanner = new Scanner(System.in);

    static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        System.out.println("Factorial: " + factorial(num));
    }
}
