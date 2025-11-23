package JAVACOLLECTION;

import java.util.*;

class RideRequest {
    int id, priority;
    String user;
    RideRequest(int id, String user, int priority) {
        this.id = id; this.user = user; this.priority = priority;
    }
}

class Driver {
    int id; String name;
    Driver(int id, String name) { this.id = id; this.name = name; }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Driver) && this.id == ((Driver)o).id;
    }
    @Override
    public int hashCode() { return id; }
}

class Ride {
    RideRequest req; Driver drv;
    Ride(RideRequest req, Driver drv) {
        this.req = req; this.drv = drv;
    }
}

public class RideSharingShort {

    Queue<RideRequest> pending = new LinkedList<>();
    Set<Driver> drivers = new HashSet<>();
    List<Ride> history = new ArrayList<>();

    // highest priority first
    PriorityQueue<RideRequest> priorityQ =
        new PriorityQueue<>((a,b) -> b.priority - a.priority);

    // 1. Add request
    void addRequest(RideRequest r) {
        pending.add(r);
        priorityQ.add(r);
    }

    // Add driver to pool
    void addDriver(Driver d) {
        drivers.add(d);
    }

    // 2 & 4. Assign driver (priority first)
    Ride assignRide() {
        if (drivers.isEmpty()) return null;

        RideRequest r = priorityQ.poll();   // get highest priority
        pending.remove(r);                 // remove from normal queue

        Driver d = drivers.iterator().next();
        drivers.remove(d);

        return new Ride(r, d);
    }

    // 3. Complete ride
    void complete(Ride r) {
        history.add(r);
        drivers.add(r.drv);
    }

    // ---------- Demo ----------
    public static void main(String[] args) {
        RideSharingShort sys = new RideSharingShort();

        sys.addDriver(new Driver(1, "Rahul"));
        sys.addDriver(new Driver(2, "Neha"));

        sys.addRequest(new RideRequest(101, "Aadi", 3));
        sys.addRequest(new RideRequest(102, "Riya", 9)); // high priority
        sys.addRequest(new RideRequest(103, "Aman", 5));

        Ride r1 = sys.assignRide();
        sys.complete(r1);

        Ride r2 = sys.assignRide();
        sys.complete(r2);

        System.out.println("Completed Rides: " + sys.history.size());
    }
}

