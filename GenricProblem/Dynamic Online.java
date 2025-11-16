package GenricProblem;

import java.util.*;

// ---------- Categories ----------
abstract class Category {
    private String name;
    Category(String name) { this.name = name; }
    public String getName() { return name; }
    @Override
    public String toString() { return name; }
}

class BookCategory extends Category { BookCategory(String name) { super(name); } }
class ClothingCategory extends Category { ClothingCategory(String name) { super(name); } }
class GadgetCategory extends Category { GadgetCategory(String name) { super(name); } }

// ---------- Product with type parameter for Category ----------
class Product<C extends Category> {
    private String title;
    private double price;
    private C category;

    public Product(String title, double price, C category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public C getCategory() { return category; }

    @Override
    public String toString() {
        return title + " [" + category + "] - ₹" + String.format("%.2f", price);
    }
}

// ---------- Utility with generic method to apply discount ----------
class MarketplaceUtils {
    // Works for any Product<C> (keeps relation between product and its category)
    public static <C extends Category, P extends Product<C>> void applyDiscount(P product, double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Percent must be between 0 and 100");
        }
        double newPrice = product.getPrice() * (1 - percent / 100.0);
        product.setPrice(newPrice);
    }
}

// ---------- Catalog that can hold different product categories ----------
class Catalog {
    // store products of any category
    private List<Product<? extends Category>> items = new ArrayList<>();

    public void addProduct(Product<? extends Category> p) {
        items.add(p);
    }

    public void displayProducts() {
        if (items.isEmpty()) {
            System.out.println("Catalog is empty.");
            return;
        }
        for (Product<? extends Category> p : items) {
            System.out.println(p);
        }
    }
}

// ---------- Demo ----------
public class MarketplaceDemo {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        Product<BookCategory> book = new Product<>("Java Fundamentals", 599.0, new BookCategory("Programming Books"));
        Product<ClothingCategory> tshirt = new Product<>("Graphic Tee", 799.0, new ClothingCategory("Casual Wear"));
        Product<GadgetCategory> phone = new Product<>("Phone X", 29999.0, new GadgetCategory("Smartphones"));

        catalog.addProduct(book);
        catalog.addProduct(tshirt);
        catalog.addProduct(phone);

        System.out.println("Catalog (before discounts):");
        catalog.displayProducts();

        // Apply discounts dynamically using generic method
        MarketplaceUtils.applyDiscount(book, 10.0);    // 10% off book
        MarketplaceUtils.applyDiscount(phone, 5.0);    // 5% off phone
        MarketplaceUtils.applyDiscount(tshirt, 20.0);  // 20% off clothing

        System.out.println("\nCatalog (after discounts):");
        catalog.displayProducts();
    }
}
