interface SecurityUtils {
    static boolean isStrong(String p) {
        return p.length() >= 8 && p.matches(".*[0-9].*") && p.matches(".*[A-Z].*");
    }
}

public class SecurityUtilsTest {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrong("Pass1234"));
        System.out.println(SecurityUtils.isStrong("weak"));
    }
}
