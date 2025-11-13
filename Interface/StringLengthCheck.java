package OOPS.Interface;
import java.util.function.Function;

public class StringLengthCheck {
    public static void main(String[] args) {
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("Hello"));
        System.out.println(f.apply("Interface Test Code"));
    }
}
