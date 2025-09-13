package JAVACLASSANDOBJ.LVL1;

class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayItem() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Unit: " + price);
    }

    double calculateTotal(int quantity) {
        return price * quantity;
    }
}

public class InventoryTest {
    public static void main(String[] args) {
        Item item1 = new Item(101, "Notebook", 45.50);
        item1.displayItem();
        int quantity = 5;
        double totalCost = item1.calculateTotal(quantity);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + totalCost);
    }
}
