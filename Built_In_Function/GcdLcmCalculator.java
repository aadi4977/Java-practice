import java.util.Scanner;

public class GcdLcmCalculator {
    static Scanner scanner = new Scanner(System.in);

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        System.out.println("GCD: " + gcd(a, b));
        System.out.println("LCM: " + lcm(a, b));
    }
}
