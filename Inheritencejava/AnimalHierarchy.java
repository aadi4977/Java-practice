package Inheritencejava;


    // Superclass Animal
class Animal {
    String name;
    int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass Dog
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " (Dog): Woof Woof!");
    }
}

// Subclass Cat
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " (Cat): Meow Meow!");
    }
}

// Subclass Bird
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " (Bird): Tweet Tweet!");
    }
}

// Main class to test
public class AnimalHierarchy {
    public static void main(String[] args) {
        // Polymorphism: Parent reference holding child object
        Animal a1 = new Dog("Bruno", 5);
        Animal a2 = new Cat("Kitty", 3);
        Animal a3 = new Bird("Tweety", 2);

        // Calling overridden methods
        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}


