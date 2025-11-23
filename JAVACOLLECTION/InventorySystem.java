package JAVACOLLECTION;

import java.util.*;

class Product {
    String name;
    double price;
    int stock;

    Product(String name, double price, int stock) {
        this.name = name; this.price = price; this.stock = stock;
    }

    @Override
    public String toString() {
        return name + " (₹" + price + ", stock=" + stock + ")";
    }
}

public class InventorySystem {

    Set<String> productNames = new HashSet<>();     // unique names
    List<Product> products = new ArrayList<>();     // all products
    Queue<Product> restockQueue = new LinkedList<>(); // to be restocked
    Stack<Product> restockStack = new Stack<>();    // recently restocked

    // 1. Add new products, avoid duplicates
    void addProduct(String name, double price, int stock) {
        if (productNames.add(name)) {  // true if not already present
            Product p = new Product(name, price, stock);
            products.add(p);
            System.out.println("Added: " + p);
        } else {
            System.out.println("Duplicate product: " + name);
        }
    }

    // 2. Identify low stock (<= threshold) and enqueue
    void findLowStock(int threshold) {
        for (Product p : products) {
            if (p.stock <= threshold) {
                restockQueue.add(p);
                System.out.println("Low stock, added to restock queue: " + p);
            }
        }
    }

    // 3. Process restock queue
    void processRestock(int addQty) {
        while (!restockQueue.isEmpty()) {
            Product p = restockQueue.poll();
            p.stock += addQty;
            restockStack.push(p);  // for possible undo
            System.out.println("Restocked: " + p);
        }
    }

    // 4. Undo last restock
    void undoLastRestock(int addQty) {
        if (restockStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        Product p = restockStack.pop();
        p.stock -= addQty;
        System.out.println("Undo restock: " + p);
    }

    // ---------- Demo ----------
    public static void main(String[] args) {
        InventorySystem inv = new InventorySystem();

        inv.addProduct("Milk", 50, 2);
        inv.addProduct("Bread", 30, 10);
        inv.addProduct("Eggs", 6, 3);
        inv.addProduct("Milk", 55, 5); // duplicate

        inv.findLowStock(5);     // enqueue low-stock items
        inv.processRestock(10);  // add 10 units each
        inv.undoLastRestock(10); // undo last restock
    }
}

