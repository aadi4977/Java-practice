class LowBal extends Exception { LowBal(String m){super(m);} }
class ATM {
    int bal = 10000;
    void withdraw(int amt) throws LowBal {
        if (amt > bal) throw new LowBal("Not enough balance");
        bal -= amt;
        System.out.println("Left: " + bal);
    }
    public static void main(String[] a) {
        ATM x = new ATM();
        try { x.withdraw(15000); }
        catch (LowBal e) { System.out.println(e.getMessage()); }
    }
}