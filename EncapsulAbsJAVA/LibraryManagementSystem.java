package EncapsulAbsJAVA;

import java.util.*;

// Interface
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract Class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    // Encapsulated borrower info
    private String borrowerName;
    private boolean reserved;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.reserved = false;
        this.borrowerName = null;
    }

    // Abstract Method
    public abstract int getLoanDuration();

    // Concrete Method
    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }

    // Encapsulation: Getters/Setters for borrower
    public String getBorrowerName() { return borrowerName; }
    protected void setBorrowerName(String borrowerName) { this.borrowerName = borrowerName; }

    public boolean isReserved() { return reserved; }
    protected void setReserved(boolean reserved) { this.reserved = reserved; }
}

// Book Class
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days loan
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setReserved(true);
            setBorrowerName(borrowerName);
            System.out.println("Book reserved for " + borrowerName);
        } else {
            System.out.println("Book already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }
}

// Magazine Class
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days loan
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setReserved(true);
            setBorrowerName(borrowerName);
            System.out.println("Magazine reserved for " + borrowerName);
        } else {
            System.out.println("Magazine already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }
}

// DVD Class
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days loan
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setReserved(true);
            setBorrowerName(borrowerName);
            System.out.println("DVD reserved for " + borrowerName);
        } else {
            System.out.println("DVD already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B001", "The Java Handbook", "James Gosling"));
        items.add(new Magazine("M101", "Tech Monthly", "Editorial Team"));
        items.add(new DVD("D555", "Inception", "Christopher Nolan"));

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Available: " + reservableItem.checkAvailability());
                reservableItem.reserveItem("Alice");
                System.out.println("Available after reservation: " + reservableItem.checkAvailability());
            }
            System.out.println("-----");
        }
    }
}

