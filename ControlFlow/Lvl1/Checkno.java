package ControlFlow.Lvl1;
import java.util.Scanner;
public class Checkno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n>0){
            System.out.println("POSITIVE");
        }
        if (n<0) {
            System.out.println("NEGATIVE");
            
        }
        else{
            System.out.println("ZERO");
        }
        
    }
    
}
