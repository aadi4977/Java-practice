package OOPS.Interface;
interface Payment {
    void pay(double amount);
}

class UPI implements Payment {
    public void pay(double amount) { System.out.println("Paid via UPI " + amount); }
}

class CreditCard implements Payment {
    public void pay(double amount) { System.out.println("Paid via Credit Card " + amount); }
}

class Wallet implements Payment {
    public void pay(double amount) { System.out.println("Paid via Wallet " + amount); }
}

public class DigitalPayment {
    public static void main(String[] args) {
        Payment p = new UPI(); p.pay(500);
        p = new CreditCard(); p.pay(1200);
        p = new Wallet(); p.pay(300);
    }
}
