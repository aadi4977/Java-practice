import java.util.*;

public class EmployeeUppercase {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Rahul", "Priya", "Aman");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
