package ControlFlow.Lvl1;

import java.util.Scanner;

public class Factorialfor {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int n, fact = 1;
        n = sc.nextInt();
        if (n >= 0) {
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            System.out.println("Factorial of " + n + " is " + fact);
        } else {
            System.out.println("Enter a positive integer");
        }
    }
    
}
