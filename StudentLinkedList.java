class Student {

    int roll;
    String name;
    int age;
    char grade;
    Student next;

    Student(int roll, String name, int age, char grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {

    Student head;

    void insertBeginning(int roll, String name, int age, char grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    void insertEnd(int roll, String name, int age, char grade) {

        Student newNode = new Student(roll, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        Student temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void deleteStudent(int roll) {

        Student temp = head;
        Student prev = null;

        while (temp != null && temp.roll != roll) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Student not found");
            return;
        }

        if (prev == null)
            head = temp.next;
        else
            prev.next = temp.next;
    }

    void search(int roll) {

        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found: " + temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    void updateGrade(int roll, char grade) {

        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = grade;
                System.out.println("Grade Updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    void display() {

        Student temp = head;

        while (temp != null) {
            System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentLinkedList {

    public static void main(String[] args) {

        StudentList list = new StudentList();

        list.insertBeginning(1, "Aadi", 20, 'A');
        list.insertEnd(2, "Rahul", 21, 'B');
        list.insertEnd(3, "Priya", 19, 'A');

        System.out.println("Student Records:");
        list.display();

        list.search(2);

        list.updateGrade(2, 'A');

        list.deleteStudent(1);

        System.out.println("After Deletion:");
        list.display();
    }
}
