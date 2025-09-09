import java.util.Scanner;

public class TempConverter {
    static Scanner scanner = new Scanner(System.in);

    static double toCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    static double toFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        System.out.print("Enter temperature: ");
        double temp = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Convert to (C)elsius or (F)ahrenheit? ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("C")) {
            System.out.println(temp + " F = " + toCelsius(temp) + " C");
        } else if (choice.equalsIgnoreCase("F")) {
            System.out.println(temp + " C = " + toFahrenheit(temp) + " F");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
