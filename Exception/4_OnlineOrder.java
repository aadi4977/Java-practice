import java.util.*;
class OutStock extends Exception { OutStock(String m){super(m);} }
class PayFail extends Exception { PayFail(String m){super(m);} }
public class OnlineOrder {
    static void order() throws OutStock, PayFail {
        int n = new Random().nextInt(2);
        if (n==0) throw new OutStock("Out of stock");
        else throw new PayFail("Payment failed");
    }
    public static void main(String[] a) {
        try { order(); }
        catch (OutStock | PayFail e){ System.out.println(e.getMessage()); }
    }
}