package OOPS.Interface;
public class BackgroundJob {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Task Executed");
        new Thread(r).start();
    }
}
