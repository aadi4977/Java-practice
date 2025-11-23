package JAVACOLLECTION;

import java.util.*;

class Movie {
    String title;
    String genre;

    Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return title + " [" + genre + "]";
    }
}

public class StreamingSystem {

    Stack<Movie> watchHistory = new Stack<>();   // recently watched
    List<Movie> allMovies = new ArrayList<>();   // all available movies
    Set<String> genresWatched = new HashSet<>(); // unique genres watched
    Queue<Movie> upNext = new LinkedList<>();    // upcoming

    // add movie to catalog
    void addToCatalog(Movie m) {
        allMovies.add(m);
    }

    // 1. Add movies to "Up Next"
    void addToUpNext(Movie m) {
        upNext.add(m);
        System.out.println("Queued: " + m);
    }

    // 2 & 3. Play next movie and move to history
    void playNext() {
        if (upNext.isEmpty()) {
            System.out.println("No movies in Up Next.");
            return;
        }
        Movie m = upNext.poll();
        System.out.println("Now playing: " + m);

        watchHistory.push(m);
        genresWatched.add(m.genre);
    }

    // 4. Simple recommendations based on watched genres
    void showRecommendations() {
        System.out.println("\nRecommendations (same genres you've watched):");
        for (Movie m : allMovies) {
            if (genresWatched.contains(m.genre) && !watchHistory.contains(m)) {
                System.out.println(" - " + m);
            }
        }
    }

    // -------- Demo --------
    public static void main(String[] args) {
        StreamingSystem s = new StreamingSystem();

        Movie m1 = new Movie("Inception", "Sci-Fi");
        Movie m2 = new Movie("Interstellar", "Sci-Fi");
        Movie m3 = new Movie("La La Land", "Romance");
        Movie m4 = new Movie("The Notebook", "Romance");

        s.addToCatalog(m1);
        s.addToCatalog(m2);
        s.addToCatalog(m3);
        s.addToCatalog(m4);

        s.addToUpNext(m1);
        s.addToUpNext(m3);

        s.playNext(); // watch Inception (Sci-Fi)
        s.playNext(); // watch La La Land (Romance)

        s.showRecommendations();
    }
}

