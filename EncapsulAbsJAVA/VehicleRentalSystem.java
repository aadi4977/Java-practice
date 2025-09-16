package EncapsulAbsJAVA;

import java.util.*;

// Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    public void displayVehicleDetails() {
        System.out.println("Vehicle No: " + vehicleNumber + ", Type: " + type + ", Rate/day: " + rentalRate);
    }
}

// Car Class
class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy No: " + policyNumber;
    }
}

// Bike Class
class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) - 50; // flat discount
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.02; // 2% of rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy No: " + policyNumber;
    }
}

// Truck Class
class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 500; // extra charge
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10; // 10% of rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy No: " + policyNumber;
    }
}

// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("CAR123", 2000, "CAR-INS-001"));
        vehicles.add(new Bike("BIKE101", 500, "BIKE-INS-009"));
        vehicles.add(new Truck("TRUCK77", 5000, "TRUCK-INS-555"));

        int days = 5;

        for (Vehicle v : vehicles) {
            v.displayVehicleDetails();
            double rentalCost = v.calculateRentalCost(days);

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                double insurance = ins.calculateInsurance();
                System.out.println(ins.getInsuranceDetails());
                System.out.println("Rental Cost (" + days + " days): " + rentalCost);
                System.out.println("Insurance: " + insurance);
                System.out.println("Total Cost: " + (rentalCost + insurance));
            }
            System.out.println("-----");
        }
    }
}

