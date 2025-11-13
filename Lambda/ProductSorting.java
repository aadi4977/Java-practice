import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;
    Product(String n, double p, double r, double d) {
        name = n; price = p; rating = r; discount = d;
    }
    public String toString() {
        return name + " " + price + " " + rating + " " + discount;
    }
}

public class ProductSorting {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 60000, 4.5, 10),
                new Product("Phone", 25000, 4.2, 5),
                new Product("Watch", 5000, 4.8, 15)
        );

        Collections.sort(products, (a, b) -> Double.compare(a.price, b.price));
        System.out.println(products);

        Collections.sort(products, (a, b) -> Double.compare(b.rating, a.rating));
        System.out.println(products);

        Collections.sort(products, (a, b) -> Double.compare(b.discount, a.discount));
        System.out.println(products);
    }
}
