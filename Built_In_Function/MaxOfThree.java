import java.util.Scanner;

public class MaxOfThree {
    static Scanner scanner = new Scanner(System.in);
    
    static int takeInput() {
        System.out.print("Enter a number: ");
        return scanner.nextInt();
    }
    
    static int max(int a, int b, int c) {
        int maxVal = a;
        if (b > maxVal) maxVal = b;
        if (c > maxVal) maxVal = c;
        return maxVal;
    }
    
    public static void main(String[] args) {
        int a = takeInput();
        int b = takeInput();
        int c = takeInput();
        System.out.println("Maximum: " + max(a, b, c));
    }
}
