package GenricProblem;

// Base class
class Fruit {
    public String toString() {
        return "Fruit";
    }
}

// Subclasses
class Apple extends Fruit {
    public String toString() {
        return "Apple";
    }
}

class Mango extends Fruit {
    public String toString() {
        return "Mango";
    }
}

// Generic class with upper bound
class FruitBox<T extends Fruit> {

    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void displayFruits() {
        for (T f : fruits) {
            System.out.println(f);
        }
    }
}

// Test Class
public class Main {
    public static void main(String[] args) {

        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        FruitBox<Mango> mangoBox = new FruitBox<>();
        mangoBox.addFruit(new Mango());

        System.out.println("Apple Box:");
        appleBox.displayFruits();

        System.out.println("\nMango Box:");
        mangoBox.displayFruits();

     
    }
}
