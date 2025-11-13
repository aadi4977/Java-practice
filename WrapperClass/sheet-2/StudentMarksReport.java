package WrapperClass.sheet-2;

public class StudentMarksReport {
    public static void main(String[] args) {
        String[] inputs = {"85", "95", "null", "70", "abc"};
        Integer[] extra = {Integer.valueOf(88), null};

        int sum = 0;
        int count = 0;

        for (String s : inputs) {
            try {
                if (!s.equals("null")) {
                    int value = Integer.parseInt(s);
                    sum += value;
                    count++;
                }
            } catch (Exception e) {
            }
        }

        for (Integer m : extra) {
            if (m != null) {
                sum += m;
                count++;
            }
        }

        double avg = (count == 0) ? 0 : (double) sum / count;

        System.out.println("Average Marks: " + avg);
    }
}
