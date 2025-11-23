class BadLogin extends Exception { BadLogin(String m){super(m);} }
public class LoginSystem {
    static void check(String u, String p) throws BadLogin {
        if (!u.equals("admin") || !p.equals("1234")) throw new BadLogin("Wrong login");
        System.out.println("Welcome");
    }
    public static void main(String[] a) {
        try { check("ankush","1111"); }
        catch (BadLogin e){ System.out.println(e.getMessage()); }
    }
}