import java.io.*;
class FileHandler {
    FileHandler() throws IOException {throw new IOException("File missing");}
}
public class Main {
    public static void main(String[] a){
        try{new FileHandler();}
        catch(IOException e){System.out.println(e.getMessage());}
    }
}