package OOPS.Interface;
interface Device {
    void turnOn();
    void turnOff();
}

class Light implements Device {
    public void turnOn() { System.out.println("Light On"); }
    public void turnOff() { System.out.println("Light Off"); }
}

class AC implements Device {
    public void turnOn() { System.out.println("AC On"); }
    public void turnOff() { System.out.println("AC Off"); }
}

class TV implements Device {
    public void turnOn() { System.out.println("TV On"); }
    public void turnOff() { System.out.println("TV Off"); }
}

public class SmartDeviceControl {
    public static void main(String[] args) {
        Device d1 = new Light();
        Device d2 = new AC();
        Device d3 = new TV();
        d1.turnOn(); d1.turnOff();
        d2.turnOn(); d2.turnOff();
        d3.turnOn(); d3.turnOff();
    }
}
