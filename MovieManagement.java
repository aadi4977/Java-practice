class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev, next;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        prev = next = null;
    }
}

class MovieList {

    Movie head = null;
    Movie tail = null;

    // Insert at beginning
    void insertBeginning(String title, String director, int year, double rating) {
        Movie newNode = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at end
    void insertEnd(String title, String director, int year, double rating) {
        Movie newNode = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Insert at position
    void insertPosition(int pos, String title, String director, int year, double rating) {

        if (pos == 1) {
            insertBeginning(title, director, year, rating);
            return;
        }

        Movie newNode = new Movie(title, director, year, rating);
        Movie temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    // Delete movie by title
    void deleteMovie(String title) {

        Movie temp = head;

        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;
        else
            tail = temp.prev;

        System.out.println("Movie deleted");
    }

    // Search by director
    void searchByDirector(String director) {

        Movie temp = head;

        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println(temp.title + " " + temp.year + " Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    // Search by rating
    void searchByRating(double rating) {

        Movie temp = head;

        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + " " + temp.director + " " + temp.year);
            }
            temp = temp.next;
        }
    }

    // Display forward
    void displayForward() {

        Movie temp = head;

        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    // Display reverse
    void displayReverse() {

        Movie temp = tail;

        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update rating by title
    void updateRating(String title, double newRating) {

        Movie temp = head;

        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found");
    }
}

public class MovieManagement {

    public static void main(String[] args) {

        MovieList list = new MovieList();

        list.insertBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        list.insertEnd("Avatar", "James Cameron", 2009, 7.9);
        list.insertEnd("Interstellar", "Christopher Nolan", 2014, 8.6);

        System.out.println("Movies (Forward):");
        list.displayForward();

        System.out.println("\nMovies (Reverse):");
        list.displayReverse();

        System.out.println("\nSearch by Director:");
        list.searchByDirector("Christopher Nolan");

        System.out.println("\nUpdating Rating:");
        list.updateRating("Avatar", 8.2);

        System.out.println("\nDeleting Movie:");
        list.deleteMovie("Avatar");

        System.out.println("\nMovies after deletion:");
        list.displayForward();
    }
}
