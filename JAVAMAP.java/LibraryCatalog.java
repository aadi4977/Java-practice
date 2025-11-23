package JAVAMAP.java;
import java.util.*;

public class LibraryCatalog {
    public static void main(String[] args) {

        Map<String, String> catalog = new HashMap<>();

        // 1. Add books
        catalog.put("978-1111111111", "Data Structures");
        catalog.put("978-2222222222", "Operating Systems");
        catalog.put("978-3333333333", "Java Programming");

        // 2. Search by ISBN
        String searchISBN = "978-2222222222";
        if (catalog.containsKey(searchISBN))
            System.out.println("Found: " + catalog.get(searchISBN));
        else
            System.out.println("Book not found");

        // 3. Remove a book
        catalog.remove("978-3333333333");

        // 4. Print all ISBNs and titles sorted by ISBN
        System.out.println("\nCatalog (Sorted by ISBN):");
        catalog.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e ->
                    System.out.println(e.getKey() + " : " + e.getValue())
                );

        // EXTRA: Search by Title
        String titleSearch = "Data Structures";
        boolean found = false;

        for (Map.Entry<String, String> e : catalog.entrySet()) {
            if (e.getValue().equalsIgnoreCase(titleSearch)) {
                System.out.println("\nFound by Title: " + e.getKey() + " : " + e.getValue());
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("\nTitle not found");
    }
}

