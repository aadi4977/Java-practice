package GenricProblem;

import java.util.*;

// ---------- 1) Abstract WarehouseItem ----------
abstract class WarehouseItem {
    private String name;
    private double price;

    WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + name + " (₹" + price + ")";
    }
}

// Subclasses
class Electronics extends WarehouseItem {
    Electronics(String name, double price) { super(name, price); }
}
class Groceries extends WarehouseItem {
    Groceries(String name, double price) { super(name, price); }
}
class Furniture extends WarehouseItem {
    Furniture(String name, double price) { super(name, price); }
}

// ---------- 2) Generic Storage ----------
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) { items.add(item); }
    public List<T> getItems() { return items; }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Storage is empty.");
            return;
        }
        for (T it : items) {
            System.out.println(it);
        }
    }
}

// ---------- 3) Wildcard method to display any items ----------
class WarehouseUtils {
    // accepts a list of any subtype of WarehouseItem
    public static void displayAll(List<? extends WarehouseItem> items) {
        if (items.isEmpty()) {
            System.out.println("No items to display.");
            return;
        }
        for (WarehouseItem wi : items) {
            System.out.println(wi);
        }
    }

    // example: total price calculation using bounded wildcard
    public static double totalPrice(List<? extends WarehouseItem> items) {
        double total = 0.0;
        for (WarehouseItem wi : items) total += wi.getPrice();
        return total;
    }
}

// ---------- Demo / main ----------
public class WarehouseDemo {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Smartphone X", 29999.0));
        electronicsStorage.addItem(new Electronics("Smart TV 55\"", 54999.0));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice 5kg", 450.0));
        groceriesStorage.addItem(new Groceries("Olive Oil 1L", 999.0));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Dining Table", 19999.0));

        System.out.println("Electronics Storage (using Storage.displayItems):");
        electronicsStorage.displayItems();

        System.out.println("\nGroceries Storage (using WarehouseUtils.displayAll):");
        WarehouseUtils.displayAll(groceriesStorage.getItems()); // wildcard accepts List<Groceries>

        System.out.println("\nAll Furniture items:");
        WarehouseUtils.displayAll(furnitureStorage.getItems());

        System.out.println("\nTotal price of electronics: ₹" +
            WarehouseUtils.totalPrice(electronicsStorage.getItems()));

        // You can also combine different WarehouseItem lists into a List<WarehouseItem>
        List<WarehouseItem> mixed = new ArrayList<>();
        mixed.addAll(electronicsStorage.getItems());
        mixed.addAll(groceriesStorage.getItems());
        System.out.println("\nMixed items (displayAll on List<WarehouseItem>):");
        WarehouseUtils.displayAll(mixed);

        System.out.println("\nTotal price of mixed: ₹" + WarehouseUtils.totalPrice(mixed));
    }
}

