import java.util.Scanner;

public class PrimeChecker {
    static Scanner scanner = new Scanner(System.in);

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        System.out.println(num + (isPrime(num) ? " is a prime number" : " is not a prime number"));
    }
}
