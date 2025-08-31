
import java.util.Arrays;

public class Numbercheck {
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] storeDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    public static int sumOfSquares(int[] digits) {
        int sumSq = 0;
        for (int d : digits) {
            sumSq += Math.pow(d, 2);
        }
        return sumSq;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return sum != 0 && number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2]; // 10 rows for digits 0-9, 2 columns: digit and count
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i; // first column stores the digit
        }
        for (int d : digits) {
            freq[d][1]++; // increment frequency in second column
        }
        return freq;
    }

    public static void main(String[] args) {
        int number = 21; // Example number; can be replaced with user input

        int count = countDigits(number);
        int[] digits = storeDigits(number);
        int sum = sumOfDigits(digits);
        int sumSq = sumOfSquares(digits);
        boolean harshad = isHarshadNumber(number, digits);
        int[][] freq = digitFrequency(digits);

        System.out.println("Number: " + number);
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Count of digits: " + count);
        System.out.println("Sum of digits: " + sum);
        System.out.println("Sum of squares of digits: " + sumSq);
        System.out.println("Is Harshad Number: " + harshad);

        System.out.println("Digit frequencies:");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i][1] > 0) { // display only digits that appear
                System.out.println("Digit " + freq[i][0] + " occurs " + freq[i][1] + " times");
            }
        }
}
}
