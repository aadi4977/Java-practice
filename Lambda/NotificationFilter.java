import java.util.*;
import java.util.function.Predicate;

public class NotificationFilter {
    public static void main(String[] args) {
        List<String> alerts = Arrays.asList("Critical", "Info", "Emergency", "Routine", "Urgent");
        Predicate<String> important = a -> a.equals("Critical") || a.equals("Emergency") || a.equals("Urgent");
        alerts.stream().filter(important).forEach(System.out::println);
    }
}
