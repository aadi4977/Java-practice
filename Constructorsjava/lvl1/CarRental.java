package Constructorsjava.lvl1;
class CarRental {
    String customerName;
    String carModel;
    int rentalDays;

    // Default constructor
    CarRental() {
        customerName = "Unknown";
        carModel = "Standard";
        rentalDays = 1;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total cost
    double calculateCost() {
        double rate;
        switch (carModel.toLowerCase()) {
            case "suv": rate = 2000; break;
            case "sedan": rate = 1500; break;
            case "hatchback": rate = 1000; break;
            default: rate = 1200; // Standard car
        }
        return rate * rentalDays;
    }

    // Method to display details
    void display() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + calculateCost());
    }

    public static void main(String[] args) {
        // Default booking
        CarRental r1 = new CarRental();
        System.out.println("Booking 1 (Default):");
        r1.display();

        System.out.println();

        // Parameterized booking
        CarRental r2 = new CarRental("Alice", "SUV", 5);
        System.out.println("Booking 2 (Parameterized):");
        r2.display();
    }
}

