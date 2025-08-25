package ControlFlow.Lvl2;

import java.util.Scanner;

public class Friendsc {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ageAmar = sc.nextInt();
        int heightAmar = sc.nextInt();

        int ageAkbar = sc.nextInt();
        int heightAkbar = sc.nextInt();

        int ageAnthony = sc.nextInt();
        int heightAnthony = sc.nextInt();

        if (ageAmar < ageAkbar && ageAmar < ageAnthony) {
            System.out.println("Youngest is Amar");
        } else if (ageAkbar < ageAmar && ageAkbar < ageAnthony) {
            System.out.println("Youngest is Akbar");
        } else {
            System.out.println("Youngest is Anthony");
        }

        if (heightAmar > heightAkbar && heightAmar > heightAnthony) {
            System.out.println("Tallest is Amar");
        } else if (heightAkbar > heightAmar && heightAkbar > heightAnthony) {
            System.out.println("Tallest is Akbar");
        } else {
            System.out.println("Tallest is Anthony");
        }
    
}
}
