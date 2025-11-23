package JAVAMAP.java;

import java.util.*;

public class VisitTracker {
    public static void main(String[] args) {

        Map<String, Integer> visits = new HashMap<>();

        // Simulated page visits
        String[] pages = {
            "home", "about", "products", "home",
            "products", "contact", "home", "home", "about"
        };

        // 1. Update visit counts
        for (String p : pages) {
            visits.put(p, visits.getOrDefault(p, 0) + 1);
        }

        // 2. Print pages sorted by descending visits
        System.out.println("Page Visit Count (High → Low):");
        visits.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(e ->
                    System.out.println(e.getKey() + " : " + e.getValue())
                );

        // 3. Find the most visited page
        int max = Collections.max(visits.values());
        System.out.println("\nMost Visited Page(s):");
        for (Map.Entry<String, Integer> e : visits.entrySet()) {
            if (e.getValue() == max)
                System.out.println(" - " + e.getKey());
        }
    }
}

