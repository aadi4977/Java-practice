package JAVAMAP.java;

import java.util.*;

public class StudentGradeTracker {
    public static void main(String[] args) {

        Map<String, Double> grades = new HashMap<>();

        // 1. Add students
        grades.put("Aadi", 85.0);
        grades.put("Riya", 92.5);
        grades.put("Aman", 78.0);
        grades.put("Neha", 88.0);

        // 2. Update grade (student retakes test)
        grades.put("Aman", 90.0);   // updated

        // 3. Remove a student who dropped out
        grades.remove("Neha");

        // 4. Print students in alphabetical order
        System.out.println("Student Grades (A–Z):");
        grades.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e ->
                    System.out.println(e.getKey() + " : " + e.getValue())
                );
    }
}

