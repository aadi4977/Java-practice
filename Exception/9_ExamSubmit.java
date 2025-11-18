import java.time.*;
class Late extends Exception{Late(String m){super(m);}}
class BadFile extends Exception{BadFile(String m){super(m);}}
public class ExamSubmit {
    static void submit(String f,LocalDateTime t)throws Late,BadFile{
        LocalDateTime d=LocalDateTime.of(2025,11,5,23,59);
        if(!f.endsWith(".pdf"))throw new BadFile("Invalid file");
        if(t.isAfter(d))throw new Late("Late submission");
        System.out.println("Submitted");
    }
    public static void main(String[] a){
        try{submit("ans.txt",LocalDateTime.now());}
        catch(Exception e){System.out.println("Fail:"+e.getMessage());}
    }
}