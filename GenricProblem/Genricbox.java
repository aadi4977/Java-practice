package GenricProblem;

// Generic Box class
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

// Test class
public class Main {
    public static void main(String[] args) {

        // Box of Integer
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("Integer value: " + intBox.get());

        // Box of String
        Box<String> strBox = new Box<>();
        strBox.set("Hello Generics");
        System.out.println("String value: " + strBox.get());

        // Box of Double
        Box<Double> doubleBox = new Box<>();
        doubleBox.set(99.99);
        System.out.println("Double value: " + doubleBox.get());
    }
}
