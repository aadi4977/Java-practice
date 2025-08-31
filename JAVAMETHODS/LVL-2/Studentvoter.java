import java.util.Scanner;

public class Studentvoter {
    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false; // invalid age
        }
        return age >= 18; // true if 18 or above
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Studentvoter  checker = new Studentvoter();

        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }

        System.out.println("\nVoting Eligibility Results:");
        for (int i = 0; i < ages.length; i++) {
            boolean eligible = checker.canStudentVote(ages[i]);
            if (eligible) {
                System.out.println("Student " + (i + 1) + " (Age " + ages[i] + "): Eligible to vote ✅");
            } else {
                System.out.println("Student " + (i + 1) + " (Age " + ages[i] + "): Not eligible to vote ❌");
            }
        }
    }
}
