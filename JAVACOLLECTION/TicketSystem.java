package JAVACOLLECTION;

import java.util.*;

// Booking class
class Booking {
    String user;
    String event;
    boolean isVIP;

    Booking(String user, String event, boolean isVIP) {
        this.user = user;
        this.event = event;
        this.isVIP = isVIP;
    }

    @Override
    public String toString() {
        return user + " - " + event + (isVIP ? " (VIP)" : "");
    }
}

public class TicketSystem {

    Set<String> users = new HashSet<>();            // prevent duplicate users
    Queue<Booking> normalQueue = new LinkedList<>(); // normal booking queue
    PriorityQueue<Booking> vipQueue = new PriorityQueue<>(
            (a, b) -> Boolean.compare(b.isVIP, a.isVIP));    // VIP first

    List<Booking> confirmed = new ArrayList<>();    // confirmed bookings list

    // 1. Register user
    void register(String user) {
        if (users.add(user))
            System.out.println("User Registered: " + user);
        else
            System.out.println("Duplicate User: " + user);
    }

    // 2. Accept booking request
    void addBooking(Booking b) {
        if (!users.contains(b.user)) {
            System.out.println("User not registered: " + b.user);
            return;
        }

        if (b.isVIP)
            vipQueue.add(b);
        else
            normalQueue.add(b);

        System.out.println("Booking Added: " + b);
    }

    // 3 & 4. Confirm booking (VIPs first)
    void confirmNext() {
        Booking b;

        if (!vipQueue.isEmpty())
            b = vipQueue.poll();
        else if (!normalQueue.isEmpty())
            b = normalQueue.poll();
        else {
            System.out.println("No pending bookings.");
            return;
        }

        confirmed.add(b);
        System.out.println("Confirmed: " + b);
    }

    // Summary
    void showConfirmed() {
        System.out.println("\nConfirmed Bookings:");
        for (Booking b : confirmed)
            System.out.println(" - " + b);
    }

    // -------- Demo --------
    public static void main(String[] args) {
        TicketSystem ts = new TicketSystem();

        ts.register("Aadi");
        ts.register("Riya");
        ts.register("Aadi"); // duplicate

        ts.addBooking(new Booking("Aadi", "Concert", false));
        ts.addBooking(new Booking("Riya", "Concert", true));  // VIP
        ts.addBooking(new Booking("Aman", "Concert", true));  // not registered

        ts.confirmNext();  // VIP first
        ts.confirmNext();  // then normal
        ts.confirmNext();  // no bookings left

        ts.showConfirmed();
    }
}

