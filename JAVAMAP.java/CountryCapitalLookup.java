package JAVAMAP.java;

import java.util.*;

public class CountryCapitalLookup {
    public static void main(String[] args) {

        Map<String, String> capitals = new HashMap<>();

        // 1. Add country → capital pairs
        capitals.put("India", "New Delhi");
        capitals.put("USA", "Washington D.C.");
        capitals.put("France", "Paris");
        capitals.put("Japan", "Tokyo");
        capitals.put("Germany", "Berlin");
        capitals.put("Italy", "Rome");
        capitals.put("Canada", "Ottawa");
        capitals.put("Brazil", "Brasilia");

        // 2. Lookup by user input
        String country = "Japan";    // simulate user input
        if (capitals.containsKey(country))
            System.out.println(country + " → " + capitals.get(country));
        else
            System.out.println("Unknown country");

        // 3. Print all in alphabetical order
        System.out.println("\nAll Countries (A–Z):");
        capitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e ->
                    System.out.println(e.getKey() + " → " + e.getValue())
                );
    }
}

