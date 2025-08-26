package ControlFlow.Lvl1;

import java.util.Scanner;

public class Sumuntilif {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0, num;

        System.out.println("Enter numbers (0 or negative number to stop):");

        while (true) {
            num = sc.nextDouble();

            if (num <= 0) {   
                break;
            }

            total += num;     
        }

        System.out.println("The total sum is: " + total);

    }
    
}
