interface PaymentProcessor {
    void pay(double amt);
    default void refund(double amt) { System.out.println("Refund " + amt); }
}

class Paytm implements PaymentProcessor {
    public void pay(double amt) { System.out.println("Paid via Paytm " + amt); }
}

public class PaymentProcessorTest {
    public static void main(String[] args) {
        PaymentProcessor p = new Paytm();
        p.pay(900);
        p.refund(300);
    }
}
