public class MostFrequentChar {
    public static void main(String[] args) {
        String str = "success";
        int[] freq = new int[256];  // Correct array declaration
        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }
        int max = 0;
        char maxChar = ' ';
        for (char ch : str.toCharArray()) {
            if (freq[ch] > max) {
                max = freq[ch];
                maxChar = ch;
            }
        }
        System.out.println("Most Frequent Character: " + maxChar);
    }
}
