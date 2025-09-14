package Constructorsjava.lvl1;
class Person {
    String name;
    int age;

    // Default constructor
    Person() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized constructor
    Person(String n, int a) {
        name = n;
        age = a;
    }

    // Copy constructor
    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);   // parameterized
        Person p2 = new Person(p1);            // copy constructor

        System.out.println("Original Person:");
        p1.display();

        System.out.println("Cloned Person:");
        p2.display();
    }
}

