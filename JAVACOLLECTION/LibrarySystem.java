package JAVACOLLECTION;

import java.util.*;

class Book {
    int id;
    String title;

    Book(int id, String title) {
        this.id = id; this.title = title;
    }

    @Override
    public String toString() { return id + " - " + title; }
}

public class LibrarySystem {

    List<Book> books = new ArrayList<>();          // all books
    Set<String> memberIds = new HashSet<>();       // unique members
    Queue<Book> issueQueue = new LinkedList<>();   // waiting to be issued
    Stack<Book> returnedStack = new Stack<>();     // recently returned

    // 1. Add books
    void addBook(Book b) {
        books.add(b);
        System.out.println("Book added: " + b);
    }

    // 3. Register members (no duplicates)
    void registerMember(String memberId) {
        if (memberIds.add(memberId))
            System.out.println("Member registered: " + memberId);
        else
            System.out.println("Duplicate member: " + memberId);
    }

    // 2. Add book to issue queue
    void requestIssue(Book b) {
        issueQueue.add(b);
        System.out.println("Issue requested: " + b);
    }

    // Issue next book (simple demo)
    void issueNext() {
        if (issueQueue.isEmpty()) {
            System.out.println("No books to issue.");
            return;
        }
        Book b = issueQueue.poll();
        System.out.println("Issued: " + b);
    }

    // Return book
    void returnBook(Book b) {
        returnedStack.push(b);
        System.out.println("Returned: " + b);
    }

    // 4. Re-issue most recently returned book
    void reissueLastReturned() {
        if (returnedStack.isEmpty()) {
            System.out.println("No recently returned books.");
            return;
        }
        Book b = returnedStack.pop();
        System.out.println("Re-issued (recent): " + b);
    }

    // ---- Demo ----
    public static void main(String[] args) {
        LibrarySystem lib = new LibrarySystem();

        lib.addBook(new Book(1, "DSA"));
        lib.addBook(new Book(2, "Java"));

        lib.registerMember("M101");
        lib.registerMember("M101"); // duplicate

        Book b1 = lib.books.get(0);
        Book b2 = lib.books.get(1);

        lib.requestIssue(b1);
        lib.requestIssue(b2);
        lib.issueNext();
        lib.issueNext();

        lib.returnBook(b1);
        lib.reissueLastReturned();
    }
}

