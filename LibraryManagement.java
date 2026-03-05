class Book {
    int id;
    String title;
    String author;
    String genre;
    boolean available;

    Book next, prev;

    Book(int id, String title, String author, String genre, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        next = prev = null;
    }
}

class Library {

    Book head = null;
    Book tail = null;

    // Add book at beginning
    void insertBeginning(int id, String title, String author, String genre, boolean available) {

        Book newBook = new Book(id, title, author, genre, available);

        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add book at end
    void insertEnd(int id, String title, String author, String genre, boolean available) {

        Book newBook = new Book(id, title, author, genre, available);

        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Insert at specific position
    void insertPosition(int pos, int id, String title, String author, String genre, boolean available) {

        if (pos == 1) {
            insertBeginning(id, title, author, genre, available);
            return;
        }

        Book newBook = new Book(id, title, author, genre, available);
        Book temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newBook.next = temp.next;
        newBook.prev = temp;

        if (temp.next != null)
            temp.next.prev = newBook;

        temp.next = newBook;

        if (newBook.next == null)
            tail = newBook;
    }

    // Remove book by ID
    void deleteBook(int id) {

        Book temp = head;

        while (temp != null && temp.id != id)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Book not found");
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

        System.out.println("Book removed");
    }

    // Search by title
    void searchByTitle(String title) {

        Book temp = head;

        while (temp != null) {
            if (temp.title.equals(title)) {
                System.out.println(temp.id + " " + temp.title + " " + temp.author + " " + temp.genre);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found");
    }

    // Search by author
    void searchByAuthor(String author) {

        Book temp = head;

        while (temp != null) {
            if (temp.author.equals(author)) {
                System.out.println(temp.id + " " + temp.title + " " + temp.genre);
            }
            temp = temp.next;
        }
    }

    // Update availability
    void updateAvailability(int id, boolean status) {

        Book temp = head;

        while (temp != null) {
            if (temp.id == id) {
                temp.available = status;
                System.out.println("Availability updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found");
    }

    // Display forward
    void displayForward() {

        Book temp = head;

        while (temp != null) {
            System.out.println(temp.id + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + temp.available);
            temp = temp.next;
        }
    }

    // Display reverse
    void displayReverse() {

        Book temp = tail;

        while (temp != null) {
            System.out.println(temp.id + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + temp.available);
            temp = temp.prev;
        }
    }

    // Count total books
    void countBooks() {

        int count = 0;
        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total Books: " + count);
    }
}

public class LibraryManagement {

    public static void main(String[] args) {

        Library lib = new Library();

        lib.insertBeginning(1, "Java Basics", "James Gosling", "Programming", true);
        lib.insertEnd(2, "Data Structures", "Mark Allen", "CS", true);
        lib.insertEnd(3, "Algorithms", "Robert Sedgewick", "CS", false);

        System.out.println("Library Books (Forward):");
        lib.displayForward();

        System.out.println("\nLibrary Books (Reverse):");
        lib.displayReverse();

        System.out.println("\nSearch by Title:");
        lib.searchByTitle("Algorithms");

        System.out.println("\nUpdate Availability:");
        lib.updateAvailability(3, true);

        System.out.println("\nDelete Book:");
        lib.deleteBook(2);

        System.out.println("\nTotal Books:");
        lib.countBooks();
    }
}
