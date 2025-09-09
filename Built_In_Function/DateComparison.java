import java.time.LocalDate;

public class DateComparison {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2025, 9, 1);
        LocalDate date2 = LocalDate.of(2025, 9, 10);

        if (date1.isBefore(date2)) {
            System.out.println("Date1 is before Date2");
        } else if (date1.isAfter(date2)) {
            System.out.println("Date1 is after Date2");
        } else if (date1.isEqual(date2)) {
            System.out.println("Date1 is equal to Date2");
        }
    }
}
