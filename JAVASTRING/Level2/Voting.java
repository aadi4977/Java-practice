/*Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18.
Hint => 
Create a method to define the random 2-digit age of several students provided as method parameters and return a 1D array of ages of n students
Create a method that takes an array of age as a parameter and returns a 2D String array of age and a boolean true or false to indicate can and cannot vote. Inside the method firstly validate the age for a negative number, if a negative cannot vote. For valid age check for age is 18 or above to set true to indicate can vote.
Create a method to display the 2D array in a tabular format.
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result
*/

import java.util.Scanner;
import java.util.Random;

public class Voting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of students (fixed as 10 for this problem)
        int n = 10;

        // Generate random 2-digit ages for students
        int[] ages = generateRandomAges(n);

        // Process eligibility: ages and boolean vote eligibility as strings
        String[][] results = checkVotingEligibility(ages);

        // Display results in table
        displayResults(results);
    }

    // Generate random two-digit ages array for n students (10-99)
    public static int[] generateRandomAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            ages[i] = 10 + rand.nextInt(90);  // Random age between 10 and 99 inclusive
        }
        return ages;
    }

    // Takes ages array, returns 2D array of [age as string, "true"/"false" for eligibility]
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] results = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            results[i][0] = String.valueOf(age);

            // Validate age
            if (age < 0) {
                results[i][1] = "false"; // invalid age can't vote
            } else if (age >= 18) {
                results[i][1] = "true";
            } else {
                results[i][1] = "false";
            }
        }

        return results;
    }

    // Display the 2D array in a table format
    public static void displayResults(String[][] data) {
        System.out.println("Student\tAge\tCan Vote?");
        System.out.println("--------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d\t%s\t%s\n", i + 1, data[i][0], data[i][1]);
        }
    }
}
