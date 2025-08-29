package JAVAARRAY.Lvl2;

import java.util.Scanner;

public class Studentsgrade2d {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3]; // [student][subject: 0=Physics, 1=Chemistry, 2=Maths]
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0 ? "Physics" : j == 1 ? "Chemistry" : "Maths");
                while (true) {
                    System.out.print(subject + ": ");
                    int m = sc.nextInt();
                    if (m >= 0) {
                        marks[i][j] = m;
                        break;
                    } else {
                        System.out.println("Invalid! Marks must be positive.");
                    }
                }
            }

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) grade[i] = 'A';
            else if (percentage[i] >= 70) grade[i] = 'B';
            else if (percentage[i] >= 60) grade[i] = 'C';
            else if (percentage[i] >= 50) grade[i] = 'D';
            else if (percentage[i] >= 40) grade[i] = 'E';
            else grade[i] = 'R';
        }

        System.out.println("\n=== Student Report ===");
        System.out.printf("%-10s %-10s %-10s %-10s %-12s %-6s%n",
                          "Student", "Physics", "Chemistry", "Maths", "Percentage", "Grade");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-10d %-10d %-10d %-12.2f %-6c%n",
                              (i + 1), marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }
    }
    
}
