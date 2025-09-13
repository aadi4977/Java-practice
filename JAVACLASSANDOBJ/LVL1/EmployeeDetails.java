package JAVACLASSANDOBJ.LVL1;
class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Salary : " + salary);
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Amit Sharma", 101, 45000.50);
        Employee emp2 = new Employee("Neha Verma", 102, 52000.75);

        emp1.displayDetails();
        System.out.println();
        emp2.displayDetails();
    }
}
