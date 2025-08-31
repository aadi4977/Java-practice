
import java.util.Scanner;
public class Easysubstring {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String sub1 = "";
        for (int i = start; i < end; i++) {
            sub1 += text.charAt(i);
        }

        String sub2 = text.substring(start, end);

        System.out.println("Using charAt(): " + sub1);
        System.out.println("Using substring(): " + sub2);
        System.out.println("Are both same? " + sub1.equals(sub2));
      }
    
}
