interface Vehicle {
    void displaySpeed();
    default void displayBattery() {}
}

class PetrolCar implements Vehicle {
    public void displaySpeed() { System.out.println("Speed 80km/h"); }
}

class ElectricCar implements Vehicle {
    public void displaySpeed() { System.out.println("Speed 90km/h"); }
    public void displayBattery() { System.out.println("Battery 70%"); }
}

public class VehicleDashboard {
    public static void main(String[] args) {
        Vehicle v = new PetrolCar(); v.displaySpeed(); v.displayBattery();
        v = new ElectricCar(); v.displaySpeed(); v.displayBattery();
    }
}
