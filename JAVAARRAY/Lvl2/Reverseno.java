package JAVAARRAY.Lvl2;

import java.util.Scanner;

public class Reverseno {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int count = 0;

        while (temp != 0) {
            temp /= 10;
            count++;
        }

        int[] digits = new int[count];
        int index = 0;

        temp = number;
        while (temp != 0) {
            digits[index] = temp % 10;
            temp /= 10;
            index++;
        }

        int[] reverseArray = new int[count];
        for (int i = 0; i < count; i++) {
            reverseArray[i] = digits[count - 1 - i];
        }

        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reverseArray[i]);
        }
     }
}
