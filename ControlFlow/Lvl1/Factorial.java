package ControlFlow.Lvl1;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, fact = 1, i = 1;
        n = sc.nextInt();
        if (n >= 0) {
            while (i <= n) {
                fact *= i;
                i++;
            }
            System.out.println("Factorial of " + n + " is " + fact);
        } else {
            System.out.println("Enter a positive integer");
    }
    
}
}
