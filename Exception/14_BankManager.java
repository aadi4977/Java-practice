class NoAcc extends Exception{NoAcc(String m){super(m);}}
class LowBal extends Exception{LowBal(String m){super(m);}}
public class BankManager {
    static void acc()throws NoAcc{throw new NoAcc("Account not found");}
    static void txn()throws LowBal{throw new LowBal("Insufficient funds");}
    static void exec()throws Exception{acc();txn();}
    public static void main(String[] a){
        try{exec();}
        catch(Exception e){System.out.println(e.getMessage());}
        finally{System.out.println("Transaction complete.");}
    }
}