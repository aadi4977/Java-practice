class LateSrv extends Exception { LateSrv(String m){super(m);} }
class BadKm extends Exception { BadKm(String m){super(m);} }
public class VehicleService {
    static void check(int day,int km) throws LateSrv,BadKm {
        if(day>30) throw new LateSrv("Service overdue");
        if(km<0) throw new BadKm("Invalid km");
        System.out.println("OK");
    }
    public static void main(String[] a){
        try{check(40,-5);}
        catch(LateSrv|BadKm e){System.out.println(e.getMessage());}
    }
}