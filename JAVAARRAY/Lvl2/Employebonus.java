package JAVAARRAY.Lvl2;
import java.util.Scanner;
public class Employebonus {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int EMP_COUNT = 10;

        double[] salary = new double[EMP_COUNT];
        double[] years = new double[EMP_COUNT];
        double[] bonus = new double[EMP_COUNT];
        double[] newSalary = new double[EMP_COUNT];

        double totalOldSalary = 0, totalBonus = 0, totalNewSalary = 0;

        // Input loop
        for (int i = 0; i < EMP_COUNT; i++) {
            System.out.println("Enter details for Employee " + (i + 1));

            // Salary input validation
            System.out.print("Enter Salary: ");
            double s = sc.nextDouble();
            if (s <= 0) {
                System.out.println("Invalid salary. Please enter again.");
                i--; // decrement counter to retry
                continue;
            }

            // Years input validation
            System.out.print("Enter Years of Service: ");
            double y = sc.nextDouble();
            if (y < 0) {
                System.out.println("Invalid years of service. Please enter again.");
                i--; // decrement counter to retry
                continue;
            }

            salary[i] = s;
            years[i] = y;
        }

        // Calculation loop
        for (int i = 0; i < EMP_COUNT; i++) {
            if (years[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }
            newSalary[i] = salary[i] + bonus[i];

            // Totals
            totalOldSalary += salary[i];
            totalBonus += bonus[i];
            totalNewSalary += newSalary[i];
        }

        // Print results
        System.out.println("\n=== Employee Bonus Report ===");
        for (int i = 0; i < EMP_COUNT; i++) {
            System.out.printf("Employee %d -> Old Salary: %.2f, Bonus: %.2f, New Salary: %.2f%n",
                    (i + 1), salary[i], bonus[i], newSalary[i]);
        }

        System.out.println("\n=== Totals ===");
        System.out.printf("Total Old Salary: %.2f%n", totalOldSalary);
        System.out.printf("Total Bonus Payout: %.2f%n", totalBonus);
        System.out.printf("Total New Salary: %.2f%n", totalNewSalary);
    }
    
}
