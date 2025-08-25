package ControlFlow.Lvl1;

import java.util.Scanner;

public class Div5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        boolean res = (a%5==0);
        System.out.println("Is this number "+ a +" divisble by 5 ?"+res);
     
    }   
}
