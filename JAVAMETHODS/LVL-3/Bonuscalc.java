import java.util.Scanner;
import java.util.Random;
public class Bonuscalc {
    public static int[][] generateData(int n) {
        Random rand = new Random();
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = 10000 + rand.nextInt(90000); 
            data[i][1] = 1 + rand.nextInt(15); 
        }
        return data;
    }

    public static double[][] calculateBonus(int[][] data) {
        int n = data.length;
        double[][] result = new double[n][3];
        for (int i = 0; i < n; i++) {
            double bonus = data[i][1] > 5 ? data[i][0] * 0.05 : data[i][0] * 0.02;
            result[i][0] = data[i][0];
            result[i][1] = bonus;
            result[i][2] = data[i][0] + bonus;
        }
        return result;
    }

    public static void display(double[][] result, int[][] data) {
        double totalOld = 0, totalNew = 0, totalBonus = 0;
        System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s%n", "ID", "Salary", "Service", "Bonus", "New Salary", "");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-5d %-10.2f %-10d %-10.2f %-10.2f%n", 
                              (i+1), result[i][0], data[i][1], result[i][1], result[i][2]);
            totalOld += result[i][0];
            totalBonus += result[i][1];
            totalNew += result[i][2];
        }
        System.out.println("-----------------------------------------------------------");
        System.out.printf("Total  %-10.2f %-10s %-10.2f %-10.2f%n", totalOld, "", totalBonus, totalNew);
    }

    public static void main(String[] args) {
        int[][] data = generateData(10);
        double[][] result = calculateBonus(data);
        display(result, data);
    }
    
}
