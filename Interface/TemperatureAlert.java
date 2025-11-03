package OOPS.Interface;
import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {
        Predicate<Double> highTemp = t -> t > 38.0;
        System.out.println(highTemp.test(37.5));
        System.out.println(highTemp.test(39.2));
    }
}
