public class StudentGrade {
    public static void main(String[] a) {
        String[] g = {"90", "A+", "85"};
        for (String x : g) {
            try {
                int n = Integer.parseInt(x);
                System.out.println("Grade: " + n);
            } catch (NumberFormatException e) {
                System.out.println("Invalid: " + x);
            }
        }
    }
}