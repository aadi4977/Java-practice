package WrapperClass.sheet;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeAges {
    public static void main(String[] args) {
        int[] ages = {25, 30, 22, 45, 28, 35};

        ArrayList<Integer> list = new ArrayList<>();
        for (int age : ages) {
            list.add(age);
        }

        int youngest = Collections.min(list);
        int oldest = Collections.max(list);

        System.out.println("Youngest employee age: " + youngest);
        System.out.println("Oldest employee age: " + oldest);
    }
}
