package JAVACOLLECTION;

import java.util.*;

class Question {
    int id;
    String text;

    Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return id + ". " + text;
    }
}

class Student {
    String id, name;

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class OnlineExamSystem {

    List<Question> questions = new ArrayList<>();
    Set<String> studentIDs = new HashSet<>();
    Queue<Student> examQueue = new LinkedList<>();
    Stack<Question> navStack = new Stack<>();

    // 1. Enroll student (avoid duplicates)
    void enrollStudent(String id, String name) {
        if (studentIDs.add(id)) {     // add() returns false if duplicate
            examQueue.add(new Student(id, name));
        } else {
            System.out.println("Duplicate ID: " + id);
        }
    }

    // 2. Add & randomize questions
    void addQuestion(Question q) {
        questions.add(q);
    }

    void randomize() {
        Collections.shuffle(questions);
    }

    // 3. Serve students in queue
    void startExam() {
        while (!examQueue.isEmpty()) {
            Student s = examQueue.poll();
            System.out.println("\nServing: " + s.name);
            takeExam();
        }
    }

    // 4. Navigate questions using stack
    void takeExam() {
        int i = 0;
        navStack.clear();

        while (i < questions.size()) {
            Question q = questions.get(i);
            System.out.println("Current: " + q);

            // Move to next question
            if (i + 1 < questions.size()) {
                navStack.push(q);   // save current
                i++;
            } else {
                break;
            }

            // Go back once for demo
            if (!navStack.isEmpty()) {
                System.out.println("Back to: " + navStack.pop());
            }
        }
    }

    // ---------------- Demo ----------------
    public static void main(String[] args) {
        OnlineExamSystem sys = new OnlineExamSystem();

        sys.enrollStudent("S1", "Aadi");
        sys.enrollStudent("S2", "Riya");
        sys.enrollStudent("S2", "Duplicate Riya"); // duplicate

        sys.addQuestion(new Question(1, "2 + 2 = ?"));
        sys.addQuestion(new Question(2, "Capital of India?"));
        sys.addQuestion(new Question(3, "Java uses which OOP concept?"));

        sys.randomize(); 
        sys.startExam();
    }
}

