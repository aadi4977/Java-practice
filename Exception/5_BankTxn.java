import java.util.*;
class NegAmt extends Exception { NegAmt(String m){super(m);} }
class LowBal extends Exception { LowBal(String m){super(m);} }
class NetFail extends Exception { NetFail(String m){super(m);} }
public class BankTxn {
    static void txn() throws NegAmt, LowBal, NetFail {
        int n = new Random().nextInt(3);
        if (n==0) throw new NegAmt("Negative amount");
        if (n==1) throw new LowBal("Low balance");
        throw new NetFail("Network fail");
    }
    public static void main(String[] a) {
        try { txn(); }
        catch (NegAmt | LowBal | NetFail e){ System.out.println(e.getMessage()); }
    }
}