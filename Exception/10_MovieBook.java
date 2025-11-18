import java.util.*;
class BadSeat extends Exception{BadSeat(String m){super(m);}}
class Booked extends Exception{Booked(String m){super(m);}}
public class MovieBook {
    static Map<Integer,Boolean> seat=new HashMap<>();
    static{for(int i=1;i<=5;i++)seat.put(i,false);}
    static void book(int n)throws BadSeat,Booked{
        if(!seat.containsKey(n))throw new BadSeat("No such seat");
        if(seat.get(n))throw new Booked("Already booked");
        seat.put(n,true);
        System.out.println("Seat "+n+" booked");
    }
    public static void main(String[] a){
        try{book(2);book(2);}
        catch(Exception e){System.out.println(e.getMessage());}
    }
}