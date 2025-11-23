package JAVAMAP.java;

import java.util.*;

public class ExamResults {
    public static void main(String[] args) {

        // subject → (student → marks)
        Map<String, Map<String, Integer>> results = new HashMap<>();

        // 1. Add subjects and marks
        results.put("Math", new HashMap<>());
        results.put("Science", new HashMap<>());
        results.put("English", new HashMap<>());

        results.get("Math").put("Aadi", 92);
        results.get("Math").put("Riya", 88);
        results.get("Math").put("Aman", 79);

        results.get("Science").put("Aadi", 85);
        results.get("Science").put("Riya", 91);
        results.get("Science").put("Aman", 73);

        results.get("English").put("Aadi", 80);
        results.get("English").put("Riya", 86);
        results.get("English").put("Aman", 90);

        // 2. Top scorer per subject
        System.out.println("Topper per Subject:");
        for (String subject : results.keySet()) {
            String topper = "";
            int highest = -1;

            for (Map.Entry<String, Integer> e : results.get(subject).entrySet()) {
                if (e.getValue() > highest) {
                    highest = e.getValue();
                    topper = e.getKey();
                }
            }

            System.out.println(subject + " → " + topper + " (" + highest + ")");
        }

        // 3. Average score per subject
        System.out.println("\nAverage Score per Subject:");
        for (String subject : results.keySet()) {
            int sum = 0, count = 0;
            for (int marks : results.get(subject).values()) {
                sum += marks;
                count++;
            }
            double avg = sum / (double) count;
            System.out.println(subject + " → " + avg);
        }

        // 4. Subjects where at least one student scored above 90
        System.out.println("\nSubjects with a 90+ scorer:");
        for (String subject : results.keySet()) {
            boolean found = false;
            for (int marks : results.get(subject).values()) {
                if (marks >= 90) {
                    found = true;
                    break;
                }
            }
            if (found) System.out.println(subject);
        }
    }
}

