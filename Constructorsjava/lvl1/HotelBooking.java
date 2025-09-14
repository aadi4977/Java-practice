package Constructorsjava.lvl1;
class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    // Default constructor
    HotelBooking() {
        guestName = "Unknown";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    // Method to display booking details
    void display() {
        System.out.println("Guest: " + guestName + 
                           ", Room: " + roomType + 
                           ", Nights: " + nights);
    }

    public static void main(String[] args) {
        // Default constructor
        HotelBooking b1 = new HotelBooking();
        System.out.println("Booking 1 (Default):");
        b1.display();

        System.out.println();

        // Parameterized constructor
        HotelBooking b2 = new HotelBooking("Alice", "Deluxe", 3);
        System.out.println("Booking 2 (Parameterized):");
        b2.display();

        System.out.println();

        // Copy constructor
        HotelBooking b3 = new HotelBooking(b2);
        System.out.println("Booking 3 (Copied from Booking 2):");
        b3.display();
    }
}


