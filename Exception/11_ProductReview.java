class BadRate extends Exception{BadRate(String m){super(m);}}
class EmptyRev extends Exception{EmptyRev(String m){super(m);}}
public class ProductReview {
    static void review(int r,String c)throws BadRate,EmptyRev{
        if(r<1||r>5)throw new BadRate("Invalid rating");
        if(c==null||c.isEmpty())throw new EmptyRev("Empty review");
        System.out.println("Thanks for rating "+r);
    }
    public static void main(String[] a){
        try{review(6,"Good");}
        catch(BadRate e){System.out.println(e.getMessage());}
        catch(EmptyRev e){System.out.println(e.getMessage());}
    }
}