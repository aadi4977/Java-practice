/*Create a program to display a calendar for a given month and year. The program should take the month and year as input from the user and display the calendar for that month. E.g. for 07 2005 user input, the program should display the calendar as shown below

Hint => 
Write a Method to get the name of the month. For this define a month Array to store the names of the months
Write a Method to get the number of days in the month. For this define a days Array to store the number of days in each month. For Feb month, check for Leap Year to get the number of days. Also, define a Leap Year Method. 
Write a method to get the first day of the month using the Gregorian calendar algorithm
y0 = y − (14 − m) / 12
x = y0 + y0/4 − y0/100 + y0/400
m0 = m + 12 × ((14 − m) / 12) − 2
d0 = (d + x + 31m0 / 12) mod 7

Displaying the Calendar requires 2 for loops. 
The first for loop up to the first day to get the proper indentation. As in the example above 3 spaces from Sun to Thu as to be set as July 1st starts on Fri
The Second for loop Displays the days of the month starting from 1 to the number of days. Add proper indentation for single-digit days using %3d to display the integer right-justified in a field of width 3. Please note to move to the next line after Sat

*/
import java.util.Scanner;

public class Calendar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input month and year
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        // Get month name and number of days
        String monthName = getMonthName(month);
        int daysInMonth = getNumberOfDays(month, year);

        // Get the first day of the month (0=Sunday, 1=Monday, ..., 6=Saturday)
        int firstDay = getFirstDayOfMonth(month, year);

        // Display calendar header
        System.out.println("\n     " + monthName + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        // Indentation for first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("   ");  // 3 spaces for each indentation
        }

        // Print the days
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d", day);

            // Move to next line after Saturday
            if ((firstDay + day) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();  // Final newline
    }

    // Return the month name for given month number
    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        if (month >= 1 && month <= 12) {
            return months[month - 1];
        } else {
            return "Invalid Month";
        }
    }

    // Return number of days in given month, check leap year for February
    public static int getNumberOfDays(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30,
                      31, 31, 30, 31, 30, 31};

        // Leap year check for February
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        if (month >= 1 && month <= 12) {
            return days[month - 1];
        } else {
            return 0; // invalid month
        }
    }

    // Check if year is leap year
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // Calculate the first day of the month using Gregorian calendar algorithm
    // Return 0=Sunday, 1=Monday, ... 6=Saturday
    public static int getFirstDayOfMonth(int month, int year) {
        int m = month;
        int y = year;
        int d = 1;

        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int y0 = y;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        return d0;
    }
}
