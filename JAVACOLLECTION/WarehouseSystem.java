package JAVACOLLECTION;
import java.util.*;

// Package class
class Package {
    String id;
    String address;

    Package(String id, String address) {
        this.id = id;
        this.address = address;
    }

    @Override
    public String toString() {
        return id + " -> " + address;
    }
}

public class WarehouseSystem {

    Queue<Package> pending = new LinkedList<>();     // pending deliveries
    Set<String> packageIDs = new HashSet<>();        // unique package IDs
    List<Package> delivered = new ArrayList<>();     // delivered packages
    Stack<Package> returned = new Stack<>();         // cancelled/returned

    // 1. Add delivery request (ensure unique ID)
    void addPackage(Package p) {
        if (packageIDs.add(p.id)) {
            pending.add(p);
            System.out.println("Added: " + p);
        } else {
            System.out.println("Duplicate Package ID: " + p.id);
        }
    }

    // 2. Process delivery (deliver or return)
    void processNext(boolean isDelivered) {
        if (pending.isEmpty()) {
            System.out.println("No pending packages.");
            return;
        }

        Package p = pending.poll();

        if (isDelivered) {
            delivered.add(p);
            System.out.println("Delivered: " + p);
        } else {
            returned.push(p);
            System.out.println("Returned: " + p);
        }
    }

    // 4. Summary
    void showSummary() {
        System.out.println("\n--- Delivery Summary ---");

        System.out.println("Delivered:");
        for (Package p : delivered) System.out.println(" - " + p);

        System.out.println("Returned:");
        for (Package p : returned) System.out.println(" - " + p);
    }

    // ------- Demo --------
    public static void main(String[] args) {
        WarehouseSystem ws = new WarehouseSystem();

        ws.addPackage(new Package("P101", "Delhi"));
        ws.addPackage(new Package("P102", "Mumbai"));
        ws.addPackage(new Package("P101", "DuplicateID")); // duplicate
        ws.addPackage(new Package("P103", "Chennai"));

        ws.processNext(true);   // deliver
        ws.processNext(false);  // return
        ws.processNext(true);   // deliver

        ws.showSummary();
    }
}
