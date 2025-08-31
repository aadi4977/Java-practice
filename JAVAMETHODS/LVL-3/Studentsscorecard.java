
import java.util.*;
public class Studentsscorecard {
     public static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 40 + rand.nextInt(61); // Random 2-digit marks (40-100)
            }
        }
        return scores;
    }

    public static Object[][] calculateResults(int[][] scores) {
        int n = scores.length;
        Object[][] results = new Object[n][7];
        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = Math.round((total / 3.0) * 100.0) / 100.0;
            double percent = Math.round((total / 300.0) * 10000.0) / 100.0;
            String grade;
            if (percent >= 80) grade = "A";
            else if (percent >= 70) grade = "B";
            else if (percent >= 60) grade = "C";
            else if (percent >= 50) grade = "D";
            else if (percent >= 40) grade = "E";
            else grade = "R";

            results[i][0] = scores[i][0];
            results[i][1] = scores[i][1];
            results[i][2] = scores[i][2];
            results[i][3] = total;
            results[i][4] = avg;
            results[i][5] = percent;
            results[i][6] = grade;
        }
        return results;
    }

    public static void displayResults(Object[][] results) {
        System.out.println("ID\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < results.length; i++) {
            System.out.println((i+1) + "\t" + results[i][0] + "\t\t" + results[i][1] + "\t\t" 
                               + results[i][2] + "\t\t" + results[i][3] + "\t" 
                               + results[i][4] + "\t" + results[i][5] + "%\t\t" + results[i][6]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] scores = generateScores(n);
        Object[][] results = calculateResults(scores);
        displayResults(results);
        sc.close();
    }
    
}
