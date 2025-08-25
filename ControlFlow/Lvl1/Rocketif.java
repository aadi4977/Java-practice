package ControlFlow.Lvl1;

import java.util.Scanner;

public class Rocketif {
    public static void main(String[] args) {
        
    
     Scanner sc = new Scanner(System.in);
        System.out.print("Enter countdown start number: ");
        int counter = sc.nextInt();

        
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
    
}
}
