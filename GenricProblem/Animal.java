package GenricProblem;
import java.util.*;

class Animal {
    String name;
    Animal(String name) { this.name = name; }
    public String toString() { return getClass().getSimpleName() + " : " + name; }
}

class Dog extends Animal { Dog(String name) { super(name); } }
class Cat extends Animal { Cat(String name) { super(name); } }

public class AnimalDemo {

    // prints lists of any subtype of Animal
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(new Dog("Rex"), new Dog("Buddy"));
        List<Cat> cats = Arrays.asList(new Cat("Kitty"), new Cat("Luna"));

        System.out.println("Dogs:");
        printAnimals(dogs);

        System.out.println("\nCats:");
        printAnimals(cats);

        // The following would NOT compile: printAnimals(List<Object>) because Object is not extends Animal
    }
}
