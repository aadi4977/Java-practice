package GenricProblem;

import java.util.*;
import java.util.stream.Collectors;

// ---------- Abstract JobRole and concrete roles ----------
abstract class JobRole {
    private String roleName;
    private List<String> requiredSkills;
    private int minExperienceYears;

    protected JobRole(String roleName, List<String> requiredSkills, int minExperienceYears) {
        this.roleName = roleName;
        this.requiredSkills = new ArrayList<>(requiredSkills);
        this.minExperienceYears = minExperienceYears;
    }

    public String getRoleName() { return roleName; }
    public List<String> getRequiredSkills() { return Collections.unmodifiableList(requiredSkills); }
    public int getMinExperienceYears() { return minExperienceYears; }

    @Override
    public String toString() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer", Arrays.asList("Java", "Data Structures", "Algorithms", "OOP"), 1);
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist", Arrays.asList("Python", "Statistics", "Machine Learning", "SQL"), 2);
    }
}

class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager", Arrays.asList("Communication", "Roadmapping", "Stakeholder Management", "Prioritization"), 3);
    }
}

// ---------- Generic Resume class ----------
class Resume<T extends JobRole> {
    private String candidateName;
    private T targetRole;              // the job role this resume is intended for
    private List<String> skills;       // candidate's skills
    private int experienceYears;

    public Resume(String candidateName, T targetRole, List<String> skills, int experienceYears) {
        this.candidateName = candidateName;
        this.targetRole = targetRole;
        this.skills = new ArrayList<>(skills);
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() { return candidateName; }
    public T getTargetRole() { return targetRole; }
    public List<String> getSkills() { return Collections.unmodifiableList(skills); }
    public int getExperienceYears() { return experienceYears; }

    @Override
    public String toString() {
        return candidateName + " -> " + targetRole.getRoleName() + " (Exp: " + experienceYears + " yrs, Skills: " + skills + ")";
    }
}

// ---------- Evaluator with generic method ----------
class ResumeEvaluator {

    /**
     * Evaluate how well a candidate fits the target role.
     * Score is between 0.0 and 100.0
     *
     * Strategy:
     * - Skill overlap ratio (weight 70%)
     * - Experience bonus if >= minExperienceYears (weight 30%)
     */
    public static <T extends JobRole> double evaluate(Resume<T> resume) {
        T role = resume.getTargetRole();
        List<String> required = role.getRequiredSkills().stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        List<String> candidate = resume.getSkills().stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        long matched = required.stream().filter(candidate::contains).count();
        double skillRatio = required.isEmpty() ? 0.0 : ((double) matched / required.size()); // 0..1

        double skillScore = skillRatio * 100.0; // 0..100

        // Experience score: 100 if candidate meets or exceeds minimum, else proportional
        double expScore;
        if (role.getMinExperienceYears() <= 0) expScore = 100.0;
        else expScore = Math.min(100.0, (resume.getExperienceYears() * 100.0 / role.getMinExperienceYears()));

        // Weighted combine: 70% skills + 30% experience
        double finalScore = 0.7 * skillScore + 0.3 * expScore;

        // normalize to 0..100
        return Math.max(0.0, Math.min(100.0, finalScore));
    }

    /**
     * Wildcard method: screens a mixed list of resumes for different roles.
     * Demonstrates List<? extends JobRole> usage via the Resume generic.
     *
     * Returns shortlisted resumes that meet the threshold.
     */
    public static List<Resume<? extends JobRole>> screenResumes(
            List<Resume<? extends JobRole>> resumes,
            double thresholdScore
    ) {
        List<Resume<? extends JobRole>> shortlisted = new ArrayList<>();

        System.out.println("Screening " + resumes.size() + " resumes (threshold: " + thresholdScore + ")");
        for (Resume<? extends JobRole> r : resumes) {
            // note: to call evaluate we must keep generic relation. Use a safe helper to call evaluate.
            double score = evaluateWildcardResume(r);
            System.out.printf("  %s -> Score: %.2f%n", r.getCandidateName() + " (" + r.getTargetRole().getRoleName() + ")", score);
            if (score >= thresholdScore) {
                shortlisted.add(r);
            }
        }

        return shortlisted;
    }

    // Helper that dispatches to typed evaluate by using capture-of-wildcard
    private static double evaluateWildcardResume(Resume<? extends JobRole> r) {
        return evaluate(capture(r));
    }

    // Capture helper to preserve generic type for evaluate()
    @SuppressWarnings("unchecked")
    private static <T extends JobRole> Resume<T> capture(Resume<? extends JobRole> r) {
        return (Resume<T>) r;
    }
}

// ---------- Demo ----------
public class ResumeScreeningDemo {
    public static void main(String[] args) {
        // Create role instances (could be singletons)
        SoftwareEngineer seRole = new SoftwareEngineer();
        DataScientist dsRole = new DataScientist();
        ProductManager pmRole = new ProductManager();

        // Create resumes targeted for specific roles
        Resume<SoftwareEngineer> r1 = new Resume<>(
                "Anita",
                seRole,
                Arrays.asList("Java", "OOP", "Algorithms", "Spring"),
                2
        );

        Resume<DataScientist> r2 = new Resume<>(
                "Rohit",
                dsRole,
                Arrays.asList("Python", "SQL", "Machine Learning", "Deep Learning"),
                3
        );

        Resume<ProductManager> r3 = new Resume<>(
                "Sana",
                pmRole,
                Arrays.asList("Communication", "Roadmapping", "Agile"),
                4
        );

        Resume<SoftwareEngineer> r4 = new Resume<>(
                "Vikram",
                seRole,
                Arrays.asList("C++", "Data Structures"),
                0
        );

        Resume<DataScientist> r5 = new Resume<>(
                "Meera",
                dsRole,
                Arrays.asList("Python", "Statistics"),
                1
        );

        // Mixed list (wildcard accepts Resume<? extends JobRole>)
        List<Resume<? extends JobRole>> mixed = Arrays.asList(r1, r2, r3, r4, r5);

        // Screen resumes with threshold 60.0
        List<Resume<? extends JobRole>> shortlisted = ResumeEvaluator.screenResumes(mixed, 60.0);

        System.out.println("\nShortlisted candidates:");
        for (Resume<? extends JobRole> s : shortlisted) {
            System.out.println("  " + s.getCandidateName() + " -> " + s.getTargetRole().getRoleName());
        }
    }
}
