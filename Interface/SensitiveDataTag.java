interface Sensitive {}

class UserInfo implements Sensitive {
    String info = "Secret";
}

public class SensitiveDataTag {
    public static void main(String[] args) {
        UserInfo u = new UserInfo();
        if (u instanceof Sensitive) System.out.println("Encrypt this");
    }
}
