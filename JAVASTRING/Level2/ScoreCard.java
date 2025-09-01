/*Create a program to take input marks of students in 3 subjects physics, chemistry, and maths. Compute the percentage and then calculate the grade as shown in figure below

Hint => 
Write a method to generate random 2-digit scores for Physics, Chemistry and Math (PCM) for the students and return the scores. This method returns a 2D array with PCM scores for all students
Write a Method to calculate the total, average, and percentages for each student and return a 2D array with the corresponding values. Please ensure to round off the values to 2 Digits using Math.round() method
Write a Method to calculate the grade based on the percentage as shown in the ref table and return a 2D array of students' grade
Finally write a Method to display the scorecard of all students with their scores, total, average, percentage, and grade in a tabular format. 
*/

import java.util.Random;

public class ScoreCard {

    public static void main(String[] args) {
        int numStudents = 10;  // Number of students

        // Generate random marks for students in PCM (Physics, Chemistry, Maths)
        int[][] pcmScores = generateRandomScores(numStudents);

        // Calculate total, average, percentage for each student
        double[][] totalsAveragesPercentages = calculateTotalsAveragesPercentages(pcmScores);

        // Determine grades based on percentages
        String[][] grades = calculateGrades(totalsAveragesPercentages);

        // Display full scorecard
        displayScorecard(pcmScores, totalsAveragesPercentages, grades);
    }

    // Method to generate random 2-digit (0-99) scores for PCM for all students
    public static int[][] generateRandomScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3];  // Columns: 0=Physics, 1=Chemistry, 2=Maths

        for (int i = 0; i < n; i++) {
            scores[i][0] = rand.nextInt(100);
            scores[i][1] = rand.nextInt(100);
            scores[i][2] = rand.nextInt(100);
        }

        return scores;
    }

    // Calculate total, average, and percentage for each student
    // Columns: 0=total, 1=average, 2=percentage (rounded to 2 decimal places)
    public static double[][] calculateTotalsAveragesPercentages(int[][] scores) {
        int n = scores.length;
        double[][] result = new double[n][3];

        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return result;
    }

    // Calculate grades based on percentage thresholds
    public static String[][] calculateGrades(double[][] totalsAvgPerc) {
        String[][] grades = new String[totalsAvgPerc.length][1];

        for (int i = 0; i < totalsAvgPerc.length; i++) {
            double percentage = totalsAvgPerc[i][2];

            if (percentage >= 80) {
                grades[i][0] = "A";
            } else if (percentage >= 70) {
                grades[i][0] = "B";
            } else if (percentage >= 60) {
                grades[i][0] = "C";
            } else if (percentage >= 50) {
                grades[i][0] = "D";
            } else if (percentage >= 40) {
                grades[i][0] = "E";
            } else {
                grades[i][0] = "R";
            }
        }

        return grades;
    }

    // Display the scorecard in tabular format
    public static void displayScorecard(int[][] scores, double[][] totalsAvgPerc, String[][] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("----------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f\t\t%s\n",
                    i + 1,
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    totalsAvgPerc[i][0],
                    totalsAvgPerc[i][1],
                    totalsAvgPerc[i][2],
                    grades[i][0]);
        }
    }
}
