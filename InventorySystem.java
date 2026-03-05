class Item {
    int id;
    String name;
    int quantity;
    double price;
    Item next;

    Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        next = null;
    }
}

class Inventory {

    Item head = null;

    // Add at beginning
    void insertBeginning(int id, String name, int quantity, double price) {

        Item newItem = new Item(id, name, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add at end
    void insertEnd(int id, String name, int quantity, double price) {

        Item newItem = new Item(id, name, quantity, price);

        if (head == null) {
            head = newItem;
            return;
        }

        Item temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newItem;
    }

    // Insert at position
    void insertPosition(int pos, int id, String name, int quantity, double price) {

        if (pos == 1) {
            insertBeginning(id, name, quantity, price);
            return;
        }

        Item newItem = new Item(id, name, quantity, price);
        Item temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Delete by Item ID
    void deleteItem(int id) {

        Item temp = head;
        Item prev = null;

        while (temp != null && temp.id != id) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Item not found");
            return;
        }

        if (prev == null)
            head = temp.next;
        else
            prev.next = temp.next;

        System.out.println("Item removed");
    }

    // Update quantity
    void updateQuantity(int id, int newQuantity) {

        Item temp = head;

        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // Search by ID
    void searchByID(int id) {

        Item temp = head;

        while (temp != null) {
            if (temp.id == id) {
                System.out.println(temp.id + " " + temp.name + " " + temp.quantity + " " + temp.price);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // Search by Name
    void searchByName(String name) {

        Item temp = head;

        while (temp != null) {
            if (temp.name.equals(name)) {
                System.out.println(temp.id + " " + temp.name + " " + temp.quantity + " " + temp.price);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // Display inventory
    void display() {

        Item temp = head;

        while (temp != null) {
            System.out.println(temp.id + " | " + temp.name + " | " + temp.quantity + " | " + temp.price);
            temp = temp.next;
        }
    }

    // Calculate total inventory value
    void totalValue() {

        Item temp = head;
        double total = 0;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = " + total);
    }

    // Sort by price (ascending)
    void sortByPrice() {

        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {

                if (i.price > j.price) {

                    int tid = i.id;
                    String tname = i.name;
                    int tq = i.quantity;
                    double tp = i.price;

                    i.id = j.id;
                    i.name = j.name;
                    i.quantity = j.quantity;
                    i.price = j.price;

                    j.id = tid;
                    j.name = tname;
                    j.quantity = tq;
                    j.price = tp;
                }
            }
        }
    }

}

public class InventorySystem {

    public static void main(String[] args) {

        Inventory inv = new Inventory();

        inv.insertBeginning(101, "Keyboard", 10, 500);
        inv.insertEnd(102, "Mouse", 20, 200);
        inv.insertEnd(103, "Monitor", 5, 8000);

        System.out.println("Inventory List:");
        inv.display();

        System.out.println("\nSearch Item ID 102:");
        inv.searchByID(102);

        System.out.println("\nUpdate Quantity:");
        inv.updateQuantity(101, 15);

        System.out.println("\nTotal Inventory Value:");
        inv.totalValue();

        System.out.println("\nSorted by Price:");
        inv.sortByPrice();
        inv.display();

        System.out.println("\nDelete Item 102:");
        inv.deleteItem(102);

        System.out.println("\nFinal Inventory:");
        inv.display();
    }
}
