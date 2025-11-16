package GenricProblem;

import java.util.*;

public class CopyListDemo {

    // copies all numbers from src to dest
    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        for (Number n : src) {
            dest.add(n);
        }
    }

    public static void main(String[] args) {
        List<Integer> srcInts = Arrays.asList(1, 2, 3);
        List<Number> destNums = new ArrayList<>();

        System.out.println("Before: " + destNums);
        copyList(destNums, srcInts);
        System.out.println("After : " + destNums);

        // Also works with Double source
        List<Double> srcDoubles = Arrays.asList(2.5, 3.5);
        copyList(destNums, srcDoubles);
        System.out.println("After adding doubles: " + destNums);
    }
}
