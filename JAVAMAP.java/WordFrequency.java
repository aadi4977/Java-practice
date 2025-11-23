package JAVAMAP.java;

import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        String sentence = "Java is fun and Java is powerful";

        Map<String, Integer> freq = new HashMap<>();

        // 1 & 2. Split and normalize
        String[] words = sentence.toLowerCase().replaceAll("[^a-z ]", "").split(" ");

        // 3. Count words
        for (String w : words) {
            if (w.isEmpty()) continue;
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // 4. Print frequencies
        System.out.println("Word Frequency:");
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
