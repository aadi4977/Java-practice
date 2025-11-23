import java.io.*;
class BadStu extends Exception{BadStu(String m){super(m);}}
public class ExamSystem {
    static void check()throws BadStu{throw new BadStu("Invalid student");}
    static void submit()throws IOException,BadStu{check();throw new IOException("IO error");}
    public static void main(String[] a){
        try{submit();}
        catch(IOException e){System.out.println(e.getMessage());}
        catch(BadStu e){System.out.println(e.getMessage());}
        finally{System.out.println("Exam process done.");}
    }
}