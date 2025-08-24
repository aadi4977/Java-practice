import java.util.Scanner;

public class Yards {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int distanceInFeet = sc.nextInt();
        double distanceInYards = distanceInFeet / 3.0;
        double distanceInMiles = distanceInYards / 1760.0;
        System.out.println("The distance in yards is " + distanceInYards + " while the distance in miles is " + distanceInMiles);
    }
}
    

