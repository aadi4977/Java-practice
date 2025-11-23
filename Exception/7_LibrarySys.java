import java.util.*;
class NoBook extends Exception { NoBook(String m){super(m);} }
class BadReturn extends Exception { BadReturn(String m){super(m);} }
class LimitOver extends Exception { LimitOver(String m){super(m);} }
public class LibrarySys {
    static Set<String> s=new HashSet<>();
    static void borrow(String b,int c)throws NoBook,LimitOver{
        if(s.contains(b))throw new NoBook("Not available");
        if(c>=5)throw new LimitOver("Limit reached");
        s.add(b);System.out.println("Taken:"+b);
    }
    static void ret(String b)throws BadReturn{
        if(!s.contains(b))throw new BadReturn("Invalid return");
        s.remove(b);System.out.println("Returned:"+b);
    }
    public static void main(String[] a){
        try{borrow("Java",1);borrow("Java",1);}
        catch(Exception e){System.out.println(e.getMessage());}
    }
}