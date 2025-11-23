package JAVAMAP.java;

import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {

        Map<String, Integer> votes = new HashMap<>();

        // 10 simulated votes
        String[] castVotes = {
            "Aadi", "Riya", "Aman", "Aadi", "Riya",
            "Aadi", "Aman", "Riya", "Aadi", "Aadi"
        };

        // Count votes
        for (String candidate : castVotes) {
            votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        }

        // Print vote counts
        System.out.println("Vote Count:");
        for (Map.Entry<String, Integer> e : votes.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        // Find winner
        String winner = "";
        int maxVotes = -1;
        for (Map.Entry<String, Integer> e : votes.entrySet()) {
            if (e.getValue() > maxVotes) {
                maxVotes = e.getValue();
                winner = e.getKey();
            }
        }

        System.out.println("\nWinner: " + winner + " with " + maxVotes + " votes");
    }
}

