package JAVACOLLECTION;

import java.util.*;

class Parcel {
    String id;
    String address;
    int priority; // higher = more important

    Parcel(String id, String address, int priority) {
        this.id = id;
        this.address = address;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return id + " -> " + address + " (P=" + priority + ")";
    }
}

public class CourierSystem {

    // high-priority deliveries
    PriorityQueue<Parcel> highPriority =
            new PriorityQueue<>((a, b) -> b.priority - a.priority);

    // normal pending deliveries
    Queue<Parcel> normalQueue = new LinkedList<>();

    // track used delivery IDs (no duplicates)
    Set<String> deliveryIds = new HashSet<>();

    // completed deliveries
    List<Parcel> completed = new ArrayList<>();

    // 1. Add parcels with priority
    void addParcel(Parcel p) {
        if (!deliveryIds.add(p.id)) {       // false => already used
            System.out.println("Duplicate ID: " + p.id);
            return;
        }
        if (p.priority > 5) {
            highPriority.add(p);
        } else {
            normalQueue.add(p);
        }
        System.out.println("Added: " + p);
    }

    // 2 & 3. Assign agent and complete delivery
    void assignAndComplete(String agentName) {
        Parcel p;

        if (!highPriority.isEmpty()) {
            p = highPriority.poll();
        } else if (!normalQueue.isEmpty()) {
            p = normalQueue.poll();
        } else {
            System.out.println("No pending parcels.");
            return;
        }

        System.out.println("Agent " + agentName + " delivering: " + p);
        completed.add(p);   // move to completed list
    }

    // -------- Demo --------
    public static void main(String[] args) {
        CourierSystem cs = new CourierSystem();

        cs.addParcel(new Parcel("D101", "Delhi", 9));
        cs.addParcel(new Parcel("D102", "Mumbai", 3));
        cs.addParcel(new Parcel("D101", "Duplicate", 7)); // duplicate ID
        cs.addParcel(new Parcel("D103", "Chennai", 8));

        cs.assignAndComplete("Ravi");
        cs.assignAndComplete("Neha");
        cs.assignAndComplete("Aman");

        System.out.println("\nCompleted Deliveries:");
        for (Parcel p : cs.completed) {
            System.out.println(" - " + p);
        }
    }
}

