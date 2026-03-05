class Ticket {

    int ticketID;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;

    Ticket next;

    Ticket(int id, String customer, String movie, int seat, String time) {
        ticketID = id;
        customerName = customer;
        movieName = movie;
        seatNumber = seat;
        bookingTime = time;
        next = null;
    }
}

class TicketSystem {

    Ticket head = null;

    // Add ticket at end
    void addTicket(int id, String customer, String movie, int seat, String time) {

        Ticket newTicket = new Ticket(id, customer, movie, seat, time);

        if (head == null) {
            head = newTicket;
            newTicket.next = head;
            return;
        }

        Ticket temp = head;

        while (temp.next != head)
            temp = temp.next;

        temp.next = newTicket;
        newTicket.next = head;
    }

    // Remove ticket by ID
    void removeTicket(int id) {

        if (head == null)
            return;

        Ticket temp = head;
        Ticket prev = null;

        do {

            if (temp.ticketID == id)
                break;

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        if (temp.ticketID != id) {
            System.out.println("Ticket not found");
            return;
        }

        if (temp == head) {

            Ticket last = head;

            while (last.next != head)
                last = last.next;

            if (head.next == head) {
                head = null;
                return;
            }

            head = head.next;
            last.next = head;

        } else {
            prev.next = temp.next;
        }

        System.out.println("Ticket removed");
    }

    // Display tickets
    void displayTickets() {

        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;

        do {

            System.out.println(
                    temp.ticketID + " | " +
                    temp.customerName + " | " +
                    temp.movieName + " | Seat " +
                    temp.seatNumber + " | " +
                    temp.bookingTime);

            temp = temp.next;

        } while (temp != head);
    }

    // Search by customer name
    void searchByCustomer(String name) {

        if (head == null)
            return;

        Ticket temp = head;

        do {

            if (temp.customerName.equals(name)) {

                System.out.println("Ticket Found:");
                System.out.println(temp.ticketID + " " + temp.movieName + " Seat " + temp.seatNumber);
                return;
            }

            temp = temp.next;

        } while (temp != head);

        System.out.println("Ticket not found");
    }

    // Search by movie name
    void searchByMovie(String movie) {

        if (head == null)
            return;

        Ticket temp = head;

        do {

            if (temp.movieName.equals(movie)) {

                System.out.println("Ticket Found:");
                System.out.println(temp.ticketID + " " + temp.customerName + " Seat " + temp.seatNumber);
            }

            temp = temp.next;

        } while (temp != head);
    }

    // Count tickets
    void countTickets() {

        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Tickets Booked: " + count);
    }
}

public class TicketReservationSystem {

    public static void main(String[] args) {

        TicketSystem system = new TicketSystem();

        system.addTicket(101, "Aadi", "Avengers", 12, "10:30 AM");
        system.addTicket(102, "Rahul", "Batman", 8, "11:00 AM");
        system.addTicket(103, "Priya", "Avengers", 15, "11:10 AM");

        System.out.println("Booked Tickets:");
        system.displayTickets();

        System.out.println("\nSearch by Customer:");
        system.searchByCustomer("Rahul");

        System.out.println("\nSearch by Movie:");
        system.searchByMovie("Avengers");

        System.out.println("\nTotal Tickets:");
        system.countTickets();

        System.out.println("\nRemoving Ticket 102");
        system.removeTicket(102);

        System.out.println("\nUpdated Ticket List:");
        system.displayTickets();
    }
}