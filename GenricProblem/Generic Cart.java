package GenricProblem;

import java.util.*;

// Generic cart that can hold items of any type T
class Cart<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) { items.add(item); }
    public boolean removeItem(T item) { return items.remove(item); }
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        for (T it : items) System.out.println(it);
    }
    public List<T> getItems() { return items; }
}

// Simple classes for electronics and clothing
class Electronics {
    String name;
    Electronics(String name) { this.name = name; }
    public String toString() { return "Electronics: " + name; }
}

class Clothing {
    String name;
    Clothing(String name) { this.name = name; }
    public String toString() { return "Clothing: " + name; }
}

public class CartDemo {
    public static void main(String[] args) {
        // Cart for electronics only
        Cart<Electronics> eCart = new Cart<>();
        eCart.addItem(new Electronics("Smart TV"));
        eCart.addItem(new Electronics("Headphones"));

        // Cart for clothing only
        Cart<Clothing> cCart = new Cart<>();
        cCart.addItem(new Clothing("T-Shirt"));
        cCart.addItem(new Clothing("Jeans"));

        System.out.println("Electronics Cart:");
        eCart.displayItems();

        System.out.println("\nClothing Cart:");
        cCart.displayItems();

        
    }
}
