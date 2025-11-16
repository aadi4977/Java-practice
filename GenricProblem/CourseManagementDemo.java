package GenricProblem;

import java.util.*;

// ---------- 1) CourseType hierarchy ----------
abstract class CourseType {
    private String description;
    CourseType(String description) { this.description = description; }
    public String getDescription() { return description; }
    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" + description + ")";
    }
}

class ExamCourse extends CourseType { ExamCourse(String desc) { super(desc); } }
class AssignmentCourse extends CourseType { AssignmentCourse(String desc) { super(desc); } }
class ResearchCourse extends CourseType { ResearchCourse(String desc) { super(desc); } }

// ---------- 2) Generic Course class ----------
class Course<T extends CourseType> {
    private String code;
    private String title;
    private T evaluationType;
    private int credits;

    public Course(String code, String title, T evaluationType, int credits) {
        this.code = code;
        this.title = title;
        this.evaluationType = evaluationType;
        this.credits = credits;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public T getEvaluationType() { return evaluationType; }
    public int getCredits() { return credits; }

    @Override
    public String toString() {
        return code + " | " + title + " | " + evaluationType + " | Credits: " + credits;
    }
}

// ---------- 3) Manager for courses of one CourseType ----------
class CourseManager<T extends CourseType> {
    private List<Course<T>> courses = new ArrayList<>();

    public void addCourse(Course<T> c) {
        courses.add(c);
    }

    public List<Course<T>> getCourses() { return courses; }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses.");
            return;
        }
        for (Course<T> c : courses) {
            System.out.println(c);
        }
    }
}

// ---------- 4) Wildcard utility to handle any course type ----------
class CourseUtils {
    // Accepts a list of any Course whose CourseType extends CourseType
    public static void printAnyCourses(List<? extends Course<? extends CourseType>> list) {
        if (list.isEmpty()) {
            System.out.println("No courses to show.");
            return;
        }
        for (Course<? extends CourseType> c : list) {
            System.out.println(c);
        }
    }
}

public class CourseManagementDemo {
    public static void main(String[] args) {
        // Managers for each evaluation type (could represent different departments)
        CourseManager<ExamCourse> examManager = new CourseManager<>();
        CourseManager<AssignmentCourse> assignManager = new CourseManager<>();
        CourseManager<ResearchCourse> researchManager = new CourseManager<>();

        // Add sample courses
        examManager.addCourse(new Course<>("CS101", "Algorithms", new ExamCourse("Midterm + Final"), 4));
        examManager.addCourse(new Course<>("MA101", "Calculus", new ExamCourse("Final Exam"), 3));

        assignManager.addCourse(new Course<>("CS201", "Software Project", new AssignmentCourse("Project + Assignments"), 3));
        assignManager.addCourse(new Course<>("EE202", "Lab Circuits", new AssignmentCourse("Lab Reports"), 2));

        researchManager.addCourse(new Course<>("RS301", "AI Research", new ResearchCourse("Thesis & Publication"), 6));

        System.out.println("=== Exam Courses ===");
        examManager.listCourses();

        System.out.println("\n=== Assignment Courses ===");
        assignManager.listCourses();

        System.out.println("\n=== Research Courses ===");
        researchManager.listCourses();

        // Demonstrate wildcard handling by combining course lists
        List<Course<? extends CourseType>> all = new ArrayList<>();
        all.addAll(examManager.getCourses());
        all.addAll(assignManager.getCourses());
        all.addAll(researchManager.getCourses());

        System.out.println("\n=== All Courses (using wildcard utility) ===");
        CourseUtils.printAnyCourses(all);
    }
}
