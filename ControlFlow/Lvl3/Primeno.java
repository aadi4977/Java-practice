package ControlFlow.Lvl3;

import java.util.Scanner;

public class Primeno {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        boolean isPrime = true; // assume number is prime initially

        if (number <= 1) {
            isPrime = false; // Prime numbers are greater than 1
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false; // divisible by some other number
                    break;           // no need to check further
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is NOT a Prime Number");
        }
    }
    
}
