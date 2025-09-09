public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";
        boolean isPalindrome = true;
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Palindrome: " + isPalindrome);
    }
}
