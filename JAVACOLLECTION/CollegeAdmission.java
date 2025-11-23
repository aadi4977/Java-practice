package JAVACOLLECTION;

import java.util.*;

// Student with name + marks
class Student implements Comparable<Student> {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // For TreeSet sorting (descending marks)
    @Override
    public int compareTo(Student s) {
        if (this.marks != s.marks)
            return s.marks - this.marks; // high → low
        return this.name.compareTo(s.name); // tie-breaker
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}

public class CollegeAdmission {

    List<Student> applicants = new ArrayList<>();     // all applications
    Set<Student> shortlisted = new HashSet<>();       // unique shortlisted
    Queue<Student> interviewQueue = new LinkedList<>(); // waiting for interview
    TreeSet<Student> meritList = new TreeSet<>();     // final ranking

    // 1. Accept applications
    void apply(Student s) {
        applicants.add(s);
        System.out.println("Applied: " + s);
    }

    // 2. Shortlist students (marks >= cutoff)
    void shortlist(int cutoff) {
        for (Student s : applicants) {
            if (s.marks >= cutoff) {
                shortlisted.add(s);
                System.out.println("Shortlisted: " + s);
            }
        }
    }

    // 3. Add shortlisted to interview queue
    void prepareInterviews() {
        interviewQueue.addAll(shortlisted);
        System.out.println("\nInterview Queue Ready");
    }

    // 4. After interviews, add to merit list
    void processInterviews() {
        while (!interviewQueue.isEmpty()) {
            Student s = interviewQueue.poll();
            meritList.add(s);  // final selected
            System.out.println("Selected: " + s);
        }
    }

    // ----- Demo -----
    public static void main(String[] args) {
        CollegeAdmission c = new CollegeAdmission();

        c.apply(new Student("Aadi", 92));
        c.apply(new Student("Riya", 88));
        c.apply(new Student("Aman", 75));
        c.apply(new Student("Neha", 92));
        c.apply(new Student("Riya", 88)); // duplicate allowed in List

        c.shortlist(80);
        c.prepareInterviews();
        c.processInterviews();

        System.out.println("\nFinal Merit List:");
        for (Student s : c.meritList) {
            System.out.println(s);
        }
    }
}

