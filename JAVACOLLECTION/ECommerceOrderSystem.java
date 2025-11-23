package JAVACOLLECTION;

import java.util.*;

// Represents a single order
class Order {
    private int orderId;
    private String customerName;
    private double amount;

    public Order(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    // Duplicate orders are identified by same orderId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order)) return false;
        Order other = (Order) obj;
        return this.orderId == other.orderId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(orderId);
    }

    @Override
    public String toString() {
        return "Order{id=" + orderId + ", name=" + customerName + ", amount=" + amount + "}";
    }
}

// Main system class
public class ECommerceOrderSystem {

    // 1) Store all orders placed (including duplicates)
    private List<Order> allOrders = new ArrayList<>();

    // 2) Remove duplicates (same orderId). LinkedHashSet maintains insertion order
    private Set<Order> uniqueOrders = new LinkedHashSet<>();

    // 3) Process orders in sequence (FIFO)
    private Queue<Order> processingQueue = new LinkedList<>();

    // 4) Failed orders to retry (LIFO)
    private Stack<Order> failedOrders = new Stack<>();

    // -------- TASK 1: Add orders to the system --------
    public void addOrder(Order order) {
        allOrders.add(order);
        System.out.println("Added: " + order);
    }

    // -------- TASK 2: Identify and remove duplicate orders --------
    public void prepareUniqueOrders() {
        uniqueOrders.clear();
        uniqueOrders.addAll(allOrders);  // Set removes duplicates
        System.out.println("\nAfter removing duplicates:");
        for (Order o : uniqueOrders) {
            System.out.println(o);
        }

        // Prepare processing queue in order of placement
        processingQueue.clear();
        processingQueue.addAll(uniqueOrders);
    }

    // -------- TASK 3: Process all valid orders in order of placement --------
    public void processOrders() {
        System.out.println("\nProcessing orders (FIFO):");
        while (!processingQueue.isEmpty()) {
            Order current = processingQueue.poll();  // remove from front of queue
            System.out.println("Processing: " + current);

            // Dummy rule: if amount > 5000, mark as failed
            if (current.getAmount() > 5000) {
                System.out.println(" -> Failed. Adding to retry stack.");
                failedOrders.push(current);
            } else {
                System.out.println(" -> Processed successfully.");
            }
        }
    }

    // -------- TASK 4: Re-process failed orders from the stack --------
    public void retryFailedOrders() {
        System.out.println("\nRe-processing failed orders (LIFO from Stack):");
        while (!failedOrders.isEmpty()) {
            Order failed = failedOrders.pop();  // last failed, first retried
            System.out.println("Retrying: " + failed);
            // For demo, assume retry always succeeds
            System.out.println(" -> Processed successfully on retry.");
        }
    }

    // ---------------- MAIN (DEMO) ----------------
    public static void main(String[] args) {
        ECommerceOrderSystem system = new ECommerceOrderSystem();

        // Adding some orders (including duplicates of orderId 102, 104)
        system.addOrder(new Order(101, "Aadi", 2500));
        system.addOrder(new Order(102, "Riya", 6000));  // will fail first time
        system.addOrder(new Order(103, "Aman", 1500));
        system.addOrder(new Order(102, "Riya Duplicate", 6000)); // duplicate ID
        system.addOrder(new Order(104, "Neha", 8000));  // will fail first time
        system.addOrder(new Order(104, "Neha Again", 8000)); // duplicate ID

        // Step 2: Remove duplicates and fill queue
        system.prepareUniqueOrders();

        // Step 3: Process all valid orders in sequence
        system.processOrders();

        // Step 4: Retry failed ones from stack
        system.retryFailedOrders();
    }
}
