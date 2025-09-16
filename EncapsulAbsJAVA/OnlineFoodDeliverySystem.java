package EncapsulAbsJAVA;

import java.util.*;

// Interface
interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

// Abstract Class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract Method
    public abstract double calculateTotalPrice();

    // Concrete Method
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }

    // Encapsulation
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

// VegItem
class VegItem extends FoodItem implements Discountable {
    private double discountApplied = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - discountApplied;
    }

    @Override
    public void applyDiscount(double percent) {
        discountApplied = (getPrice() * getQuantity()) * (percent / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount applied: ₹" + discountApplied;
    }
}

// NonVegItem
class NonVegItem extends FoodItem implements Discountable {
    private double discountApplied = 0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double basePrice = getPrice() * getQuantity();
        double nonVegCharge = basePrice * 0.10; // 10% extra
        return (basePrice + nonVegCharge) - discountApplied;
    }

    @Override
    public void applyDiscount(double percent) {
        double basePrice = getPrice() * getQuantity();
        discountApplied = (basePrice) * (percent / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount applied: ₹" + discountApplied;
    }
}

// Main Class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        VegItem veg = new VegItem("Paneer Butter Masala", 200, 2);
        NonVegItem nonVeg = new NonVegItem("Chicken Biryani", 300, 1);

        veg.applyDiscount(10); // 10% discount
        nonVeg.applyDiscount(5); // 5% discount

        order.add(veg);
        order.add(nonVeg);

        double totalBill = 0;
        System.out.println("===== Order Summary =====");
        for (FoodItem item : order) {
            item.getItemDetails();
            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                System.out.println(d.getDiscountDetails());
            }
            double cost = item.calculateTotalPrice();
            System.out.println("Total: ₹" + cost);
            totalBill += cost;
            System.out.println("-----");
        }
        System.out.println("Final Bill: ₹" + totalBill);
    }
}

