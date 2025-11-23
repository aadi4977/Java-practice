package JAVACOLLECTION;

import java.util.*;

// Team with points, for ranking
class Team implements Comparable<Team> {
    String name;
    int points;

    Team(String name) {
        this.name = name;
        this.points = 0;
    }

    @Override
    public int compareTo(Team t) {
        if (this.points != t.points)
            return t.points - this.points; // high → low
        return this.name.compareTo(t.name);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Team) && this.name.equals(((Team)o).name);
    }

    @Override
    public int hashCode() { return name.hashCode(); }

    @Override
    public String toString() { return name + " (" + points + ")"; }
}

class Match {
    Team t1, t2;
    Match(Team t1, Team t2) { this.t1 = t1; this.t2 = t2; }

    @Override
    public String toString() { return t1.name + " vs " + t2.name; }
}

class Result {
    Match match;
    Team winner;

    Result(Match match, Team winner) {
        this.match = match; this.winner = winner;
    }

    @Override
    public String toString() {
        return match + " | Winner: " + winner.name;
    }
}

public class TournamentScheduler {

    Set<Team> teams = new HashSet<>();             // unique teams
    Queue<Match> matchQueue = new LinkedList<>();  // scheduled matches
    List<Result> results = new ArrayList<>();      // all results
    TreeSet<Team> leaderboard = new TreeSet<>();   // sorted by points

    // 1. Register team
    void registerTeam(Team t) {
        if (teams.add(t)) {
            leaderboard.add(t);
            System.out.println("Registered: " + t.name);
        } else {
            System.out.println("Team already registered: " + t.name);
        }
    }

    // 1. Schedule match
    void scheduleMatch(Team a, Team b) {
        if (teams.contains(a) && teams.contains(b)) {
            matchQueue.add(new Match(a, b));
            System.out.println("Scheduled: " + a.name + " vs " + b.name);
        }
    }

    // 2 & 3. Process next match and record result
    void processNextMatch() {
        if (matchQueue.isEmpty()) {
            System.out.println("No matches in queue.");
            return;
        }
        Match m = matchQueue.poll();
        Team winner = m.t1;        // simple demo: t1 wins
        winner.points += 3;        // +3 points

        leaderboard.remove(winner); // update in TreeSet
        leaderboard.add(winner);

        Result r = new Result(m, winner);
        results.add(r);
        System.out.println("Result: " + r);
    }

    // 4. Display leaderboard
    void showLeaderboard() {
        System.out.println("\nLeaderboard:");
        for (Team t : leaderboard) {
            System.out.println(t);
        }
    }

    // ---- Demo ----
    public static void main(String[] args) {
        TournamentScheduler ts = new TournamentScheduler();

        Team a = new Team("Team A");
        Team b = new Team("Team B");
        Team c = new Team("Team C");

        ts.registerTeam(a);
        ts.registerTeam(b);
        ts.registerTeam(c);

        ts.scheduleMatch(a, b);
        ts.scheduleMatch(b, c);
        ts.scheduleMatch(a, c);

        ts.processNextMatch();
        ts.processNextMatch();
        ts.processNextMatch();

        ts.showLeaderboard();
    }
}
