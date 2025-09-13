package JAVACLASSANDOBJ.LVL2;



import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return price * quantity;
    }

    void displayItem() {
        System.out.println(itemName + " | Price: " + price + " | Quantity: " + quantity + " | Total: " + getTotalPrice());
    }
}

class ShoppingCart {
    ArrayList<CartItem> items = new ArrayList<>();

    void addItem(CartItem item) {
        items.add(item);
        System.out.println(item.itemName + " added to cart.");
    }

    void removeItem(String itemName) {
        boolean removed = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).itemName.equalsIgnoreCase(itemName)) {
                items.remove(i);
                System.out.println(itemName + " removed from cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println(itemName + " not found in cart.");
        }
    }

    void displayTotalCost() {
        double total = 0;
        System.out.println("\n--- Cart Items ---");
        for (CartItem item : items) {
            item.displayItem();
            total += item.getTotalPrice();
        }
        System.out.println("Total Cart Cost: " + total);
    }
}

public class ShoppingTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        CartItem i1 = new CartItem("Laptop", 55000, 1);
        CartItem i2 = new CartItem("Headphones", 2500, 2);
        CartItem i3 = new CartItem("Mouse", 700, 1);

        cart.addItem(i1);
        cart.addItem(i2);
        cart.addItem(i3);

        cart.displayTotalCost();

        System.out.println("\nRemoving Headphones...");
        cart.removeItem("Headphones");

        cart.displayTotalCost();
    }
}

