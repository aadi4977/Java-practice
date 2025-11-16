package GenricProblem;
// Generic Pair class
class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

// Test class
public class Main {
    public static void main(String[] args) {

        Pair<String, Integer> student = new Pair<>("Amol", 20);

        System.out.println("Name: " + student.getFirst());
        System.out.println("Age : " + student.getSecond());
    }
}
