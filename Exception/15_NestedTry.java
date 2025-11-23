public class NestedTry {
    static void b(){
        try{Integer.parseInt("abc");}
        catch(NumberFormatException e){System.out.println("Bad number");}
        String x=null;System.out.println(x.length());
    }
    static void a(){
        try{b();}
        catch(NullPointerException e){System.out.println("Null error");}
    }
    public static void main(String[] a){a();}
}