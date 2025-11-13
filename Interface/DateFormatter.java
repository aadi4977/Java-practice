import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils {
    static String format(LocalDate d, String p) {
        return d.format(DateTimeFormatter.ofPattern(p));
    }
}

public class DateFormatter {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        System.out.println(DateUtils.format(d, "dd-MM-yyyy"));
        System.out.println(DateUtils.format(d, "yyyy/MM/dd"));
    }
}
