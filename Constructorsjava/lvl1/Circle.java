package Constructorsjava.lvl1;

class Circle {
    double radius;

    // Default constructor
    Circle() {
        this(1.0);  // calls parameterized constructor with default value
    }

    // Parameterized constructor
    Circle(double r) {
        radius = r;
    }

    void display() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();       // uses default
        Circle c2 = new Circle(5.5);    // uses parameterized

        c1.display();
        c2.display();
    }
}
