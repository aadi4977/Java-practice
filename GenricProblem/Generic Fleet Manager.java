package GenricProblem;

import java.util.*;

// Generic FleetManager that only accepts Vehicle or subclasses
class FleetManager<T extends Vehicle> {
    private List<T> fleet = new ArrayList<>();

    public void addVehicle(T vehicle) {
        fleet.add(vehicle);
    }

    public void showFleet() {
        if (fleet.isEmpty()) {
            System.out.println("Fleet is empty.");
            return;
        }
        for (T v : fleet) {
            System.out.println(v);
        }
    }

    public List<T> getFleet() {
        return fleet;
    }
}

// Base Vehicle class
abstract class Vehicle {
    private String model;
    Vehicle(String model) { this.model = model; }
    public String getModel() { return model; }
    public String toString() { return getClass().getSimpleName() + " (" + model + ")"; }
}

// Subclasses
class Truck extends Vehicle {
    Truck(String model) { super(model); }
}

class Bike extends Vehicle {
    Bike(String model) { super(model); }
}

// Demo / main
public class FleetDemo {
    public static void main(String[] args) {
        // Fleet of trucks
        FleetManager<Truck> truckFleet = new FleetManager<>();
        truckFleet.addVehicle(new Truck("Volvo FH"));
        truckFleet.addVehicle(new Truck("Scania R500"));

        // Fleet of bikes
        FleetManager<Bike> bikeFleet = new FleetManager<>();
        bikeFleet.addVehicle(new Bike("Yamaha YZF"));
        bikeFleet.addVehicle(new Bike("Royal Enfield Classic"));

        System.out.println("Truck Fleet:");
        truckFleet.showFleet();

        System.out.println("\nBike Fleet:");
        bikeFleet.showFleet();

       
    }
}

