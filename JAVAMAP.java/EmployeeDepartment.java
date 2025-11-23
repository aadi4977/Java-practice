package JAVAMAP.java;

import java.util.*;

public class EmployeeDepartment {
    public static void main(String[] args) {

        HashMap<Integer, String> empDept = new HashMap<>();

        // 1. Add employees
        empDept.put(101, "HR");
        empDept.put(102, "Finance");
        empDept.put(103, "IT");
        empDept.put(104, "IT");
        empDept.put(105, "Marketing");
        empDept.put(106, "Finance");

        // 2. Change department (update)
        empDept.put(103, "Marketing");  // IT → Marketing

        // 3. Find all employees of a given department
        String searchDept = "Finance";
        System.out.println("Employees in " + searchDept + ":");
        for (Map.Entry<Integer, String> e : empDept.entrySet()) {
            if (e.getValue().equals(searchDept))
                System.out.println("EmpID: " + e.getKey());
        }

        // 4. Total employees per department
        Map<String, Integer> countMap = new HashMap<>();

        for (String dept : empDept.values()) {
            countMap.put(dept, countMap.getOrDefault(dept, 0) + 1);
        }

        System.out.println("\nEmployees per Department:");
        for (Map.Entry<String, Integer> e : countMap.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
