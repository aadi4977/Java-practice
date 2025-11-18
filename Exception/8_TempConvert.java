class BadTemp extends Exception { BadTemp(String m){super(m);} }
public class TempConvert {
    static void conv(double t,char u)throws BadTemp{
        if((u=='C'&&t<-273.15)||(u=='F'&&t<-459.67))
            throw new BadTemp("Below absolute zero");
        if(u=='C')System.out.println((t*9/5)+32+" F");
        else System.out.println((t-32)*5/9+" C");
    }
    public static void main(String[] a){
        try{conv(-300,'C');}
        catch(BadTemp e){System.out.println("Error:"+e.getMessage());}
    }
}