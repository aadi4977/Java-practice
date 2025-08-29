package JAVAARRAY.Lvl2;

import java.util.Scanner;

public class BMIcalculator2d {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3]; // weight, height, BMI
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");

            double weight, height;

            while (true) {
                System.out.print("Enter weight (kg): ");
                weight = sc.nextDouble();
                if (weight > 0) break;
                System.out.println("Invalid! Weight must be positive.");
            }

            while (true) {
                System.out.print("Enter height (m): ");
                height = sc.nextDouble();
                if (height > 0) break;
                System.out.println("Invalid! Height must be positive.");
            }

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height);

            double bmi = personData[i][2];
            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\n=== BMI Report ===");
        System.out.printf("%-10s %-10s %-10s %-10s %-15s%n",
                          "Person", "Weight", "Height", "BMI", "Status");

        for (int i = 0; i < number; i++) {
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-15s%n",
                              (i + 1),
                              personData[i][0],
                              personData[i][1],
                              personData[i][2],
                              weightStatus[i]);
        }
     }
}
