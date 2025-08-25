package ControlFlow.Lvl1;
import java.util.Scanner;
public class Larg3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First number :");
        int a = sc.nextInt();
        System.out.print("Enter Second number :");
        int b = sc.nextInt();
        System.out.print("Enter Third number :");
        int c = sc.nextInt();
        boolean fir =(a>b && a>c);
        boolean sec =(b>a && b>c);
        boolean thir =(c>b && c>a);
        System.out.println("Is the first number the largest ?"+fir);
        System.out.println("Is the Second number the largest ?"+sec);
        System.out.println("Is the Third number the largest ?"+thir);
        
    }
    
}
