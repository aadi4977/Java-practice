package JAVAMAP.java;

import java.util.*;

public class InventoryManagement {
    public static void main(String[] args) {

        Map<String, Integer> stock = new HashMap<>();

        // 1. Add initial products
        stock.put("Milk", 10);
        stock.put("Bread", 20);
        stock.put("Eggs", 5);

        // 2. Customer buys items
        stock.put("Milk", stock.get("Milk") - 3);  // bought 3  
        if (stock.get("Milk") <= 0) stock.put("Milk", 0);  // out of stock

        stock.put("Eggs", stock.get("Eggs") - 6);  // bought 6 (more than available)
        if (stock.get("Eggs") <= 0) stock.put("Eggs", 0);

        // 3. New shipment arrives
        stock.put("Bread", stock.get("Bread") + 15);

        // 4. Query a product
        String query = "Milk";
        if (stock.containsKey(query))
            System.out.println(query + " remaining: " + stock.get(query));
        else
            System.out.println(query + " not stocked");

        // Print all out-of-stock products
        System.out.println("\nProducts Out of Stock:");
        for (String product : stock.keySet()) {
            if (stock.get(product) == 0) {
                System.out.println(product);
            }
        }

        // Final Inventory List
        System.out.println("\nFinal Inventory:");
        for (Map.Entry<String, Integer> e : stock.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}

