import java.util.*;

public class PatientIDPrinter {
    public static void main(String[] args) {
        List<Integer> ids = Arrays.asList(101, 202, 303, 404);
        ids.forEach(System.out::println);
    }
}
