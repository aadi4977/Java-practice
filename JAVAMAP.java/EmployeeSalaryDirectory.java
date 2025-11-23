package JAVAMAP.java;
import java.util.*;

public class EmployeeSalaryDirectory {
    public static void main(String[] args) {

        Map<String, Double> salary = new HashMap<>();

        // 1. Add employees
        salary.put("Aadi", 45000.0);
        salary.put("Riya", 52000.0);
        salary.put("Aman", 40000.0);
        salary.put("Neha", 65000.0);
        salary.put("Sahil", 50000.0);
        salary.put("Karan", 65000.0);

        // 2. Give raises
        giveRaise(salary, "Aadi", 10);   // +10%
        giveRaise(salary, "Aman", 15);   // +15%
        giveRaise(salary, "XYZ", 5);     // not found

        // 3. Compute average salary
        double sum = 0;
        for (double s : salary.values()) sum += s;
        double avg = sum / salary.size();

        // 4. Find highest-paid employee(s)
        double max = Collections.max(salary.values());

        System.out.println("\n--- Salary Directory ---");
        System.out.println("Average salary: " + avg);

        System.out.println("Highest Salary = " + max);
        System.out.println("Highest Paid Employees:");
        for (Map.Entry<String, Double> e : salary.entrySet()) {
            if (e.getValue() == max)
                System.out.println(" - " + e.getKey());
        }
    }

    static void giveRaise(Map<String, Double> map, String emp, double percent) {
        if (map.containsKey(emp)) {
            double updated = map.get(emp) * (1 + percent / 100);
            map.put(emp, updated);
            System.out.println("Raise given to " + emp + " → " + updated);
        } else {
            System.out.println("Employee not found: " + emp);
        }
    }
}

