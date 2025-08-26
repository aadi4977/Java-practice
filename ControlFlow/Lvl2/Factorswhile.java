package ControlFlow.Lvl2;

import java.util.Scanner;

public class Factorswhile {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number > 0) {
            System.out.println("Factors of " + number + " are:");
            int i = 1;
            while (i <= number) {
                if (number % i == 0) {
                    System.out.println(i);
                }
                i++;
            }
        } else {
            System.out.println("Enter a positive integer");
        }
    }
    
}
