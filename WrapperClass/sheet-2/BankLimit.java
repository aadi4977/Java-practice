package WrapperClass.sheet-2;

public class BankLimit {

    public static double remainingLimit(Double limit, double used) {
        if (limit == null) {
            return 0.0;
        }
        return limit - used;
    }

    public static void main(String[] args) {
        System.out.println(remainingLimit(5000.0, 1200.0));
        System.out.println(remainingLimit(null, 500.0));
        System.out.println(remainingLimit(3000.0, 3000.0));
    }
}
