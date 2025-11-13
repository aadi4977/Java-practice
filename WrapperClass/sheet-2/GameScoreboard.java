package WrapperClass.sheet-2;
public class GameScoreboard {
    public static void main(String[] args) {
        Integer[] scores = {10, null, 25, 40, null, 15};

        int notPlayed = 0;
        int total = 0;

        for (Integer s : scores) {
            if (s == null) {
                notPlayed++;
            } else {
                total += s;
            }
        }

        System.out.println("Players not played: " + notPlayed);
        System.out.println("Total valid scores: " + total);
    }
}

