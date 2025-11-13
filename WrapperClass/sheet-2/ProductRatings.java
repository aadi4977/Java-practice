package WrapperClass.sheet-2;

import java.util.ArrayList;
import java.util.Objects;

public class ProductRatings {
    public static void main(String[] args) {
        int[] oldRatings = {4, 5, 3, 5};
        ArrayList<Integer> newRatings = new ArrayList<>();
        newRatings.add(5);
        newRatings.add(null);
        newRatings.add(4);
        newRatings.add(3);

        ArrayList<Integer> allRatings = new ArrayList<>();

        for (int r : oldRatings) {
            allRatings.add(r);
        }

        for (Integer r : newRatings) {
            allRatings.add(r);
        }

        int sum = 0;
        int count = 0;

        for (Integer r : allRatings) {
            if (Objects.nonNull(r)) {
                sum += r;
                count++;
            }
        }

        double avg = (count == 0) ? 0 : (double) sum / count;

        System.out.println("Average Rating: " + avg);
    }
}

