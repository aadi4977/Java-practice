public class ReplaceWord {
    public static String replace(String sentence, String word, String replacement) {
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(word))
                arr[i] = replacement;
        }
        return String.join(" ", arr);
    }
    public static void main(String[] args) {
        String sentence = "The cat sat on the mat";
        System.out.println(replace(sentence, "cat", "dog"));
    }
}
