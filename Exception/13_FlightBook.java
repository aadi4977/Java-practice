class NoSeat extends Exception{NoSeat(String m){super(m);}}
class PayFail extends Exception{PayFail(String m){super(m);}}
public class FlightBook {
    static void seat()throws NoSeat{throw new NoSeat("Seat unavailable");}
    static void pay()throws PayFail{throw new PayFail("Payment fail");}
    static void book()throws Exception{seat();pay();}
    public static void main(String[] a){
        try{book();}
        catch(NoSeat e){System.out.println(e.getMessage());}
        catch(PayFail e){System.out.println(e.getMessage());}
        finally{System.out.println("Thanks for booking!");}
    }
}