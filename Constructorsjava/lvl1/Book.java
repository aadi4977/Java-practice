package Constructorsjava.lvl1;
class Book {
    String title;
    String author;
    double price;

    // Default constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor
    Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }

    public static void main(String[] args) {
        Book b1 = new Book();   // default
        System.out.println(b1.title + " - " + b1.author + " - " + b1.price);

        Book b2 = new Book("Java", "James Gosling", 499.99); // parameterized
        System.out.println(b2.title + " - " + b2.author + " - " + b2.price);
    }
}
