package ControlFlow.Lvl2;

import java.util.Scanner;

public class Poweofno {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();
        int result = 1;

        if (number >= 0 && power >= 0) {
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            System.out.println(number + " raised to the power " + power + " is " + result);
        } else {
            System.out.println("Enter positive integers only");
        }
    
}
}
