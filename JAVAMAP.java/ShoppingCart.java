package JAVAMAP.java;
import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {

        // LinkedHashMap preserves insertion order
        LinkedHashMap<String, Double> cart = new LinkedHashMap<>();

        // 1. Add products (in order)
        cart.put("Laptop", 42000.0);
        cart.put("Mouse", 800.0);
        cart.put("Keyboard", 1500.0);
        cart.put("Headphones", 2200.0);
        cart.put("Monitor", 12000.0);

        // 2. Display products in order of addition
        System.out.println("Cart Items (in order added):");
        for (Map.Entry<String, Double> e : cart.entrySet()) {
            System.out.println(e.getKey() + " : ₹" + e.getValue());
        }

        // 3. Calculate total
        double total = 0;
        for (double price : cart.values()) total += price;
        System.out.println("\nTotal before discount: ₹" + total);

        // 4. Apply 10% discount if total > 5000
        if (total > 5000) {
            double discount = total * 0.10;
            total -= discount;
            System.out.println("Discount applied (10%): -₹" + discount);
        }

        // 5. Simulate user removing an item (quantity becomes zero)
        System.out.println("\nUser removes 'Mouse' from cart.");
        cart.remove("Mouse");

        // Recalculate total after removal
        double newTotal = 0;
        for (double price : cart.values()) newTotal += price;

        System.out.println("\nFinal Cart Items:");
        for (Map.Entry<String, Double> e : cart.entrySet()) {
            System.out.println(e.getKey() + " : ₹" + e.getValue());
        }
        System.out.println("Final Bill Amount: ₹" + newTotal);
    }
}

