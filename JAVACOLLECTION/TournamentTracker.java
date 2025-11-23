package JAVACOLLECTION;

import java.util.*;

// --------- Player ----------
class Player {
    int id;
    String name;

    Player(int id, String name) {
        this.id = id; this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Player) && this.id == ((Player)o).id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return name + "(" + id + ")";
    }
}

// --------- Match ----------
class Match {
    Player p1, p2;

    Match(Player p1, Player p2) {
        this.p1 = p1; this.p2 = p2;
    }

    @Override
    public String toString() {
        return p1 + " vs " + p2;
    }
}

// --------- Result ----------
class Result {
    Match match;
    Player winner;

    Result(Match match, Player winner) {
        this.match = match; this.winner = winner;
    }

    @Override
    public String toString() {
        return match + " | Winner: " + winner;
    }
}

// --------- Score (for leaderboard) ----------
class Score implements Comparable<Score> {
    Player player;
    int points;

    Score(Player player, int points) {
        this.player = player; this.points = points;
    }

    @Override
    public int compareTo(Score o) {
        if (this.points != o.points)
            return o.points - this.points;  // descending by score
        return this.player.id - o.player.id; // tie-breaker
    }

    @Override
    public String toString() {
        return player + " -> " + points;
    }
}

// --------- Tournament System ----------
public class TournamentTracker {

    Set<Player> players = new HashSet<>();           // register players
    Queue<Match> matchQueue = new LinkedList<>();    // upcoming matches
    List<Result> results = new ArrayList<>();        // match outcomes
    TreeSet<Score> leaderboard = new TreeSet<>();    // sorted scores
    Map<Player, Integer> scoreMap = new HashMap<>(); // internal scores

    // 1. Register players
    void registerPlayer(Player p) {
        if (players.add(p))
            System.out.println("Registered: " + p);
        else
            System.out.println("Duplicate player: " + p);
    }

    // 2. Schedule matches
    void scheduleMatch(Player p1, Player p2) {
        if (players.contains(p1) && players.contains(p2)) {
            matchQueue.add(new Match(p1, p2));
            System.out.println("Scheduled: " + p1 + " vs " + p2);
        } else {
            System.out.println("Both players must be registered.");
        }
    }

    // Process next match: pick winner (for demo: p1 wins)
    void processNextMatch() {
        if (matchQueue.isEmpty()) return;

        Match m = matchQueue.poll();
        Player winner = m.p1; // simple demo logic

        System.out.println("Processing match: " + m);
        recordResult(m, winner);
    }

    // 3. Record result & update leaderboard
    void recordResult(Match m, Player winner) {
        Result r = new Result(m, winner);
        results.add(r);
        System.out.println("Result: " + r);

        int newScore = scoreMap.getOrDefault(winner, 0) + 3; // +3 points
        scoreMap.put(winner, newScore);

        // rebuild leaderboard entry for this player
        leaderboard.removeIf(s -> s.player.equals(winner));
        leaderboard.add(new Score(winner, newScore));
    }

    // 4. Display leaderboard
    void showLeaderboard() {
        System.out.println("\nLeaderboard:");
        for (Score s : leaderboard) {
            System.out.println(s);
        }
    }

    // ------------- Demo -------------
    public static void main(String[] args) {
        TournamentTracker t = new TournamentTracker();

        Player a = new Player(1, "Aadi");
        Player b = new Player(2, "Riya");
        Player c = new Player(3, "Aman");

        t.registerPlayer(a);
        t.registerPlayer(b);
        t.registerPlayer(c);
        t.registerPlayer(new Player(1, "DuplicateAadi")); // duplicate

        t.scheduleMatch(a, b);
        t.scheduleMatch(b, c);
        t.scheduleMatch(a, c);

        t.processNextMatch();
        t.processNextMatch();
        t.processNextMatch();

        t.showLeaderboard();
    }
}
