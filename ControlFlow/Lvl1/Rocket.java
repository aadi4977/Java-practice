package ControlFlow.Lvl1;
import java.util.Scanner;

public class Rocket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter countdown start number: ");
        int counter = sc.nextInt();

        
        while (counter >= 1) {
            System.out.println(counter);
            counter--;  
    }
}
}
