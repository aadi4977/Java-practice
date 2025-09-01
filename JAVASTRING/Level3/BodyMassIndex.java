/* An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in a team of 10 members. For this create a program to find the BMI and display the height, weight, BMI, and status of each individual
Hint => 
Take user input for the person's weight (kg) and height (cm) and store it in the corresponding 2D array of 10 rows. The First Column stores the weight and the second column stores the height in cm
Create a Method to find the BMI and status of every person given the person's height and weight and return the 2D String array. Use the formula BMI = weight / (height * height). Note unit is kg/m^2. For this convert cm to meter
Create a Method that takes the 2D array of height and weight as parameters. Calls the user-defined method to compute the BMI and the BMI Status and stores in a 2D String array of height, weight, BMI, and status.
Create a method to display the 2D string array in a tabular format of Person's Height, Weight, BMI, and the Status
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
*/

import java.util.Scanner;

public class BodyMassIndex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPersons = 10;
        // 2D array: rows= persons, columns= [0]=weight (kg), [1]=height (cm)
        double[][] weightHeight = new double[numPersons][2];

        // Input weight and height for each person
        for (int i = 0; i < numPersons; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            weightHeight[i][0] = scanner.nextDouble();

            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            weightHeight[i][1] = scanner.nextDouble();
        }

        // Calculate BMI and status for all persons
        String[][] bmiData = calculateBMIStatus(weightHeight);

        // Display the results in a table format
        displayBMIResults(bmiData);
    }

    // Compute BMI and status given weight and height for all persons
    public static String[][] calculateBMIStatus(double[][] weightHeight) {
        int n = weightHeight.length;
        String[][] results = new String[n][4]; // weight, height, BMI, status

        for (int i = 0; i < n; i++) {
            double weight = weightHeight[i][0];
            double heightCm = weightHeight[i][1];
            double heightM = heightCm / 100;   // convert cm to meters

            double bmi = weight / (heightM * heightM);
            // Round BMI to 2 decimal places
            bmi = Math.round(bmi * 100.0) / 100.0;

            String status = getBMIStatus(bmi);

            results[i][0] = String.valueOf(weight);
            results[i][1] = String.valueOf(heightCm);
            results[i][2] = String.valueOf(bmi);
            results[i][3] = status;
        }

        return results;
    }

    // Determine BMI status
    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Display the BMI results in tabular form
    public static void displayBMIResults(String[][] data) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight(kg)", "Height(cm)", "BMI", "Status");
        System.out.println("------------------------------------------------");

        for (String[] row : data) {
            System.out.printf("%-10s %-10s %-10s %-15s\n",
                    row[0], row[1], row[2], row[3]);
        }
    }
}
