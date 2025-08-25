package ControlFlow.Lvl2;

import java.util.Scanner;

public class Greatestfactor {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int greatestFactor = 1;

        if (number > 1) {
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break;
                }
            }
            System.out.println("Greatest factor of " + number + " besides itself is " + greatestFactor);
        } else {
            System.out.println("Enter an integer greater than 1");
        }
    }
    
}
