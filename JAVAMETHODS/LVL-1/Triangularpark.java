import java.util.Scanner;
public class Triangularpark {
     public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        double distance = 5000; 
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side 1 of the park (in meters): ");
        double side1 = sc.nextDouble();
        System.out.print("Enter side 2 of the park (in meters): ");
        double side2 = sc.nextDouble();
        System.out.print("Enter side 3 of the park (in meters): ");
        double side3 = sc.nextDouble();
        double rounds = calculateRounds(side1, side2, side3);
        System.out.println("The athlete must complete " + Math.ceil(rounds) + " rounds to run 5 km.");
    }
    
}
