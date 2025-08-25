package ControlFlow.Lvl1;

import java.util.Scanner;

public class Sumuntilzero {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        double total = 0;
        double num = sc.nextDouble();   

        while (num != 0) {              
            total += num;               
            num = sc.nextDouble();      
        }

        System.out.println("The total sum is: " + total);

        sc.close();
    }
    
}
