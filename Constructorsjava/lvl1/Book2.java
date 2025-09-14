package Constructorsjava.lvl1;
class Book {
    String title;
    String author;
    double price;
    boolean available;

    // Constructor
    Book(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    // Method to borrow a book
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed successfully.");
        } else {
            System.out.println(title + " is not available right now.");
        }
    }

    // Method to display book details
    void display() {
        System.out.println("Title: " + title +
                           ", Author: " + author +
                           ", Price: " + price +
                           ", Available: " + available);
    }

    public static void main(String[] args) {
        // Create books
        Book b1 = new Book("Java Programming", "James Gosling", 499.99, true);
        Book b2 = new Book("Python Basics", "Guido van Rossum", 299.99, false);

        // Display details
        b1.display();
        b2.display();

        System.out.println();

        // Try borrowing
        b1.borrowBook();  // will succeed
        b2.borrowBook();  // will fail

        // Show updated status
        b1.display();
        b2.display();
    }
}
