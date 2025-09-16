package EncapsulAbsJAVA;

import java.util.*;

// Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Abstract Class
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String location) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = location;
    }

    // Abstract Method
    public abstract double calculateFare(double distance);

    // Concrete Method
    public void getVehicleDetails() {
        System.out.println("VehicleID: " + vehicleId + ", Driver: " + driverName + ", Rate/km: " + ratePerKm);
    }

    // Encapsulation: Getters & Setters
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public String getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(String location) { this.currentLocation = location; }
}

// Car Class
class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        double baseFare = 50; // Base fare for cars
        return baseFare + (distance * getRatePerKm());
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

// Bike Class
class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // No base fare, cheaper
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

// Auto Class
class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        double minFare = 30; // Minimum fare for autos
        double fare = distance * getRatePerKm();
        return (fare < minFare) ? minFare : fare;
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

// Main Class
public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();

        Car car = new Car("C101", "Rajesh", 15, "Connaught Place");
        Bike bike = new Bike("B202", "Amit", 8, "Karol Bagh");
        Auto auto = new Auto("A303", "Suresh", 10, "India Gate");

        rides.add(car);
        rides.add(bike);
        rides.add(auto);

        double distance = 12.5; // Example ride distance in km

        System.out.println("===== Ride Fare Details =====");
        for (Vehicle v : rides) {
            v.getVehicleDetails();
            System.out.println("Current Location: " + ((GPS)v).getCurrentLocation());
            double fare = v.calculateFare(distance);
            System.out.println("Fare for " + distance + " km: ₹" + fare);
            System.out.println("-----");
        }
    }
}

