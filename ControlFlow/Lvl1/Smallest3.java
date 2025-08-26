package ControlFlow.Lvl1;
import java.util.Scanner;
public class Smallest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter First number :");
        int a = sc.nextInt();
        System.out.print("Enter Second number :");
        int b = sc.nextInt();
        System.out.print("Enter Third number :");
        int c = sc.nextInt();
        boolean res = (a<b && a<c);
        System.out.println("Is the first number the smallest ? "+res);

    }
    
}
