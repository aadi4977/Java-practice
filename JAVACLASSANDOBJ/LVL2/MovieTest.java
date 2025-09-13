package JAVACLASSANDOBJ.LVL2;

class MovieTicket {
    String movieName;
    int seatNumber;
    double price;
    boolean booked;

    MovieTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.booked = false;
    }

    void bookTicket() {
        if (!booked) {
            booked = true;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Seat " + seatNumber + " is already booked.");
        }
    }

    void displayDetails() {
        if (booked) {
            System.out.println("Movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: " + price);
        } else {
            System.out.println("Seat " + seatNumber + " is not booked yet.");
        }
    }
}

public class MovieTest {
    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket("Inception", 12, 250);
        MovieTicket ticket2 = new MovieTicket("Interstellar", 15, 300);

        ticket1.bookTicket();
        ticket1.displayDetails();

        System.out.println("------------------");

        ticket2.displayDetails();
        ticket2.bookTicket();
        ticket2.displayDetails();
    }
}
