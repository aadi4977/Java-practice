package JAVACLASSANDOBJ.LVL2;



class Student {
    String name;
    int rollNumber;
    double marks;

    Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 50) return "C";
        else return "F";
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
}

public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("Aarav", 101, 92);
        Student s2 = new Student("Isha", 102, 68);
        Student s3 = new Student("Rohan", 103, 45);

        s1.displayDetails();
        System.out.println("------------------");
        s2.displayDetails();
        System.out.println("------------------");
        s3.displayDetails();
    }
}