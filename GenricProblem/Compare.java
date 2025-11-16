package GenricProblem;

public class Main {

    // Generic method to compare two values
    public static <T> boolean isEqual(T a, T b) {
        return a.equals(b);
    }

    public static void main(String[] args) {
        System.out.println(isEqual(10, 10));          // true
        System.out.println(isEqual("Aadi", "Aadi"));  // true
        System.out.println(isEqual(5.5, 6.5));        // false
    }
}

