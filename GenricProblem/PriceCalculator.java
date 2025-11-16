package GenricProblem;

import java.util.*;

// Product superclass
class Product {
    private String name;
    private double price;
    Product(String name, double price) { this.name = name; this.price = price; }
    public double getPrice() { return price; }
    public String toString() { return name + " - " + price; }
}

class Mobile extends Product { Mobile(String name, double price) { super(name, price); } }
class Laptop extends Product { Laptop(String name, double price) { super(name, price); } }

public class PriceCalculatorDemo {

    // sums prices of any list of Products (or subclasses)
    public static double calculateTotal(List<? extends Product> items) {
        double sum = 0.0;
        for (Product p : items) sum += p.getPrice();
        return sum;
    }

    public static void main(String[] args) {
        List<Mobile> mobiles = Arrays.asList(
            new Mobile("Phone X", 599.99),
            new Mobile("Phone Y", 799.50)
        );

        List<Laptop> laptops = Arrays.asList(
            new Laptop("Laptop A", 1200.0),
            new Laptop("Laptop B", 899.99)
        );

        System.out.println("Total mobiles: " + calculateTotal(mobiles));
        System.out.println("Total laptops: " + calculateTotal(laptops));

        // Mixed products (List<Product>) also works:
        List<Product> mixed = new ArrayList<>();
        mixed.addAll(mobiles);
        mixed.addAll(laptops);
        System.out.println("Total mixed: " + calculateTotal(mixed));
    }
}


