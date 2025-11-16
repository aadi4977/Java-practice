package GenricProblem;
public class Main {

    // Generic method with bounded type
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println("Max Integer: " + maximum(10, 25, 5));
        System.out.println("Max Double : " + maximum(3.5, 1.2, 9.7));
        System.out.println("Max String : " + maximum("Apple", "Mango", "Banana"));
    }
}

