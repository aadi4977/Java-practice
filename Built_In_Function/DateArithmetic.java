import java.time.LocalDate;

public class DateArithmetic {
    public static void main(String[] args) {
        LocalDate inputDate = LocalDate.of(2025, 9, 1); // example input date

        LocalDate result = inputDate.plusDays(7).plusMonths(1).plusYears(2);
        result = result.minusWeeks(3);

        System.out.println("Resulting Date: " + result);
    }
}
