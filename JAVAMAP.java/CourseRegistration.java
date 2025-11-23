package JAVAMAP.java;
import java.util.*;

public class CourseRegistration {
    public static void main(String[] args) {

        Map<String, Integer> courses = new HashMap<>();

        // 1. Add courses
        courses.put("CS101", 45);
        courses.put("CS102", 52);
        courses.put("MA101", 10);
        courses.put("PH101", 3);
        courses.put("EC201", 60);

        // 2. Add/drop students
        // Add 5 students to CS101
        courses.put("CS101", courses.get("CS101") + 5);

        // Drop 2 students from MA101
        courses.put("MA101", Math.max(0, courses.get("MA101") - 2));

        // Drop 5 students from PH101 (cannot go negative)
        courses.put("PH101", Math.max(0, courses.get("PH101") - 5));

        // 3. Print near-full (≥50) and under-subscribed (<5)
        System.out.println("\nNear Full Courses (≥50):");
        for (Map.Entry<String, Integer> e : courses.entrySet()) {
            if (e.getValue() >= 50)
                System.out.println(e.getKey() + " : " + e.getValue());
        }

        System.out.println("\nUnder-Subscribed Courses (<5):");
        for (Map.Entry<String, Integer> e : courses.entrySet()) {
            if (e.getValue() < 5)
                System.out.println(e.getKey() + " : " + e.getValue());
        }

        // Final list
        System.out.println("\nFinal Course Registrations:");
        for (Map.Entry<String, Integer> e : courses.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}

