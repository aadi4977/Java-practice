package JAVACLASSANDOBJ.LVL2;



class PalindromeChecker {
    String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);
    }

    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }
    }
}

public class PalindromeTest {
    public static void main(String[] args) {
        PalindromeChecker p1 = new PalindromeChecker("Level");
        PalindromeChecker p2 = new PalindromeChecker("OpenAI");

        p1.displayResult();
        p2.displayResult();
    }
}
