package JAVAMAP.java;
import java.util.*;

public class AttendanceTracker {
    public static void main(String[] args) {

        Map<String, Integer> attendance = new HashMap<>();

        // 1. Initialize students (all with 0 days present)
        String[] students = {"Aadi", "Riya", "Aman", "Neha", "Sahil"};
        for (String s : students) {
            attendance.put(s, 0);
        }

        Random rand = new Random();

        // 2. Simulate attendance for 15 days
        for (int day = 1; day <= 15; day++) {
            System.out.println("Day " + day + " present:");

            // random students marked present
            for (String s : students) {
                if (rand.nextBoolean()) {     // 50% chance present
                    attendance.put(s, attendance.get(s) + 1);
                    System.out.print(s + " ");
                }
            }
            System.out.println("\n");
        }

        // 3. Print students with fewer than 10 days
        System.out.println("Students with <10 days attendance:");
        for (Map.Entry<String, Integer> e : attendance.entrySet()) {
            if (e.getValue() < 10) {
                System.out.println(e.getKey() + " : " + e.getValue());
            }
        }
    }
}

