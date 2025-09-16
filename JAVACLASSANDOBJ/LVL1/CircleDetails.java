package JAVACLASSANDOBJ.LVL1;

class Circle {
    double radius;

    Circle(double r) {
        radius = r;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    double circumference() {
        return 2 * Math.PI * radius;
    }

    void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area());
        System.out.println("Circumference: " + circumference());
    }
}

public class CircleDetails {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.display();
    }
}
