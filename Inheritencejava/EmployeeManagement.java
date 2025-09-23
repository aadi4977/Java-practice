package Inheritencejava;
// Base class Employee
class Employee {
    String name;
    int id;
    double salary;

    // Constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display details (can be overridden)
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

// Subclass Manager
class Manager extends Employee {
    int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Subclass Developer
class Developer extends Employee {
    String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Subclass Intern
class Intern extends Employee {
    String school;

    public Intern(String name, int id, double salary, String school) {
        super(name, id, salary);
        this.school = school;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("School/University: " + school);
    }
}

// Main class to test
public class EmployeeManagement {
    public static void main(String[] args) {
        // Creating objects for each type
        Employee e1 = new Manager("Alice", 101, 90000, 10);
        Employee e2 = new Developer("Bob", 102, 70000, "Java");
        Employee e3 = new Intern("Charlie", 103, 20000, "MIT");

        // Polymorphism in action
        e1.displayDetails();
        System.out.println("----------------------");
        e2.displayDetails();
        System.out.println("----------------------");
        e3.displayDetails();
    }
}
