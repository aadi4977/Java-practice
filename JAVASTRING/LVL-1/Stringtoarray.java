
import java.util.Scanner;
public class Stringtoarray {
    public static char[] getChars(String text) {
        char[] arr = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i);
        }
        return arr;
    }

    public static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] userDefined = getChars(text);
        char[] builtIn = text.toCharArray();

        System.out.print("User-defined method: ");
        for (char c : userDefined) System.out.print(c + " ");
        System.out.println();

        System.out.print("Built-in toCharArray(): ");
        for (char c : builtIn) System.out.print(c + " ");
        System.out.println();

        boolean isSame = compareArrays(userDefined, builtIn);
        System.out.println("Both arrays are same: " + isSame);
    }
    
}
